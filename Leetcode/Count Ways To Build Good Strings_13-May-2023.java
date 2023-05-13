class Solution {

    // By Recursion

    // public int countGoodStrings(int low, int high, int zero, int one) {
        
    //     int ans = 0;
    //     for(int len=low;len<=high;len++){
    //         ans=(ans+countGoodStrings(len,zero,one))%1000000007;
    //     }
    //     return ans;
    // }

    // public int countGoodStrings(int len, int zero, int one) {
        
    //     if(len==0) return 1;
    //     if(len<0) return 0;

    //     int sum = (countGoodStrings(len-zero,zero,one) + countGoodStrings(len-one,zero,one))%1000000007;

    //     return sum;
    // }

    // By Memoization
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp,-1);
        int ans = 0;
        for(int len=low;len<=high;len++){
            ans=(ans+countGoodStrings(len,zero,one,dp))%1000000007;
        }
        return ans;
    }

    public int countGoodStrings(int len, int zero, int one, int [] dp) {
        
        if(len==0) return 1;
        if(len<0) return 0;
        if(dp[len]!=-1) return dp[len];

        dp[len] = (countGoodStrings(len-zero,zero,one,dp) + countGoodStrings(len-one,zero,one,dp))%1000000007;

        return dp[len];
    }
}