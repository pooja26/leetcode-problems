/*
import java.util.*;
class Node {
    Node left;
    Node right;
    int x;
    Node(int x){
        this.x = x;
        left=right=null;
    }
}
public class Traversal {
    public static void inorderRec(Node root) {
        Node curr = root;
        if(null == curr) return;
        inorderRec(root.left);
        System.out.println(root.x);
        inorderRec(root.right);
    }
    public static void preorderRec(Node root) {
        if(null == root) return;
        System.out.println(root.x);
        preorderRec(root.left);
        preorderRec(root.right);
    }
    public static void postorderRec(Node root) {
        if(null == root) return;
        postorderRec(root.left);
        postorderRec(root.right);
        System.out.println(root.x);
    }
    public static void inorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node curr = root;
        while (curr != null && !stack.isEmpty()) {
            while (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            curr = stack.pop();
            System.out.println(curr.x);
            curr = curr.right;

        }
    }
    public static void preorder(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<Node>();
        stack.push(curr);
        while(curr!=null && !stack.isEmpty()) {
            Node val = stack.pop();
            System.out.println(val.x);
            if(val.right!=null)
                stack.push(val.right);
            if(val.left!=null)
                stack.push(val.left);
        }
    }
    public static void postorder(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node temp = stack.peek();
            if(null == temp.right && null == temp.left)
                System.out.println(stack.pop().x);
            else {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                    temp.left = null;
                }
            }

        }
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        postorder(root);
    }
}
*/
