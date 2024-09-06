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
    
    public static void main(String[] args) {
        boolean isCorrect = isInt("asd");
        
        System.out.println((isCorrect ? "Correcto" : "incorrecto"));
    }
}
