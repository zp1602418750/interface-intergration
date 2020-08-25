package com.tiza.dcms.inf.utils.dflzm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 第三方需要加密方式
     * */
    public static String GetMd5Value(String strText) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            digest = md5.digest(strText.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //10转成16进制
        return toHexString(digest);

    }

    public static String getMD5(String value) {
        byte[] sign = null;
        String result="";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            sign = md5.digest(value.getBytes("UTF-8"));
            result=new String(sign,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //10转成16进制
        return result;
    }



    public static String GetSignValue(String data,String key) {
        //私钥 api_sercet  (customerID+apikey生成MD5串)
        String value = data+key;
        byte[] sign = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            sign = md5.digest(value.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //10转成16进制
        return toHexString(sign);
    }

    /**
     *  10转成16进制
     * */
    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        //10转成16进制
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex).toString().toUpperCase();
        }
        return sb.toString();
    }

    /**
     * md5 32位大写*/
    public static String encrypt32(String encryptStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(encryptStr.getBytes("UTF-8"));
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16){
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            encryptStr = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptStr.toUpperCase();
    }

    /**
     * md5 16位大写*/
    public static String encrypt16(String encryptStr) {
        String substring = encrypt32(encryptStr).substring(8, 24);
        return substring;
    }

}
