/*Given an array of meeting time intervals consisting of start and end times
 [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.*/


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Gap {
    int startTime;
    int endTime;
    Gap(int startTime,int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class MeetingRooms2 {

    public int minMeetingRooms(Gap[] gap) {

        Arrays.sort(gap, new GapComparator()) ;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(gap[0].endTime);
        int count=1;
        for(int i=1;i<gap.length;i++) {
            if(gap[i].startTime>=queue.peek()) {
                queue.poll();
            } else {
                count++;
            }
            queue.add(gap[i].endTime);
        }
        return count;
    }
 public class GapComparator implements Comparator<Gap> {

        @Override
        public int compare(Gap o1, Gap o2) {
            return o1.startTime-o2.startTime;
        }
    }

    public static void main(String[] args) {
        MeetingRooms2 m = new MeetingRooms2();
        Gap[] gap = new Gap[3];
        gap[0] = new Gap(0,30);
        gap[1] = new Gap(35,40);
        gap[2] = new Gap(30,35);
        System.out.println(m.minMeetingRooms(gap));
    }
}
