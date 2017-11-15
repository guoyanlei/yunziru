<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/10/27
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <title>云自如 自如分享,分享自如,自如上传下载你想要的云资源吧</title>
    <meta name="description" content=是拥有超级丰富的云资源分享平台,自如分享最新电影,经典电影与电视剧资源云链接,是云资源爱好者最好的分享平台之一。想更自如的获得更多云资源,就上云自如,因为有你所以更精彩。>
    <meta name="keywords" content="云自如，云资源，百度云资源,百度云平台,百度云搜索,百度云bt" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/front/img/footdon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/front/css/amazeui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/front/css/yunziru.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/front/css/animate.min.css">
    <script src="${pageContext.request.contextPath}/static/front/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/front/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/front/js/yunziru.js"></script>
    <base target="_blank" />
    <script src="${pageContext.request.contextPath}/static/front/js/countUp.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/front/js/amazeui.lazyload.min.js"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?fe42b49c11a22004b71d818e77633f3d";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
</head>
<body>
<header class="am-topbar am-topbar-inverse">
    <div class="amz-container">
        <h1 class="am-topbar-brand">
            <a href="${pageContext.request.contextPath}" class="am-topbar-logo">
                <img src="${pageContext.request.contextPath}/static/front/img/logo.png?1" alt="云自如">
            </a>
        </h1>
        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                data-am-collapse="{target: '#doc-topbar-collapse-5'}">
            <span class="am-sr-only">
                导航切换
            </span>
            <span class="am-icon-bars">
            </span>
        </button>
        <script>

        </script>

        <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse-5">
            <ul class="am-nav am-nav-pills am-topbar-nav pet_filter">
                <li class="am-active">
                    <a href="${pageContext.request.contextPath}" title="云自如" target="_self">
                        首页
                    </a>
                </li>
                <li class="am-dropdown" data-am-dropdown="">
                    <a class="am-dropdown-toggle" data-am-dropdown-toggle="" href="javascript:;" target="_self">
                        电影资源
                        <span class="am-icon-caret-down">
                        </span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li>
                            <a href="${pageContext.request.contextPath}" title="最新发布" target="_self">
                                最新发布
                            </a>
                        </li>
                        <li>
                            <a href="recommend" title="编辑推荐" target="_self">
                                编辑推荐
                            </a>
                        </li>
                        <li>
                            <a href="hot" title="人气排行" target="_self">
                                人气排行
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="fresh" title="新鲜事" target="_blank">
                        新鲜事
                    </a>
                </li>
            </ul>
        </div>
    </div>
</header>