package Assignment5.data.singleton;

public class Singleton {
    String str;

    /**
     * this method creates an object for Singleton class and returns it
     * @param input
     * @return st
     */
    public static Singleton staticMethod(String input){
        //cannot access a non-static variable from a static method without an instance

        Singleton singleton = new Singleton();
        singleton.str = input;
        return singleton;
    }

    /**
     * prints the global variable
     */
    public void nonStaticMethod(){
        System.out.println(str);
    }
}
