public class UseLecturer {
    /**
     * Script to use Lecturer and its two methods.
     */
    public static void main(String[] args){
        Lecturer myLecturer = new Lecturer("Mrs Mellor");
        System.out.println("My lecturer is " + myLecturer.getName() + " and is: ");
        myLecturer.teach("Astrophysics");
        myLecturer.doResearch("Black holes");
    }
}
