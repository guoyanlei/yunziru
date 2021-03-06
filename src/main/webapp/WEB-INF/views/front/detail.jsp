<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <title>${movie.title} 百度云网盘下载 百度云资源 云自如</title>
    <meta name="description" content="${movie.title} 百度云 百度网盘 云自如">
    <meta name="keywords" content="${movie.title} 百度云 百度网盘 云自如" />
<%@ include file="header.jsp"%>

<div class="am_ziyuan">
    <div class="am_ziyuan_user">
        <div class="am_ziyuan_user_info">
            <div class="am_ziyuan_user_info_name">${movie.title}</div>
            <div class="am_ziyuan_user_info_coordinate">
                &nbsp; <span class="am-icon-leaf"> &nbsp; ${movie.year} </span> &nbsp;&nbsp;
                <span class="am-icon-tag"> ${movie.location}  ${movie.type}</span>
            </div>
        </div>
    </div>

    <div class="am_ziyuan_content">
        <div class="am_ziyuan_content_l">
            <div data-am-widget="slider" class="am-slider am-slider-default" data-am-slider='{}' >
                <ul class="am-slides">
                    <c:forEach items="${movie.images}" var="image">
                        <li>
                            <img src="${image}" alt="">
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <section class="am-panel am-panel-default">
                <header class="am-panel-hd">
                    <h3 class="am-panel-title">简介</h3>
                </header>
                <div class="am-panel-bd" style="font-size: 14px;">
                    ${movie.summary}
                </div>


            </section>

            <div class="am-panel am-panel-success">
                <header class="am-panel-hd">
                    <h3 class="am-panel-title">下载区</h3>
                </header>
                <div class="am-panel-bd" style="font-size: 14px;">
                    网盘链接： ${movie.baiduLink}  密码：${movie.baiduPwd} <br/>
                    其他下载：
                    <c:forEach var="entry" items="${ movie.ed2kLinks}">
                        <a href="${entry.key}">${entry.value}</a> <br/>
                    </c:forEach>
                </div>

                <div class="bdsharebuttonbox" style="float: right">
                    <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                    <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                    <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
                    <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
                    <a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
                    <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                    <a href="#" class="bds_more" data-cmd="more"></a>
                </div>
            </div>
        </div>
        <div class="am_ziyuan_content_r">
            <ul class="am_ziyuan_r_info">
                <li><i class="am-icon-heart"></i><span> ${movie.priseCount} 人喜欢</span></li>
                <li><i class="am-icon-eye"></i><span> ${movie.hotCount} 次查看</span></li>
                <li><i class="am-icon-clock-o"></i><span>发布 ${movie.createTime}</span></li>
            </ul>
            <ul class="am_ziyuan_share">
                <div class="opera">
                    <span id="btn" onclick="prise()">
                        <i class="iconfont">&#xe602;</i> 感觉不错，赞一个
                    </span>
                </div>

            </ul>
            <ul class="am_ziyuan_tag">
                <li><span class="am_ziyuan_tag_title">TAG</span></li>
                <div id = "tag_movies">
                    <c:forEach var="tagMovie" items="${tagMovies}">
                        <li><a href="#"><span>${tagMovie.tagName}</span><span>${tagMovie.movieCount}</span></a></li>
                    </c:forEach>
                </div>
                <li><a href="#"><span></span><span></span></a></li>
            </ul>
            <div class="page_hot">
                <div class="page_hot_title">人气资源</div>
                <div class="page_hot_list">
                    <c:forEach var="hotMovie" items="${hotMovies}">
                        <div class="page_hot_block">
                        <dl>
                            <dt>
                                <a href="${pageContext.request.contextPath}/movies/${hotMovie.id}/detail">
                                <img src="${hotMovie.poster}" alt=""></a></dt>
                            <dd>
                                <i style="font-size: 14px;color: #a1a1a1;">
                                    <a href="${pageContext.request.contextPath}/movies/${hotMovie.id}/detail">
                                    ${hotMovie.name}</a>
                                </i>
                                <em>${movie.createTime}
                                </em>
                                <div class="hot_block_info">
                                    <div class="hot_info_l am-icon-cloud-download">${hotMovie.hotCount}</div>
                                </div>
                            </dd>
                        </dl>
                        </div>
                    </c:forEach>
                </div>
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
                                <span class="am-icon-cloud-download">${movie.hotCount}</span>
                                <span class="am-icon-share-square-o">${movie.createTime}</span>
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

    window._bd_share_config = {
        "common": {
            "bdSnsKey": {},
            "bdText": "自如分享分享自如，最自如的云资源分享",
            "bdDesc": "${movie.title}",
            "bdMini": "2",
            "bdMiniList": false,
            "bdPic": "${movie.poster}",
            "bdStyle": "1",
            "bdSize": "24"
        },
        "share": {},
        "slide" : [{
            "bdImg" : 0,
            "bdPos" : "right",
            "bdTop" : 100
        }]
    };
    with(document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~ ( - new Date() / 36e5)];

</script>
<script>

    $.post('hot',function(data){
        if(!data.success)
        {
            console.log(data.msg);
            return false;
        }
    },'json');

    function prise(){

        $.post('prise',function(data){
            if(!data.success) {
                console.log(data.msg);
                return false;
            }
        },'json');
    }

    var tagMoviesHtml = '';
    $.get('tagMovies',function(data){
        if(!data.success){
            console.log(data.msg);
            return false;
        }
        for( var i = 0 ; i < data.data.length ; i++ ){
            tagMoviesHtml += "<li><a href=\"#\"><span>" + data.data[i].tagName +"</span><span>" + data.data[i].movieCount +"</span></a></li>\n";
        }
        $('#tag_movies').append(tagMoviesHtml);
        page++;
    },'json');

</script>
<%@ include file="footer.jsp"%>