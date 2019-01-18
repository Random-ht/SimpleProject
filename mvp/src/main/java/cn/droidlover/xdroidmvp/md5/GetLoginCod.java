package cn.droidlover.xdroidmvp.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by gxjkz on 2018/1/3.
 */

public class GetLoginCod {

    public static final String secret = "affheb5edfsqgrewe11ejmw3plx"; //密钥

    public static String getlogincod(String value) {

        String jiami = secret + value + secret;
//        Log.i("--------", "00-0-");
        return MD5Util.getStringMD5(jiami);

    }


    public static String getMd5(String inStr) {
        String outStr = null;
        if (inStr == null) {
            outStr = null;
        } else if ("".equals(inStr)) {
            outStr = "";
        } else {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(inStr.getBytes());
                byte b[] = md.digest();
                StringBuffer buf = new StringBuffer();
                for (int i = 1; i < b.length; i++) {
                    int c = b[i] >>> 4 & 0xf;
                    buf.append(Integer.toHexString(c));
                    c = b[i] & 0xf;
                    buf.append(Integer.toHexString(c));
                }
                outStr = buf.toString();
            } catch (NoSuchAlgorithmException e) {

                e.printStackTrace();
            }
        }
        return outStr;
    }
}
