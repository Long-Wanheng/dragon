package com.dragon.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 16:58
 */
public class DigestUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DigestUtils.class);

    public static String getMessageDigest(byte[] buffer, String key) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(key);
            digest.reset();
            digest.update(buffer);
            return bytes2Hex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("获取md5算法异常:{}",e);
        }
        return null;
    }

    public static String bytes2Hex(byte[] bts) {
        StringBuilder des = new StringBuilder("");
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des.append("0");
            }
            des.append(tmp);
        }
        return des.toString();
    }

    public static String getMD5(byte[] buffer) {
        return getMessageDigest(buffer, "MD5");
    }

    public static String getMD5(String str) {
        try {
            return getMD5(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("获取md5值失败 {}",e);
        }
        return null;
    }
}
