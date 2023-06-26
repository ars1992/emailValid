import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmailNotValid {
        Scanner eingbe = new Scanner(System.in);
        //String email = eingbe.nextLine();
        String email = "";

        if(
                !istStringNull(email) &&
                !enthaeltLeerzeichen(email) &&
                entaehltAt(email) &&
                enthaeltDomain(email) &&
                zeichenNachAT(email) >= 2 &&
                zeichenVorAt(email) >= 3
        ){
            System.out.println("ok");
        } else System.out.println("nicht ok");
    }

    private static boolean istStringNull(String email) throws EmailNotValid{
        if(email == null || email.isBlank())
            throw new EmailNotValid("ERROR: email ist leer");
        return false;
    }

    private static boolean enthaeltDomain(String email){
        String[] domains = {".de", ".com"};
        for(String domain : domains){
            if (email.endsWith(domain))
                return true;
        }
        return false;
    }

    private static int zeichenVorAt(String email){
        return email.split("@")[0].length();
    }

    private static int zeichenNachAT(String email){
        String[] splitAt = email.split("@");
        String stringNachAt = splitAt[splitAt.length - 1].split("\\.")[0];
        return stringNachAt.length();
    }

    private static boolean entaehltAt(String email){
        return email.contains("@");
    }

    private static boolean enthaeltLeerzeichen(String email){
        return email.contains(" ");
    }
}


