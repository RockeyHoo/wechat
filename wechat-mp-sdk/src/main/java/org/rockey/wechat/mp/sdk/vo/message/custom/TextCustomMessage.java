package org.rockey.wechat.mp.sdk.vo.message.custom;

import org.rockey.wechat.mp.sdk.vo.message.custom.detail.TextCustomMessageDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author RockeyHoo
 */
public class TextCustomMessage extends CustomMessage {
    @JSONField(name = "text")
    private TextCustomMessageDetail textDetail;

    {
        super.setMsgType(CustomMessageType.TEXT.getMsgType());
    }

    public TextCustomMessage(TextCustomMessageDetail textDetail) {
        this.textDetail = textDetail;
    }

    public TextCustomMessageDetail getTextDetail() {
        return textDetail;
    }

    public void setTextDetail(TextCustomMessageDetail textDetail) {
        this.textDetail = textDetail;
    }

}
