import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmailNotValid {
        Scanner eingbe = new Scanner(System.in);
        //String email = eingbe.nextLine();
        String email = "abc@gg.de";

        if(
                ! istStringNull(email) &&
                ! enthaeltLeerzeichen(email) &&
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

    private static boolean enthaeltDomain(String email) throws EmailNotValid{
        String[] domains = {".de", ".com"};
        for(String domain : domains){
            if (email.endsWith(domain))
                return true;
        }
        throw new EmailNotValid("ERROR: Keine Domain");
    }

    private static int zeichenVorAt(String email) throws EmailNotValid{
        if (email.split("@")[0].length() <= 2)
            throw new EmailNotValid("ERROR: Zu wenige Zeichen vor dem @");
        return email.split("@")[0].length();
    }

    private static int zeichenNachAT(String email) throws EmailNotValid{
        String[] splitAt = email.split("@");
        String stringNachAt = splitAt[splitAt.length - 1].split("\\.")[0];
        if (stringNachAt.length() < 2)
            throw new EmailNotValid("ERROR: Zu wenige Zeichen nach dem @");
        return stringNachAt.length();
    }

    private static boolean entaehltAt(String email) throws EmailNotValid{
        if (email.contains("@"))
            return true;
        throw new EmailNotValid("ERROR: Kein @ Zeichen");
    }

    private static boolean enthaeltLeerzeichen(String email) throws EmailNotValid{
        if (email.contains(" "))
            throw new EmailNotValid("ERROR: Darf keine ' ' Zeichen Enthalten");
        return false;
    }
}


