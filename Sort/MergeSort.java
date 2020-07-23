public class MergeSort {


    //Combine every two adjacent numbers in the sequence to form (length/2) sequences
    //After sorting, each sorted array contains two elements
    //Combine the above sequences again to form (length/4) sequences, each sequence contains four elements
    //Repeat the above procedure until all elements are sorted
    //Here are two ways: the iteration way and the recursion way

    //Iteration version
    public static void sort(int[] arr){
        int len=arr.length;
        int[] result=new int[len];
        int block,start;

        for(block=1;block<len*2;block*=2){
            for(start=0;start<len;start+=2*block){
                int low=start;
                int mid=(start+block)<len?(start+block):len;
                int high=(start+2*block)<len?(start+2*block):len;
                int start1=low,end1=mid;
                int start2=mid,end2=high;
                while(start1<end1&&start2<end2){
                    result[low++]=arr[start1]<arr[start2]?arr[start1]:arr[start2];
                }
                while(start1<end1){
                    result[low++]=arr[start1++];
                }
                while(start2<end2){
                    result[low++]=arr[start2++];
                }
            }
            int[] tmp=arr;
            arr=result;
            result=tmp;
        }
    }

    //Recursion version
    public static void recur_version(int[] arr){
        recur(arr,0,arr.length-1);
    }
    public static void recur(int[] arr,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            recur(arr,start,mid);
            recur(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right){
        int[] tmp=new int[arr.length];
        int p1=left,p2=mid+1,k=left;
        while(p1<=mid&&p2<=right){
            if(arr[p1]<=arr[p2]){
                tmp[k++]=arr[p1++];
            }
            else{
                tmp[k++]=arr[p2++];
            }
        }
        while(p1<=mid){
            tmp[k++]=arr[p1++];
        }
        while (p2<=right){
            tmp[k++]=arr[p2++];
        }
        for(int i=left;i<=right;i++){
            arr[i]=tmp[i];
        }
    }


    //Average-case complexity: O(nlogn)
    //Best-case complexity:O(N)
    //Worst-case complexity:O(Nlogn)
    //Space-complexity:O(n)
    //stable sort
}
