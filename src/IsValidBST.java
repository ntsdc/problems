import ds.TreeNode;
import ds.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public static void main(String[] args) {
        System.out.println(new Solution98().isValidBST
                (TreeUtil.stringToTreeNode("[5,1,4,null,null,3,6]")));
    }
}

class Solution98 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if (root == null) return true;
        boolean left = inorder(root.left);
        if (root.val <= pre) return false;
        pre = root.val;
        boolean right = inorder(root.right);
        return right && left;
    }
}