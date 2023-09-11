import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task {
    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter begining year");
        String input1 = scan.nextLine();
        System.out.println("Enter last year");
        String input2 = scan.nextLine();
        
        //putting given years in to right argumets position
        int y1 = Integer.parseInt(input1);
        int y2 = Integer.parseInt(input2);
        
        if (y1<=y2){
             printBonusDatesBetween(y1, y2);
        }else if (y1>y2){
            printBonusDatesBetween(y2, y1);
        }else{
            System.out.println("Your entered wrong data.");
        }
        scan.close();
    }
  
    public static void printBonusDatesBetween(int fromYear, int toYear){
       
        //creating date format to check against. Will be needed to check validity of date.
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int x = fromYear; x <= toYear; x++){
            //converting years to string
            String year= Integer.toString(x);

            //formatting only one possible date
            String newDate = year+ "-" + year.charAt(3) + year.charAt(2) + "-" + year.charAt(1) + year.charAt(0);

            //checking if date is valid
            try {
                LocalDate.parse(newDate, dateFormat);
                System.out.println(newDate);
            } catch (DateTimeParseException e) {
                continue;
            }
        }
    }    
}

/*
        Short TASK explanation
        
        because year is 4 digits and mounth+day also 4 digits, digits taken from year could generate only one date, which will be the same from both sides. So algorithm is:
        1. converting years to srting;
        2. adding to the string reversed/coresponding characters as month and day;
        3. checking if newly created date is valid;
            TRUE - printing date
            FALSE - skipping date
        4. going to next year;
        */