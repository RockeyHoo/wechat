package org.rockey.wechat.mp.sdk.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.rockey.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.rockey.wechat.mp.sdk.util.biz.BizUtil;
import org.rockey.wechat.mp.sdk.vo.ReplyDetail;
import org.rockey.wechat.mp.sdk.vo.ReplyDetailWarpper;
import org.rockey.wechat.mp.sdk.vo.biz.BizJsonRtn;
import org.rockey.wechat.mp.sdk.vo.message.reply.Reply;
import org.rockey.wechat.mp.sdk.vo.push.Push;
import org.rockey.wechat.mp.sdk.vo.token.License;

import java.util.Arrays;

/**
 *
 * @author RockeyHoo
 */
public class ReplyUtil {
    public static Reply buildReply(Reply reply, Push push) {
        try {
            if (reply != null) {
                // keep is new instance
                Reply newReply = (Reply) BeanUtils.cloneBean(reply);

                newReply.setCreateTime(getUnixTimeStamp());
                newReply.setToUserName(push.getFromUserName());
                newReply.setFromUserName(push.getToUserName());

                return newReply;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static long getUnixTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    public static Reply parseReplyDetailWarpper(ReplyDetailWarpper replyDetailWarpper) {
        if (replyDetailWarpper == null) {
            return null;
        }

        String replyType = replyDetailWarpper.getReplyType();
        ReplyEnumFactory replyEnumFactory = EnumUtils.getEnum(ReplyEnumFactory.class, StringUtils.upperCase(replyType));
        if (replyEnumFactory == null) {
            return null;
        }

        Reply buildReply = replyEnumFactory.buildReply(replyDetailWarpper.getReplyDetails());
        if (buildReply != null) {
            buildReply.setFuncFlag(replyDetailWarpper.getFuncFlag());

            return buildReply;
        }

        return null;
    }

    /**
     * dummy reply. please according to your own situation to build ReplyDetailWarpper, and remove those code in production.
     */
    public static ReplyDetailWarpper getDummyTextReplyDetailWarpper() {
        ReplyDetail replyDetail = new ReplyDetail();
        replyDetail.setDescription("欢迎订阅泉桥资产");

        return new ReplyDetailWarpper("text", Arrays.asList(replyDetail));
    }

    public static ReplyDetailWarpper getClickTextReplyDetailWarpper() {
        ReplyDetail replyDetail = new ReplyDetail();
        replyDetail.setDescription("REPLACEMENT");

        return new ReplyDetailWarpper("text", Arrays.asList(replyDetail));
    }

    public static ReplyDetailWarpper getDummyTextReplyDetailWarpper(License license,String openId,String message) {
        ReplyDetail replyDetail = new ReplyDetail();
        BizJsonRtn reply = BizUtil.getBizInfo(license, openId, message);
        if (StringUtils.trimToEmpty(reply.getErrCode()).equals("")) {
        	replyDetail.setDescription("咔咔回复 : " + reply.getContent());
        } else {
            replyDetail.setDescription("欢迎订阅咔咔 \n" +
                    "Welcome subscribe kaka, are you SB?");
        }
        return new ReplyDetailWarpper("text", Arrays.asList(replyDetail));
    }
    
    /**
     * dummy reply. please according to your own situation to build ReplyDetailWarpper, and remove those code in production.
     */
    public static ReplyDetailWarpper getDummyNewsReplyDetailWarpper() {
        ReplyDetail replyDetail1 = new ReplyDetail();
        replyDetail1.setTitle("fork me");
        replyDetail1.setMediaUrl("http://c.hiphotos.baidu.com/baike/c%3DbaikeA4%2C10%2C95/sign=c1767bbf4b36acaf4de0c1ad15b2e851/29381f30e924b899a39841be6e061d950b7b02087af4d6b3.jpg");
        replyDetail1.setUrl("https://github.com/usc/wechat-mp-sdk");
        replyDetail1.setDescription("hello world, wechat mp sdk is coming");

        ReplyDetail replyDetail2 = new ReplyDetail();
        replyDetail2.setTitle("star me");
        replyDetail2.setMediaUrl("http://e.hiphotos.baidu.com/baike/pic/item/96dda144ad345982665e49810df431adcaef84c9.jpg");
        replyDetail2.setUrl("https://github.com/usc/wechat-mp-web");
        replyDetail2.setDescription("wechat mp web demo");

        return new ReplyDetailWarpper("news", Arrays.asList(replyDetail1, replyDetail2));
    }
}
