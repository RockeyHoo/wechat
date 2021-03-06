package org.rockey.wechat.mp.sdk.vo.message.mass;

import org.rockey.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author RockeyHoo
 */
public class MassNews extends AbstractToStringBuilder
{
    @JSONField(name = "media_id")
    private String mediaId;

    public MassNews() {
    }

    public MassNews(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
