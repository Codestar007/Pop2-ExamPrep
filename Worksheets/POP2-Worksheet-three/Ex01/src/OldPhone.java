public class OldPhone implements Phone{

    public static void main(String[] args) {
        OldPhone newPhone = new OldPhone();
        newPhone.call("0207 999 9999");
    }

    public void call(String number){
        System.out.println("Calling " + number);
    }
}
