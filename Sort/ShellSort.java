public class ShellSort {


    //First take an integer d1(length/2) as the first increment
    //Divide all the records of the file into d1 groups
    //Put all the elements whose distance is d1 in the same group
    //Perform insertion sort in each group
    //Then take another integer d2(d1/2) as the second increment
    //Repeat the above procedure until d=1
    public static void sort(int[] arr){
        int len=arr.length;
        int shell =len/2;
        while(shell>=1){
            for(int i=shell;i<len;i++){
                if(arr[i]<arr[i-shell]){
                    int tmp=arr[i];
                    for(int j=i;j>=0;j-=shell){
                        if(j-shell>=0&&tmp<arr[j-shell]){
                            arr[j]=arr[j-shell];
                        }
                        else{
                            arr[j]=tmp;
                            break;
                        }
                    }
                }
            }
            shell/=2;
        }
    }


    //Average-case complexity: O(NlogN)
    //Best-case complexity:
    //Worst-case complexity:O(N^2)
    //Space-complexity:O(1)
    //unstable sort
}
