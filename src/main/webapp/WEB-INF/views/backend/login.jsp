<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/10/27
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>云自如管理后台-登录</title>
    <meta name="description" content="是拥有超级丰富的云资源分享平台,自如分享最新电影,经典电影与电视剧资源云链接,是云资源爱好者最好的分享平台之一。想更自如的获得更多云资源,就上云自如,因为有你所以更精彩">
    <meta name="keywords" content="云自如，云资源，百度云资源,百度云平台,百度云搜索,百度云bt">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/static/front/img/footdon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/app.css">
    <script src="${pageContext.request.contextPath}/static/backend/js/jquery.min.js"></script>
</head>

<body data-type="login">
<script src="${pageContext.request.contextPath}/static/backend/js/theme.js"></script>

<div class="am-g tpl-g">
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-logo">
            </div>
            <div style="font-size: 14px;color: #ffc028; text-align: center">
                ${msg}
            </div>
            <form class="am-form tpl-form-line-form" name="fileForm" method="post" action="do_login">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="username" name="username" placeholder="请输入账号">
                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password" name="password" placeholder="请输入密码">

                </div>
                <div class="am-form-group tpl-login-remember-me">
                    <input id="rememberMe" name="rememberMe" type="checkbox" >
                    <label for="rememberMe">
                        记住密码
                    </label>
                </div>
                <div class="am-form-group">
                    <button type="button" onclick="submitBtnClick()" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    function submitBtnClick(){
        document.fileForm.submit();
    }
</script>
<script src="${pageContext.request.contextPath}/static/backend/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/app.js"></script>

</body>

</html>