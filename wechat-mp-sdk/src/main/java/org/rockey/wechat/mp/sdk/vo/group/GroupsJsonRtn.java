package org.rockey.wechat.mp.sdk.vo.group;

import java.util.List;

import org.rockey.wechat.mp.sdk.vo.JsonRtn;

/**
 *
 * @author RockeyHoo
 */
public class GroupsJsonRtn extends JsonRtn
{
    private List<Group> groups;

    public GroupsJsonRtn() {
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}
