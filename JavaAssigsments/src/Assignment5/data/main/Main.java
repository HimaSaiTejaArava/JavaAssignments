package Assignment5.data.main;
import Assignment5.data.data.Data;
import Assignment5.data.singleton.Singleton;

public class Main {
    /**
     * this main method creates object of first class and calls both the methods in first class
     * calls static method of second class which returns object of second class using the object calls non static method
     * of second class
     * @param args
     */
    public static void main(String args[]){
        Data data = new Data();
        data.printDefaultClassVariables();
        data.printDefaultLocalVariables();
        Singleton singleton = Singleton.staticMethod("Happy");
        singleton.nonStaticMethod();
    }
}
