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
    
    class RetObj{
        
        int mMax;
        int mMin;
        int mCount;
        boolean mIsBST;
        
        public RetObj(int max, int min, int count, boolean isBST){
            mMax = max;
            mMin = min;
            mCount = count;
            mIsBST = isBST;
        }
        
    }
    
    public RetObj largestBSTSubtreeAux(TreeNode root){
        // root != null
        int max = root.val;
        int min = root.val;
        int maxCount = 1;
        int totalCount = 1;
        boolean isBST = true;
        
        if(null != root.left){
            RetObj l = largestBSTSubtreeAux(root.left);
            if(l.mIsBST && l.mMax < root.val){
                ;
            }else{
                isBST = false;
            }
            
            min = l.mMin;
            maxCount = Math.max(maxCount, l.mCount);
            totalCount += l.mCount;
        }
        
        if(null != root.right){
            RetObj r = largestBSTSubtreeAux(root.right);
            if(r.mIsBST && r.mMin > root.val){
                ;
            }else{
                isBST = false;
            }
            
            max = r.mMax;
            maxCount = Math.max(maxCount, r.mCount);
            totalCount += r.mCount;
        }
        
        return new RetObj(max, min, isBST?totalCount:maxCount, isBST);
        
    }
    
    public int largestBSTSubtree(TreeNode root) {
        if(null == root)
            return 0;
            
        RetObj ret = largestBSTSubtreeAux(root);
        return ret.mCount;
        
    }
}
