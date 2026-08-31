
import java.util.Random;

public class QuickSelect {

    public static void quickSelect(int[] arr, int low, int high, int k) {
        if (low >= high) {
            return;
        }

        int s=low;
        int e=high;
        int pivot = arr[(low+high)/2];
        while(s<=e){
            while(s <= e && arr[s]<pivot){
                s++;
            }

            while(s <= e && arr[e]>pivot){
                e--;
            }

            if(s<=e){
                swap(arr, s, e);    
                s++;
                e--;          
            }
        }
        pivot=e+1;

        if (pivot == k) {
            return ;
        } else if (k < pivot) {
             quickSelect(arr, low, e, k);
        } else {
             quickSelect(arr, s, high, k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static long timeQuickSelectRun(int[] input, int k) {
        int[] copy = input.clone();
        long start = System.nanoTime();
        quickSelect(copy, 0, copy.length - 1, k);
        long end = System.nanoTime();
        return end - start;
    }

    private static int[] randomArray(int size, int bound, Random random) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    private static void benchmarkQuickSelect() {
        Random random = new Random(42);
        int fixedSize = 1000;
        int runs = 30;

        System.out.println("run,input_size,time_ns");

        int k = fixedSize / 2;

        for (int t = 0; t < runs; t++) {
            int[] arr = randomArray(fixedSize, fixedSize * 10, random);
            long time = timeQuickSelectRun(arr, k);
            System.out.println((t + 1) + "," + fixedSize + "," + time);
        }
    }

    public static void main(String[] args) {

        int[] arr = {7, 2, 1, 8, 6, 3, 5, 4};

        int k = 3; 

        quickSelect(arr, 0, arr.length - 1, k);

        for(int i=0;i<k;i++){
            System.out.println(arr[i]);
        }

        benchmarkQuickSelect();
    }
} 
