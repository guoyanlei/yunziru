package com.yunziru.meiju.crawler;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.qiniu.util.StringUtils;
import com.yunziru.common.util.HttpClientUtil;
import com.yunziru.meiju.entity.DownLinkInfo;
import com.yunziru.meiju.entity.MeiJu;
import com.yunziru.meiju.entity.MeiJuSimple;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by guoyanlei
 * Date：2017/10/22
 * Description：
 */
@Component
public class MeijuCrawler {

    public String getResponseContent(String url) {

        return HttpClientUtil.getInstance().sendHttpGet(url);
    }

    public List<MeiJuSimple> parseMeijuList(String content) {

        List<MeiJuSimple> meiJuSimples = Lists.newArrayList();

        Pattern pattern = Pattern.compile("<div class=\"art_img_box clearfix\" style=\"padding:15px;\">(.+?)<div class=\"art_info_bottom\" style=\"width:685px\">(.+?)</div>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            MeiJuSimple meiJuSimple = new MeiJuSimple();
            String content1 = matcher.group(1);
            String content2 = matcher.group(2);
            String turl = "http://www.msj1.com/archives/{%tid}.html";
            String regx = "com/archives/([1-9]\\d{1,19})\\.html\" title=";
            Pattern p = Pattern.compile(regx, Pattern.DOTALL);
            Matcher m = p.matcher(content1);
            if(m.find()){
                String tid = m.group(1);
                meiJuSimple.setTid(Long.parseLong(tid));
                //System.out.println(turl.replace("{%tid}", tid));
                meiJuSimple.setUrl(turl.replace("{%tid}", tid));
            }
            p = Pattern.compile("<em>\\[(.+?)\\]</em>", Pattern.DOTALL);
            m = p.matcher(content1);
            if(m.find()){
                //System.out.println(m.group(1).trim());
                meiJuSimple.setUpdateStatus(m.group(1).trim());
                meiJuSimple.setEnd(m.group(1).trim().contains("完结"));
            }

            Pattern p2 = Pattern.compile("栏目：<a href=\"http://www.msj1.com/c/(.+?)\" rel=\"category tag\">(.+?)</a></span>", Pattern.DOTALL);
            Matcher m2 = p2.matcher(content2);
            if(m2.find()){
                //System.out.println(m2.group(1));
                //System.out.println(m2.group(2));
                meiJuSimple.setCategoryEN(m2.group(1));
                meiJuSimple.setCategoryCH(m2.group(2));
            }

            Pattern p3 = Pattern.compile("<span>标签(.+?)</span>", Pattern.DOTALL);
            Matcher m3 = p3.matcher(content2);
            if(m3.find()){
                String tags =  m3.group(1);
                Pattern p3_1 = Pattern.compile("<a href=\"(.+?)\" rel=\"tag\">(.+?)</a>", Pattern.DOTALL);
                Matcher m3_1 = p3_1.matcher(tags);
                String tagEN = "";
                String tagCH = "";
                while (m3_1.find()) {
                    String t = m3_1.group(1);
                    tagEN += t.substring(t.lastIndexOf("/")+1, t.length()) + ",";
                    tagCH += m3_1.group(2) + ",";
                }
                //System.out.println(tagCH);
                //System.out.println(tagEN);
                meiJuSimple.setTagEN(tagEN.substring(0, tagEN.length()-1));
                meiJuSimple.setTagCH(tagCH.substring(0, tagCH.length()-1));
            }

            meiJuSimples.add(meiJuSimple);
        }

        return meiJuSimples;
    }

