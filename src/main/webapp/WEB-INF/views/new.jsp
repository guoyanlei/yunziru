<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="get">
    <div class="am-g">
        <div class="am-u-lg-12">
            <div class="get-title">
                <div class="get_font_left"><img src="${pageContext.request.contextPath}/static/img/font_yjy.png" alt=""></div>
                <div class="get_font_center" id="banner_num"></div>
                <div class="get_font_rigth"><img src="${pageContext.request.contextPath}/static/img/font_zty.png" alt=""></div>
            </div>

            <div class="font_line"><img src="${pageContext.request.contextPath}/static/img/font_line.png" alt=""></div>
            <p>
                <a href="https://itunes.apple.com/us/app/chong-wu-xiu/id976605844?l=zh&ls=1&mt=8" title="宠物App store版" class="am-btn am-btn-sm get-btn  am-radius banner_ios am-icon-refresh " rel="nofollow"> Refresh</a> <a
                    href="http://android.myapp.com/myapp/detail.htm?apkName=com.staffy.pet" title="宠物秀安卓版" class="am-btn am-btn-sm  am-radius get-btn banner_android am-icon-cloud-upload" rel="nofollow"> Upload</a>
            </p>
        </div>
    </div>
</div>
<div class="banner_navbg">
    <div class="am-g">
        <div class="banner_nav"><span class="am-icon-caret-right">  筛选：</span>
            <a href="${pageContext.request.contextPath}" title="最新发布" target="_self" class="click_bjtj banner_hover">最新发布</a>
            <a href="recommend" title="编辑推荐" target="_self" class="click_rqzg" >编辑推荐</a>
            <a href="hot" title="人气最高" target="_self"  class="click_rqzg">人气最高</a>
        </div>
    </div>
</div>

<div class="am-g am-imglist">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-3 am-avg-lg-6 am-gallery-imgbordered am_index_addimglist" data-am-gallery="{  }" >

    </ul>
    <div class="am_news_load am_news_load_index">
            <span><i class="am-icon-spinner am-icon-spin"></i>加载更多云资源
            </span>
    </div>
</div>
<script>
    var page     = 1;
    var pageSize = 24;
    var datalist = 'indexrecommendlist';

    $(function(){
        load_more();
    });

    $('.am-icon-spinner').hide();
    $('.am_news_load_index').on('click',function(){
        $('.am-icon-spinner').show();
        load_more();
    });

    function load_more(){

        var indexListImgHtml = '';
        $('.am_news_load_index').unbind('click');
        $.get('movies/list?page='+ page + '&size=' + pageSize,function(data){

            $('.am-icon-spinner').hide();
            // 数据异常
            if(!data.success)
            {
                console.log(data.msg);
                return false;
            }
            for( var i = 0 ; i < data.data.length ; i++ ){
                indexListImgHtml += "<li>\n" +
                "                <div class=\"am-gallery-item\">\n" +
                "                    <a href=\"movies/"+ data.data[i].id + "/detail\" class=\"\">\n" +
                "                        <img class=\"am_img animated\" alt=\"\"\n" +
                "                             src=\"${pageContext.request.contextPath}/static/img/loading.gif\"\n" +
                "                             data-original=\"" + data.data[i].poster + "\"/>\n" +
                "                        <div class=\"am_listimg_info\">\n" +
                "                            <span class=\"am-icon-heart\">" + data.data[i].priseCount + "</span>\n" +
                "                            <span class=\"am-icon-tag\">" + getDateDiff(data.data[i].createTime) + "</span>\n" +
                "                        </div>\n" +
                "                        <div class=\"am-gallery-desc\" style=\"padding-top: 5px;\">" + data.data[i].title + "</div>\n" +
                "                    </a>\n" +
                "                </div>\n" +
                "            </li>";
            }
            $('.am_index_addimglist').append(indexListImgHtml);
            // 懒加载
            $("img.am_img").lazyload();
            $("a.am_img_bg").lazyload({
                effect : 'fadeIn'
            });
            // 点击加载更多
            $('.am_news_load_index').on('click',function(){
                $('.am-icon-spinner').show();
                load_more(page,pageSize);
            });
            page++;
        },'json');
    }

</script>
<%@ include file="footer.jsp"%>
