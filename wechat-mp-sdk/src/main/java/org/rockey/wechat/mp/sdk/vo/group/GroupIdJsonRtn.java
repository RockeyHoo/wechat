package org.rockey.wechat.mp.sdk.vo.group;

import org.rockey.wechat.mp.sdk.vo.JsonRtn;

/**
 *
 * @author RockeyHoo
 */
public class GroupIdJsonRtn extends JsonRtn
{
    private int groupId;

    public GroupIdJsonRtn() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
