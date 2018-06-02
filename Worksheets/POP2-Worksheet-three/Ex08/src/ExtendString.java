public class ExtendString extends String{
        public ExtendString(String original) {
                super(original);
        }

        public void printEven(String myString){
                for (int i = 0; i < myString.length();i++) {
                        if(i % 2 == 0){
                                System.out.println(myString.charAt(i));
                        }else{
                                //TODO
                        }
                }
        }

        public static void main(String[]args){
                ExtendString str = new ExtendString("");
                str.printEven("Hey, I am extending String!!");
        }
}