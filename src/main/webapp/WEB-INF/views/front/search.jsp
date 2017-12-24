<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <title>云自如-自如搜索 百度云 云资源 百度网盘资源 bt种子分享</title>
    <meta name="description" content="是拥有超级丰富的云资源分享平台,自如分享最新电影,经典电影与电视剧资源云链接,是云资源爱好者最好的分享平台之一。想更自如的获得更多云资源,就上云自如,因为有你所以更精彩!">
    <meta name="keywords" content="云自如,云资源,百度云盘,百度云,百度云搜索,百度云资源,百度云下载,百度云网盘,bt下载,bt种子,bt天堂" />

<%@ include file="header.jsp"%>
<div data-am-widget="tabs" class="am-tabs am-tabs-d2 am_news_tab">
    <ul class="am-tabs-nav am-cf am_cf">
        <li class="am-active">
            <a href="[data-tab-panel-0]">搜电影</a>
        </li>
        <li class="">
            <a href="[data-tab-panel-1]">搜美剧</a>
        </li>
        <li class="">
            <a href="[data-tab-panel-2]">搜其他</a>
        </li>
    </ul>
    <div class="am-tabs-bd">
        <div data-tab-panel-0 class="am-tab-panel am-active">
            <div class="am-list-news-bd am_news_list_all" >
                <div class="am-input-group am-input-group-success" style="padding-top: 40px; width: 80%;margin:0 auto; text-align: center">
                    <input type="text" name="movie_keyword" onkeydown="movie_search()" id="movie_keyword" class="am-form-field" placeholder="自如搜电影">
                    <span class="am-input-group-label" onclick="movie_search()" >
                        <i class="am-icon-search am-icon-fw" ></i>
                    </span>
                </div>
            </div>
            <div class="am-list-news-bd am_news_list_all">
                <ul class="am-list am_movie_search_add_list">

                </ul>
            </div>
            <div class="am_news_load am_news_load_index">
                <span><i class="am-icon-spinner am-icon-spin"></i> 加载更多
                </span>
            </div>
        </div>
        <div data-tab-panel-1 class="am-tab-panel ">
            <div class="am-list-news-bd am_news_list_all" >
                <div class="am-input-group am-input-group-success" style="padding-top: 40px; width: 80%;margin:0 auto; text-align: center">
                    <input type="text" name="meiju_keyword" onkeydown="meiju_search()" id="meiju_keyword" class="am-form-field" placeholder="自如搜美剧">
                    <span class="am-input-group-label" onclick="meiju_search()" >
                        <i class="am-icon-search am-icon-fw" ></i>
                    </span>
                </div>
            </div>
            <div class="am-list-news-bd am_news_list_all">
                <ul class="am-list am_meiju_search_add_list">

                </ul>
            </div>
            <div class="am_news_load am_news_load_index">
                <span><i class="am-icon-spinner am-icon-spin"></i> 加载更多
                </span>
            </div>
        </div>
        <div data-tab-panel-2 class="am-tab-panel ">
            <div class="am-list-news-bd am_news_list_all" >
                <div class="am-input-group am-input-group-success" style="padding-top: 40px; width: 80%;margin:0 auto; text-align: center">
                    <input type="text" name="other_keyword" onkeydown="other_search()" id="other_keyword" class="am-form-field" readonly placeholder="自如搜其他">
                    <span class="am-input-group-label" onclick="other_search()" >
                        <i class="am-icon-search am-icon-fw" ></i>
                    </span>
                </div>
            </div>
            <div class="am-list-news-bd am_news_list_all">
                <ul class="am-list am_other_search_add_list">

                </ul>
            </div>
            <div class="am_news_load am_news_load_index">
                <span><i class="am-icon-spinner am-icon-spin"></i> 加载更多
                </span>
            </div>
        </div>
    </div>

</div>


<div class="am_ziyuan_cai">
    <div class="am_ziyuan_cai_ti">猜你喜欢</div>
    <div class="am-g am-imglist">
        <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-3 am-avg-lg-4 am-gallery-imgbordered" data-am-gallery="{  }" >
            <c:forEach var="movie" items="${ulikeMovies}">
                <li>
                    <div class="am-gallery-item">
                        <a href="${pageContext.request.contextPath}/movies/${movie.id}/detail" class="">
                            <img class="am_img animated" alt="${movie.title}"
                                 src="${pageContext.request.contextPath}/static/front/img/loading.gif"
                                 data-original="${movie.poster}"/>
                            <div class="am_listimg_info">
                                <span class="am-icon-heart">${movie.priseCount}</span>
                            <span class="am-icon-tag">${movie.createTime}
                            </span>
                            </div>
                            <div class="am-gallery-desc" style="padding-top: 5px;">${movie.title}</div>
                        </a>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>


