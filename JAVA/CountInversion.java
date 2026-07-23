import java.util.List;
import java.util.ArrayList;

class Solution {
      public  int merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
       int count =0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else{
                count++;
                temp.add(arr[right++]); 
            }
        }

        while (left <= mid)
            temp.add(arr[left++]);

        while (right <= high)
            temp.add(arr[right++]);

        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);

       return count;
    }
    public  int merseSort(int [] arr, int low, int high){
        if(low>=high) return 0;
        int mid = (low + high) / 2;
        int c=0;
        c+=merseSort(arr, low, mid);
        c+=merseSort(arr,mid+1,high);
        c+=merge(arr,low,mid,high);
        return c;
        
    }

    public int CountInver(int[] nums) {
        return merseSort(nums,0,nums.length-1);
    }
}

public class CountInversion {

    public static void main(String[] args) {
        int arr[]={12,3,23,5,4};
        Solution ar= new Solution();
        System.out.println(ar.CountInver(arr));
        
    }
}