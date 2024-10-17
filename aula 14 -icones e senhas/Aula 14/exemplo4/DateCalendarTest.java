package exemplo4;

import java.util.Calendar;

public class DateCalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("Data e Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));

        c.set(Calendar.YEAR, 1963);
        c.set(Calendar.MONTH, Calendar.MARCH);
        c.set(Calendar.DAY_OF_MONTH, 8);
        System.out.println("Data e Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
    
        c = Calendar.getInstance();
        System.out.println("Data e Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + (c.get(Calendar.MONTH) + 1));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        int hora = c.get(Calendar.HOUR_OF_DAY);
        if(hora > 6 && hora < 12){
            System.out.println("Bom dia!");
        }else if(hora > 12 && hora < 18){    
            System.out.println("Boa tarde!");
        } else {
            System.out.println("Boa noite!");
        }
    }
}
