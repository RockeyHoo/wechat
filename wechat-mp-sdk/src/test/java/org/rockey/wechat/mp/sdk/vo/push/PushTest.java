package org.rockey.wechat.mp.sdk.vo.push;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.rockey.wechat.mp.sdk.factory.PushEnumFactory;
import org.rockey.wechat.mp.sdk.vo.message.reply.Reply;

import java.io.File;

/**
 * @author RockeyHoo
 */
public class PushTest
{

    public static void main(String[] args) throws Exception
    {
        File parent = new File(PushTest.class.getClassLoader().getResource("push").toURI());
        for (File pushFile : parent.listFiles())
        {
            if (!StringUtils.startsWithIgnoreCase(pushFile.getName(), "text"))
            {
                continue;
            }
            String message = FileUtils.readFileToString(pushFile, "utf-8");
            String messageType = getMsgType(message);
            PushEnumFactory pushEnum = EnumUtils.getEnum(PushEnumFactory.class, StringUtils.upperCase(messageType));
            Push push = pushEnum.convert(message);
            Reply reply = pushEnum.parse(push);
            System.out.println(push + "\n" + push + "\n reply" + reply + "\n");
        }
    }

    private static String getMsgType(String message)
    {
        return StringUtils.substringBetween(message, "<MsgType><![CDATA[", "]]></MsgType>");
    }

}
