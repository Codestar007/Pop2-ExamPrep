import java.lang.Math;
import java.util.*;
import java.util.ArrayList;

/**
 *
 */
public class PrimeDivisorList {
    MyArrayList PdList;

    /**
     * ConstructorExamples.Constructor
     */
    public PrimeDivisorList() {
        // this.num = num;
        PdList = new MyArrayList();
        this.PdList = PdList;
    }
    /**
     * Starting point of the program
     * @param args none
     */
    public static void main(String...args) {
        // TODO
        PrimeDivisorList pd = new PrimeDivisorList();
        int num;
        Scanner keyboard = new Scanner(System.in);

        do{
            System.out.print("Enter a number: ");
            num = keyboard.nextInt();
            try {
                pd.add(num );
            } catch (Exception e) {
                System.out.println("Your number is either null or not a prime divisor");
                e.printStackTrace();
            }
        }while (num  <= 6);
        System.out.println("this is the result: " + pd.PdList.toString());
    }

    /**
     * adds valid prime divisor to a list
     *
     * @param x input number from user
     * @return x input number from user
     * @throws Exception
     */
    public Integer add(Integer x) throws Exception {
        if (x.equals(null)){
            throw new NullPointerException();
        }
        else if (isNotPrime(x)){
            throw new IllegalArgumentException();
        }
        PdList.add(x);
            return x;
    }

    /**
     * checks if a number is not prime
     * @param x x input number from user
     * @return true if number is not prime, otherwise false
     */
    public boolean isNotPrime(int x){
        for (int i = 2; i <= x/2; i++){
            if(x % i==0){
                return true; // if it is not a prime number
            }
        }
        return false;
    }

    public class MyArrayList extends ArrayList {
        private static final long serialVersionUID = 1L;
        /**
         * Overrides toString method
         * @return
         */
        @Override
        public  String toString(){
            HashSet mySet = new HashSet(); // to hold a list of numbers in the PdList
            int x = 1;
            for (Object o : PdList) {
                mySet.add(o);
            }
            for (Object elem : mySet){
                int freq = Collections.frequency(PdList, elem);
                int sqrP = (int)Math.pow((int)(elem), freq);
                x = (int)(x * sqrP);
            }
            return String.valueOf(x);
        }
    }
}

