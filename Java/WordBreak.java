import java.util.*;

public class WordBreak{
    
    public boolean wordBreakAux(String s, Set<String> wordDict, int[] dp){
        
        int sLen = s.length();
        int wSize = wordDict.size();
        int dLen = dp.length;
        
        if( 0 == sLen)
            return true;
            
        if( 0 == wSize)
            return false;
            
        if(0 == dp[sLen]){
            for(int i = 0; i<=sLen; ++i){
                if(wordDict.contains(s.substring(i, sLen)) && wordBreakAux(s.substring(0,i), wordDict, dp)){
                    dp[sLen] = 1;
                    break;
                }
            }
            if(0 == dp[sLen])
            {
                dp[sLen] = -1;
            }
        }
        
        if(1 == dp[sLen])
            return true;
            
        if(-1 == dp[sLen])
            return false;
            
        return false;
        
    }
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        int sLen = s.length();
        
        int[] dp = new int[sLen+1];
        
        for(int i = 0; i <= sLen; ++i){
            dp[i] = 0;
        }
        
        return wordBreakAux(s, wordDict, dp);
           
    }
}
