import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        Interval prev = intervals.get(0);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
               return o1.startTime-o2.startTime;
            }
        });
        for(int i =0;i<intervals.size();i++) {
            Interval cur = intervals.get(i);
            if(isOverlapping(prev,cur)) {
                prev.endTime = Math.max(prev.endTime,cur.endTime);
            } else {
                list.add(prev);
                prev = cur;
            }
        }
        list.add(prev);
        return list;
    }
    public boolean isOverlapping(Interval a,Interval b) {
        return b.startTime<=a.endTime;
    }


    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals() ;
        List<Interval> request = new ArrayList<>();
        Interval in1 = new Interval(1,3);
        Interval in2 = new Interval(2,6);
        Interval in3 = new Interval(8,10);
        Interval in4 = new Interval(15,1);

        request.add(in1);
        request.add(in2);
        request.add(in3);
        request.add(in4);

        List<Interval> list = m.merge(request);
        for(Interval in:list) {
            System.out.println(in.startTime+" "+in.endTime);
        }
    }
}
