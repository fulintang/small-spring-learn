package com.tang.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    
    private static final Map<String, String> hashMap = new HashMap<>();
    
    static {
        hashMap.put("100001", "汤福林");
        hashMap.put("100002", "龙彦旭");
        hashMap.put("100003", "汤乐言");
    }
    
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
    
}
