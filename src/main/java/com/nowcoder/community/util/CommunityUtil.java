package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

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

}
