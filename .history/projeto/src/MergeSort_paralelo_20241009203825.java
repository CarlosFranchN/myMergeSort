import java.util.concurrent.RecursiveAction;


public class MergeSort_paralelo extends RecursiveAction {
    public int[] array;
    public int left;
    public int right;
    private static long time;

    public MergeSort_paralelo(int[] array, int left, int right){
        this.array = array;
        this.left = left;
        this.right = right;
        this.time = 0;
    }

    @Override
    protected void compute(){
        if (left < right){
            int mid = (left + right) / 2;
            long inicio = System.nanoTime();
            MergeSort_paralelo rightTask = new MergeSort_paralelo(array, left, mid);
            MergeSort_paralelo leftTask = new MergeSort_paralelo(array, mid+1, right);
        
            invokeAll(leftTask,rightTask);
            mergeSort.merge(array, left, mid, right);
            long fim  = System.nanoTime();
            time = fim - inicio;
        }
    }
    public static long get_Time(){
        return time;
    }

    
}
