package exemplo7;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Locale_Datas {
    public static void main(String[] args) throws ParseException{
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        Locale brasil = new Locale("pt", "BR");
        Locale eua = Locale.US;
        Locale italia = Locale.ITALY;

        DateFormat fb = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println("Data e hora brasileira: " + fb.format(data));
        DateFormat sb = DateFormat.getDateInstance(DateFormat.SHORT, brasil);
        System.out.println("Data e hora brasileira resumida: " + sb.format(data));
        

        DateFormat fe = DateFormat.getDateInstance(DateFormat.FULL, eua);
        System.out.println("Data e hora americana: " + fe.format(data));
        DateFormat se = DateFormat.getDateInstance(DateFormat.SHORT, eua);
        System.out.println("Data e horav americana resumida: " + se.format(data));



        DateFormat fi = DateFormat.getDateInstance(DateFormat.FULL, italia);
        System.out.println("Data e hora italiana: " + fi.format(data));
        DateFormat si = DateFormat.getDateInstance(DateFormat.SHORT, italia);
        System.out.println("Data e hora italiana resumida: " + si.format(data));

    }
}
