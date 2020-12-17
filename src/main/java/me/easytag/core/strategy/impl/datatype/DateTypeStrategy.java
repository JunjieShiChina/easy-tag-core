package me.easytag.core.strategy.impl.datatype;

import me.easytag.core.logic.dto.LogicData;
import me.easytag.core.strategy.DataTypeStrategy;

import java.util.Date;

/**
 * 日期类型策略
 */
public class DateTypeStrategy implements DataTypeStrategy {
    @Override
    public boolean handleEquals(LogicData source, LogicData target) {
        Date sourceDate = (Date) source.getValue();
        Date targetDate = (Date) target.getValue();
        if(sourceDate == null || targetDate == null) {
            return false;
        }
        return sourceDate.equals(targetDate);
    }

    @Override
    public boolean handleLess(LogicData source, LogicData target) {
        Date sourceDate = (Date) source.getValue();
        Date targetDate = (Date) target.getValue();
        if(sourceDate == null || targetDate == null) {
            return false;
        }
        return sourceDate.before(targetDate);
    }

    @Override
    public boolean handleGreater(LogicData source, LogicData target) {
        Date sourceDate = (Date) source.getValue();
        Date targetDate = (Date) target.getValue();
        if(sourceDate == null || targetDate == null) {
            return false;
        }
        return sourceDate.after(targetDate);
    }

    @Override
    public boolean handleIn(LogicData source, LogicData target) {
        Date sourceDate = (Date) source.getValue();
        Date[] targetDateArray = (Date[]) target.getValue();
        if(sourceDate == null || targetDateArray == null || targetDateArray.length < 1) {
            return false;
        }
        for (Date targetDate: targetDateArray) {
            if(sourceDate.equals(targetDate)) {
                return true;
            }
        }
        return  false;
    }

    @Override
    public boolean handleBetween(LogicData source, LogicData target) {
        Date sourceDate = (Date) source.getValue();
        Date[] targetDateArray = (Date[]) target.getValue();
        if(sourceDate == null || targetDateArray == null || targetDateArray.length < 2) {
            return false;
        }
        Date targetDateFrom = null;
        Date targetDateTo = null;

        Date targetDate1 = targetDateArray[0];
        Date targetDate2 = targetDateArray[1];
        if(targetDate1.before(targetDate2)) {
            targetDateFrom = targetDate1;
            targetDateTo = targetDate2;
        } else {
            targetDateFrom = targetDate2;
            targetDateTo = targetDate1;
        }

        if(sourceDate.equals(targetDateFrom) || sourceDate.equals(targetDateTo)) {
            return true;
        }

        return (sourceDate.after(targetDateFrom) && sourceDate.before(targetDateTo));
    }
}
