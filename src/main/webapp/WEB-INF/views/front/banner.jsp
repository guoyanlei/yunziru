<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/10/27
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="get">
    <div class="am-g">
        <div class="am-u-lg-12">
            <div class="get-title">
                <div class="get_font_left"><img src="${pageContext.request.contextPath}/static/img/font_yjy.png" alt=""></div>
                <div class="get_font_center" id="banner_num"></div>
                <div class="get_font_rigth"><img src="${pageContext.request.contextPath}/static/img/font_zty.png" alt=""></div>
            </div>

            <div class="font_line"><img src="${pageContext.request.contextPath}/static/img/font_line.png" alt=""></div>
            <p>
                <a onclick="refresh();" title="刷新资源" class="am-btn am-btn-sm get-btn  am-radius banner_ios am-icon-refresh " rel="nofollow"> Refresh</a>
                <a onclick="upload();" title="上传资源" class="am-btn am-btn-sm  am-radius get-btn banner_android am-icon-cloud-upload" rel="nofollow"> Upload</a>
            </p>
        </div>
    </div>
</div>

<script>
    //@首页 数字跳动
    var options = {
        useEasing: true,
        useGrouping: true,
        separator: '',
        decimal: '.',
        prefix: '',
        suffix: ''
    };
    var banner_num = new CountUp("banner_num", ${totalCount-50}, ${totalCount}, 0, 5, options);
    banner_num.start();

    function refresh(){
        window.location.reload();
    }

    function upload(){
        alert("上传资源暂未开启，敬请期待~")
    }
</script>