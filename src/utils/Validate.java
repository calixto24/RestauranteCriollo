package utils;

public class Validate {
    public static boolean isRequired(String str) {
        return !str.equals("");
    }
    
    public static boolean isInt(String str) {
        try {
            
            Integer.parseInt(str); //abc
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
}
