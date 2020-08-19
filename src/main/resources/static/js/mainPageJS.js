var sfzh = "";
var orgId = "";
var role = "";
$(function () {
	var tagColor = ['#09e4be', '#9943fc', '#d8fc12', '#fcba0c', '#198bfe', '#7e4efc',
        '#fb770b', '#30ef6b', '#f86bf7', '#4fd6f4'];
	for (var i = 0; i < $(".my-tag").length; i++) {
		for (var j = 0; j < tagColor.length; j++) {
			if ((j + i) % tagColor.length === 0) {
				$(".my-tag").eq(i).css("background", tagColor[j]);
			}
		}
	}
});
window.onload = function(){
	//设置参数
	setPageParam();
    //设置菜单事件
	setMenuEvent();
	if(document.getElementById("healthJMMenu") != null && document.getElementById("healthJMMenu").childNodes[0] != undefined
			&& document.getElementById("healthJMMenu").childNodes[0].childNodes[0] != undefined){
		document.getElementById("healthJMMenu").childNodes[0].childNodes[0].click();
	}
}
//获取档案的基本信息
function getArchiveInfo(){
	var jsonParam = new Object();
    jsonParam.sfzh = sfzh;
    var authorCookie = getCookie("author");
    $.ajax({
        type: 'POST',
        dataType: "json",
        async: false,
        contentType: 'application/json',
        url: roadPath + '/health/archive/getArchiveDetailBySfzh',
        data: JSON.stringify(jsonParam),
        beforeSend: function (XMLHttpRequest) {
        	XMLHttpRequest.setRequestHeader("authToken", authorCookie);
        },
        success: function (resultMsg) {
        	if(resultMsg.retCode == 0 && resultMsg.data != null){
        		//获取当前用户的权限菜单
        	    getLoginRoleMenu();
                $('#hzmc').text($.util.isNull(resultMsg.data.hzmc) ? "无" : resultMsg.data.hzmc);
                $('#xb').text($.util.isNull(resultMsg.data.xb) ? "无" : resultMsg.data.xb);
                $('#nl').text($.util.isNull(resultMsg.data.nl) ? "无" : resultMsg.data.nl);
                $('#zjlxText').text($.util.isNull(resultMsg.data.zjlxText) ? "无" : resultMsg.data.zjlxText);
                $('#sfzh').text($.util.isNull(resultMsg.data.sfzh) ? "无" : resultMsg.data.sfzh);
                $('#csrq').text($.util.isNull(resultMsg.data.csrq) ? "无" : resultMsg.data.csrq);
                $('#sj').text($.util.isNull(resultMsg.data.sj) ? "无" : resultMsg.data.sj);
                if($.util.isNull(resultMsg.data.rqlxText)){
                	$('#rqlxText').append("<span>无</span>");
                }else{
                	var rqlxArr = resultMsg.data.rqlxText.split(",");
                    var rqlxStr = '';
                    for(var i = 0; i < rqlxArr.length; i++){
                 	   rqlxStr += ' <span class="my-tag">'+rqlxArr[i]+'</span>';
                    }
                    $("#rqlxText").append(rqlxStr);
                }
                $("#archiveId").val(resultMsg.data.id);
        	}else{
        		$(".mainPage").html('');
        		$(".mainPage").html('<div class="nodatasign" style="margin-top: 6%;"><img src="../img/img_zwsj.png" /></div><div class="nodatasign">暂无信息</div>');
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	console.log(errorThrown);
        }
    });
}
//获取当前用户的权限菜单
function getLoginRoleMenu(){
	var jsonParam = new Object();
    jsonParam.orgId = orgId;
    jsonParam.roleCap = role;
    jsonParam.treeType = "2";
    var authorCookie = getCookie("author");
    $.ajax({
        type: 'POST',
        dataType: "json",
        async: false,
        contentType: 'application/json',
        url: roadPath + '/health/menu/getmenutree',
        data: JSON.stringify(jsonParam),
        beforeSend: function (XMLHttpRequest) {
        	XMLHttpRequest.setRequestHeader("authToken", authorCookie);
        },
        success: function (resultMsg) {
        	if(resultMsg.retCode == 0){
        		$('#healthJMMenu').html('');
        		var healthJMMenuStr = '';
        		var menuArr = resultMsg.data;
        		if(menuArr != undefined && menuArr.length > 0){
        			for(var i = 0; i < menuArr.length; i++){
            			healthJMMenuStr += '';
            			if(menuArr[i].name == '随访信息'){
            				healthJMMenuStr += '<li class="menuLi" id="sfxx">'+
					                                '<div class="menuBtn" src=""> '+
							                            '<i class="iconfont">'+iconMap[menuArr[i].name]+'</i>'+
							                            '<div>'+menuArr[i].name+'</div>'+
							                        '</div>'+
							                        '<ul class="childMenu" id="childMenuUl"></ul>'+
							                    '</li>';
            			}else{
            				healthJMMenuStr += '<li class="menuLi">'+
						                            '<div class="menuBtn " src="'+menuArr[i].url+'">'+
							                            '<i class="iconfont">'+iconMap[menuArr[i].name]+'</i>'+
							                            '<div>'+menuArr[i].name+'</div>'+
							                        '</div>'+
							                    '</li>';
            			}
            		}
            		$('#healthJMMenu').append(healthJMMenuStr);
            		//获取随访菜单的信息
            	    getFollowMenuList();
        		}
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	console.log(errorThrown);
        }
    });
}
//获取随访菜单的信息
function getFollowMenuList(){
	var jsonParam = new Object();
    jsonParam.sfzh = sfzh;
    var authorCookie = getCookie("author");
    $.ajax({
        type: 'POST',
        dataType: "json",
        async: false,
        contentType: 'application/json',
        url: roadPath + '/health/followmenu/getfollowMenu',
        data: JSON.stringify(jsonParam),
        beforeSend: function (XMLHttpRequest) {
        	XMLHttpRequest.setRequestHeader("authToken", authorCookie);
        },
        success: function (resultMsg) {
        	if(resultMsg.retCode == 0){
        		var menuArr = resultMsg.data;
            	if(menuArr != undefined && menuArr.length > 0){
            		var menuStr = '';
                	for(var i = 0; i < menuArr.length; i++){
                		menuStr += '<li src="followUpInfo/'+menuArr[i].name+'.html"><div>'+menuArr[i].tit+'</div></li>'
                	}
                	$("#childMenuUl").append(menuStr);
            	}else{
            		$("#sfxx").hide();
            	}
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	console.log(errorThrown);
        }
    });
}
//设置参数
function setPageParam(){
	sfzh = $.util.getUrlParam('sfzh');
	$("#idCard").val(sfzh);
	authToken = $.util.getUrlParam('authToken');
	optionCookie(authToken);
	orgId = $.util.getUrlParam('orgId');
	role = $.util.getUrlParam('role');
	//设置菜单的图标
	setMenuIcon();
	//获取档案的基本信息
    getArchiveInfo();
}
//设置菜单事件
function setMenuEvent(){
	// 一级菜单切换
    $(".menuLi .menuBtn").click(function () {
        $(".menuBtn").removeClass("menuAct");
        $(this).addClass("menuAct");
        // 切换iframe的src
        if ($('#mainIframe').attr('src') !== $(this).attr('src') && $(this).attr('src') !== '') {
            $('#mainIframe').attr('src',$(this).attr('src'));
        }
        $(".menuBtn").next().stop().hide();
        $(".childMenu li").removeClass("erjiAct");
        if ($(this).attr('src') === '') {
            $(this).next().stop().show();
        }
    });
    $(".childMenu li").click(function () {
        $(".childMenu li").removeClass("erjiAct");
        $(this).addClass("erjiAct");
        if ($('#mainIframe').attr('src') !== $(this).attr('src') && $(this).attr('src') !== '') {
            $('#mainIframe').attr('src',$(this).attr('src'));
        }
    });
    var bodyHeight = $(window).height();
    function divResize () {
        bodyHeight = $(window).height();
        $("#mainIframe").css({height: bodyHeight - 130 + 'px'});
        $(".leftMenu").css({height: bodyHeight - 130 + 'px'});
    }
    divResize();
    $(window).resize(function(){
        divResize();
    });
}
var iconMap = {};
//设置菜单的图标
function setMenuIcon(){
	iconMap['居民基本信息'] = '&#xe601;';
	iconMap['预防接种信息'] = '&#xe605;';
	iconMap['居民体检信息'] = '&#xe663;';
	iconMap['双向转诊信息'] = '&#xe65f;';
	iconMap['随访信息'] = '&#xe606;';
	iconMap['门诊信息'] = '&#xe660;';
	iconMap['住院信息'] = '&#xe661;';
	iconMap['签约信息'] = '&#xe600;';
    iconMap['临检检验'] = '&#xe603;';
}