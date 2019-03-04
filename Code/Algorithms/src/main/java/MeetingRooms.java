import java.util.Arrays;
import java.util.Comparator;

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
        For example,
        Given [[0, 30],[5, 10],[15, 20]],
        return false.*/
class Interval {
    int startTime;
    int endTime;
    Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {

        if(null == intervals || intervals.length == 0) return true;
        Arrays.sort(intervals, new IntervalComparator());
        Interval prev = intervals[0];
        for(int i=1;i<intervals.length;i++) {
            Interval curr = intervals[i];
            if(isOverlapped(prev,curr)) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
    public class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {

            return o1.startTime - o2.startTime;
        }
    }
    public boolean isOverlapped(Interval a,Interval b) {
        return a.endTime > b.startTime;
    }

    public static void main(String[] args) {
        MeetingRooms room = new MeetingRooms();
        Interval[] interval = new Interval[2];
        interval[0] = new Interval(0,30);
        interval[1] = new Interval(35,70);
        System.out.println(room.canAttendMeetings(interval));
    }
}
