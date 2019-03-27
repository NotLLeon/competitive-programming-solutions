import java.util.*;
public class bts16p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int []names=new int[n];
		String temp=sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for(int i=0;i<n;i++)names[i]=st.nextToken().charAt(0);
		long total=n, adj=1;
		for(int i=0;i<n;i++){
			if(i<n-1&&(names[i]==names[i+1]||Math.abs(names[i]-names[i+1])==32)){
				adj++;
			}else{
				for(int j=1;j<adj;j++)total+=j;
				adj=1;
			}
		}
		System.out.println(total);

	}

}
