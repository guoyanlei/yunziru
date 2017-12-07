<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <title>云自如-自如搜索 百度云 云资源 百度网盘资源 bt种子分享</title>
    <meta name="description" content="是拥有超级丰富的云资源分享平台,自如分享最新电影,经典电影与电视剧资源云链接,是云资源爱好者最好的分享平台之一。想更自如的获得更多云资源,就上云自如,因为有你所以更精彩!">
    <meta name="keywords" content="云自如,云资源,百度云盘,百度云,百度云搜索,百度云资源,百度云下载,百度云网盘,bt下载,bt种子,bt天堂" />

<%@ include file="header.jsp"%>

<div class="am-list-news-bd am_news_list_all" >
    <div class="am-input-group am-input-group-success" style="padding-top: 50px; width: 80%;margin:0 auto; text-align: center">
        <input type="text" name="keyword" id="keyword" class="am-form-field" placeholder="自如搜索一下">
        <span class="am-input-group-label" onclick="search()" >
            <i class="am-icon-search am-icon-fw" ></i>
        </span>
    </div>
</div>

<div class="am-list-news-bd am_news_list_all">
    <ul class="am-list am_search_add_list">

    </ul>
    <div class="am_news_load am_news_load_index">
        <span><i class="am-icon-spinner am-icon-spin"></i> 加载更多
        </span>
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
                            <span class="am-icon-tag">
                                <script>
                                    var d = new Date(${movie.createTime});
                                    var date = (d.getFullYear()) + "-" +
                                            (d.getMonth() + 1) + "-" +
                                            (d.getDate());
                                    document.write(date);
                                </script>
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

    var page     = 1;
    var pageSize = 10;

    $('.am-icon-spinner').hide();
    $('.am_news_load_index').on('click',function(){
        $('.am-icon-spinner').show();
        load_more();
    });

    function search() {
        page = 1;
        if (page == 1 || $('#keyword').val() == '') {
            $('.am_search_add_list').empty();
        }
        load_more();
    }
    function load_more(){

        var keyword = $('#keyword').val();
        var searchHtml = '';
        $('.am_news_load_index').unbind('click');
        $.get('movies/list?page='+ page + '&size=' + pageSize + '&keyword=' + encodeURI(keyword), function(data){

            $('.am-icon-spinner').hide();
            // 数据异常
            if(!data.success)
            {
                console.log(data.msg);
                return false;
            }
            for( var i = 0 ; i < data.data.length ; i++ ){

                searchHtml += "<li class=\"am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left am_list_li\">\n" +
                        "               <div>\n" +
                        "                   <h3 class=\"am-list-item-hd am_list_title\">\n"+
                        "                   <a href=\"movies/"+ data.data[i].id + "/detail\">" + data.data[i].title + "</a>\n"+
                        "                   </h3>\n"+
                        "               </div>\n"+
                        "               <div class=\"am_listimg_info\">\n" +
                        "                    <span class=\"am-icon-heart\">" + data.data[i].priseCount + "</span>\n" +
                        "                    <span class=\"am-icon-eye\">" + data.data[i].hotCount + "</span>\n" +
                        "                    <span class=\"am-icon-tag\">" + getDate(data.data[i].createTime) + "</span>\n" +
                        "               </div>\n" +
                        "       </li>\n";
            }
            $('.am_search_add_list').append(searchHtml);
            // 点击加载更多
            $('.am_news_load_index').on('click',function(){
                page++;
                $('.am-icon-spinner').show();
                load_more(page,pageSize);
            });
        },'json');
    }
</script>
<%@ include file="footer.jsp"%>