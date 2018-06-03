package Mock_Practical.worksheet;

/**
 * Created by kjeged01 on 03/06/2018.
 */

    /*
    Option 1
    */
    public class IsReverse {
        public static boolean isReverse(String s1 , String s2 ){
            if(s1.length() == 0 && s2.length() == 0){
                return true;
            }else if(s1.length() == 0 || s2.length() == 0){
                return false; // not same length
            }else {
                String s1first = s1.substring(0, 1);
                String s2last = s1.substring(s2.length() - 1);
                return s1first.equalsIgnoreCase(s2last) &&
                        isReverse(s1.substring(1),
                                s2.substring(0, s2.length()-1));
            }
        }


    /*
Option 1
*/
    public static boolean isReverseTwo(String s1 , String s2 ){
        if(s1.length() != s2.length()){
            return false; // not same length
        }else if(s1.length() == 0 && s2.length() == 0){
            return true;
        }else {
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            return s1.charAt(0) == s2.charAt(s2.length()-1) &&
            isReverseTwo(s1.substring(1, s1.length()),
                    s2.substring(0, s2.length() - 1));
        }
    }
    /*
    Option 4
    */
    public static boolean isReverseFour(String s1 , String s2 ){
        return reverse(s1.toLowerCase()).equals(s2.toLowerCase()) ;
    }

    private static String reverse(String s){
        if (s.length()== 0){
            return s;
        }else{
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

}
