package Assignment4;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

public class Assignment4 {

    public void giveInputs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give No of Dates");
        int datesCount = sc.nextInt();

        for(int i = 0; i < datesCount; i++){
            System.out.println("Give Signed Date (dd-mm-yyyy)");
            String signedDate = sc.next();
            System.out.println("Give Current Date (dd-mm-yyyy)");
            String currentDate = sc.next();
            findRange(signedDate, currentDate);
        }
    }

    public void findRange(String signedDate, String currentDate){

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate signed = LocalDate.parse(signedDate, dateFormatter);
        LocalDate current = LocalDate.parse(currentDate, dateFormatter);

        if(signed.plusYears(1).minusDays(30).isAfter(current)){
            System.out.println("No Range");
            return;
        }

        LocalDate anniversary = LocalDate.of(current.getYear(), signed.getMonth(), signed.getDayOfMonth());

        LocalDate startRange = anniversary.minusDays(30);
        LocalDate endRange = anniversary.plusDays(30);

        if(current.isBefore(endRange)){
            endRange = current;
        }

        System.out.println(signedDate + "," + currentDate);
        System.out.println(formatDate(startRange) + " " + formatDate(endRange));
    }

    private String formatDate(LocalDate localDate){
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
