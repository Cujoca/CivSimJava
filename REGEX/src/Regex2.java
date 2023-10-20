import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {


    public static void giveWords (String thing) {
        String regex = "\\b\\S+\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(thing);
        while (m.find()) {
            System.out.println(m.group(0));
        }
    }

    public static boolean analyzeSentence() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = scan1.nextLine();

        if (username.matches("[sf][hu][ic][tk]")) {
            System.out.println("please choose another username");
            analyzeSentence();
        } else {
            System.out.println("username accepted");
            return true;
        }
        return false;
    }


    public static boolean analyzeEmail() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("enter email");
        String email = scan1.nextLine();

        if (email.matches("^\\w+[@]\\w+[\\.][c][o][m]")) {
            System.out.println("valid");
            return true;
        }
        System.out.println("not valid");
        return false;


    }



    public static void main (String[] args) {
        String thing = "Now this is a certified bruh moment";
        giveWords(thing);
        //analyzeSentence();
        analyzeEmail();
    }

}
