package org.starrier.sky.ladder.basic.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author starrier
 * @date 2020/12/28
 */
public class Base64Util {

    /***
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /***
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encode(key);
    }


}
