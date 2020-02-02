import java.util.Random;
import java.util.Scanner;

/**
 * Created by Silvre on 2020-02-01.
 */
public class KoreanNumbers {
    private static String[] numbers = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
    private static String TEN = "십";
    private static String HUNDRED = "백";
    private static String THOUSAND = "천";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        String input;
        int value, combo = 0;
        do {
            value = r.nextInt(9999) + 1;
            System.out.print(value + " -> ");
            input = s.nextLine();
            if(input.equals("exit")) System.exit(0);
            if(matches(value, input)) {
                System.out.println("Nice! " + ++combo + "x");
            }
            else {
                System.out.println("Incorrect.  Try again.");
                combo = 0;
            }
        } while(true);
    }


    private static boolean matches(int num, String input) {
       String number = "";
       number += numbers[num % 10];
       num /= 10;
       System.out.println(number);
       if(num == 0) return number.equals(input);
       if(num % 10 != 0) {
          number = TEN + number;
          number = numbers[num % 10] + number;
       }
       num /= 10;
       System.out.println(number);
       if(num == 0) return (number.substring(0, 1).equals("일") ? number.substring(1) : number).equals(input);
       if(num % 10 != 0) {
           number = HUNDRED + number;
           number = numbers[num % 10] + number;
       }
       num /= 10;
       System.out.println(number);
       if(num == 0) return (number.substring(0, 1).equals("일") ? number.substring(1) : number).equals(input);
       if(num % 10 != 0) {
           number = THOUSAND + number;
           number = numbers[num % 10] + number;
       }
       System.out.println(number);
       return (number.substring(0, 1).equals("일") ? number.substring(1) : number).equals(input);
    }
}
