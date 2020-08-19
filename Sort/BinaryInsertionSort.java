public class BinaryInsertionSort {

    //折半插入排序，是插入排序的优化算法

    public int[] sort(int[] data){
        int len=data.length;
        for(int i=1;i<len;i++){
            int temp=data[i];
            int low=0;
            int high=i-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(temp>data[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            for(int j=i;j>low;j--){
                data[j]=data[j-1];
            }
            data[low]=temp;
        }
        return data;
    }
}
