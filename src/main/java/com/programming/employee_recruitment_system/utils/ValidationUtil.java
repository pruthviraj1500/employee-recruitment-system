package com.programming.employee_recruitment_system.utils;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {
    public static boolean isBlank(final CharSequence cs) {
        return StringUtils.isBlank(cs);
    }
}
