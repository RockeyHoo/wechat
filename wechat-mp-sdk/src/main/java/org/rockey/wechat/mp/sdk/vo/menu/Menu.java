package org.rockey.wechat.mp.sdk.vo.menu;

import java.util.ArrayList;
import java.util.List;

import org.rockey.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author RockeyHoo
 */
public class Menu extends AbstractToStringBuilder
{
    @JSONField(name = "button")
    private List<MenuInfo> menuInfos = new ArrayList<MenuInfo>();

    public Menu() {
    }

    public Menu(List<MenuInfo> menuInfos) {
        this.menuInfos = menuInfos;
    }

    public List<MenuInfo> getMenuInfos() {
        return menuInfos;
    }

    public void setMenuInfos(List<MenuInfo> menuInfos) {
        this.menuInfos = menuInfos;
    }

}
