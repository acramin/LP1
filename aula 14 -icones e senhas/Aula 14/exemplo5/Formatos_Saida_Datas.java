package exemplo5;

import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;

public class Formatos_Saida_Datas {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data brasileira: " + df.format(data));
        df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("Data sem o dia descrito: " + df.format(data));
        df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Data resumida 1: " + df.format(data));
        df = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data resumida 2: " + df.format(data));
    }
}
