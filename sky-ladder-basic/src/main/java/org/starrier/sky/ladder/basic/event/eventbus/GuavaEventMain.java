package org.starrier.sky.ladder.basic.event.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @author starrier
 * @date 2021/2/22
 */
public class GuavaEventMain {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GeventListener listener = new GeventListener();
        eventBus.register(listener);

        eventBus.post(new HelloEvent("hello"));
        eventBus.post(new WorldEvent("world", "23333"));
    }
}
