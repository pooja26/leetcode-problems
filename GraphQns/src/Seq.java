import java.util.ArrayList;
import java.util.List;

public class Seq {
    public static int getSum(List<Integer> arr, int target) {
        int start_ind=0;
        int count = 0;
        int sum = arr.get(0);
        if(sum==target)
            count++;
        for (int j=1;j<arr.size();) {
            sum+=arr.get(j);
            if( sum == target) {
                count++;
                start_ind++;
                sum=0;
            } else if(sum>target) {
                start_ind++;
                j++;
                sum=0;
                sum+=start_ind;
            }
            else{
                j++;
            }
            if(start_ind<arr.size() && j== arr.size()) {
                j=start_ind+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> arr=new ArrayList();
        arr.add(4);
        arr.add(2);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        System.out.println(getSum(arr,6));
    }
}
