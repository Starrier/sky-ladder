package org.starrier.sky.ladder.common.basic.security;

import java.security.MessageDigest;

/**
 * @author starrier
 * @date 2020/12/24
 */
public class MD5Util {

    public static final String KEY_MD5 = "MD5";

    /***
     * MD5加密（生成唯一的MD5值）
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        return md5.digest();
    }


}
