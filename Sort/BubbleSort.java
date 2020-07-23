public class BubbleSort {


    //Compare the adjacent elements and exchange their position if the former is bigger than the latter
    //Do the same work for each pair of adjacent elements, from the first pair at the beginning to the last pair
    //After this process, the last element should be the largest number
    //Repeat the above steps for all elements except the last one
    //Continue to repeat the above steps for fewer and fewer elements each time until there is no pair of numbers to compare
    public static void sort(int[] arr){
        int len=arr.length;
        for(int i=0;i<len;i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    //Average-case complexity: O(N^2)
    //Best-case complexity:O(N^2)
    //Worst-case complexity:O(N^2)
    //Space-complexity:O(1)
    //stable sort
}
