<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            </div>
        </div>
        <div class="am_ziyuan_content_r">
            <ul class="am_ziyuan_r_info">
                <li><i class="am-icon-heart"></i><span> ${movie.priseCount} 人喜欢</span></li>
                <li><i class="am-icon-eye"></i><span> ${movie.hotCount} 次查看</span></li>
                <li><i class="am-icon-clock-o"></i><span>发布
                    <script>
                        var d = new Date(${movie.createTime});
                        var date = (d.getFullYear()) + "-" +
                                (d.getMonth() + 1) + "-" +
                                (d.getDate());
                        document.write(date);
                    </script></span></li>
            </ul>
            <ul class="am_ziyuan_share">
                <button type="button" class="am-btn am-btn-success am-radius"><i class="am-icon-heart"></i>
                    喜欢
                </button> &nbsp;&nbsp;
                <button type="button" class="am-btn am-btn-warning am-radius"><i class="am-icon-share-square-o"></i>
                    &nbsp;分享
                </button>
            </ul>
            <ul class="am_ziyuan_tag">
                <li><span class="am_ziyuan_tag_title">TAG</span></li>
                <li><a href=""><span>2017</span><span>15623</span></a></li>
                <li><a href=""><span>美国</span><span>6251</span></a></li>
                <li><a href=""><span>剧情</span><span>3256</span></a></li>
                <li><a href=""><span>百度云</span><span>54</span></a></li>
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
                                <i>
                                    <a href="${pageContext.request.contextPath}/movies/${hotMovie.id}/detail">
                                    ${hotMovie.name}</a>
                                </i>
                                <em>
                                    <script>
                                        var d = new Date(${movie.createTime});
                                        var date = (d.getFullYear()) + "-" +
                                                (d.getMonth() + 1) + "-" +
                                                (d.getDate());
                                        document.write(date);
                                    </script>
                                </em>
                                <div class="hot_block_info">
                                    <div class="hot_info_l am-icon-heart">${hotMovie.priseCount}</div>
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
                                 src="${pageContext.request.contextPath}/static/img/loading.gif"
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
<%@ include file="footer.jsp"%>