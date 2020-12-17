package me.easytag.core;

import me.easytag.core.driver.comparator.ComparatorDriver;
import me.easytag.core.driver.comparator.impl.DefaultComparatorDriver;
import me.easytag.core.driver.judgetype.JudgeTypeDriver;
import me.easytag.core.driver.judgetype.impl.DefaultJudgeTypeDriver;
import me.easytag.core.dto.comparator.CompareData;
import me.easytag.core.dto.judge.JudgeData;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.JudgeTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ExampleTest {

    public static void main(String[] args) throws ParseException {

        String a1 = "123";
        String[] a2Array = new String[]{"a","b", "abc"};
        String a2 = "123";

        ComparatorDriver driver = DefaultComparatorDriver.getInstance();

        boolean execute = driver.execute(a1, a2Array, LogicalOperatorEnum.IN, DataTypeEnum.STRING);

        CompareData compareData1 = new CompareData();
        compareData1.setDataType(DataTypeEnum.STRING);
        compareData1.setLogicalOperator(LogicalOperatorEnum.IN);
        compareData1.setSourceData(a1);
        compareData1.setTargetData(a2Array);

        System.out.println(execute);

        boolean execute2 = driver.execute(a1, a2, LogicalOperatorEnum.EQUALS, DataTypeEnum.STRING);

        CompareData compareData2 = new CompareData();
        compareData2.setDataType(DataTypeEnum.STRING);
        compareData2.setLogicalOperator(LogicalOperatorEnum.EQUALS);
        compareData2.setSourceData(a1);
        compareData2.setTargetData(a2);

        System.out.println(execute2);

        boolean execute3 = driver.execute(a1, a2, LogicalOperatorEnum.NOT_EQUALS, DataTypeEnum.STRING);
        System.out.println(execute3);

        double d1 = 0.123d;
        double d2 = 0.1234d;
        double d3 = 0.1232d;
        boolean execute1 = driver.execute(d3, Arrays.asList(d1, d2).toArray(), LogicalOperatorEnum.BETWEEN, DataTypeEnum.DOUBLE);
        System.out.println(execute1);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = dateFormat.parse("2020-12-17 10:18:50");
        Date date2 = dateFormat.parse("2020-12-17 10:18:55");
        Date date3 = dateFormat.parse("2020-12-17 10:18:52");
        boolean executeDate = driver.execute(date3, Arrays.asList(date1, date2).toArray(), LogicalOperatorEnum.BETWEEN, DataTypeEnum.DATE);
        System.out.println(executeDate);

        boolean executeDate2 = driver.execute(date3, Arrays.asList(date1, date2).toArray(), LogicalOperatorEnum.NOT_BETWEEN, DataTypeEnum.DATE);
        System.out.println(executeDate2);

        JudgeTypeDriver judgeTypeDriver = DefaultJudgeTypeDriver.getInstance();

        JudgeData judgeData = new JudgeData();
        judgeData.setJudgeType(JudgeTypeEnum.OR);
        judgeData.setCompareDataList(Arrays.asList(compareData1, compareData2));
        boolean execute4 = judgeTypeDriver.execute(judgeData);
        System.out.println(execute4);

    }

}
