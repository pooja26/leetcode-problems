package BinaryTree;


public class TreeFromInPre {
    private int preInd=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = helper(preorder,inorder,0,inorder.length-1);
        return root;
    }
    public TreeNode helper(int[] preorder,int[] inorder,int inStart, int inEnd) {
        if(inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preInd++]);
        int inIndex=0;
        for(int i=inStart;i<=inEnd;i++) {
            if(inorder[i]==root.val) {
                inIndex=i;
                break;
            }
        }
        root.left=helper(preorder,inorder,inStart,inIndex-1);
        root.right=helper(preorder,inorder,inIndex+1,inEnd);
        return root;
    }

    public static void main(String[] args) {

        int[] inorder={9,3,15,20,7};
        int[] preorder={3,9,20,15,7};
        TreeFromInPre p = new TreeFromInPre();
        p.buildTree(preorder,inorder);
    }
}
