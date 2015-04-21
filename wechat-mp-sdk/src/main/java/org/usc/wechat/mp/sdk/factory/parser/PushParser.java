package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.push.Push;

/**
 *
 * @author RockeyHoo
 */
public interface PushParser {
    Reply parse(Push push);
}
