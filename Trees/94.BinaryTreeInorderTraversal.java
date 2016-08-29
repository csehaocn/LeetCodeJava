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
        
        /* Let's do a little bit of exploration as well
            1.  Normal edition: with pointer and stack
            2.  Pointer non-null edition
        */
        
        /* 1. Normal edition
        
        List<Integer> res = new ArrayList<Integer>();
        if(null == root)
            return res;
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        
        while(!s.isEmpty() || null != c){
            if(null == c){
                TreeNode t = s.pop();
                res.add(t.val);
                c = t.right;
            }else{
                s.push(c);
                c = c.left;
            }
        }
        
        return res;
        */
        
        /* Pointer non-null edition
            To summary: the non-null edition seems always messier than null enable version.
            Due to multiple additional if elses, it might actually run slower.
        */
        
        List<Integer> res = new ArrayList<Integer>();
        if(null == root)
            return res;
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        
        while(true){
            if(null == c.left){
                res.add(c.val);
                if(null == c.right){
                    while(!s.isEmpty() && null == s.peek().right){
                        res.add(s.pop().val);
                    }
                    if(s.isEmpty()){
                        return res;
                    }else{
                        res.add(s.peek().val);
                        c = s.pop().right;
                    }
                }else{
                    c = c.right;
                }
            }else{
                s.push(c);
                c = c.left;
            }
            
        }
        
    }
}
