import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex3 {


    public static void main (String[] args) {
        String challenge1 = "I want a bike";
        System.out.println(challenge1.matches(".+"));

        String challenge2 = "I want a ball";
        //String regex = "I want a (bike|ball)";
        //System.out.println(challenge1.matches(regex));
        //System.out.println(challenge2.matches(regex));


        //regex = "I want a \\w+.";
        //Pattern p = Pattern.compile(regex);
        //Matcher m = p.matcher(challenge1);
        //System.out.println(m.matches());

        String challenge4 = "replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccdddefffg";
        //String regex = "a{3}b{1}c{4}d{3}e{1}f{3}g{1}";
        //System.out.println(challenge5.matches(regex));

        String challenge6 = "abcd.135";
        //String regex = "^\\w+[\\.]\\d+$";
        //System.out.println(challenge6.matches(regex));

        String challenge7 = "avcd.135uvqz.7tzik.999";
        //String regex = "\\d+";
        //Pattern p = Pattern.compile(regex);
        //Matcher m = p.matcher(challenge7);

        //while (m.find()) {
          //  System.out.println(m.group(0));
        //}

        String challenge8 = "abcd.135\tuvqz.7\ttzik.999\n";
        //String regex = "\\d+";
        //Pattern p = Pattern.compile(regex);
        //Matcher m = p.matcher(challenge8);
        //while (m.find()) {
          //  System.out.println(m.start(0));
            //System.out.println(m.end(0));
            //System.out.println(m.group(0));
        //}

        String challenge9 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String regex = "\\{(\\d\\,\\s\\d)\\}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(challenge9);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }



}
