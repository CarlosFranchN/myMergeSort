import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.HashMap;

public class App {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        HashMap<String, int[]> times = new HashMap<String, int[]>();
        // int[] arr = {38, 27, 43, 3, 9, 82, 10}; // Array de exemplo
        int[] arr = gerarArrayAleatorio(100);
        int [] arr_tempos = new int[5] ;
        for (int i = 0; i <= arr_tempos.length; i++) {
            long tempo = getTempoMergeSortParalelo(arr, 4);
            arr_tempos[0]
        }
        times.put("Merge Sort Paralelo", tempo);
        System.out.println(times);

        // System.out.println(getTempoMergeSortParalelo(arr, 4));

    }
        public static int[] gerarArrayAleatorio(int N) {
        Random random = new Random();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(100);  // Gera números aleatórios de 0 a 99
        }

        return array;
    }
        public static long getTempoMergeSortParalelo(int[] array, int nThreads){
            ForkJoinPool pool = new ForkJoinPool(nThreads);
            int n = array.length;

          MergeSort_paralelo task = new MergeSort_paralelo(array, 0, n-1);
          pool.invoke(task);
        //   for(int num: array){
        //     System.out.print(num + " ");
        // }
        // System.out.println();
        // System.out.println(MergeSort_paralelo.get_Time());
            return  task.get_Time();
        }
}
