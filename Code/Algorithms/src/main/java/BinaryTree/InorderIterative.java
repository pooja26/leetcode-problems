package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        this.val = x;
        left=right=null;
    }
}
public class InorderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> response= new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(!s.isEmpty() || null != curr) {
            while (curr!=null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            response.add(curr.val);
            curr = curr.right;
        }
        return response;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderIterative i = new InorderIterative();
        List<Integer> list = i.inorderTraversal(root);
        for(int num:list) {
            System.out.println(num);
        }
    }
}
