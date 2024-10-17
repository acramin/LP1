import javax.swing.JFrame;

public class Trocas extends JFrame{
    
    public Trocas(Vetor v){
        super("Trocas / Bubble Sort");

                // bubble
                bubbleSort(v);
    }

    private void bubbleSort(Vetor v) {
        int t = v.getTamanho();
        double temp;
        for (int i = 0; i < t; i++) {
            for (int j = 1; j < (t - i); j++) {
                if (v.getElemento(j - 1) > v.getElemento(j)) {
                    temp = v.getElemento(j - 1);
                    v.setElemento(j - 1, v.getElemento(j));
                    v.setElemento(j, temp);
                }
            }
        }
    }

    /*static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }*/ // https://www.sortvisualizer.com/bubblesort/
}
