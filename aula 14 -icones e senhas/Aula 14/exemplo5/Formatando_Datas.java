package exemplo5;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public class Formatando_Datas {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2013, Calendar.FEBRUARY, 28);
        Date data = c.getTime();
        System.out.println("Data: " + data);

        DateFormat df = DateFormat.getDateInstance();
        System.out.println("Data formatada: " + df.format(data));

        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("Hora formatada: " + hora.format(data));

        DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println("Data e Hora formatada: " + dtHora.format(data));
    }
}

