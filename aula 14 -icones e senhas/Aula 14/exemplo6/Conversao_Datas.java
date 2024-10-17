package exemplo6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Conversao_Datas {
    public static void main(String[] args) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat df = DateFormat.getDateInstance();
        System.out.println("Data : " + df.format(data));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data formatada: " + sdf.format(data));

        System.out.println("Data convertida: " + sdf.parse("28/02/2013"));
        
    }
}
