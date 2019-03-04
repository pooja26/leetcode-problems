import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

class Tuple implements Comparable<Tuple> {
     int x;
     int y;
     int val;
    public Tuple(int x,int y,int val) {
        this.x = x;
        this.y=y;
        this.val=val;
    }
    @Override
    public int compareTo(Tuple o) {
        return this.val-o.val;
    }
}
public class KthSmallInMat {

    public int kthSmall(int[][] mat, int k) {
        int n=mat.length;
        PriorityQueue<Tuple> q = new PriorityQueue<>();
        for(int j=0;j<=n-1;j++) {
            q.offer(new Tuple(0,j,mat[0][j]));
        }
        for (int i=0;i<k-1;i++) {
            Tuple t = q.poll();
            if(t.x==n-1){
                continue;
            }
            q.offer(new Tuple(t.x+1,t.y,mat[t.x+1][t.y]));
        }
        return q.poll().val;

    }
    public static void main(String[] args) {

        int[][] nums = {{1,5,9},{10,11,13},{12,13,15}};
        KthSmallInMat k =new KthSmallInMat();
        System.out.println(k.kthSmall(nums,8));
    }
}
