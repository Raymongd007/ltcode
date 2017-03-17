/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if(!stack.isEmpty()) {
                TreeNode p = stack.peek();
                if(p.left.val == node.val && node.right == null) {
                    stack.pop();
                    ret.add(p.val);
                    putLeft(p.right,stack);
                } else {
                    putLeft(node.right,stack);
                }
            }else {
                putLeft(node.right,stack);
            }
            
        }
        return ret;
        
    }
    
    public void putLeft(TreeNode root,Stack<TreeNode> stack) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
