package org.rockey.wechat.mp.sdk.vo.user;

import java.util.List;

import org.rockey.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author RockeyHoo
 */
public class OpenIdsJsonRtn extends AbstractToStringBuilder
{
    @JSONField(name = "openid")
    private List<String> openIds;

    public OpenIdsJsonRtn() {
    }

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }

}
