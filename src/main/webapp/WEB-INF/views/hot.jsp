<%@ include file="header.jsp"%>
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
                <a href="https://itunes.apple.com/us/app/chong-wu-xiu/id976605844?l=zh&ls=1&mt=8" title="宠物App store版" class="am-btn am-btn-sm get-btn  am-radius banner_ios am-icon-refresh " rel="nofollow"> Refresh</a> <a
                    href="http://android.myapp.com/myapp/detail.htm?apkName=com.staffy.pet" title="宠物秀安卓版" class="am-btn am-btn-sm  am-radius get-btn banner_android am-icon-cloud-upload" rel="nofollow"> Upload</a>
            </p>
        </div>
    </div>
</div>
<div class="banner_navbg">
    <div class="am-g">
        <div class="banner_nav"><span class="am-icon-caret-right">  筛选：</span>
            <a href="${pageContext.request.contextPath}" title="最新发布" target="_self"  class="click_rqzg">最新发布</a>
            <a href="recommend" title="编辑推荐" target="_self" class="click_bjtj">编辑推荐</a>
            <a href="hot" title="人气最高" target="_self"  class="click_rqzg  banner_hover">人气最高</a>
            </div>
    </div>
</div>

<div class="am-g am-imglist">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-3 am-avg-lg-6 am-gallery-imgbordered" data-am-gallery="{  }" >
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-1.jpg" class="">
                    <img class="am_img animated" alt=""
                         src="${pageContext.request.contextPath}/static/img/loading.gif"
                         data-original="${pageContext.request.contextPath}/static/img/083816a1eanxbt11nlx4a8.jpg" />
                    <div class="am_listimg_info">
                        <span class="am-icon-heart">27</span>
                        <span class="am-icon-tag">2天前</span>
                    </div>
                    <div class="am-gallery-desc" style="padding-top: 5px;">《布希维克/全境警戒》720p. BD高清中英双字 百度云网盘下载</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
                    <img src="https://img.alicdn.com/imgextra/i1/2539261409/TB2s0WIbvY85uJjSZFzXXc93VXa_!!2539261409.png"  alt="某天 也许会相遇 相遇在这个好地方"/>
                    <div class="am_listimg_info">
                        <span class="am-icon-heart">27</span>
                        <span class="am-icon-tag">2天前</span>
                    </div>
                    <div class="am-gallery-desc">《极寒之城.美版》720p.HD高清中英双字 百度云网盘下载</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
                    <img src="${pageContext.request.contextPath}/static/img/075357imgjyylc0yxmgmpc.jpg"  alt="不要太担心 只因为我相信"/>
                    <div class="am_listimg_info">
                        <span class="am-icon-heart">27</span>
                        <span class="am-icon-tag">2天前</span>
                    </div>
                    <div class="am-gallery-desc">《昨日重现》720p.HD高清中字 百度云网盘下载</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
                    <img src="${pageContext.request.contextPath}/static/img/145212w5rkka5xc1m2dsj0.jpg"  alt="终会走过这条遥远的道路"/>
                    <div class="am_listimg_info">
                        <span class="am-icon-heart">27</span>
                        <span class="am-icon-tag">2天前</span>
                    </div>
                    <div class="am-gallery-desc">《赛车总动员3：极速挑战》1080p.国英双语.HD高清中字 百度云网盘下载</div>
                </a>
            </div>
        </li>
    </ul>
    <div class="am_news_load am_news_load_index"><span><i  class="am-icon-spinner am-icon-spin"></i>加载更多云资源</span></div>
    <br>

    <br>
</div>
<script>
    var page     = 2;
    var pagesize = 50;
    var datalist = 'indexrecommendlist';

    $('.am-icon-spinner').hide();
    $('.am_news_load_index').on('click',function(){
        $('.am-icon-spinner').show();
        load_more();
    });

    function load_more()
    {
        var indexListImgHtml = '';
        $('.am_news_load_index').unbind('click');
        $.post('/v2/'+datalist+'',{page:page,pagesize:pagesize},function(data){

            $('.am-icon-spinner').hide();
            // 数据异常
            if(data.code != 100)
            {
                console.log(data.msg);
                return false;
            }
            for( var i = 0 ; i < data.data.list.length ; i++ ){
                indexListImgHtml += '<li><div class="am-gallery-item am_list_block"><a href="/g/'+data.data.list[i].id+'.html" title="盛源优宠 举国同庆，戴个新领结" class="am_img_bg"><img class="am_img animated" src="${pageContext.request.contextPath}/static/img/loading.gif" alt="盛源优宠 举国同庆，戴个新领结的宠物猫宠物狗"  data-original="'+data.data.list[i].picture+'" /></a><div class="am_listimg_info"><span class="am-icon-heart">'+data.data.list[i].like_num+'</span><span class="am-icon-comments">'+data.data.list[i].comment_num+'</span><span class="am_imglist_time">'+data.data.list[i].create_time+'</span></div></div><a class="am_imglist_user"><span class="am_imglist_user_ico"><img src="'+data.data.list[i].user.avatar+'" alt="盛源优宠"></span><span class="am_imglist_user_font">铲屎官 '+data.data.list[i].user.nick+'</span></a></li>';
            }
            $('.am_index_addimglist').append(indexListImgHtml);
            // 懒加载
            $("img.am_img").lazyload();
            $("a.am_img_bg").lazyload({
                effect : 'fadeIn'
            });
            // 点击加载更多
            $('.am_news_load_index').on('click',function(){
                $('.am-icon-spinner').show();
                if(data.data.page_data.page < data.data.page_data.page_total ){
                    load_more(page,pagesize);
                }
            });
            page++;
        },'json');

    }

</script>
<%@ include file="footer.jsp"%>
