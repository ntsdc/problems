import ds.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args) {
        TreeNode root = new Solution105().buildTree(
                new int[]{3,9,20,15,7},
                new int[]{9,3,15,20,7});
    }
}

class Solution105 {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        indexMap = new HashMap<>();     //中序遍历序列建立哈希表，加快查找速度
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildSubTree(preorder,inorder,0,len-1,0,len-1);
    }

    public TreeNode buildSubTree(int[] preorder, int[] inorder,
                                 int preorder_l, int preorder_r, int inorder_l, int inorder_r) {
        if(preorder_l>preorder_r){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorder_l]);
        int inorderidx = indexMap.get(preorder[preorder_l]);    //获取中序下标
        int size = inorderidx - inorder_l; //左子树下标长度
        root.left = buildSubTree(preorder, inorder, preorder_l + 1, preorder_l + size, inorder_l, inorderidx-1);
        /*左子树序列先序为[preorder_root+1, preorder_l + size]，中序为[inorder_l, inorderidx-1]*/
        root.right = buildSubTree(preorder, inorder, preorder_l + size + 1, preorder_r, inorderidx + 1, inorder_r);
        /*右子树先序[preorder_l + size + 1, preorder_r],中序[inorderidx + 1, inorder_r]*/
        return root;
    }
}
