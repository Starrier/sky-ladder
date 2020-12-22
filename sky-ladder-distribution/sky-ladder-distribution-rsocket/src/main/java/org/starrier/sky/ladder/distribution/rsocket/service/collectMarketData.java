package org.starrier.sky.ladder.distribution.rsocket.service;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

/**
 * @author starrier
 * @date 2020/12/22
 */
@Controller
public class collectMarketData {

    @MessageMapping("collectMarketData")
    public Mono<Void> collectMarketData() {
        return Mono.empty();
    }
}
