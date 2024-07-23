package utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtils {
    public static void main (String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("truongcongT99"));
    }
}
