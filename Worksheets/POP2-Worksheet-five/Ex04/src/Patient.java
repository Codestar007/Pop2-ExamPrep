import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 4 More patients
 Write a class that asks for data (name and year of birth)
 about new patients in a hospital and keeps them in a list of Patient.
 The constructor of Patient must throw an IllegalArgumentException
 if the age of the patient is negative or greater than 130.
 */
public class Patient {
    private int age;
    private String name;
    private String[] patientsList = new String[10];
    private Integer counter = 0;

    public Patient(){
        // TODO
    }
    public Patient(int pAge, String pName) throws IllegalArgumentException {
            if (pAge > 130 || pAge < 0) {
                throw new IllegalArgumentException("Too young or too old!!");
            }
            else{
                age = pAge;
                name = pName;
                patientsList[counter] = (pName + ", " + pAge);
                counter++;
            }
        }

    public static void main(String[] args) {
        Patient p = new Patient();
        Integer myAge = p.patientAge();
        String myName = p.myGetName();
        try {
            Patient newPatient = new Patient(myAge, myName);
        }
        catch (IllegalArgumentException ex){
            System.out.println("Too young or too old!!");
        }
    }

    public String myGetName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter Your name: ");
        String myName = keyboard.nextLine();
        return myName;
    }

    public Integer patientAge(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter Your age: ");
        Integer myEntry = keyboard.nextInt();
        return myEntry;
    }
}
