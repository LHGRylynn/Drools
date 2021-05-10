package com.ytooo.model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author: 王乾
 * Date: 2021/5/10 21:39
 */
public class favorityLanguage {
    public static HashSet<String> languages;

    static {
        languages.add("cn");
        languages.add("jp");
    }

    public static boolean isFavorite(String s){
      if( languages.contains(s)){
          return true;
      }else{
          return false;
      }
    }

    public static double langBonus=0.1;

}
