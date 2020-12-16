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
}
