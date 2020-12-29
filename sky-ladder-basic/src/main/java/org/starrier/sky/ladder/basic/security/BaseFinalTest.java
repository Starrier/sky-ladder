package org.starrier.sky.ladder.basic.security;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author starrier
 * @date 2020/12/28
 */
public class BaseFinalTest {

    public static void main(String[] args) throws Exception {


        String content = "abcdefg789+-*+="; // 待加密的字符串


        // 加密数据
        byte[] encrypt = AESFinal.encrypt(content);
        String encryptDataHex = Hex.encodeHexString(encrypt);   //把密文转为16进制
        System.out.println("将密文转换为 String " + encryptDataHex);


        byte[] bytes = Hex.decodeHex(encryptDataHex.toCharArray());
        byte[] decrypt = AESFinal.decrypt(bytes);
        String string = new String(decrypt);
        System.out.println("string 转化为 解密后的原始数据 " + string);


        // 解密数据
        String decryptAESStr = new String(decrypt, StandardCharsets.UTF_8);
        System.out.println("解密后的数据为：" + decryptAESStr);

        if (content.equals(decryptAESStr)) {
            System.out.println("测试通过！");
        } else {
            System.out.println("测试未通过！");
        }

    }
}
