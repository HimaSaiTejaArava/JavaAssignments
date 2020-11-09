package Assignment11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment11 {

    public static void input() throws IOException {

        String path = "/home/himasait/";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter FileName : ");
        String fileName = sc.next();
        path = path + fileName;
        File file = new File(path);
        Scanner scFile = new Scanner(file);
        Map<Character, Integer> charsMap = new HashMap<Character, Integer>();
        String line;

        while (scFile.hasNextLine()) {
            line = scFile.nextLine();
            countCharacters(file, charsMap, line);

        }
    }

    static void countCharacters(File file , Map<Character, Integer> charsMap , String line) throws IOException {


        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                if (charsMap.containsKey(line.charAt(i)))
                    charsMap.put(line.charAt(i), charsMap.get(line.charAt(i)) + 1);
                else
                    charsMap.put(line.charAt(i), 1);
            }
        }

        FileWriter fileWriter = new FileWriter("/home/himasait/charsCount.txt");
        fileWriter.write(charsMap.toString());
        fileWriter.close();
    }
}