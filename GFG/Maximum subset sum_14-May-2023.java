//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        long [] dp = new long[N+1];
        Arrays.fill(dp,-1);
        return findMaxSubsetSum(N-1,A,0,dp);
    }
    public static long findMaxSubsetSum(int n, int[] A, int ind, long[] dp) {
        // code here
        if(ind>n){
            return 0;
        }
        if(dp[ind]!=-1) return dp[ind];
        
        long take = A[ind]+findMaxSubsetSum(n,A,ind+1,dp);
        long notake = 0;
        if(ind+1 <= n){
            notake = A[ind+1]+findMaxSubsetSum(n,A,ind+2,dp);
        }
        
        return dp[ind] = Math.max(take,notake);
    }
    
}
        
