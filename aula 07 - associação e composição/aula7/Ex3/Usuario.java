package Ex3;

public class Usuario {
    public static void main(String[] args) {

        CondicionadorDeAr condicionadorDeAr = new CondicionadorDeAr();

        condicionadorDeAr.ligar();
        for (int i = 0; i <10; i++){ // tenta ir até 30
            condicionadorDeAr.aumentarTemperatura();
        }
        for (int i = 0; i <18; i++){ // tenta ir até 10
            condicionadorDeAr.diminuirTemperatura();;
        }
        for (int i = 0; i <10; i++){ // vai até 25
            condicionadorDeAr.aumentarTemperatura();
        }
        condicionadorDeAr.imprimirTemperatura(); // imprime atual (no caso, 25°C)

    }
}
