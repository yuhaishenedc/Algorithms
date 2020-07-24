public class RadixSort {


    //msd_version
    public static void sort(int[] arr){
        int min=arr[0];
        int exp;
        for(int a:arr){
            if(a<min){
                min=a;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]+=Math.abs(min);
        }
        int max=arr[0];
        for(int a:arr){
            if(a>max){
                max=a;
            }
        }
        for(exp=1;max/exp>0;exp*=10){
            int[] tmp=new int[arr.length];
            int[] buckets=new int[10];
            for(int value:arr){
                buckets[(value/exp)%10]++;
            }
            for(int i=1;i<10;i++){
                buckets[i]+=buckets[i-1];
            }
            for(int i=arr.length-1;i>=0;i--){
                tmp[buckets[(arr[i]/exp)%10]-1]=arr[i];
                buckets[(arr[i]/exp)%10]--;
            }
            System.arraycopy(tmp,0,arr,0,arr.length);
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
        }
        for(int i=0;i<arr.length;i++){
            arr[i]-=Math.abs(min);
        }
    }

    //
}
