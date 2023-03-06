import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class inoderTraversal {
}
class Solution94 {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

}