package T102二叉树的层序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        if(root!=null){
            dfs(res,root,0);
        }
        return res;
    }
    public void dfs(List<List<Integer>> res,TreeNode node, int level){
        if(res.size()==level){
            res.add(new ArrayList());
        }
        res.get(level).add(node.val);
        if (node.left != null) {
            dfs(res,node.left,level+1);
        }
        if (node.right != null) {
            dfs(res,node.right,level+1);
        }
    }
}
