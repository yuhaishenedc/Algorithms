public class RadixSort {

    public static void main(String[] args) {
        int[] arr=new int[]{73,22,93,43,55,14,28,65,39,81};
        lsd_sort(arr);
    }

    //msd_version
    public static void lsd_sort(int[] arr){
        int min=arr[0];
        int exp;
        for(int a:arr){
            if(a<min){
                min=a;
            }
        }
        //Consider the negative situation
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
        }
        for(int i=0;i<arr.length;i++){
            arr[i]-=Math.abs(min);
        }
    }

    //lsd_version
    public static void msd_sort(int[] arr){
        int min=arr[0];
        for(int a:arr){
            if(a<min){
                min=a;
            }
        }
        //Consider the negative situation
        for(int i=0;i<arr.length;i++){
            arr[i]+=Math.abs(min);
        }
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        double d=Math.pow(10,String.valueOf(max).length());
        int k=1;
        int[][] t=new int[10][arr.length];
        int[] num=new int[10];
        while(k<d){
            for(int a:arr){
                int m=(a/k)%10;
                t[m][num[m]]=a;
                num[m]++;
            }
            int c=0;
            for(int i=0;i<10;i++){
                if(num[i]!=0){
                    for(int j=0;j<num[i];j++){
                        arr[c++]=t[i][j];
                    }
                }
                num[i]=0;
            }
            k*=10;
        }
    }
}
