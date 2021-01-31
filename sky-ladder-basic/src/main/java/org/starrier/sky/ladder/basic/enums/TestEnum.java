package org.starrier.sky.ladder.basic.enums;

/**
 * @author starrier
 * @date 2021/1/31
 */
/**
 * 枚举
 */
public enum TestEnum {
    ;

    String code;
    String name;

    TestEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name() + "{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

