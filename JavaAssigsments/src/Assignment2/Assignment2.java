package Assignment2;

import java.util.HashMap;
import java.util.Scanner;

public class Assignment2 {

    public void isAll26(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        String lowerAlphas = "abcdefghijklmnopqrstuvwxyz";
        boolean[] boolArr = new boolean[26];

        if(input.length() < 26) {
            System.out.println("No");
            return;
        }

        int i, count = 0;

        for(i = 0; i < input.length(); i++) {
            int visitedIndex = lowerAlphas.indexOf(input.charAt(i));
            if(visitedIndex != -1) {
                if(boolArr[visitedIndex] != true) {
                    boolArr[visitedIndex] = true;
                    count++;
                }
            }
        }

        if(count < 26 ) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
    }
}
