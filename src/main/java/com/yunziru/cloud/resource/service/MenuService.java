package com.yunziru.cloud.resource.service;

import com.yunziru.cloud.resource.dao.MenuDao;
import com.yunziru.cloud.resource.dto.MenuDTO;
import com.yunziru.cloud.resource.entity.Menu;
import com.yunziru.common.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/12/10
 * Description：
 */
@Service
public class MenuService  extends CommonService<Menu, Long> {

    private static final Logger LOG = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private MenuDao menuDao;

    @Autowired
    public void setMenuDao(MenuDao menuDao){
        super.setCommonDao(menuDao);
    }

    public static ArrayList<MenuDTO> menusCache = new ArrayList<>();

    public List<Menu> getAllTopMenu() {
        return menuDao.findMenuByParent(0L);
    }

    public void initCache() {
        List<Menu> menuList = this.getAllTopMenu();
        menuList.forEach(menu -> {
            menusCache.add(new MenuDTO(menu.getName(), menu.getUrl(), menuDao.findMenuByParent(menu.getId())));
        });
    }

    @PostConstruct
    public void init() {
        if (LOG.isInfoEnabled()) {
            LOG.info("init menu ...");
        }
        initCache();
    }
}
