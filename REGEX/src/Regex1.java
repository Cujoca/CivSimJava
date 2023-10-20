public class Regex1 {

    public static void main (String[] args) {
        String example = "Now this is a bruh moment";
        System.out.println(example.matches("^[^\\d].*"));
        System.out.println(example.replaceAll("[nN].*", " Get Fucked N "));
        System.out.println(example.replaceAll("[nN][oO]+", " Get Fucked N "));
        example = "skiing is interestingly an increasingly interesting activity";
        System.out.println(example.replaceAll("(?<!i)[i]", "I"));
        System.out.println(example.replaceAll("[i]?", "I"));
        example = "skiing is interestingly an increasingly interesting skiing activity";
        System.out.println(example.replaceAll("^skiing", "dirtbiking"));













    }





}
