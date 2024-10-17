package Ex2;

public class ThreeDimensionalShape extends Shape{
    private int a;
    private int b;

    public ThreeDimensionalShape(int a, int b, int c) {
        super(c);
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    // Sobrecarga e Sobreposição
    public float volume() {
        return 0;
    }

    // Sobrecarga e Sobreposição
    public float areaSup() {
        return 0;
    }

    // Sobrecarga
    public int volume(int a, int b, int c) {
        return 0;
    }

    // Sobrecarga
    public int areaSup(int a, int b , int c) {
        return 0;
    }

}
