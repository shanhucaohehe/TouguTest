package com.example.tie.mqttdemo.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 处理小数位数工具类
 * Created by fengpeihao on 2017/2/15.
 */

public class NumberUtils {
    private static DecimalFormat mFormat2 = new DecimalFormat("#0.00");
    private static DecimalFormat mFormat1 = new DecimalFormat("#0.0");
    private static DecimalFormat format = new DecimalFormat("#0");

    /**
     * 保留两位小数字符串
     *
     * @param d
     * @return
     */
    public static String getFloatStr2(double d) {
        try {
            return mFormat2.format(d);
        } catch (Exception e) {
            return "0.00";
        }
    }

    /**
     * 保留两位小数字符串
     *
     * @param str
     * @return
     */
    public static String getFloatStr2(String str) {
        try {
            return mFormat2.format(Double.parseDouble(str));
        } catch (Exception e) {
            return "0.00";
        }
    }

    /**
     * 保留一位小数字符串
     *
     * @param d
     * @return
     */
    public static String getFloatStr1(double d) {
        try {
            return mFormat1.format(d);
        } catch (Exception e) {
            return "0.0";
        }
    }

    /**
     * 保留一位小数字符串
     *
     * @param str
     * @return
     */
    public static String getFloatStr1(String str) {
        try {
            return mFormat1.format(Double.parseDouble(str));
        } catch (Exception e) {
            return "0.0";
        }
    }

    /**
     * 整数字符串
     *
     * @param f
     * @return
     */
    public static String getIntegerStr(double f) {
        try {
            return format.format(f);
        } catch (Exception e) {
            return "0";
        }
    }

    /**
     * 整数字符串
     *
     * @param str
     * @return
     */
    public static String getIntegerStr(String str) {
        try {
            return format.format(Double.parseDouble(str));
        } catch (Exception e) {
            return "0";
        }
    }

    /**
     * @param str
     * @return
     */
    public static double getDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0.00;
        }
    }

    public static int getInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 返回整数（大于等于该数的那个最近值）
     *
     * @param d
     * @return
     */
    public static int getRoundCeilingInt(double d) {
        BigDecimal decimal = new BigDecimal(d);
        BigDecimal bigDecimal = decimal.setScale(0, BigDecimal.ROUND_UP);
        return bigDecimal.intValue();
    }

    /**
     * 返回double（大于等于该数的那个最近值）
     *
     * @param d
     * @param newScale
     * @return
     */
    public static double getRoundCeiling(double d, int newScale) {
        BigDecimal decimal = new BigDecimal(d);
        BigDecimal bigDecimal = decimal.setScale(newScale, BigDecimal.ROUND_UP);
        return bigDecimal.doubleValue();
    }

    /**
     * 查询数值在数组中的索引
     *
     * @param arr
     * @param value
     * @return
     */
    public static int getPosition(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return 0;
    }

}
