import ds.TreeNode;
import ds.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class TreeFlatten {
    public static void main(String[] args) {

        new Solution114().flatten(
                TreeUtil.stringToTreeNode("[1,2,5,3,4,null,6]")
        );

    }
}
class Solution114 {
    private List<TreeNode>  treeNodes = new ArrayList<>();
    public void flatten(TreeNode root) {

        preorder(root);
        for (int i = 0; i < treeNodes.size()-1; i++) {
            TreeNode last = treeNodes.get(i);
            last.right = treeNodes.get(i + 1);
            last.left = null;
        }
    }
    public void preorder(TreeNode node){
        //
        if(node == null){
            return;
        }
        treeNodes.add(node);
        preorder(node.left);
        preorder(node.right);
    }
}