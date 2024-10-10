
public class mergeSort {
    public static int[] mergeSorting(int[] a, int left, int right){
        if ( left < right){
            int mid = (left+right)/2;
            mergeSorting(a, left, mid);
            mergeSorting(a, mid+1, right);
            merge(a, left,mid,right);
        }
        
        return a;
        
    }

    
    }

