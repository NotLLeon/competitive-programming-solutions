import java.util.*;
public class dwite12c2p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=0;t<5;t++){
			int n=sc.nextInt(), cnt=n;
			int[]cards=new int[n], ans=new int[n];
			boolean[]v=new boolean[n];
			boolean flag=false;
			for(int i=0;i<n;i++){
				cards[i]=sc.nextInt();
				v[i]=true;
			}
			for(int i=0;i<n;i++){
				if(cards[i]>=cnt){
					System.out.println("IMPOSSIBLE");
					flag=true;
					break;
				}
				int ind=0;
				for(int j=n-1;j>=0;j--){
					if(v[j]){
						if(ind==cards[i]){
							v[j]=false;
							cnt--;
							ans[i]=j+1;
							break;
						}
						ind++;
					}
				}
			}
			if(flag)continue;
			for(int i=0;i<n;i++)System.out.print(ans[i]+" ");
			System.out.println();
			
			
		}

	}

}