    public MeiJu parseMeiju(String content, MeiJuSimple meiJuSimple) {

        MeiJu meiJu = MeiJu.of(meiJuSimple);
        //解析title
        String regx = "<h1 itemprop=\"name\">(.+?)</h1>";
        Pattern pattern = Pattern.compile(regx, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println((matcher.group(1).trim()));
            meiJu.setTitle(matcher.group(1).trim());
        }

        //解析date
        regx = "<small>时间:</small>(.+?)\t\t\t\t<small>";
        pattern = Pattern.compile(regx, Pattern.DOTALL);
        matcher = pattern.matcher(content);
        while(matcher.find()){
            //System.out.println((matcher.group(1).trim()));
            meiJu.setDate(matcher.group(1).trim());
        }

        //解析image
        regx = "<img class=\"alignleft size-full(.+?)width=\"([1-9]\\d{1,5})\" height=\"([1-9]\\d{1,5})\" />";
        pattern = Pattern.compile(regx, Pattern.DOTALL);
        matcher = pattern.matcher(content);
        while(matcher.find()){
            String img = matcher.group(1).trim();
            Pattern p1 = Pattern.compile("src=\"(.+?)\"", Pattern.DOTALL);
            Matcher m1 = p1.matcher(img);
            if (m1.find()) {
                meiJu.setImage(m1.group(1).trim());
                //System.out.println(m1.group(1).trim());
            }
        }

        //解析summery
        regx = "<div class=\"dbinfo\">(.+?)<h2 id=";
        pattern = Pattern.compile(regx, Pattern.DOTALL);
        matcher = pattern.matcher(content);
        while (matcher.find()){
            //System.out.println((matcher.group(1).replaceAll("<div>|</div>|<span class=\"pl\">|</span>","").trim()));
            meiJu.setSummary(matcher.group(1).replaceAll("<div>|</div>|<span class=\"pl\">|</span>","").trim());
        }
        if (StringUtils.isNullOrEmpty(meiJu.getSummary())){
            regx = "<div class=\"dbinfo\">(.+?)<strong style=";
            pattern = Pattern.compile(regx, Pattern.DOTALL);
            matcher = pattern.matcher(content);
            if(matcher.find()){
                //System.out.println((matcher.group(1).replaceAll("<div>|</div>|<span class=\"pl\">|</span>","").trim()));
                meiJu.setSummary(matcher.group(1).replaceAll("<div>|</div>|<span class=\"pl\">|</span>","").trim());
            }
        }

        //解析down_url
        List<List<DownLinkInfo>> lists = Lists.newArrayList();
        pattern = Pattern.compile("<h2 id=\"download\">(.+?)</table>", Pattern.DOTALL);
        matcher = pattern.matcher(content);
        while (matcher.find()) {
            String down = matcher.group();
            lists.add(this.parseDownLink(down));
        }
        if (lists.size() == 0 || lists.size() == 1) {
            pattern = Pattern.compile("<h2 id=\"download\">(.+?)</ul>", Pattern.DOTALL);
            matcher = pattern.matcher(content);
            while (matcher.find()) {
                String down = matcher.group();
                lists.add(this.parseDownLink3(down));
            }
        }
        if (lists.size() == 0 || lists.size() == 1) {
            pattern = Pattern.compile("<h2 id=\"download\">(.+?)</table>", Pattern.DOTALL);
            matcher = pattern.matcher(content);
            while (matcher.find()) {
                String down = matcher.group();
                lists.add(this.parseDownLink2(down));
            }
        }

        meiJu.setDownLinks(JSON.toJSONString(lists.stream().filter(list-> list.size() > 0).collect(Collectors.toList())));
        return meiJu;
    }

