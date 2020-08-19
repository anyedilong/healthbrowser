$.util = {
	// 验证是否为空
	isNull : function(obj) {
		if (obj == null || obj == '' || typeof (obj) == "undefined" ||obj=='null' ||obj=='undefined'
				) {
			return true;
		}
		return false;
	},
	//获取页面之间的传参
	getUrlParam : function(name){
		 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
         var r = window.location.search.substr(1).match(reg);
         if (r != null) return decodeURI(r[2]); return null;
	}
};


