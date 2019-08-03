package lianxi0803;


public class Test {

}


class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int index = 0;

    private TreeNode build(int[] postorder,int[] inorder, int inbegin, int inend) {

        if (inbegin > inend)
            return null;

        TreeNode root = new TreeNode(postorder[index]);

        int rootIndex = indexOfTreeNode(inorder, postorder[index], inbegin, inend);
        index--;

        root.right = build(postorder,inorder, rootIndex + 1, inend);
        root.left = build(postorder,inorder, inbegin, rootIndex - 1);

        return root;
    }

    private int indexOfTreeNode(int[] inorder, int val, int inbegin, int inend) {
        for (int i = inbegin; i <= inend; i++)
            if (inorder[i] == val)
                return i;
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;
        index = postorder.length-1;
        return build(postorder,inorder, 0, inorder.length - 1);
    }
}