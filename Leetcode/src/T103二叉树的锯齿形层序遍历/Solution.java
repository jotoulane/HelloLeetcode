package T103二叉树的锯齿形层序遍历;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        if(root!=null){
            dfs(res,root);
        }
        return res;
    }
    public void dfs(List<List<Integer>> ans, TreeNode node){
        Queue<TreeNode> nodeQueue = new ArrayDeque();
        nodeQueue.offer(node);
        boolean isOrderLeft = true;
        while (!nodeQueue.isEmpty()){
            Deque<Integer> levelList = new LinkedList();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList(levelList));
            isOrderLeft = !isOrderLeft;
        }
    }
}
