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
                <div class="page_hot_list"><div class="page_hot_block">
                    <dl>
                        <dt>
                            <a href="/21712.html">
                            <img src="https://img.alicdn.com/imgextra/i1/2539261409/TB2s0WIbvY85uJjSZFzXXc93VXa_!!2539261409.png" alt=""></a></dt>
                        <dd>
                            <i>极寒之城.美版</i>
                            <em>2天前</em>
                            <div class="hot_block_info">
                                <div class="hot_info_l am-icon-heart">16</div>
                            </div>
                        </dd>
                    </dl>
                </div>
                    <div class="page_hot_block">
                        <dl>
                            <dt><a href="/19866.html">
                                <img src="${pageContext.request.contextPath}/static/img/075357imgjyylc0yxmgmpc.jpg" alt=""></a></dt>
                            <dd>
                                <i>昨日重现</i>
                                <em>2天前</em>
                                <div class="hot_block_info">
                                    <div class="hot_info_l am-icon-heart">14</div>
                                </div>
                            </dd>
                        </dl>
                    </div>
                    <div class="page_hot_block">
                        <dl>
                            <dt><a href="/23083.html">
                                <img src="${pageContext.request.contextPath}/static/img/145212w5rkka5xc1m2dsj0.jpg" alt=""></a></dt>
                            <dd>
                                <i>赛车总动员3:极速挑战</i>
                                <em>12天前</em>
                                <div class="hot_block_info">
                                    <div class="hot_info_l am-icon-heart">13</div>
                                </div>
                            </dd>
                        </dl>
                    </div>
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
            <li>
                <div class="am-gallery-item">
                    <a href="detail" class="">
                        <img class="am_img animated" alt="米斯特苏  的宠物猫宠物狗"
                             src="${pageContext.request.contextPath}/static/img/loading.gif"
                             data-original="${pageContext.request.contextPath}/static/img/083816a1eanxbt11nlx4a8.jpg" />
                        <div class="am_listimg_info">
                            <span class="am-icon-heart">27</span>
                            <span class="am-icon-tag">2天前</span>
                        </div>
                        <div class="am-gallery-desc" style="padding-top: 5px;">《布希维克/全境警戒》720p. BD高清中英双字 百度云网盘下载</div>
                    </a>
                </div>
            </li>
            <li>
                <div class="am-gallery-item">
                    <a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
                        <img src="https://img.alicdn.com/imgextra/i1/2539261409/TB2s0WIbvY85uJjSZFzXXc93VXa_!!2539261409.png"  alt="某天 也许会相遇 相遇在这个好地方"/>
                        <div class="am_listimg_info">
                            <span class="am-icon-heart">27</span>
                            <span class="am-icon-tag">2天前</span>
                        </div>
                        <div class="am-gallery-desc">《极寒之城.美版》720p.HD高清中英双字 百度云网盘下载</div>
                    </a>
                </div>
            </li>
            <li>
                <div class="am-gallery-item">
                    <a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
                        <img src="${pageContext.request.contextPath}/static/img/075357imgjyylc0yxmgmpc.jpg"  alt="不要太担心 只因为我相信"/>
                        <div class="am_listimg_info">
                            <span class="am-icon-heart">27</span>
                            <span class="am-icon-tag">2天前</span>
                        </div>
                        <div class="am-gallery-desc">《昨日重现》720p.HD高清中字 百度云网盘下载</div>
                    </a>
                </div>
            </li>
            <li>
                <div class="am-gallery-item">
                    <a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
                        <img src="${pageContext.request.contextPath}/static/img/145212w5rkka5xc1m2dsj0.jpg"  alt="终会走过这条遥远的道路"/>
                        <div class="am_listimg_info">
                            <span class="am-icon-heart">27</span>
                            <span class="am-icon-tag">2天前</span>
                        </div>
                        <div class="am-gallery-desc">《赛车总动员3：极速挑战》1080p.国英双语.HD高清中字 百度云网盘下载</div>
                    </a>
                </div>
            </li>
        </ul>
    </div>


</div>
<%@ include file="footer.jsp"%>