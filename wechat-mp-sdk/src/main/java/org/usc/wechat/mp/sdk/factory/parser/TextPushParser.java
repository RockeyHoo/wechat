package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.util.ReplyUtil;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.push.TextPush;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class TextPushParser implements PushParser {
	private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");
	
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof TextPush)) {
            return null;
        }

        TextPush textPush = (TextPush) push;

        // TODO please custom it.
        //Reply reply = ReplyUtil.parseReplyDetailWarpper(ReplyUtil.getDummyNewsReplyDetailWarpper());回复news消息
        //Reply reply = ReplyUtil.parseReplyDetailWarpper(ReplyUtil.getDummyTextReplyDetailWarpper());
        Reply reply = ReplyUtil.parseReplyDetailWarpper(ReplyUtil.getDummyTextReplyDetailWarpper(license, textPush.getToUserName(), textPush.getContent()));
        return ReplyUtil.buildReply(reply, textPush);
    }

}