package me.easytag.core;

import me.easytag.core.driver.ComparatorDriver;
import me.easytag.core.driver.impl.DefaultComparatorDriver;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;

public class ExampleTest {

    public static void main(String[] args) {
//        String a1 = "abc";
//        String[] a2Array = new String[]{"a","b", "abc"};

        String a1 = null;
        String[] a2Array = new String[]{"a","b", "abc"};
        String a2 = "123";

        ComparatorDriver driver = new DefaultComparatorDriver();

        boolean execute = driver.execute(a1, a2Array, LogicalOperatorEnum.IN, DataTypeEnum.STRING);
        System.out.println(execute);

        boolean execute2 = driver.execute(a1, a2, LogicalOperatorEnum.EQUALS, DataTypeEnum.STRING);
        System.out.println(execute2);
    }

}
