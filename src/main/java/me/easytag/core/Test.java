package me.easytag.core;

import me.easytag.core.comparators.impl.EqualsComparator;
import me.easytag.core.enums.DataTypeEnum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        DateFormat simDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simDateFormat.parse("2020-12-16 15:12:12");
        Date date2 = simDateFormat.parse("2020-12-16 15:12:13");

        EqualsComparator equalsComparator = new EqualsComparator(DataTypeEnum.DOUBLE);
        boolean compare = equalsComparator.compare(0.1254d, 0.12542d);
        System.out.println(compare);
    }
}
