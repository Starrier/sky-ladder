package org.starrier.sky.ladder.basic.convert;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author starrier
 * @date 2020/12/1
 */
public class StringWithBigDecimal {

    public static void main(String[] args) {

        System.out.println(stringToBigDecimal("1.2222222"));

        System.out.println(bigDecimalToString(BigDecimal.valueOf(1.22222222)));
    }

    public static BigDecimal stringToBigDecimal(String target){

        if(StringUtils.isBlank(target)){
            return null;
        }

        return new BigDecimal(target);
    }

    public static String bigDecimalToString(BigDecimal target){
        if (target == null){
            return StringUtils.EMPTY;
        }

        return target.toString();
    }
}
