public class HeapSort {


    //Create a heap
    //Swap the root of the heap and the last element of the heap
    //The last element is considered to have been sorted and removed from the heap
    //Repeat the above procedure until the whole heap is sorted
    public static void sort(int[] arr){
        heapInsert(arr);
        int length=arr.length;
        while(length>1){
            swap(arr,0,length-1);
            length--;
            heapify(arr,0,length);
        }
    }

    public static void heapInsert(int[] arr){
        for(int i=0;i<arr.length;i++){
            int currentIndex=i;
            int fatherIndex=(currentIndex-1)/2;
            while(arr[currentIndex]>arr[fatherIndex]){
                swap(arr,currentIndex,fatherIndex);
                currentIndex=fatherIndex;
                fatherIndex=(currentIndex-1)/2;
            }
        }
    }

    public static void heapify(int[] arr,int index,int size){
        int left=2*index+1;
        int right=2*index+2;
        while(left<size){
            int largestIndex;
            if(right<size&&arr[left]<arr[right]){
                largestIndex=right;
            }
            else{
                largestIndex=left;
            }
            if(arr[index]>arr[largestIndex]){
                break;
            }
            swap(arr,largestIndex,index);
            index=largestIndex;
            left=2*index+1;
            right=2*index+2;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //Average-case complexity: O(NlogN)
    //Best-case complexity:O(NlogN)
    //Worst-case complexity:O(NlogN)
    //Space-complexity:O()
    //unstable sort
}
