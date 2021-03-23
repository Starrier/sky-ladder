package org.starrier.sky.ladder.basic.event.eventbus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author starrier
 * @date 2021/2/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloEvent {

    private String eventName;
}
