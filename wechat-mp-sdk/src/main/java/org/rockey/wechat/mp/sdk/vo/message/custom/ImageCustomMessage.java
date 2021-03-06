package org.rockey.wechat.mp.sdk.vo.message.custom;

import org.rockey.wechat.mp.sdk.vo.message.custom.detail.MediaCustomMessageDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author RockeyHoo
 */
public class ImageCustomMessage extends CustomMessage {
    @JSONField(name = "image")
    private MediaCustomMessageDetail imageDetail;

    {
        super.setMsgType(CustomMessageType.IMAGE.getMsgType());
    }

    public ImageCustomMessage(MediaCustomMessageDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

    public MediaCustomMessageDetail getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(MediaCustomMessageDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

}
