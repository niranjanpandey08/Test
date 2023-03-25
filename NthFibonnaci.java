
import java.util.*;

public class NthFibonnaci {

	public static int solveRecursion(int n) {

		if(n == 0) return 0;
		if(n == 1) return 1;

		return solveRecursion(n-1) + solveRecursion(n-2);
	}

	public static int solveDP(int n, int dp[]) {

		//Memorization Method
		//Top Down

		if(n == 0) return 0;
		if(n == 1) return 1;

		if(dp[n] != -1)
		return dp[n];
	    return dp[n] = solveDP(n-1,dp) + solveDP(n-2,dp); 
	}

	public static int solveTabu(int n, int dp[]) {

		//Tabulation Method
		//Bottom Up

		dp[0] = 0;
		dp[1] = 1;

		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}

	public static int solveBest(int n) {

		int prev = 0;
		int curr = 1;

		for(int i=2; i<=n; i++) {
			int next = prev + curr;
			prev = curr;
			curr = next;
		}
		return curr;
	}

	public static void main(String[] args) {

		int n = 5;
		int ans = solveRecursion(n);
		System.out.println("Recursion : "+ans);

		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);

		ans = solveDP(n, dp);
		System.out.println("DP First : "+ans);

		ans = solveTabu(n, dp);
		System.out.println("DP Second : "+ans);

		ans = solveBest(n);
		System.out.println("Best Method : "+ans);
	}
}