package org.rockey.wechat.mp.sdk.util.platform;

import org.apache.commons.lang3.StringUtils;
import org.rockey.wechat.mp.sdk.util.HttpUtil;
import org.rockey.wechat.mp.sdk.vo.JsonRtn;
import org.rockey.wechat.mp.sdk.vo.WechatRequest;
import org.rockey.wechat.mp.sdk.vo.group.Group;
import org.rockey.wechat.mp.sdk.vo.group.GroupJsonRtn;
import org.rockey.wechat.mp.sdk.vo.group.MemberMovement;
import org.rockey.wechat.mp.sdk.vo.group.OpenId;
import org.rockey.wechat.mp.sdk.vo.group.GroupIdJsonRtn;
import org.rockey.wechat.mp.sdk.vo.group.GroupWarpper;
import org.rockey.wechat.mp.sdk.vo.group.GroupsJsonRtn;
import org.rockey.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author RockeyHoo
 */
public class GroupUtil {
    public static GroupsJsonRtn getGroups(License license) {
        return HttpUtil.getRequest(WechatRequest.GET_GROUPS, license, GroupsJsonRtn.class);
    }

    public static GroupIdJsonRtn getGroupIdByOpenId(License license, String openId) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.GET_GROUP_BY_OPEN_ID, license, new OpenId(openId), GroupIdJsonRtn.class);
    }

    public static GroupJsonRtn createGroup(License license, String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.CREATE_GROUP, license, new GroupWarpper(new Group(groupName)), GroupJsonRtn.class);
    }

    // TODO-RockeyHoo: now update group always failed, tip system error, check later
    public static JsonRtn updateGroup(License license, Group group) {
        if (group == null) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.UPDATE_GROUP, license, new GroupWarpper(group), GroupJsonRtn.class);
    }

    public static JsonRtn moveMember(License license, String openId, int toGroupId) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.MOVE_MEMBER_GROUP, license, new MemberMovement(openId, toGroupId), GroupJsonRtn.class);
    }
}
