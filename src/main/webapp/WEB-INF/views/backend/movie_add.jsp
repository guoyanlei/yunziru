<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/10/27
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

<%@ include file="header.jsp"%>
<%@ include file="side_bar.jsp"%>

<div class="tpl-content-wrapper">

    <div class="row-content am-cf">

        <div class="row">

            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">添加电影</div>
                        <div class="widget-function am-fr">
                            <a href="javascript:;" class="am-icon-cog"></a>
                        </div>
                    </div>
                    <div class="widget-body am-fr">

                        <form class="am-form tpl-form-border-form" name="movieForm" method="post" action="${pageContext.request.contextPath}/backend/movies">
                            <div class="am-form-group">
                                <label for="title" class="am-u-sm-12 am-form-label am-text-left">标题：</label>
                                <input type="hidden" class="tpl-form-input am-margin-top-xs" id="id" name="id" value="${movie.id}" placeholder="">
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="title" name="title" value="<c:out value="${movie.title}" escapeXml="true"/>" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="name" class="am-u-sm-12 am-form-label am-text-left">电影名称：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="name" name="name" value="<c:out value="${movie.name}" escapeXml="true"/>" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="year" class="am-u-sm-12 am-form-label am-text-left">年份：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="year" name="year" value="${movie.year}" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="location" class="am-u-sm-12 am-form-label am-text-left">地区：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="location" name="location" value="${movie.location}" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="type" class="am-u-sm-12 am-form-label am-text-left">类型：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="type" name="type" value="${movie.type}" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="ed2kLink" class="am-u-sm-12 am-form-label am-text-left">迅雷链接：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="ed2kLink" name="ed2kLink" value="<c:out value="${movie.ed2kLink}" escapeXml="true"/>" placeholder="">
                                    <small>可多个，如：{"xxx":"desc","xxx:desc"}</small>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="baiduLink" class="am-u-sm-12 am-form-label am-text-left">百度网盘链接：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="baiduLink" name="baiduLink" value="${movie.baiduLink}" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="baiduPwd" class="am-u-sm-12 am-form-label am-text-left">百度网盘密码：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="baiduPwd" name="baiduPwd"  value="${movie.baiduPwd}" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="tid" class="am-u-sm-12 am-form-label am-text-left">爬虫tid：</label>
                                <div class="am-u-sm-12">
                                    <input type="text" class="tpl-form-input am-margin-top-xs" id="tid" name="tid" value="${movie.tid}" placeholder="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="summary" class="am-u-sm-12 am-form-label  am-text-left">简介：</label>
                                <div class="am-u-sm-12 am-margin-top-xs">
                                    <textarea rows="30" id="summary" name="summary" placeholder="请输入简介"><c:out value="${movie.summary}" escapeXml="true"/>
                                    </textarea>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-12 am-form-label  am-text-left">海报和截图：</label>
                                <div class="am-u-sm-12 am-margin-top-xs">
                                    <div id="uploader" class="wu-example">
                                        <div class="queueList">
                                            <div id="dndArea" class="placeholder">
                                                <div id="filePicker"></div>
                                            </div>
                                        </div>
                                        <div class="statusBar" style="display:none;">
                                            <div class="progress">
                                                <span class="text">0%</span>
                                                <span class="percentage"></span>
                                            </div><div class="info"></div>
                                            <div class="btns">
                                                <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="images" class="am-u-sm-12 am-form-label  am-text-left">海报和截图url：</label>
                                <div class="am-u-sm-12 am-margin-top-xs">
                                    <textarea class="" rows="5" id="images" name="images" placeholder=""><c:out value="${movie.images}" escapeXml="true"/></textarea>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-12 am-u-sm-push-12">
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
<script src="${pageContext.request.contextPath}/static/backend/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/app.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/ckeditor/ckeditor.js"></script>


<script type="text/javascript">

    CKEDITOR.replace( 'summary' );

    // 添加全局站点信息
    var BASE_URL = '${pageContext.request.contextPath}/static/backend/webuploader';

    // 上传路径
    var UPLOAD_URL = '${pageContext.request.contextPath}/backend/fileUpload';

    function submitBtnClick(){
        document.movieForm.submit();
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/backend/webuploader/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/backend/webuploader/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/backend/webuploader/js/global.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/backend/webuploader/js/webuploader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/backend/webuploader/js/demo.js"></script>


</body>
</html>