package com.github.easytag.core.comparators;

/**
 * 比较器
 */
public interface Comparator {

    /**
     * 比较器执行比较
     * @param source
     * @param target
     * @return
     */
    boolean compare(Object source, Object target);

}
