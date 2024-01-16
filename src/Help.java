import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class Help {
    public static String convertDateToString(Date date) { //C'est pour convertir notre date vers le format souhaitée dans l'exercice, tout en l'encapsulant dans un String.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public static String convertToStringAnfRespoctSpaces(int number, int maximalLength) {
        int numberLength = new Integer(number).toString().length();
        char[] spacesToAdd = new char[maximalLength - numberLength];
        Arrays.fill(spacesToAdd, ' ');
        return "" + number + new String(spacesToAdd);
    }
}