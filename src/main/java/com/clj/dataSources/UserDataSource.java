package com.clj.dataSources;

import java.util.HashMap;

/**
 * @Description
 * @Author gb
 * @Data 2022/9/2 22:03
 */
public class UserDataSource {


    private static HashMap<String,String > map=new HashMap();

    static {
        map.put("kingJu","12345678");
        map.put("chenlinju","88888888");
    }

    public static boolean existUser(String userName,String passWord){


        String s = map.get(userName);

        if (passWord.equals(s))
            return true;
        else
            return false;


    }
}
