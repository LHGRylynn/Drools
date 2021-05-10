package com.ytooo.model;

/**
 * Author: 王乾
 * Date: 2021/5/10 20:36
 */
public class Popularity {
   // [(-0.001, 0.269] < (0.269, 0.776] < (0.776, 1.678] < (1.678, 5.035] < (5.035, 547.488]]

    public static  double first=5.035;
    public static  double second=1.678;
//    public static double third=0.776;
//    public static double fourth=0.269;

    public static double getFirstBonus(){
        return 2;
    }
    public static double getSecondBonus(){
        return 1;
    }
//    public static double getThird(){
//        return 0.2;
//    }
//    public static double getFourth(){
//        return 0.1;
//    }


}
