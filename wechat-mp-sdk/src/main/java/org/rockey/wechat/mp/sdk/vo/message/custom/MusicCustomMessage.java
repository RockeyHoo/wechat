package org.rockey.wechat.mp.sdk.vo.message.custom;

import org.rockey.wechat.mp.sdk.vo.message.custom.detail.MusicCustomMessageDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author RockeyHoo
 */
public class MusicCustomMessage extends CustomMessage {
    @JSONField(name = "music")
    private MusicCustomMessageDetail musicDetail;

    {
        super.setMsgType(CustomMessageType.MUSIC.getMsgType());
    }

    public MusicCustomMessage(MusicCustomMessageDetail musicDetail) {
        this.musicDetail = musicDetail;
    }

    public MusicCustomMessageDetail getMusicDetail() {
        return musicDetail;
    }

    public void setMusicDetail(MusicCustomMessageDetail musicDetail) {
        this.musicDetail = musicDetail;
    }

}
