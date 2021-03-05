package Controllers;

import java.security.*;
import java.math.*;

public class AccountController {

    public String TextToMD5(String s) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger(1,m.digest()).toString(16);
    }

    public Boolean CheckPassword(String pw, String UserNickname){
        Boolean r = false;

        try {
            // TODO: Get user password from file/db
            if("94f9eb627104fc845739ee95880053c6".equals(TextToMD5(pw))){
                r = true;
            }
        } catch (Exception e) {
            return false;
        }
        return r;
    }
}
