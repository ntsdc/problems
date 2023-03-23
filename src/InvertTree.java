import ds.TreeNode;
import ds.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public static void main(String[] args) {
        System.out.println(
                new Solution226().invertTree(
                        TreeUtil.stringToTreeNode("[4,2,7,1,3,6,9]")
                )
        );
    }

}
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()){
            TreeNode node = treeNodeQueue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.right != null){
                treeNodeQueue.offer(node.right);
            }
            if(node.left != null){
                treeNodeQueue.offer(node.left);
            }
        }
        return root;
    }
}
//class Solution {
//    // 先序遍历--从顶向下交换
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        // 保存右子树
//        TreeNode rightTree = root.right;
//        // 交换左右子树的位置
//        root.right = invertTree(root.left);
//        root.left = invertTree(rightTree);
//        return root;
//    }
//}
//
//利用中序遍历
//class Solution {
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        invertTree(root.left); // 递归找到左节点
//        TreeNode rightNode= root.right; // 保存右节点
//        root.right = root.left;
//        root.left = rightNode;
//        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
//        invertTree(root.left);
//    }
//}
//
//利用后序遍历
//class Solution {
//    public TreeNode invertTree(TreeNode root) {
//        // 后序遍历-- 从下向上交换
//        if (root == null) return null;
//        TreeNode leftNode = invertTree(root.left);
//        TreeNode rightNode = invertTree(root.right);
//        root.right = leftNode;
//        root.left = rightNode;
//        return root;
//    }
//}
