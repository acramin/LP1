package Ex2;

public class Triangle extends TwoDimensionalShape{

    public Triangle(int altura, int base) {
        super(altura, base);
    }

    // Sobreposição
    public float area() {
        int altura = getMedida();
        int base = getLado2();
        return (altura * base) / 2;
    }

    // Sobreposição
    public float perimetro() {
        int base = getLado2();
        return 3 * base;
    }
}