    public List<DownLinkInfo> parseDownLink(String content) {

        List<DownLinkInfo> linkInfos = Lists.newArrayList();
        Pattern pattern = Pattern.compile("<tr>(.+?)</tr>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String tr = matcher.group(1).trim();
            DownLinkInfo downLink = new DownLinkInfo();

            Pattern p = Pattern.compile("href=\"ed2k:(.+?)\" target=\"_blank\"", Pattern.DOTALL);
            Matcher m = p.matcher(tr);
            while (m.find()) {
                //System.out.println("ed2k:" + (m.group(1).trim()));
                downLink.setEd2k("ed2k:" + m.group(1).trim());
            }
            if (StringUtils.isNullOrEmpty(downLink.getEd2k())) {
                p = Pattern.compile("<td>(.+?) | 磁力</td>", Pattern.DOTALL);
                m = p.matcher(tr);
                if (m.find()) {
                    //System.out.println((m.group(1).trim()));
                    downLink.setTitle(m.group(1).trim());
                }
            }

            p = Pattern.compile("target=\"_blank\">(.+?)</a></td>", Pattern.DOTALL);
            m = p.matcher(tr);
            while (m.find()) {
                //System.out.println(m.group(1).trim());
                downLink.setTitle(m.group(1).trim());
            }

            if (StringUtils.isNullOrEmpty(downLink.getTitle())) {
                p = Pattern.compile("target=\"_blank\">(.+?)</a> \\| <a ", Pattern.DOTALL);
                m = p.matcher(tr);
                while (m.find()) {
                    //System.out.println(m.group(1).trim());
                    downLink.setTitle(m.group(1).trim());
                }
            }
            if (StringUtils.isNullOrEmpty(downLink.getTitle())) {
                p = Pattern.compile(" target=\"_blank\" rel=\"noopener noreferrer\">(.+?)</a> \\| <a ", Pattern.DOTALL);
                m = p.matcher(tr);
                while (m.find()) {
                    //System.out.println(m.group(1).trim());
                    downLink.setTitle(m.group(1).trim());
                }
            }

            if (StringUtils.isNullOrEmpty(downLink.getTitle())) {
                p = Pattern.compile(" target=\"_blank\" rel=\"noopener noreferrer\">(.+?)</a>", Pattern.DOTALL);
                m = p.matcher(tr);
                while (m.find()) {
                    //System.out.println(m.group(1).trim());
                    downLink.setTitle(m.group(1).trim());
                }
            }

            p = Pattern.compile("<a href=\"magnet:(.+?)\">磁力</a>", Pattern.DOTALL);
            m = p.matcher(tr);
            while (m.find()) {
                //System.out.println("magnet:" + m.group(1).trim().replaceAll(" target=\"_blank", ""));
                downLink.setMagnet("magnet:" + m.group(1).trim().replaceAll(" target=\"_blank", ""));
            }

            p = Pattern.compile("<a href=\"http(.+?)\" target=\"_blank\" rel=\"noopener noreferrer\">网盘</a>", Pattern.DOTALL);
            m = p.matcher(tr);
            while (m.find()) {
                //System.out.println("http" + m.group(1).trim());
                downLink.setWangpan("http" + m.group(1).trim());
            }

            p = Pattern.compile("<td class=\"right\">\\((.+?)\\)</td>", Pattern.DOTALL);
            m = p.matcher(tr);
            while (m.find()) {
                //System.out.println(m.group(1).trim());
                downLink.setSize(m.group(1).trim());
            }

            if ("<a".equals(downLink.getTitle())) {
                if (!tr.contains("</a> | <a")) {
                    p = Pattern.compile("<a target=\"_blank\" href=\"(.+?)\">(.+?)</a>", Pattern.DOTALL);
                    m = p.matcher(tr);
                    while (m.find()) {
                        downLink.setEd2k(m.group(1).trim());
                        downLink.setTitle(m.group(2).trim());
                    }
                } else {
                    p = Pattern.compile("<a target=\"_blank\" href=\"(.+?)\">(.+?)</a>", Pattern.DOTALL);
                    m = p.matcher(tr);
                    while (m.find()) {
                        downLink.setEd2k(m.group(1).trim());
                        downLink.setTitle(m.group(2).trim());
                    }
                    p = Pattern.compile("<a href=\"magnet:(.+?)\"", Pattern.DOTALL);
                    m = p.matcher(tr);
                    while (m.find()) {
                        //System.out.println("magnet:" + m.group(1).trim().replaceAll(" target=\"_blank", ""));
                        downLink.setMagnet("magnet:" + m.group(1).trim());
                    }
                }
            }

            if (downLink.getTitle() != null && downLink.getTitle().contains("</a> | <a")) {
                downLink.setTitle(downLink.getTitle().substring(0, downLink.getTitle().indexOf("</a> | <a")));
            }

            if (downLink.isNotNull()) {
                linkInfos.add(downLink);
            }
        }
        return linkInfos.stream()
                .filter(meiju -> !StringUtils.isNullOrEmpty(meiju.getTitle()))
                .collect(Collectors.toList());
    }

    public List<DownLinkInfo> parseDownLink2(String content) {

        List<DownLinkInfo> linkInfos = Lists.newArrayList();
        Pattern pattern = Pattern.compile("<tr>(.+?)</tr>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String tr = matcher.group(1).trim();
            DownLinkInfo downLink = new DownLinkInfo();

            Pattern p = Pattern.compile("<a href=\"(.+?)\" target=\"_blank\" rel=\"noopener noreferrer\">(.+?)</a>", Pattern.DOTALL);
            Matcher m = p.matcher(tr);
            while (m.find()) {
                //System.out.println("ed2k:" + (m.group(1).trim()));
                downLink.setEd2k(m.group(1).trim());
                downLink.setTitle(m.group(2).trim());
            }
            if (downLink.isNotNull()) {
                linkInfos.add(downLink);
            }
        }
        return linkInfos.stream()
                .filter(meiju -> !StringUtils.isNullOrEmpty(meiju.getTitle()))
                .collect(Collectors.toList());
    }

    public List<DownLinkInfo> parseDownLink3(String content) {

        List<DownLinkInfo> linkInfos = Lists.newArrayList();
        Pattern pattern = Pattern.compile("<li>(.+?)</li>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String tr = matcher.group(1).trim();
            DownLinkInfo downLink = new DownLinkInfo();

            Pattern p = Pattern.compile("<a href=\"(.+?)\" target=\"_blank\">(.+?)</a>", Pattern.DOTALL);
            Matcher m = p.matcher(tr);
            if (m.find()) {
                //System.out.println("ed2k:" + (m.group(1).trim()));
                downLink.setEd2k(m.group(1).trim());
                downLink.setTitle(m.group(2).trim());
            }
            if (downLink.isNotNull()) {
                linkInfos.add(downLink);
            }
        }
        return linkInfos.stream()
                .filter(meiju -> !StringUtils.isNullOrEmpty(meiju.getTitle()))
                .collect(Collectors.toList());
    }
}
