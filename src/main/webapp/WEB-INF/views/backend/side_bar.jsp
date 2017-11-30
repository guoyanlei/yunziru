<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/10/27
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<style type="text/css">
    .sub-display {
        display: block;
    }
</style>

<!-- 侧边导航栏 -->
<div class="left-sidebar">
    <!-- 菜单 -->
    <ul class="sidebar-nav">
        <li class="sidebar-nav-heading">Yunziyuan<span class="sidebar-nav-heading-info"> 云资源</span></li>
        <li class="sidebar-nav-link">
            <a href="index.html">
                <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="javascript:;" class="sidebar-nav-sub-title" id = "movies">
                <i class="am-icon-table sidebar-nav-link-logo"></i> 电影资源
                <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico sidebar-nav-sub-ico-rotate"></span>
            </a>
            <ul class="sidebar-nav sidebar-nav-sub" id="movies_ul">
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath}/backend/movies/" id = "movie_list">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 所有电影
                    </a>
                </li>

                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath}/backend/movies/recommend" id = "recommend_movies">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 精品推荐
                    </a>
                </li>
            </ul>
        </li>
        <li class="sidebar-nav-link">
            <a href="${pageContext.request.contextPath}/backend/users/" id = "user_list">
                <i class="am-icon-table sidebar-nav-link-logo"></i> 用户列表
            </a>
        </li>
    </ul>
</div>

<script>
    $("#${active_menu}").addClass("active");
    $("#${sub_active_menu}").addClass("sub-active");
    $("#${active_menu_display}").addClass("sub-display");
</script>