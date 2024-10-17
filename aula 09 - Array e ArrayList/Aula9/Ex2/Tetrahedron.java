package Ex2;

public class Tetrahedron extends ThreeDimensionalShape{
    
    public Tetrahedron(int a) {
        super(a, a, a);
    }

    // Sobreposição
    public float volume() {
        int a = getMedida();
        return (float) (a * a * a * Math.sqrt(2)) / 12;
    }

    // Sobreposição
    public float areaSup() {
        int a = getMedida();
        return (float) (a * a * Math.sqrt(3));
    }
}
