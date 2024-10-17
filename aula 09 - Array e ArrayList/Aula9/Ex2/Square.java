package Ex2;

public class Square extends TwoDimensionalShape{

    public Square(int ladoA){
        super(ladoA, ladoA);
    }

    // Sobreposição
    public float area(){
        float ladoA = getMedida();
        return ladoA * ladoA;
    }
    
    // Sobreposição
    public float perimetro() {
        int ladoA = getMedida();
        return 4 * ladoA;
    }

}
