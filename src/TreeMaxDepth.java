import ds.TreeNode;
import ds.TreeUtil;

public class TreeMaxDepth {
    public static void main(String[] args) {
        System.out.println(new Solution104().maxDepth(
                TreeUtil.stringToTreeNode("[3,9,20,null,null,15,7]")));

    }
}

class Solution104 {
    private int max = 0;
    public int maxDepth(TreeNode root) {
        getMax(root, 1);
        return max;
    }
    public void getMax(TreeNode node, int depth) {
        if (node == null) {
            if(depth - 1 > max){
                max = depth - 1;
            }
            return;
        }
        getMax(node.left, depth + 1);
        getMax(node.right, depth + 1);
    }
}