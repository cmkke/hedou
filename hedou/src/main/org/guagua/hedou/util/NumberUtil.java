/**
 * 
 */
package org.guagua.hedou.util;

import java.math.BigDecimal;

/**
 * @ClassName: MoneyUtil.java
 * @Description:
 * @author mk
 * @date 2013年9月12日 上午11:00:53
 * @version 1.00 初始版本
 */
public class NumberUtil
{
    
    /**
     * 对double数据进行取精度.1
     * 
     * @param value double数据.
     * @param scale 精度位数(保留的小数位数).
     * @param roundingMode 精度取值方式.
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }
    
    /**
     * double 相加
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static double sum(double d1, double d2)
    {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }
    
    /**
     * double 相减
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static double sub(double d1, double d2)
    {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }
    
    /**
     * double 乘法
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1, double d2)
    {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }
    
    /**
     * double 除法
     * 
     * @param d1
     * @param d2
     * @param scale 四舍五入 小数点位数
     * @return
     */
    public static double div(double d1, double d2, int scale)
    {
        
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    public static void main(String[] args)
    {
        System.out.println((int)mul(1.5,10));
        float aa= (float)div(265, 10, 2);
        System.out.println(aa);
    }
}
