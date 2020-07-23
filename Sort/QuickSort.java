public class QuickSort {


    //Pick an element(usually the last element in the array) from the array and call it a "pivot"
    //Re-order the array all elements smaller than the pivot are placed in front of the pivot
    //All elements larger than the pivot are placed behind the pivot
    //Recursively sort the sub-array which are in front of and behind the pivot
    public static void sort(int[] arr){
        recur(0,arr.length-1,arr);
    }

    public static void recur(int begin,int end,int[] arr){
        if(begin>=end){
            return;
        }
        int mid=arr[end];
        int left=begin,right=end-1;
        while(left<right){
            while(arr[left]<=mid&&left<right){
                left++;
            }
            while(arr[right]>=mid&&left<right){
                right--;
            }
            swap(left,right,arr);
        }
        if(arr[left]>=arr[end]){
            swap(left,end,arr);
        }
        else{
            left++;
        }
        recur(begin,left-1,arr);
        recur(left+1,end,arr);
    }

    public static void swap(int x,int y, int[] arr){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }


    //Average-case complexity: O(NlogN)
    //Best-case complexity:O(NlogN)
    //Worst-case complexity:O(N^2)
    //Space-complexity:
    //unstable sort
}
