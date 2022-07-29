package com.tang.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试用用户Dao
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/29 10:30
 */
public class UserDao {

    private static final Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "汤福林");
        hashMap.put("10002", "龙彦旭");
        hashMap.put("10003", "汤乐言");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
    
}
