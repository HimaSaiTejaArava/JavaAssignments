package Assignment5.data.data;

public class Data {

    int member1;
    char member2;

    public Data() {
    }

    /**
     * prints the member variables
     */
    public void printDefaultClassVariables(){
        System.out.println(member1); // initialised with 0
        System.out.println(member2); // initialised with ''
    }

    public void printDefaultLocalVariables(){
        int intVar;
        char charVar;

		/*There is no default value for local variables.
         We need to initialize local variables before using them.
        */
//		System.out.println(intVar);
//		System.out.println(charVar);
    }
}
