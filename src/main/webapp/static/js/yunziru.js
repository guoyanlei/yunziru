$(function() {
    // $('.am-dropdown').on('mouseover',function(){
    //     $(this).addClass('am-active');
    // });
    // $('.am-dropdown').on('mouseout',function(){
    //     $(this).removeClass('am-active');
    // });
    //     if($('.get').width() < 640){
    //     $('.get').height($('.get').width() / ( 1920 / 278 ));
    //     alert($('.get').height());
    // }
    //     var mobile_prtscn_width  = $('.am-max540').width();
    // var mobile_views_width   =  mobile_prtscn_width;
    // var mobile_views_heigth  =  mobile_views_width / (1200 / 220);
    // $('.am-bottom-don2').css({'height':mobile_views_heigth,'width':mobile_views_width});
    $(window).resize(function() {
        $('.am_listimg_info .am_imglist_time').css('display', $('.am_list_block').width() <= 170 ? 'none': 'block');
    });

    //@首页 图片滑动效果
    $(".am_list_block").on('mouseover',
        function() {
            $('.am_img_bg').removeClass('am_img_bg');
            $(this).find('.am_img').addClass('bounceIn');
        });
    $('.am_img').on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
        function() {
            $('.am_img').removeClass('bounceIn');
        });
    if ($(window).width() < 700) {
        $('.am_list_block').off();
    }

    //@首页 底部下载按钮
    // function mouse_over_out(obj, style, overcss, outcss) {
    //      obj.bind('mouseover', function() {
    //          $(this).css(style, overcss);
    //      });
    //      obj.bind('mouseout', function() {
    //          $(this).css(style, outcss);
    //      });
    //  }

    //@首页 图片列表长宽相等
    $(window).resize(function() {
        $('.am_img_bg').height($('.am_img_bg').width());
    });
    //@首页 用户名截取
    $('.am-gallery-desc').each(function() {
        if ($(this).text().length >= 28) {
            $(this).html($(this).text().substr(0, 28) + "...");
        }
    });

    //@懒加载
    $("img.am_img").lazyload();
    $("a.am_img_bg").lazyload({
        threshold: 1,
        effect: 'fadeOut'
    });

});

//动画效果
function OpenDonghua(Chufa, Mubiao, Xiaoguo) {
    Chufa.on('mouseover',
        function() {
            $(this).find(Mubiao).addClass(Xiaoguo);
        });
}
function CloseDonghua(Chufa, Mubiao, Xiaoguo) {
    Chufa.on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
        function() {
            Mubiao.removeClass(Xiaoguo);
        });
}

function getDateDiff(dateTimeStamp) {
    var minute = 1000 * 60;
    var hour = minute * 60;
    var day = hour * 24;
    var halfamonth = day * 15;
    var month = day * 30;
    var now = new Date().getTime();
    var diffValue = now - dateTimeStamp;
    if (diffValue < 0) {
        return;
    }
    var monthC = diffValue / month;
    var weekC = diffValue / (7 * day);
    var dayC = diffValue / day;
    var hourC = diffValue / hour;
    var minC = diffValue / minute;
    if (monthC >= 1) {
        result = "" + parseInt(monthC) + "月前";
    } else if (weekC >= 1) {
        result = "" + parseInt(weekC) + "周前";
    } else if (dayC >= 1) {
        result = "" + parseInt(dayC) + "天前";
    } else if (hourC >= 1) {
        result = "" + parseInt(hourC) + "小时前";
    } else if (minC >= 1) {
        result = "" + parseInt(minC) + "分钟前";
    } else result = "刚刚";
    return result;
}