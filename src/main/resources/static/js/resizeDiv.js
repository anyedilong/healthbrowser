$(function () {
    var pageHeight = $(window).height();
    function divResize () {
        pageHeight = $(window).height();
        $(".pageCont").css({height: pageHeight - 30 + 'px'});
        $(".leftCard").css ({
            height: $(".pageCont").height() - 40 + 'px',
            width: $(".pageCont").width() * 0.35 + 'px'
        });
        $(".rightCard").css ({
            height: $(".pageCont").height() - 40 + 'px',
            width: $(".pageCont").width() * 0.65 - 40 - 15 + 'px'
        });
        $(".cons-txt").css ({
            width: $(".consLi").width() - 205 + 'px'
        });
    }
    divResize();
    $(window).resize(function(){
        divResize();
    });
})