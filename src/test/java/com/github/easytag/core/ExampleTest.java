package com.github.easytag.core;

import com.github.easytag.core.driver.comparator.ComparatorDriver;
import com.github.easytag.core.driver.comparator.impl.DefaultComparatorDriver;
import com.github.easytag.core.driver.judgetype.JudgeTypeDriver;
import com.github.easytag.core.driver.judgetype.impl.DefaultJudgeTypeDriver;
import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.dto.express.*;
import com.github.easytag.core.dto.judge.JudgeData;
import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.enums.JudgeTypeEnum;
import com.github.easytag.core.enums.LogicalOperatorEnum;
import com.github.easytag.core.executors.expression.ExpressionExecutor;
import com.github.easytag.core.executors.expression.impl.DefaultExpressionExecutor;
import com.github.easytag.core.resolver.impl.DefaultExpressionParser;

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


//        Map<String, Object> expressionVars = new HashMap<>();
//        expressionVars.put("A", "123");
//        expressionVars.put("B", new String[]{"a","b", "abc"});
//        String expression = "A IN B AND [ A GREATER C OR C LESS D ] AND [ D IN E AND [ [ E GREATER F OR E EQUALS F ] OR F EQUALS G ] ]";
//
//        DefaultExpressionParser defaultExpressionParser = new DefaultExpressionParser();
//        ExpressNode headNode = defaultExpressionParser.parse(expression);
//        System.out.println(headNode);

        ExpressCondition expressCondition = new ExpressCondition();
        ExpressBranch expressBranch = new ExpressBranch();
        ExpressItem expressItem = new ExpressItem();
        expressItem.setDataType(DataTypeEnum.INTEGER.name());
        expressItem.setLogicalOperator(LogicalOperatorEnum.LESS.name());
        expressItem.setSourceData(2);
        expressItem.setTargetData(1);
        expressBranch.setExpressItem(expressItem);
        expressCondition.setExpressBranches(Arrays.asList(expressBranch));

        DefaultExpressionParser defaultExpressionParser = DefaultExpressionParser.getInstance();
        ExpressionContext expressionContext = defaultExpressionParser.parseExpression(expressCondition);
        System.out.println(expressionContext);

        ExpressNode parseNode = defaultExpressionParser.parse(expressionContext.getExpression());
        System.out.println(parseNode);

        ExpressionExecutor expressionExecutor = DefaultExpressionExecutor.getInstance();
        boolean execute5 = expressionExecutor.execute(expressionContext);
        System.out.println(execute5);
    }


}
