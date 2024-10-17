package Ex2;

public class Cube extends ThreeDimensionalShape{
    
    public Cube(int ladoA) {
        super(ladoA, ladoA, ladoA);
    }

    // Sobreposição
    public float volume() {
        int ladoA = getMedida();
        return ladoA * ladoA * ladoA;
    }

    // Sobreposição
    public float areaSup() {
        int ladoA = getMedida();
        return 6 * (ladoA * ladoA);
    }
}
