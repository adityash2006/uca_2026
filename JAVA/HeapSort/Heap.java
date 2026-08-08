
import java.util.Random;

public class Heap {
    public static void heapifyDown(int[] arr,int position,int size){

        int now = position;
        int len = size;
        while(true){
            int left = 2*now+1;
            int right = 2*now+2;
            int largest = now;

            if(left < len && arr[left]>arr[largest]){
                largest = left;
            }
            if(right < len && arr[right]>arr[largest]){
                largest = right;
            }

            if(largest==now) break;

            int temp = arr[now];
            arr[now] = arr[largest];
            arr[largest] = temp;
            
            now = largest;
        }

    }
            public static void heapSort(int[] arr) {
                for (int i = (arr.length) / 2 - 1; i >= 0; i--) {
                    heapifyDown(arr, i, arr.length);
                }

                for (int i = arr.length - 1; i >= 1; i--) {
                    int temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                    heapifyDown(arr, 0, i);
                }
            }

            public static int[] createRandomArray(int size) {
                Random random = new Random();
                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = random.nextInt(size * 2) - size;
                }

                return arr;
            }

            public static int[] createAscendingArray(int size) {
                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }

                return arr;
            }

            public static int[] createDescendingArray(int size) {
                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }

                return arr;
            }

            public static void measureRuntime(String caseName, int[] arr) {
                long start = System.nanoTime();
                heapSort(arr);
                long end = System.nanoTime();

                System.out.println(caseName + " runtime: " + (end - start) / 1_000_000.0 + " ms");
            }
    
    public static void main(String[] args) {
                int size = 5000;

                measureRuntime("Random array", createRandomArray(size));
                measureRuntime("Ascending array", createAscendingArray(size));
                measureRuntime("Descending array", createDescendingArray(size));
        
    }
}
