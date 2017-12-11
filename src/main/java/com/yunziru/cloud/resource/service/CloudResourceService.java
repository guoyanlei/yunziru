package com.yunziru.cloud.resource.service;

import com.google.common.collect.Lists;
import com.yunziru.cloud.resource.dao.impl.CloudResourceDaoImpl;
import com.yunziru.cloud.resource.dto.CloudResourceSimpleDTO;
import com.yunziru.cloud.resource.entity.CloudResource;
import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.cloud.resource.dao.CloudResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/12/10
 * Description：
 */
@Service
public class CloudResourceService extends CommonService<CloudResource, Long> {

    @Autowired
    private CloudResourceDao cloudResourceDao;

    @Resource
    private CloudResourceDaoImpl cloudResourceDaoImpl;

    @Autowired
    public void setCloudResourceDao(CloudResourceDao cloudResourceDao){
        super.setCommonDao(cloudResourceDao);
    }

    /**
     * 获取资源概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<CloudResourceSimpleDTO> getResourceList(String keyword, int page, int size, String menuId) {
        if ("".equals(keyword)) {
            return Lists.newArrayList();
        }
        return cloudResourceDaoImpl.getResourcelist(keyword, PageUtil.getOffset(page, size), size, menuId);
    }


}
