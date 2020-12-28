package org.starrier.sky.ladder.basic.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static org.starrier.sky.ladder.basic.security.AES3Utils.encryptAES;
import static org.starrier.sky.ladder.basic.security.AES3Utils.getStrKeyAES;
import static org.starrier.sky.ladder.basic.security.AES3Utils.strKey2SecretKey;

/**
 * @author starrier
 * @date 2020/12/28
 */
public class RSAUtil {

    /**
     * 生成密钥对：密钥对中包含公钥和私钥
     *
     * @return 包含 RSA 公钥与私钥的 keyPair
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static KeyPair getKeyPair() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("AES");    // 获得RSA密钥对的生成器实例
        SecureRandom secureRandom = new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes("utf-8")); // 说的一个安全的随机数
        keyPairGenerator.initialize(2048, secureRandom);    // 这里可以是1024、2048 初始化一个密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();   // 获得密钥对
        return keyPair;
    }

    /**
     * 获取公钥 (并进行Base64编码，返回一个 Base64 编码后的字符串)
     *
     * @param keyPair
     * @return 返回一个 Base64 编码后的公钥字符串
     */
    public static String getPublicKey(KeyPair keyPair) {
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 获取私钥(并进行Base64编码，返回一个 Base64 编码后的字符串)
     *
     * @param keyPair
     * @return 返回一个 Base64 编码后的私钥字符串
     */
    public static String getPrivateKey(KeyPair keyPair) {
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 将Base64编码后的公钥转换成 PublicKey 对象
     *
     * @param pubStr
     * @return PublicKey
     */
    public static PublicKey string2PublicKey(String pubStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Base64.getDecoder().decode(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * 将Base64编码后的私钥转换成 PrivateKey 对象
     *
     * @param priStr
     * @return PrivateKey
     */
    public static PrivateKey string2Privatekey(String priStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Base64.getDecoder().decode(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    /**
     * 公钥加密
     *
     * @param content   待加密的内容 byte[]
     * @param publicKey 加密所需的公钥对象 PublicKey
     * @return 加密后的字节数组 byte[]
     */
    public static byte[] publicEncrytype(byte[] content, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    /**
     * 私钥解密
     *
     * @param content    待解密的内容 byte[]
     * @param privateKey 解密需要的私钥对象 PrivateKey
     * @return 解密后的字节数组 byte[]
     */
    public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    public static String encrypt(String encryptOriginalContent) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {

        System.out.println("明文数据为：" + encryptOriginalContent);

        // 获得经 BASE64 处理之后的 AES 密钥
        String strKeyAES = getStrKeyAES();

        System.out.println("经BASE64处理之后的密钥：" + strKeyAES);

        // 将 BASE64 处理之后的 AES 密钥转为 SecretKey
        SecretKey secretKey = strKey2SecretKey(strKeyAES);

        // 加密数据
        byte[] encryptAESbytes = encryptAES(encryptOriginalContent.getBytes(StandardCharsets.UTF_8), secretKey);
        return HexUtils.bytes2Hex(encryptAESbytes);
    }


    public static String decoder(String decoder) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, UnsupportedEncodingException {

        byte[] encryptAESbytes = HexUtils.hex2Bytes(decoder);
        SecretKey secretKey = getSecretKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytes1 = cipher.doFinal(encryptAESbytes);
        return HexUtils.bytes2Hex(bytes1);
    }

    public static SecretKey getSecretKey() throws NoSuchAlgorithmException {
        // 获得经 BASE64 处理之后的 AES 密钥
        String strKeyAES = getStrKeyAES();
        System.out.println("经BASE64处理之后的密钥：" + strKeyAES);

        // 将 BASE64 处理之后的 AES 密钥转为 SecretKey
        return strKey2SecretKey(strKeyAES);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {

        // 待加密数据
        String content = "abcdefg789+-*+=";
        System.out.println(System.currentTimeMillis());
        // 加密数据
        String encodeToString = encrypt(content);
        // 解密数据
        String decryptAESStr = decoder(encodeToString);

        if (content.equals(decryptAESStr)) {
            System.out.println("测试通过！");
        } else {
            System.out.println("测试未通过！");
        }

    }

    public static byte[] parseHexStr2Byte(String hexStr) {

        if (hexStr.length() < 1)

            return null;

        byte[] result = new byte[hexStr.length() / 2];

        for (int i = 0; i < hexStr.length() / 2; i++) {

            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);

            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);

            result[i] = (byte) (high * 16 + low);

        }

        return result;

    }


}
