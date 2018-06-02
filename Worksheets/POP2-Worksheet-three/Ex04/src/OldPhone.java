public class OldPhone implements Phone{

    private String brand = null;
    public OldPhone(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    //

    public static void main(String[] args) {
        OldPhone newPhone = new OldPhone("Nokia");
        newPhone.call("0207 999 9999");
    }

    public void call(String number){
        System.out.println("Calling " + number);
    }
}
