package org.rockey.wechat.mp.sdk.vo;

import org.rockey.wechat.mp.sdk.vo.push.event.EventPush;
import org.rockey.wechat.mp.sdk.vo.push.event.LocationEventPush;
import org.rockey.wechat.mp.sdk.vo.push.event.MassEndJobFinishEventPush;
import org.rockey.wechat.mp.sdk.vo.push.event.NormalEventPush;

/**
 *
 * @author RockeyHoo
 */
public enum EventPushType {
    SUBSCRIBE("subscribe", NormalEventPush.class),
    UNSUBSCRIBE("unsubscribe", NormalEventPush.class),
    CLICK("CLICK", NormalEventPush.class),
    VIEW("VIEW", NormalEventPush.class),
    SCAN("scan", NormalEventPush.class),
    LOCATION("LOCATION", LocationEventPush.class),
    MASSSENDJOBFINISH("MASSSENDJOBFINISH", MassEndJobFinishEventPush.class);

    private String type;
    private Class<? extends EventPush> eventPushClass;

    private EventPushType(String type, Class<? extends EventPush> eventPushClass) {
        this.type = type;
        this.eventPushClass = eventPushClass;
    }

    public String getType() {
        return type;
    }

    public Class<? extends EventPush> getEventPushClass() {
        return eventPushClass;
    }
}
