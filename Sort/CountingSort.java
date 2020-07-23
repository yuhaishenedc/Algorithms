public class CountingSort {


    //stable version
    public static void sort(int[] arr){
        int max=arr[0];
        int min=arr[0];
        int len=arr.length;
        for(int i=1;i<len;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        int d=max-min;
        int[] countArray=new int[d+1];
        for(int i=0;i<arr.length;i++){
            countArray[arr[i]-min]++;
        }
        int sum=0;
        for(int i=0;i<countArray.length;i++){
            sum+=countArray[i];
            countArray[i]=sum;
        }
        int[] sortArray=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            sortArray[countArray[arr[i]-min]-1]=arr[i];
            countArray[arr[i]-min]--;
        }
        arr=sortArray;
    }
}
