import java.util.ArrayList;

public class BucketSort {


    //
    public static void sort(int[] arr){
        int max=arr[0];
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }

        int bucketNum=(max-min)/arr.length+1;
        ArrayList<ArrayList<Integer>> bucketArr=new ArrayList<>();
        for(int i=0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        for(int i=0;i<arr.length;i++){
            int num=(arr[i]-min)/arr.length;
            int len_arr=bucketArr.get(num).size();
            if(len_arr==0){
                bucketArr.get(num).add(arr[i]);
            }
            else{
                ArrayList<Integer> insert_arr=bucketArr.get(num);
                int last_element=insert_arr.get(len_arr-1);
                insert_arr.add(last_element);
                int s=insert_arr.size();
                int j=s-1;
                while(j>0){
                    if(arr[i]<insert_arr.get(j-1)){
                        insert_arr.set(j,insert_arr.get(j-1));
                        j--;
                    }
                    else{
                        break;
                    }
                }
                insert_arr.set(j,arr[i]);
            }
        }

        int count=0;
        for(int i=0;i<bucketNum;i++){
            for(int j=0;j<bucketArr.get(i).size();j++){
                arr[count++]=bucketArr.get(i).get(j);
            }
        }
    }
}
