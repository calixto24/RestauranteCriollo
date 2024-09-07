package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean isRequired(String str) {
        return !str.equals("");
    }
    
    public static boolean isInt(String str) {
        try {
            
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean minLength( String str , int min){
       return str.length()>min;
   
    }
    
    public static boolean maxLength(String str, int max){
       return str.length()<max; 
    }
    
    public static boolean equalsLength(String str, int equals){
       return str.length()==equals; 
    }
    
    public static boolean isEmail(String str) {
        String regex = "^[a-z0-9.-_]+@[a-z0-9.-]+\\.[a-z]{2,}$";
        
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        
        return matcher.matches();
    }
    
    public static boolean isDate(String str) {
        String regex = "^(0[1-9]|[1-9]|[12][0-9]|3[01])/(0[1-9]|[1-9]|1[0-2])/[0-9]{4}$"; // 01/05/2004
        
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        
        return matcher.matches();
    }
}
