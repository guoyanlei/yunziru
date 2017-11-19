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
                                            <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                <div class="am-form-group tpl-table-list-select">
                                    <input type="text" class="am-form-field tpl-form-no-bg" placeholder="发布时间" data-am-datepicker="" readonly="">

                                </div>
                            </div>

                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field ">
                                    <span class="am-input-group-btn">
                                    <button class="am-btn am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
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
                                    <tr class="gradeX">
                                        <td>Amaze UI 模式窗口</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i>
                                                </a>
                                                <a href="javascript:;">
                                                    <i class="am-icon-trash"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>有适配微信小程序的计划吗</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i>
                                                </a>
                                                <a href="javascript:;">
                                                    <i class="am-icon-trash"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="gradeX">
                                        <td>请问有没有amazeui 分享插件</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i>
                                                </a>
                                                <a href="javascript:;">
                                                    <i class="am-icon-trash"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>关于input输入框的问题</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i>
                                                </a>
                                                <a href="javascript:;">
                                                    <i class="am-icon-trash"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>有没有发现官网上的下载包不好用</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i>
                                                </a>
                                                <a href="javascript:;">
                                                    <i class="am-icon-trash"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr class="even gradeC">
                                        <td>我建议WEB版本文件引入问题</td>
                                        <td>2016-09-26</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i>
                                                </a>
                                                <a href="javascript:;">
                                                    <i class="am-icon-trash"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                            <div class="am-u-lg-12 am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">»</a></li>
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