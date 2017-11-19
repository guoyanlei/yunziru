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
                            <div class="widget-title  am-cf">用户列表</div>
                        </div>
                        <div class="widget-body  am-fr tpl-form-border-form tpl-form-border-br">

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/backend/users/add'" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>用户名</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="user" items="${users.content}">
                                        <tr class="gradeX">
                                            <td>${user.id}</td>
                                            <td>${user.username}</td>
                                            <td>
                                                <c:if test="${user.username != 'admin'}">
                                                    <div class="tpl-table-black-operation">
                                                        <a href="${pageContext.request.contextPath}/backend/users/add?id=${user.id}">
                                                            <i class="am-icon-pencil"></i>
                                                        </a>
                                                        <a href="${pageContext.request.contextPath}/backend/users/delete?id=${user.id}">
                                                            <i class="am-icon-trash"></i>
                                                        </a>
                                                    </div>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                            <div class="am-u-lg-12 am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li><a href="${pageContext.request.contextPath}/backend/users?page=1">«</a></li>
                                        <c:if test="${users.getTotalPages() == 1}">
                                            <li class="am-active"><a href="#">${users.getNumber()+1}</a></li>
                                        </c:if>
                                        <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
                                         <c:if test="${users.getNumber()+1 == 1 && users.getTotalPages() != 1}">
                                             <c:forEach begin="1" end="5" step="1" var="i">
                                                 <c:if test="${users.getNumber() == i-1}">
                                                     <li class="am-active"><a href="#">${i}</a></li>
                                                 </c:if>
                                                 <c:if test="${users.getNumber() != i-1 && i <= users.getTotalPages()}">
                                                     <li><a href="${pageContext.request.contextPath}/backend/users?page=${i}">${i}</a></li>
                                                 </c:if>
                                             </c:forEach>
                                             <li><a href="${pageContext.request.contextPath}/backend/users?page=${users.getNumber()+2}">下一页</a></li>
                                         </c:if>

                                         <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
                                         <c:if test="${users.getNumber()+1 > 1 && users.getNumber()+1 < users.getTotalPages()}">
                                             <li><a href="${pageContext.request.contextPath}/backend/users?page=${users.getNumber()}">上一页</a></li>
                                             <c:forEach begin="1" end="5" step="1" var="i">
                                                 <c:if test="${users.getNumber()+1 == i}">
                                                     <li class="am-active"><a href="#">${i}</a></li>
                                                 </c:if>
                                                 <c:if test="${users.getNumber()+1 != i && i <= users.getTotalPages()}">
                                                     <li><a href="${pageContext.request.contextPath}/backend/users?page=${i}">${i}</a></li>
                                                 </c:if>
                                             </c:forEach>
                                             <li><a href="${pageContext.request.contextPath}/backend/users?page=${users.getNumber()+2}">下一页</a></li>
                                         </c:if>

                                         <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
                                         <c:if test="${users.getNumber()+1 == users.getTotalPages() && users.getTotalPages() != 1}">
                                             <li><a href="${pageContext.request.contextPath}/backend/users?page=${users.getNumber()}">上一页</a></li>
                                             <c:forEach begin="1" end="5" step="1" var="i">
                                                 <c:if test="${users.getNumber()+1 == i}">
                                                     <li class="am-active"><a href="#">${i}</a></li>
                                                 </c:if>
                                                 <c:if test="${users.getNumber()+1 != i && i <= users.getTotalPages()}">
                                                     <li><a href="${pageContext.request.contextPath}/backend/users?page=${i}">${i}</a></li>
                                                 </c:if>
                                             </c:forEach>
                                         </c:if>
                                        <li><a href="${pageContext.request.contextPath}/backend/users?page=${users.getTotalPages()}">»</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="${pageContext.request.contextPath}/static/backend/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/app.js"></script>

</body>

</html>