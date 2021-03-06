package org.rockey.wechat.mp.sdk.factory.builder;

import org.rockey.wechat.mp.sdk.vo.ReplyDetail;
import org.rockey.wechat.mp.sdk.vo.message.reply.ImageReply;
import org.rockey.wechat.mp.sdk.vo.message.reply.detail.MediaDetail;
import org.rockey.wechat.mp.sdk.vo.message.reply.Reply;

import java.util.List;

/**
 *
 * @author RockeyHoo
 */
public class ImageReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);
        return new ImageReply(new MediaDetail(detail.getMediaId()));
    }

}
