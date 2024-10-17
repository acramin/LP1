package Ex2;

public class Circle extends TwoDimensionalShape{
    
    public Circle(int raio){
        super(raio, raio);
    }

    // Sobreposição
    public float area(){
        int raio = getMedida();
        return (float) Math.PI*raio*raio;
    }

    // Sobreposição
    public float perimetro(){
        int raio = getMedida();
        return (float) Math.PI*2*raio;
    }
}
