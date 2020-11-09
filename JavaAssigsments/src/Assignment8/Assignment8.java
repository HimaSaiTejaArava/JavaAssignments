package Assignment8;

import java.util.Scanner;

public class Assignment8 {

    public static void input() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PIN");

        try {
            InvalidInputException iie = new InvalidInputException();
            iie.throwExceptions(sc.nextInt());
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }
}

class WrongInputException extends Exception {
    @Override
    public String getMessage() {
        return "Input must be Four Digits";
    }
}

class InputOverloadException extends Exception {
    @Override
    public String getMessage() {
        return "Input is more than Four Digits";
    }
}

class RandomException extends Exception {
    @Override
    public String getMessage() {
        return "Something went wrong, Please Try Again";
    }
}

class InvalidInputException {

    void throwExceptions(int pin) throws WrongInputException, InputOverloadException, RandomException {
        if (pin  < 1000)
            throw new WrongInputException();
        else if (pin > 9999)
            throw new InputOverloadException();
        else
            throw new RandomException();
    }
}
