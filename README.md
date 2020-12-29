# easy-tag-core
easy-tag核心库

# 什么是easy-tag?
tag可以理解为标签，即用一个标签来描述一个事物<br>

easy-tag则是为了描述一组规则

# easy-tag可以做什么?
1.给规则定义标签

2.用标签匹配数据

# 什么是规则?
这里定义的规则可以理解为一堆逻辑关系，如：<br>
a=1 且 b>2 且 c<3等

---
<strong>**简而言之,easy-tag为了给一对简单的规则打上标签**</strong><br>
例如：<br>
a=1 且 b>2 且 c<3 是A标签<br>
a=1 或 b>2 或 c<3 是B标签<br>
在真正的使用场景中，我们则可以把某种规则简单的称之为A标签，B标签等

# easy-tag-core可以做什么?
按规则计算数据

# EXAMPLE
## 普通判断器用法（用来判断某一个规则是否满足）
#### 判断某个字符串是否在某组字符串中
```
 ComparatorDriver driver = DefaultComparatorDriver.getInstance();
 String a1 = "123";
 String[] a2Array = new String[]{"a","b", "abc"};
 String a2 = "123";
 boolean inResult = driver.execute(a1, a2Array, LogicalOperatorEnum.IN, DataTypeEnum.STRING);
 // true即满足 false即不满足
```
---
#### 判断字符串相等
```
 ComparatorDriver driver = DefaultComparatorDriver.getInstance();
 String a1 = "123";
 String a2 = "123";
 boolean equalsResult = driver.execute(a1, a2, LogicalOperatorEnum.EQUALS, DataTypeEnum.STRING);
 // true即满足 false即不满足
```
---
#### 判断某个时间处于一对时间之间
```
ComparatorDriver driver = DefaultComparatorDriver.getInstance();
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date1 = dateFormat.parse("2020-12-17 10:18:50");
Date date2 = dateFormat.parse("2020-12-17 10:18:55");
Date date3 = dateFormat.parse("2020-12-17 10:18:52");
boolean executeDate = driver.execute(date3, Arrays.asList(date1, date2).toArray(), LogicalOperatorEnum.BETWEEN, DataTypeEnum.DATE);
// true即满足 false即不满足
```
## 组合判断器用法（用来判断某一组规则是否满足）
#### 用OR类型判断一组规则
```
JudgeTypeDriver judgeTypeDriver = DefaultJudgeTypeDriver.getInstance();

String a1 = "123";
String[] a2Array = new String[]{"a","b", "abc"};
String a2 = "123";

CompareData compareData1 = new CompareData();
compareData1.setDataType(DataTypeEnum.STRING);
compareData1.setLogicalOperator(LogicalOperatorEnum.IN);
compareData1.setSourceData(a1);
compareData1.setTargetData(a2Array);

CompareData compareData2 = new CompareData();
compareData2.setDataType(DataTypeEnum.STRING);
compareData2.setLogicalOperator(LogicalOperatorEnum.EQUALS);
compareData2.setSourceData(a1);
compareData2.setTargetData(a2);

DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date1 = dateFormat.parse("2020-12-17 10:18:50");
Date date2 = dateFormat.parse("2020-12-17 10:18:55");
Date date3 = dateFormat.parse("2020-12-17 10:18:52");

CompareData compareData3 = new CompareData();
compareData3.setDataType(DataTypeEnum.DATE);
compareData3.setLogicalOperator(LogicalOperatorEnum.BETWEEN);
compareData3.setSourceData(date3);
compareData3.setTargetData(Arrays.asList(date1, date2).toArray());

JudgeData judgeData = new JudgeData();
judgeData.setJudgeType(JudgeTypeEnum.OR);
judgeData.setCompareDataList(Arrays.asList(compareData1, compareData2, compareData3));
boolean result = judgeTypeDriver.execute(judgeData);
// true即满足 false即不满足
```
#### 通过传入DTO数据，进行复杂计算
```
// 生成DTO
ExpressCondition expressCondition = new ExpressCondition();
ExpressBranch expressBranch = new ExpressBranch();
ExpressItem expressItem = new ExpressItem();
expressItem.setDataType(DataTypeEnum.INTEGER.name());
expressItem.setLogicalOperator(LogicalOperatorEnum.LESS.name());
expressItem.setSourceData(2);
expressItem.setTargetData(1);
expressBranch.setExpressItem(expressItem);
expressCondition.setExpressBranches(Arrays.asList(expressBranch));

// 进行计算
EasyTagService easyTagService = DefaultEasyTagService.getInstance();
boolean result = easyTagService.handle(expressCondition);
System.out.println(result);
```
---
## 实现原理如图
![image](/src/main/resources/imgs/easy-tag数据结构.png)

