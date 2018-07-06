package com.hz.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
public class Menu implements Serializable {
    private Integer id;
    private String menuName;
    private String menuCode;
    private String menuIcon;
    private String menuUrl;
    private String menuLevel;

    private Integer menuParentId;

    private List<Menu> secondMenuList;
    public Menu(Integer id, String menuName, String menuCode, String menuIcon, String menuUrl, String menuLevel, Integer menuParentId) {
        this.id = id;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
    }

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuParentId='" + menuParentId + '\'' +
                '}';
    }
}
