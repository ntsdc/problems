import ds.TreeNode;
import ds.TreeUtil;

public class SymmetricTree {
    public static void main(String[] args) {
        System.out.println(new Solution101().isSymmetric(
                TreeUtil.stringToTreeNode("[1,2,2,null,3,null,3]")
        ));
    }
}
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return order(root.left, root.right);
    }
    public boolean order(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val == node2.val){
            return order(node1.left, node2.right) && order(node1.right, node2.left);
        }
        return false;
    }
}