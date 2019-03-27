import java.util.*;
public class dwite11c4p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=0;t<5;t++){
			for(int t1=0;t1<3;t1++){
				 int n=sc.nextInt();
				 int[]arr=new int[n];
				 int m=0;
				 for(int i=0;i<n;i++)m+=(1<<i);
				 boolean []dp=new boolean[m+1];
				 for(int i=0;i<n;i++)arr[i]=sc.nextInt();
				 for(int i=1;i<dp.length;i++){
					 LinkedList<Integer>T=new LinkedList<Integer>();
					 for(int j=0;j<n;j++)if((i&(1<<j))!=0)T.add(arr[j]);
					 boolean in=true, de=true;
					 int prev=-1;
					 for(int cur:T){
						 if(prev!=-1&&cur>prev)de=false;
						 if(prev!=-1&&cur<prev)in=false;
						 prev=cur;
					 }
					 dp[i]=in||de;
				 }
				 for(int i=1;i<dp.length;i++){
					 if(dp[i])continue;
					 dp[i]=true;
					 for(int j=0;j<n;j++){
						 if(((i&(m-(1<<j)))!=i)&&dp[i&(m-(1<<j))])dp[i]=false;
					 }
				 }
				 if(dp[m])System.out.print('B');
				 else System.out.print('A');
			}
			System.out.println();
		}
	}
}