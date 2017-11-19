<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/10/27
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="side_bar.jsp"%>

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <c:choose>
                                <c:when test="${user.id > 0}">
                                    <div class="widget-title am-fl">修改用户</div>
                                </c:when>
                                <c:otherwise>
                                    <div class="widget-title am-fl">添加用户</div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="widget-body am-fr">

                            <form class="am-form tpl-form-border-form tpl-form-border-br" name="fileForm" method="post" action="save">
                                <div class="am-form-group">
                                    <input type="hidden" id="id" name="id" value="${user.id}">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">用户名</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" style="width: 200px;" id="userName" name="userName" value="${user.username}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-pwd" class="am-u-sm-3 am-form-label">密码</label>
                                    <div class="am-u-sm-9">
                                        <input type="password" class="tpl-form-input" style="width: 200px;" id="password" name="password">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" onclick="submitBtnClick()" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
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