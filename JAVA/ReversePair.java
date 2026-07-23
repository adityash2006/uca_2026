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
    public  int merseSort(int [] arr, int low, int high){
        if(low>=high) return 0;
        int mid = (low + high) / 2;
        int c=0;
        c+=merseSort(arr, low, mid);
        c+=merseSort(arr,mid+1,high);
        c+=countPair(arr,low,mid,high);
        merge(arr,low,mid,high);
        return c;
        
    }

    public int countPair(int[] arr, int low, int mid, int high){
        
        int ans=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && arr[i]>2*arr[j]){
                j++;
            }
            ans+=j-mid-1;
            
        }

        return ans;
    }
    public int reversePairs(int[] nums) {
        return merseSort(nums,0,nums.length-1);
    }
}