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
                            <div class="widget-title  am-cf">电影列表</div>
                        </div>

                        <div class="widget-body  am-fr tpl-form-border-form tpl-form-border-br">
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/backend/movies/add'" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                <div class="am-form-group tpl-table-list-select">
                                    <input type="text" class="am-form-field tpl-form-no-bg" onchange="search(1)"  id="time" name="time" value="${time}" placeholder="发布时间" data-am-datepicker="" readonly="">
                                </div>
                            </div>

                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field " id="keyword" name="keyword" value="${keyword}">
                                    <span class="am-input-group-btn">
                                    <button onclick="search(1)" class="am-btn am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
                                    </span>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                    <tr>
                                        <th width="60%">电影标题</th>
                                        <th>时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="movie" items="${movies.content}">
                                        <tr class="gradeX">
                                            <td>${movie.title}</td>
                                            <td>
                                                <script>
                                                    var d = new Date(${movie.createTime});
                                                    document.write((d.getFullYear()) + "-" + (d.getMonth() + 1) + "-" + (d.getDate()));
                                                </script>
                                            </td>
                                            <td>
                                                <div class="tpl-table-black-operation">
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i>
                                                    </a>
                                                    <a href="javascript:deleteMovie(${movie.id});">
                                                        <i class="am-icon-trash"></i>
                                                    </a>
                                                    <a href="javascript:rcmMovie(${movie.id});">
                                                        <i class="am-icon-star-o"></i>
                                                    </a>
                                                </div>
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
                                        <li><a href="javascript:search(1)">«</a></li>
                                        <c:if test="${movies.getTotalPages() == 1}">
                                            <li class="am-active"><a href="#">${movies.getNumber()+1}</a></li>
                                        </c:if>
                                        <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
                                        <c:if test="${movies.getNumber()+1 == 1 && movies.getTotalPages() != 1}">
                                            <c:forEach begin="${movies.getNumber()+1}" end="${movies.getNumber()+5}" step="1" var="i">
                                                <c:if test="${movies.getNumber() == i-1}">
                                                    <li class="am-active"><a href="javascript:;">${i}</a></li>
                                                </c:if>
                                                <c:if test="${movies.getNumber() != i-1 && i <= movies.getTotalPages()}">
                                                    <li><a href="javascript:search(${i})">${i}</a></li>
                                                </c:if>
                                            </c:forEach>
                                            <li><a href="javascript:search(${movies.getNumber()+2})">下一页</a></li>
                                        </c:if>

                                        <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
                                        <c:if test="${movies.getNumber()+1 > 1 && movies.getNumber()+1 < movies.getTotalPages()}">
                                            <li><a href="javascript:search(${movies.getNumber()})">上一页</a></li>
                                            <c:forEach begin="${movies.getNumber()+1}" end="${movies.getNumber()+5}" step="1" var="i">
                                                <c:if test="${movies.getNumber()+1 == i}">
                                                    <li class="am-active"><a href="javascript:;">${i}</a></li>
                                                </c:if>
                                                <c:if test="${movies.getNumber()+1 != i && i <= movies.getTotalPages()}">
                                                    <li><a href="javascript:search(${i})">${i}</a></li>
                                                </c:if>
                                            </c:forEach>
                                            <li><a href="javascript:search(${movies.getNumber()+2})">下一页</a></li>
                                        </c:if>

                                        <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
                                        <c:if test="${movies.getNumber()+1 == movies.getTotalPages() && movies.getTotalPages() != 1}">
                                            <li><a href="javascript:search(${movies.getNumber()})">上一页</a></li>
                                            <c:forEach begin="${movies.getNumber()+1}" end="${movies.getNumber()+5}" step="1" var="i">
                                                <c:if test="${movies.getNumber()+1 == i}">
                                                    <li class="am-active"><a href="javascript:;">${i}</a></li>
                                                </c:if>
                                                <c:if test="${movies.getNumber()+1 != i && i <= movies.getTotalPages()}">
                                                    <li><a href="javascript:search(${i})">${i}</a></li>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                        <li><a href="javascript:search(${movies.getTotalPages()})">»</a></li>
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
<script type="text/javascript">
    function search(page){

        var url = "${pageContext.request.contextPath}/backend/movies";
        var time = $('#time').val();
        var keyword = $('#keyword').val();

        window.location.href = url + "?page=" + page + "&keyword=" + encodeURI(keyword) + "&time=" + time;
    }

    function deleteMovie (id) {
        $.ajax({
            url: '${pageContext.request.contextPath}/backend/movies/'+id,
            type: 'DELETE',
            success: function(result) {
                window.location.reload();
            }
        });
    }

    function rcmMovie (id) {

        $.post("${pageContext.request.contextPath}/backend/movies/recommend",{movieId:id},
            function(result){
                if (result.data) {
                    alert("推荐成功~");
                } else {
                    alert("推荐失败！");
                }
        });
    }
</script>
<script src="${pageContext.request.contextPath}/static/backend/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/app.js"></script>

</body>

</html>