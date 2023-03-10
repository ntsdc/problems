import ds.List2String;
import ds.TreeNode;
import ds.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        System.out.println(List2String.int2dListToString(new Solution102().levelOrder(
                TreeUtil.stringToTreeNode("[1,2,null,3,null,4,null,5]")
        )));

    }

}
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int currentSize = q.size();
            TreeNode temp;
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                temp = q.poll();
                integers.add(temp.val);
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            res.add(integers);
        }
        return res;
    }
}