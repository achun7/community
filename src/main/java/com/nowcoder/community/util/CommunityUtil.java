package com.nowcoder.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommunityUtil {

    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");//原随机字符串由数字英文'-'组成
    }

    // MD5加密 只能加密，不能解密
    // hello -> abc123def456
    // hello + 3e4a8(salt,随机字符串) -> abc123def456abc
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {//空格、空字符串都返回true
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    //    获取json请求
    public static String getJSONString(int code, String msg, Map<String, Object> map) {//编号，提示，内容
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if (map != null) {
            for (String key : map.keySet()) {
                json.put(key, map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJSONString(int code, String msg) {
        return getJSONString(code, msg, null);
    }

    public static String getJSONString(int code) {
        return getJSONString(code, null, null);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 25);
        System.out.println(getJSONString(0, "ok", map));
    }

}
