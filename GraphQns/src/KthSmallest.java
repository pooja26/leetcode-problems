//import java.util.*;
//public class KthSmallest {
//    public static void getKth(Node a,int k) {
//        int c=0;
//        Node curr = a;
//        Stack<Node> stack = new Stack<Node>();
//        while(curr!=null || !stack.isEmpty()) {
//            if(curr!=null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            else {
//                Node val = stack.pop();
//                if(--k == 0){
//                    System.out.println(val.x);
//                }
//                curr = val.right;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Node root = new Node(20);
//        root.left = new Node(8);
//        root.right = new Node(22);
//        root.left.left = new Node(4);
//        root.left.right = new Node(10);
//        getKth(root,3);
//    }
//}
