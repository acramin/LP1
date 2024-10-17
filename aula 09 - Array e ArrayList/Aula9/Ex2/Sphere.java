package Ex2;

public class Sphere extends ThreeDimensionalShape{
    
    public Sphere(int raio) {
        super(raio, raio, raio);
    }

    // Sobreposição
    public float volume() {
        int raio = getMedida();
        return (float) ((4 / 3) * Math.PI * raio * raio * raio);
    }

    // Sobreposição
    public float areaSup() {
        int raio = getMedida();
        return (float) (4 * Math.PI * raio * raio);
    }
}
