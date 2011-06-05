/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author binhnx218
 */
public class Hash {

    public String MD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes("UTF-8"));
        byte[] thedigest = md.digest();
        md.reset();
        return getHexStringFromBytes(thedigest);
    }
    
    public String SHA256(String str)throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes("UTF-8"));
        byte[] thedigest = md.digest();
        md.reset();
        return getHexStringFromBytes(thedigest);
    }
    
    public String getHexString(byte[] bytes)
    {
        return getHexStringFromBytes(bytes);
    }
    
    private String getHexStringFromBytes(byte[] bytes)
    {
        StringBuilder strbuf = new StringBuilder(bytes.length * 2);
        for (int buf : bytes) 
        {
            if ((buf & 0xff) < 0x10)
                strbuf.append("0");
            strbuf.append(Long.toString(buf & 0xff, 16));
        }
        return strbuf.toString();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
        // <editor-fold defaultstate="collapsed" desc="From Stackoverflow  http://stackoverflow.com/questions/415953/generate-md5-hash-in-java">
    /*
     * The MessageDigest class can provide you with an instance of the Hash digest.
     * Always when working with Strings and the crypto classes be sure to always specify the encoding you want the byte representation in.
     * If you just us string.getBytes() it will use the platform default. (Not all platforms use the same defaults)
     * 
    import java.security.*;

    ..

    byte[] bytesOfMessage = yourString.getBytes("UTF-8");

    MessageDigest md = MessageDigest.getInstance("Hash");
    byte[] thedigest = md.digest(bytesOfMessage);
     * 
     * If you have a lot of data take a look at the .update(byte[]) method which can be called repeatedly.
     * Then call .digest() to obtain the resulting hash.
     */
    // </editor-fold>
}