</div>
<script>

    var movie_page     = 1;
    var movie_pageSize = 10;

    $('.am-icon-spinner').hide();
    $('.am_news_load_index').on('click',function(){
        $('.am-icon-spinner').show();
        movie_load_more();
    });

    function movie_search() {
        movie_page = 1;
        if (movie_page == 1 || $('#movie_keyword').val() == '') {
            $('.am_movie_search_add_list').empty();
        }
        movie_load_more();
    }
    function movie_load_more(){

        var keyword = $('#movie_keyword').val();
        var searchHtml = '';
        $('.am_news_load_index').unbind('click');
        $.get('movies/list?page='+ movie_page + '&size=' + movie_pageSize + '&keyword=' + encodeURI(keyword), function(data){

            $('.am-icon-spinner').hide();
            // 数据异常
            if(!data.success)
            {
                console.log(data.msg);
                return false;
            }
            for( var i = 0 ; i < data.data.length ; i++ ){

                searchHtml += "" +
                        "<li class=\"am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left am_list_li\">\n" +
                        "    <div class=\"page_hot_block\" style=\"width:100%; height: 100px;\">\n" +
                        "        <dl style=\"width:100%; height: 150px;\">\n" +
                        "            <dt style=\"margin-top:5px; width: 83px; height: 100px;\">\n" +
                        "            <img src=\"" + data.data[i].poster + "\" alt=\"\" style=\"margin-left:5px;width: 78px; height: 100px;\"/>\n" +
                        "            </dt>\n" +
                        "        <dd style=\"margin-top:5px;\">\n" +
                        "        <h3 class=\"am-list-item-hd am_list_title\" style=\"line-height: 20px;\">\n" +
                        "            <a href=\"movies/"+ data.data[i].id + "/detail\">" + data.data[i].title + "</a>\n" +
                        "        </h3>\n" +
                        "        <div class=\"am_listimg_info\">\n" +
                        "            <span class=\"am-icon-heart\">" + data.data[i].priseCount + "</span>\n" +
                        "            <span class=\"am-icon-eye\">" + data.data[i].hotCount + "</span>\n" +
                        "            <span class=\"am-icon-tag\">" + getDate(data.data[i].createTime) + "</span>\n" +
                        "        </div>\n" +
                        "        </dd>\n" +
                        "        </dl>\n" +
                        "     </div>\n" +
                        "</li>\n";
            }
            $('.am_movie_search_add_list').append(searchHtml);
            // 点击加载更多
            $('.am_news_load_index').on('click',function(){
                movie_page++;
                $('.am-icon-spinner').show();
                movie_load_more(movie_page,movie_pageSize);
            });
        },'json');
    }
</script>
<script>

    var meiju_page     = 1;
    var meiju_pageSize = 10;

    $('.am-icon-spinner').hide();
    $('.am_news_load_index').on('click',function(){
        $('.am-icon-spinner').show();
        meiju_load_more();
    });

    function meiju_search() {
        meiju_page = 1;
        if (meiju_page == 1 || $('#meiju_keyword').val() == '') {
            $('.am_meiju_search_add_list').empty();
        }
        meiju_load_more();
    }
    function meiju_load_more(){

        var keyword = $('#meiju_keyword').val();
        var searchHtml = '';
        $('.am_news_load_index').unbind('click');
        $.get('meijus/list?page='+ meiju_page + '&size=' + meiju_pageSize + '&keyword=' + encodeURI(keyword), function(data){

            $('.am-icon-spinner').hide();
            // 数据异常
            if(!data.success)
            {
                console.log(data.msg);
                return false;
            }
            for( var i = 0 ; i < data.data.length ; i++ ){

                searchHtml += "" +
                        "<li class=\"am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left am_list_li\">\n" +
                        "    <div class=\"page_hot_block\" style=\"width:100%; height: 100px;\">\n" +
                        "        <dl style=\"width:100%; height: 150px;\">\n" +
                        "            <dt style=\"margin-top:5px; width: 83px; height: 100px;\">\n" +
                        "            <img src=\"" + data.data[i].poster + "\" alt=\"\" style=\"margin-left:5px;width: 78px; height: 100px;\"/>\n" +
                        "            </dt>\n" +
                        "        <dd style=\"margin-top:5px;\">\n" +
                        "        <h3 class=\"am-list-item-hd am_list_title\" style=\"line-height: 20px;\">\n" +
                        "            <a href=\"meijus/"+ data.data[i].id + "/detail\">【" + data.data[i].updateStatus + "】" + data.data[i].title + "</a>\n" +
                        "        </h3>\n" +
                        "        <div class=\"am_listimg_info\">\n" +
                        "            <span class=\"am-icon-heart\">" + data.data[i].priseCount + "</span>\n" +
                        "            <span class=\"am-icon-eye\">" + data.data[i].hotCount + "</span>\n" +
                        "            <span class=\"am-icon-tag\">" + data.data[i].date + "</span>\n" +
                        "        </div>\n" +
                        "        </dd>\n" +
                        "        </dl>\n" +
                        "     </div>\n" +
                        "</li>\n";
            }
            $('.am_meiju_search_add_list').append(searchHtml);
            // 点击加载更多
            $('.am_news_load_index').on('click',function(){
                meiju_page++;
                $('.am-icon-spinner').show();
                meiju_load_more(meiju_page,meiju_pageSize);
            });
        },'json');
    }
</script>
<%@ include file="footer.jsp"%>