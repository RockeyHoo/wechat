package org.rockey.wechat.mp.sdk.util.platform;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.rockey.wechat.mp.sdk.util.HttpUtil;
import org.rockey.wechat.mp.sdk.vo.WechatRequest;
import org.rockey.wechat.mp.sdk.vo.token.License;
import org.rockey.wechat.mp.sdk.vo.user.UserInfoJsonRtn;
import org.rockey.wechat.mp.sdk.vo.user.UsersJsonRtn;

import java.util.Locale;
import java.util.Map;

/**
 * @author RockeyHoo
 */
public class UserUtil
{
    public static UserInfoJsonRtn getUserInfo(License license, String openId)
    {
        return getUserInfo(license, openId, null);
    }

    public static UserInfoJsonRtn getUserInfo(License license, String openId, Locale local)
    {
        if (StringUtils.isEmpty(openId))
        {
            return null;
        }
        String lang = local != null ? local.toString() : StringUtils.EMPTY;
        Map<String, String> paramMap = ImmutableMap.of("openid", openId, "lang", lang, "access_token", AccessTokenUtil.getAccessToken(license));
        return HttpUtil.getRequest(WechatRequest.GET_USER_INFO, license, paramMap, UserInfoJsonRtn.class);
    }

    public static UsersJsonRtn getUsers(License license)
    {
        return getUsers(license, null);
    }

    public static UsersJsonRtn getUsers(License license, String nextOpenId)
    {
        Map<String, String> paramMap = ImmutableMap.of("next_openid", StringUtils.defaultString(nextOpenId), "access_token", AccessTokenUtil.getAccessToken(license));
        return HttpUtil.getRequest(WechatRequest.GET_USERS, license, paramMap, UsersJsonRtn.class);
    }
}
