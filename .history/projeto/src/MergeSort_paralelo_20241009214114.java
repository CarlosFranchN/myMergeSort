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
        MergeSort_paralelo.time = 0;
    }

    @Override
    protected void compute(){
        if (left < right){
            int mid = (left + right) / 2;
            long inicio = System.nanoTime();
            MergeSort_paralelo rightTask = new MergeSort_paralelo(array, left, mid);
            MergeSort_paralelo leftTask = new MergeSort_paralelo(array, mid+1, right);
        
            invokeAll(leftTask,rightTask);
            merge(array, left, mid, right);
            long fim  = System.nanoTime();
            time = fim - inicio;
        }
    }
    public long get_Time(){
        return time;
    }

    public static int[] merge(int[] a, int left, int mid, int right) {
        int b[] = new int[a.length];
        int i = left;
        int j = mid+1;
        int k = left;




        while (i<=mid && j <=right) {
            if(a[i] < a[j]){
                b[k] = a[i];
                i++;
            }
            else{
                b[k] = a[j];
                j++;
            }
            k++;
        }
            if (i>mid) {
                while (j<=right) {
                    b[k]=a[j];
                    k++;
                    j++;
                }
            }else{
                while (i<=mid) {
                    b[k]=a[i];
                    k++;
                    i++;
                }
            }
            for(k=left;k<=right;k++){
                a[k] = b[k];
            }
            return a;
        }
        
}
