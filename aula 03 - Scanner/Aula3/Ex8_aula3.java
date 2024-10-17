
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex8_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite angulo em graus: ");
        double ang = sc.nextDouble();
        ang = ang*Math.PI/180;

        DecimalFormat df = new DecimalFormat("0.00");

        if(ang == 0 || ang == Math.toRadians(360)){

            double sen = Math.ceil(Math.sin(ang));
            double cos = Math.ceil(Math.cos(ang));
            double tan = Math.ceil(Math.tan(ang));
            double sec = 1/cos;

            System.out.println("Seno: " + sen);
            System.out.println("Cosseno: " + cos);
            System.out.println("Tangente: " + tan);
            System.out.println("Secante: " + sec);

        } else if(ang == Math.toRadians(90)){

            double sen = Math.floor(Math.sin(ang));
            double cos = Math.floor(Math.cos(ang));
            double csc = 1/sen;

            System.out.println("Seno: " + sen);
            System.out.println("Cosseno: " + cos);
            System.out.println("Cossecante: " + csc);

        } else if (ang == Math.toRadians(270)){
            
            double sen = Math.floor(Math.sin(ang));
            double cos = Math.ceil(Math.cos(ang));
            double csc = 1/sen;

            System.out.println("Seno: " + sen);
            System.out.println("Cosseno: " + cos);
            System.out.println("Cossecante: " + csc);

        } else if(ang == Math.toRadians(180)) {

            double sen = Math.floor(Math.sin(ang));
            double cos = Math.ceil(Math.cos(ang));
            double tan = Math.ceil(Math.tan(ang));
            double sec = 1/cos;

            System.out.println("Seno: " + sen);
            System.out.println("Cosseno: " + cos);
            System.out.println("Tangente: " + tan);
            System.out.println("Secante: " + sec);
        } else {
            double sen = Math.sin(ang);
            double cos = Math.cos(ang);
            double tan = Math.tan(ang);
            double sec = 1/cos;
            double csc = 1/sen;
            double ctg = 1/tan;

            System.out.println("Seno: " + df.format(sen));
            System.out.println("Cosseno: " + df.format(cos));
            System.out.println("Tangente: " + df.format(tan));
            System.out.println("Secante: " + df.format(sec));
            System.out.println("Cossecante: " + df.format(csc));
            System.out.println("Cotangente: " + df.format(ctg));

        }
    }
}

