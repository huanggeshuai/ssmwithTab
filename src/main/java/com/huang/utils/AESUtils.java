package com.huang.utils;

import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

/**
 * @author huang
 * @Classname AESUtils
 * @Description aes加密算法 ecb模式
 * @Date 2019/7/8 21:15
 * @Created by huang
 */
public class AESUtils {
    /**
     * 密钥
     */
    private static final String KEY = "1234567890123456";// AES加密要求key必须要128个比特位（这里需要长度为16，否则会报错）

    /**
     * 算法
     */
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * 偏移量
     */
    private static final String OFFSET = "ABCDEFGHIJKLMNOP";

    /** 算法名称 */
    private static final String KEY_ALGORITHM = "AES";

    /** 密钥长度 支持128 192 256 */
    private static final Integer KEY_LENGTH = 128;

    final static char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','m','n','p','Q','r','s','t','u','v','w','x','y','z',
            '2','3','4','5','6','7','8','9'};



    /**
     * AES加密
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
        kgen.init(KEY_LENGTH);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), KEY_ALGORITHM));

        return cipher.doFinal(content.getBytes("utf-8"));
    }


    /**
     * AES加密为base 64 code
     *
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return Base64Utils.encryptBASE64(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES解密
     *
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey 解密密钥
     * @return 解密后的String
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
        kgen.init(KEY_LENGTH);

        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes("utf-8"), KEY_ALGORITHM));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }


    /**
     * 将base 64 code AES解密
     *
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(Base64Utils.decryptBASE64(encryptStr), decryptKey);
    }


    public static String initAesKey(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(arr[ random.nextInt(arr.length) ]);
        }
        random = null;
        return stringBuilder.toString();
    }


    public static void main(String[] args) throws Exception {
        String content = "huanggeshuai666";
        System.out.println("加密前：" + content);
        String key = "u2KWABsbsGAzuyh7";
        System.out.println("加密密钥和解密密钥：" + key);

        String encrypt = aesEncrypt(content, key);
        System.out.println("加密后：" + encrypt);

        String decrypt = aesDecrypt(encrypt, key);

        System.out.println("解密后：" + decrypt);
        System.out.println(initAesKey());
    }

}
