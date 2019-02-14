package com.template.utils;

import org.apache.commons.lang3.RandomUtils;

public class RandomUtil {

    public static int getRandomIntInRange(int s, int e) {
        return RandomUtils.nextInt(s, e);
    }

}
