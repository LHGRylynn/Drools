package com.ytooo.bean;

import com.opencsv.bean.CsvBindByName;

/**
 * Author: 王乾
 * Date: 2021/5/10 14:03
 */
public class a {
    @CsvBindByName(column = "a")
    private String a;

    @CsvBindByName(column = "b")
    private int b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
