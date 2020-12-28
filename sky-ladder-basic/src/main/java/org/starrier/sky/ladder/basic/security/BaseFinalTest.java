package org.starrier.sky.ladder.basic.security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author starrier
 * @date 2020/12/28
 */
public class BaseFinalTest {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException,
            IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {


        String content = "abcdefg789+-*+="; // 待加密的字符串


        // 加密数据
        byte[] encrypt = AESFinal.encrypt(content);

        byte[] decrypt = AESFinal.decrypt(encrypt);

        // 解密数据
        String decryptAESStr = new String(decrypt, StandardCharsets.UTF_8);
        System.out.println("解密后的数据为：" + decryptAESStr);

        if (content.equals(decryptAESStr)) {
            System.out.println("测试通过！");
        } else {
            System.out.println("测试未通过！");
        }

        String encodeToString = Base64.getEncoder().encodeToString(encrypt);
        System.out.println("encode to String " + encodeToString);
        byte[] bytesFromString = Base64.getDecoder().decode(encodeToString);

        boolean equals = encrypt.equals(bytesFromString);
        System.out.println(equals);

    }
}
