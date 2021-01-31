package org.starrier.sky.ladder.basic.enums;

/**
 * @author starrier
 * @date 2021/1/31
 */
public class MainTest {

    public static void main(String[] args) {

        // 新增四个枚举项
        addTestEnum("a", "A", "AA");
        addTestEnum("b", "B", "BB");
        addTestEnum("c", "C", "CC");
        addTestEnum("d", "D", "DD");


        for (TestEnum testEnum : TestEnum.values()) {
            System.out.println(testEnum.toString());
        }

    }

    /**
     *
     * @param enumName 枚举名
     * @param code 枚举项1
     * @param name 枚举项2
     */
    private static void addTestEnum(String enumName, String code, String name) {
        DynamicEnumUtil.addEnum(TestEnum.class, enumName, new Class<?>[]
                        {String.class, String.class},
                new Object[]{code, name});
    }

}
