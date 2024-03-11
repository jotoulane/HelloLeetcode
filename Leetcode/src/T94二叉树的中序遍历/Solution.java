package T94二叉树的中序遍历;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
