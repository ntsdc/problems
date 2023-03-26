import ds.TreeNode;
import ds.TreeUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCA {  //LCA问题
    public static void main(String[] args) {
//        new Solution236().lowestCommonAncestor(
//                TreeUtil.stringToTreeNode("")
//        );
    }
}
class Solution236 {
    Map<Integer, TreeNode> parent = new HashMap<>();    //存储每个节点的父节点
    Set<TreeNode> treeNodes = new HashSet<>();  //向上遍历 存储遍历到的每一个节点

    public void dfs(TreeNode node){
        if(node.left != null){
            parent.put(node.left.val, node);
            dfs(node.left);
        }
        if(node.right != null){
            parent.put(node.right.val, node);
            dfs(node.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null){
            treeNodes.add(p);
            p = parent.get(p.val);
        }
        while (q != null){
            if(treeNodes.contains(q)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}