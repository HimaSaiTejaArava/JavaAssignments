package Assignment9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Assignment9 {

    public void regexPattern() throws IOException {
        Pattern pattern = Pattern.compile("^[A-Z].*[.]$");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input");
        if (pattern.matcher(bufferedReader.readLine()).find()) {
            System.out.println("The given input started with capital letter and ends with a period.");
            System.exit(0);
        }
        System.out.println("The given statement is invalid");
        System.exit(0);
    }
}