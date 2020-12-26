package org.starrier.sky.ladder.common.basic.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author starrier
 * @date 2020/12/24
 */
public class Base64Util {

    /***
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryBASE64(String key) throws Exception{
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /***
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception{
        return (new BASE64Encoder()).encode(key);
    }

    public static void main(String[] args) throws Exception {
        String targetSource = "Sky-ladder";

        String encryptBASE64 = encryptBASE64(targetSource.getBytes());
        System.out.println(encryptBASE64);

        byte[] decryBASE64 = decryBASE64(encryptBASE64);

        System.out.println(decryBASE64);

    }

}
