package com.yunziru.common.util;

/**
 * Created by guoyanlei
 * Date：2017/11/8
 * Description：
 */
public class PageUtil {

    public static int getOffset(int page, int size) {
        return (page-1) * size;
    }
}
