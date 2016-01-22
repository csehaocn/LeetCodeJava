// The trick here is to find the potential pivot for the left and right half.
//
// Then use min to get the right pivot. 
//
// For the Divide and Conquer, sometimes we do not get the direct divided result, we get something close, then use function to process them. Function like Min and Max.
//
// The pivot obviously has the property it is the minimum, the left most minimum in the array.
// Think about this property, then we can use it.
public class Solution {
    public int findMinHelper(int[] num, int l, int u){
        
        if(u == l)
            return num[l];
    
        if(num[u] > num[l])
            return num[l];
    
        int m = (u + l)/2;
        
        int leftPivot = findMinHelper(num, l, m);
        int rightPivot = findMinHelper(num, m+1, u);
        return Math.min(leftPivot, rightPivot);
        
    }
    public int findMin(int[] num) {
        int len = num.length;
        
        return findMinHelper(num, 0, len-1);
        
    }
}
