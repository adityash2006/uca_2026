import java.util.List;
import java.util.ArrayList;

class Solution {
      public  void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
       
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else{
                temp.add(arr[right++]); 
            }
        }

        while (left <= mid)
            temp.add(arr[left++]);

        while (right <= high)
            temp.add(arr[right++]);

        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);

    }
    public  void merseSort(int [] arr, int low, int high,int[] ansArray){
        if(low>=high) return;
        int mid = (low + high) / 2;
        
        merseSort(arr, low, mid,ansArray);
        merseSort(arr,mid+1,high,ansArray);
        countPair(arr,low,mid,high,ansArray);
        merge(arr,low,mid,high);
        
        
    }

    public void countPair(int[] arr, int low, int mid, int high,int[] ansArray){
    
        int j=mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && arr[i]>arr[j]){
                j++;
            }
            ansArray[i]+=j-mid-1;  
        }   
    }
    public void countSmaller(int[] nums,int[] ansArray) {
        merseSort(nums,0,nums.length-1,ansArray);
    }
}

public class CountSmallerAfterSelf{
    public static void main(String[] args) {
        Solution s1=new Solution();
        int[] arr={5,2,6,1};
        int[] ansArray=new int[arr.length];

        s1.countSmaller(arr,ansArray);
        for (int i : ansArray) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}