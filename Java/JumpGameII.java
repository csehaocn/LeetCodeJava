
public class Solution {
    public int jump(int[] A) {
        int Alen = A.length; 
        if(0 == Alen)
            return 0;
        int c_span = 0;
        int n_span = 0;
        int steps = 0;
        for(int i = 0; i != Alen; ++i){


            if(i > c_span){
                // not in curr span
                if(i > n_span){
                    // not reachable
                    return -1;
                }
                else{
                
                //
                //Notice here, in the first version, I updated 
                //n_span = Math.max(n_span, A[i]+1) first
                //then here, after updating c_span n_span in special condition,
                //n_span = Math.max is not updated and i++ is trigered in for loop
                    c_span = n_span;
                    steps++;
                    if(c_span >= Alen-1)
                        return steps;
                }
            }
            // in curr span
            n_span = Math.max(n_span, A[i]+i);
        }
        
        return steps;
    }
}
