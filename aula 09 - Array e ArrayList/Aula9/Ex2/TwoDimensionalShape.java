package Ex2;

public class TwoDimensionalShape extends Shape{
    private int lado2;

    public TwoDimensionalShape(int lado1, int lado2) {
        super(lado1);
        this.lado2 = lado2;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    // Sobrecarga e Sobreposição
    public float area() {
        return 0;
    }

    // Sobrecarga e Sobreposição
    public float perimeter() {
        return 0;
    }

    // Sobrecarga
    public float area(int lado1, int lado2) {
        return 0;
    }

    // Sobrecarga
    public float perimeter(int lado1, int lado2) {
        return 0;
    }

}
