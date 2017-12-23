<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <title>${meiju.title} 百度云网盘下载 百度云资源 云自如</title>
    <meta name="description" content="${meiju.title} 百度云 百度网盘 云自如">
    <meta name="keywords" content="${meiju.title} 百度云 百度网盘 云自如" />
<%@ include file="../header.jsp"%>

<div class="am_ziyuan">
    <div class="am_ziyuan_user">
        <div class="am_ziyuan_user_info">
            <div class="am_ziyuan_user_info_name">【${meiju.updateStatus}】${meiju.title}</div>
            <div class="am_ziyuan_user_info_coordinate">
                &nbsp; <span class="am-icon-leaf"> &nbsp; ${meiju.date} </span> &nbsp;&nbsp;
                <span class="am-icon-tag"> ${meiju.tagCh}  ${meiju.categoryCh}</span>
            </div>
        </div>
    </div>

    <div class="am_ziyuan_content">
        <div class="am_ziyuan_content_l">

            <div class="page_hot_block" style="width: 500px; height: 205px;">
                <dl style="width: 500px; height: 205px;">
                    <dt style="margin-top:5px; width: 160px; height: 205px;">
                        <img src="${meiju.poster}" alt="" style="margin-left:5px;width: 155px; height: 200px;"/>
                    </dt>
                    <dd style="margin-top:5px;">
                        <i style="font-size: 14px;color: #a1a1a1;">
                            ${meiju.summaryBase}
                        </i>
                    </dd>
                </dl>
            </div>
            <section class="am-panel am-panel-default">
                <header class="am-panel-hd">
                    <h3 class="am-panel-title">简介</h3>
                </header>

                <div class="am-panel-bd" style="font-size: 14px;">
                    ${meiju.summaryDesc}
                </div>
            </section>

            <div class="am-panel am-panel-success">
                <c:forEach var="downLink" items="${ meiju.downLinks}" varStatus="status">
                <header class="am-panel-hd">
                    <h3 class="am-panel-title">下载区 ${status.index + 1} 【右键复制到迅雷，百度网盘等下载】</h3>
                </header>
                <div class="am-panel-bd" style="font-size: 14px;">
                        <c:forEach var="entry" items="${downLink}">
                            <a href="${entry.ed2k}">${entry.title}</a>
                            <c:if test="${entry.magnet != null}">
                                | <a href="${entry.magnet}">磁力</a>
                            </c:if>
                            <c:if test="${entry.wangpan != null}">
                                | <a href="${entry.wangpan}">网盘</a>
                            </c:if>
                            <c:if test="${entry.size != null}">
                                | ${entry.size}
                            </c:if>
                            <br/>
                        </c:forEach>
                </div>
                </c:forEach>

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
                <li><i class="am-icon-heart"></i><span> ${meiju.priseCount} 人喜欢</span></li>
                <li><i class="am-icon-eye"></i><span> ${meiju.hotCount} 次查看</span></li>
                <li><i class="am-icon-clock-o"></i><span>发布 ${meiju.date}</span></li>
            </ul>
            <ul class="am_ziyuan_share">
                <div class="opera">
                    <span id="btn" onclick="prise()">
                        <i class="iconfont">&#xe602;</i> 感觉不错，赞一个
                    </span>
                </div>

            </ul>
            <ul class="am_ziyuan_tag">
                <li><span class="am_ziyuan_tag_title"></span></li>
            </ul>
            <div class="page_hot">
                <div class="page_hot_title">人气资源</div>
                <div class="page_hot_list">
                    <c:forEach var="hotMeiJu" items="${hotMeiJus}">
                        <div class="page_hot_block">
                        <dl>
                            <dt>
                                <a href="${pageContext.request.contextPath}/meijus/${hotMeiJu.id}/detail">
                                <img src="${hotMeiJu.poster}" alt=""></a></dt>
                            <dd>
                                <i style="font-size: 14px;color: #a1a1a1;">
                                    <a href="${pageContext.request.contextPath}/meijus/${hotMeiJu.id}/detail">
                                        [${hotMeiJu.updateStatus}]${hotMeiJu.title}</a>
                                </i>
                                <em>${hotMeiJu.date}
                                </em>
                                <div class="hot_block_info">
                                    <div class="hot_info_l am-icon-cloud-download">${hotMeiJu.hotCount}</div>
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
            <c:forEach var="meiju" items="${ulikeMeiJus}">
                <li>
                    <div class="am-gallery-item">
                        <a href="${pageContext.request.contextPath}/meijus/${meiju.id}/detail" class="">
                            <img class="am_img animated" alt="【${meiju.updateStatus}】${meiju.title}"
                                 src="${pageContext.request.contextPath}/static/front/img/loading.gif"
                                 data-original="${meiju.poster}"/>
                            <div class="am_listimg_info">
                                <span class="am-icon-cloud-download">${meiju.hotCount}</span>
                                <span class="am-icon-share-square-o">${meiju.date}</span>
                            </div>
                            <div class="am-gallery-desc" style="padding-top: 5px;">【${meiju.updateStatus}】${meiju.title}</div>
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
            "bdDesc": "${meiju.title}",
            "bdMini": "2",
            "bdMiniList": false,
            "bdPic": "${meiju.poster}",
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

</script>
<%@ include file="../footer.jsp"%>