package StringQns;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {

        String[] strings = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s:strings) {
            sb.append(s);
        }
        while (sb.charAt(0)=='0' && sb.length()>1)
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber l = new LargestNumber();
        int[] nums={10,2};
        System.out.println(l.largestNumber(nums));
    }
}
