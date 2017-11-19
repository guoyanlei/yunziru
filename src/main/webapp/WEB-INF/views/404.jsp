<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>404页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/static/front/img/footdon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/app.css">
    <script src="${pageContext.request.contextPath}/static/backend/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
<script src="${pageContext.request.contextPath}/static/backend/js/theme.js"></script>
<div class="row-content am-cf">
    <div class="widget am-cf">
        <div class="widget-body">
            <div class="tpl-page-state">
                <div class="tpl-page-state-title am-text-center tpl-error-title">404</div>
                <div class="tpl-error-title-info">Page Not Found</div>
                <div class="tpl-page-state-content tpl-error-content">
                <p>对不起，没有找到您所需要的页面，可能页面已被移除。</p>
                <button type="button" onclick="goBack()" class="am-btn am-btn-secondary am-radius tpl-error-btn">Back Home</button></div>

            </div>
        </div>
    </div>
</div>
<script>
    function goBack(){
        window.history.back();
    }
</script>
<script src="${pageContext.request.contextPath}/static/backend/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/amazeui.datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/app.js"></script>

</body>

</html>