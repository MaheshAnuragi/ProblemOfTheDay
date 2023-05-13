class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length-1;
        long [] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return mostPoints(questions, 0, dp ,n);
    }
    // Recursion
    // public long mostPoints(int[][] questions, int index) {
        
    //     if(index > questions.length-1){
    //         return 0;
    //     }

    //     long skip = 0 + mostPoints(questions,index+1);
    //     long solve = questions[index][0] + mostPoints(questions,questions[index][1]+index+1);

    //     return Math.max(skip,solve);
    // }

    // DP by Memoization

    public long mostPoints(int[][] questions, int index , long []dp, int n){
        
        if(index > n){
            return 0;
        }

        if(dp[index]!=-1) return dp[index];

        long skip = 0 + mostPoints(questions,index+1,dp,n);
        long solve = questions[index][0] + mostPoints(questions,questions[index][1]+index+1,dp,n);

        return dp[index] = Math.max(skip,solve);
    }

}