package Ex2;

public class Teste {
    public static void main(String[] args) {

        System.out.println("Teste Square");
        Square sqr = new Square(5);
        System.out.println("Area: " + sqr.area());
        System.out.println("Perimetro: " + sqr.perimetro());
        System.out.println();

        System.out.println("Teste Circle");
        Circle cl = new Circle(5);
        System.out.println("Area: " + cl.area());
        System.out.println("Perimetro: " + cl.perimetro());
        System.out.println();

        System.out.println("Teste Triangle");
        Triangle tg = new Triangle(5, 2);
        System.out.println("Area: " + tg.area());
        System.out.println("Perimetro: " + tg.perimetro()); /// Considerando que o triangulo eh sempre equilatero
        System.out.println();

        System.out.println("Teste Cube");
        Cube cb = new Cube(5);
        System.out.println("Volume: " + cb.volume());
        System.out.println("Area superficie: " + cb.areaSup());
        System.out.println();

        System.out.println("Teste Sphere");
        Sphere sh = new Sphere(5);
        System.out.println("Volume: " + sh.volume());
        System.out.println("Area superficie: " + sh.areaSup());
        System.out.println();

        System.out.println("Teste Tetrahedron");
        Tetrahedron th = new Tetrahedron(5);
        System.out.println("Volume: " + th.volume());
        System.out.println("Area superficie: " + th.areaSup());
        System.out.println();
    }
}
