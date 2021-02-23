package maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author starrier
 * @date 2020/12/2
 */
public class Maps {

    public static void main(String[] args) {

        System.out.println(caculate());
    }

    public static Map<Integer, Integer> caculate() {

        Map<Integer, Integer> target = new HashMap<>();

        for (int i = 0; i < 10; i++) {

            target.put(i, target.getOrDefault(i, 1));

        }

        return target;
    }
}
