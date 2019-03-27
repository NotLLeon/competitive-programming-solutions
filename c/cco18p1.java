import java.util.*;
public class cco18p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String s1=sc.nextLine();
		int[]n1=new int[n], n2=new int[n];
		for(int i=0;i<n;i++)n1[i]=sc.nextInt();
		sc.nextLine();
		String s2=sc.nextLine();
		for(int i=0;i<n;i++)n2[i]=sc.nextInt();
		int[][]dp=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i!=0)dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
				if(j!=0)dp[i][j]=Math.max(dp[i][j], dp[i][j-1]);
				if((s1.charAt(i)=='W'&&s2.charAt(j)=='L'&&n1[i]>n2[j])
						||(s1.charAt(i)=='L'&&s2.charAt(j)=='W'&&n1[i]<n2[j])){
					if(i==0&&j==0)dp[i][j]=n1[i]+n2[j];
					else if(i==0)dp[i][j]=Math.max(dp[i][j], dp[i][j-1]);
					else if(j==0)dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
					else dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+n1[i]+n2[j]);
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
	}
}