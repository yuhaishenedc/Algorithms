public class InsertionSort {

    //Starting from the first element, the element can be considered to have been sorted
    //Take out the next element and scan from back to front in the sorted sequence of elements
    //If the element is greater than a certain element(a) in the sorted sequence
    //start from a, the sorted elements are moved one place in turn
    //Insert the element in the vacated position
    //Repeat the above process
    public static void sort(int[] arr){
        int len=arr.length;
        for(int i=1;i<len;i++){
            int tmp=arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(tmp<arr[j]){
                    arr[j+1]=arr[j];
                }
                else{
                    break;
                }
            }
            arr[j+1]=tmp;
        }
    }


    //Average-case complexity: O(N^2)
    //Best-case complexity:O(N^2)
    //Worst-case complexity:O(N^2)
    //Space-complexity:O(1)
    //stable sort
}
