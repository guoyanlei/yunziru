<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <title>云自如-编辑推荐 百度云 云资源 百度网盘资源 bt种子分</title>
    <meta name="description" content="是拥有超级丰富的云资源分享平台,自如分享最新电影,经典电影与电视剧资源云链接,是云资源爱好者最好的分享平台之一。想更自如的获得更多云资源,就上云自如,因为有你所以更精彩!">
    <meta name="keywords" content="云自如,云资源,百度云盘,百度云,百度云搜索,百度云资源,百度云下载,百度云网盘,bt下载,bt种子,bt天堂" />
<%@ include file="header.jsp"%>
<%@ include file="banner.jsp"%>

<div class="banner_navbg">
    <div class="am-g">
        <div class="banner_nav"><span class="am-icon-caret-right">  筛选：</span>
            <a href="${pageContext.request.contextPath}/" title="最新发布" target="_self" class="click_rqzg">最新发布</a>
            <a href="recommend" title="编辑推荐" target="_self" class="click_bjtj banner_hover">编辑推荐</a>
            <a href="hot" title="人气最高" target="_self"  class="click_rqzg">人气最高</a>
        </div>
    </div>
</div>

<div class="am-g am-imglist">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-3 am-avg-lg-6 am-gallery-imgbordered am_index_addimglist" data-am-gallery="{  }" >

        <c:forEach var="movie" items="${movies}">
            <li>
                <div class="am-gallery-item">
                    <a href="movies/${movie.id}/detail" class="">
                        <img class="am_img animated" alt="${movie.title}"
                             src="${pageContext.request.contextPath}/static/front/img/loading.gif"
                             data-original="${movie.poster}"/>
                        <div class="am_listimg_info">
                            <span class="am-icon-cloud-download">${movie.hotCount}</span>
                            <span class="am-icon-share-square-o">${movie.createTime}</span>
                        </div>
                        <div class="am-gallery-desc" style="padding-top: 5px;">${movie.title}</div>
                    </a>
                </div>
            </li>
        </c:forEach>
    </ul>
    <div class="am_news_load am_news_load_index">
            <span><i class="am-icon-spinner am-icon-spin"></i>加载更多推荐资源
            </span>
    </div>
</div>
<script>
    var page     = 2;
    var pageSize = 20;
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
        $.get('recommend/movies/list?page='+ page + '&size=' + pageSize,function(data){

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
                "                             src=\"${pageContext.request.contextPath}/static/front/img/loading.gif\"\n" +
                "                             data-original=\"" + data.data[i].poster + "\"/>\n" +
                "                        <div class=\"am_listimg_info\">\n" +
                "                            <span class=\"am-icon-cloud-download\">" + data.data[i].hotCount + "</span>\n" +
                "                            <span class=\"am-icon-share-square-o\">" + data.data[i].createTime + "</span>\n" +
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
                if(data.data.number < data.data.totalPages ){
                    load_more(page,pageSize);
                }
            });
            page++;
        },'json');
    }

</script>
<%@ include file="footer.jsp"%>
