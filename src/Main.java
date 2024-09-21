import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //variabelen:
        boolean play = true;
        String ongeldig = "ongeldige invoer";
        //arrays:
        Integer[] numeric = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};
        //objecten:
        Translator translator = new Translator(alphabetic, numeric);
        Scanner scanner = new Scanner(System.in);
        //programma:
            //start loop
        while (play == true) {
            System.out.println("Type 'x' om te stoppen en type 'v' om te vertalen.");
            //input:
            String input = scanner.nextLine();
            //als x stop
            if (input.equals("x")) {
                play = false;
                //als v input cijfer
            } else if (input.equals("v")) {
                System.out.println("Type een cijfer in van 0 t/m 9");
                //input
                int number = scanner.nextInt();
                scanner.nextLine();
                //als 0-9 dan vertaal:
                if (number < 10) {
                    String result = translator.Translate(number);
                    System.out.println("De vertaling van " + number + " is " + result + ".");
                } else { //anders ongeldig
                    System.out.println(ongeldig);
                }
            } else { //geen x of v is ongeldig
                System.out.println(ongeldig);
            }
        }
    }
}


class Translator {
    HashMap<Integer, String> numericAlpha = new HashMap<>();

    public Translator(String[] alphabetic, Integer[] numeric) {

        for (int i = 0; i < alphabetic.length; i++) {
            numericAlpha.put(numeric[i], alphabetic[i]);

        }
    }

    public String Translate(Integer number) {
        return numericAlpha.get(number);

    }

}

