package com.engine.verbose.accountsmanager.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class BeanUtilsHelper {
    private BeanUtilsHelper() {
        // Private constructor to prevent instantiation
    }

    public static void copyNonNullProperties(Object source, Object target) {
        BeanWrapper src = new BeanWrapperImpl(source);
        Set<String> nullPropertyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : src.getPropertyDescriptors()) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                nullPropertyNames.add(pd.getName());
            }
        }

        String[] ignoreProperties = nullPropertyNames.toArray(new String[0]);
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }
}
