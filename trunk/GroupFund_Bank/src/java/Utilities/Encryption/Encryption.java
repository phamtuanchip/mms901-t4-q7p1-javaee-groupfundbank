/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author binhnx218
 */
//Encrypt: GroupID_UserID(16 char)_Password(64 char)
//Result:   iv_encrypted

public class Encryption {
    public String init() throws NoSuchAlgorithmException
    {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        return getHexString(raw);
    }
    
    public String[] encrypt(String keyStr, String inputStr) throws UnsupportedEncodingException, NoSuchAlgorithmException, 
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        byte[] raw = getBytes(keyStr);
        byte[] input = inputStr.getBytes("UTF-8");
        SecretKeySpec key = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] IV = cipher.getIV (); 
        byte[] encrypted = cipher.doFinal(input);
        String iv = getHexString(IV);
        String encryptedStr = getHexString(encrypted);
        return new String[] {
            iv, encryptedStr
        };
    }
    public String decrypt(String encryptedStr, String keyStr, String iv) 
            throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, 
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException
    {
        byte[] raw = getBytes(keyStr);
        byte[] IV = getBytes(iv);
        byte[] encrypted = getBytes(encryptedStr);
        SecretKeySpec key = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV));
        String decrypted = new String(cipher.doFinal(encrypted));
        return decrypted;
    }
    
    private String getHexString(byte[] bytes)
    {
        Hash hash = new Hash();
        return hash.getHexString(bytes);
    }
    
    private byte[] getBytes(String str)
    {
        int len = str.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) 
        {
            data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
                                 + Character.digit(str.charAt(i+1), 16));
        }
        return data;
    }
}
