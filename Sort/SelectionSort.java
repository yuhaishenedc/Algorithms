public class SelectionSort {


    //First choose the maximum or the minimum value from the unordered array
    //Put this value at the beginning of the array
    //Then continue to find the maximum or the minimum value from the remaining unsorted array
    //Put this value at the end of the sorted array
    //And so on, until all elements are sorted
    public static void sort(int[] arr){
        int i,j,min,temp,len=arr.length;
        for(i=0;i<len-1;i++){
            min=i;
            for(j=i+1;j<len;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }


    //Average-case complexity: O(N^2)
    //Best-case complexity:O(N^2)
    //Worst-case complexity:O(N^2)
    //Space-complexity:O(1)
    //unstable sort


    //The total numbe of comparisons N=(n-1)+(n-2)+...+1=n*(n-1)/2
    //The number of exchange is O(n)
    //In the best case when the array is in order, the number of exchange is 0
    //In the worst case when the array is reversed, the number of exchange is n-1
}
