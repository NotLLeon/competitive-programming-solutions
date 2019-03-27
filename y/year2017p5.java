import java.util.*;
import java.io.*;
public class year2017p5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken()), cnt=0;
		String s=br.readLine();
		boolean[]l=new boolean[n];
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='1'){
				l[i]=true;
				cnt++;
			}
		}
		int ind1=0, ind2=0, c1=0, c2=0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='1'){
				ind1++;
				if(ind1==cnt/2+1)c1=i;
			}else{
				ind2++;
				if(ind2==(n-cnt)/2+1)c2=i;
			}
		}
		int[]p1={c1-1, c1+1}, p2={c2-1, c2+1};
		int ans1=cnt==0?0:1, ans2=cnt==n?0:1, m1=k, m2=k;
		for(int i=1;i<=n;i++){
			if(c1+i-p1[1]<=m1&&c1+i<n&&l[c1+i]){
				ans1++;
				m1-=c1+i-p1[1];
				p1[1]++;
			}
			if(p1[0]-c1+i<=m1&&c1-i>=0&&l[c1-i]){
				ans1++;
				m1-=p1[0]-c1+i;
				p1[0]--;
			}
			if(c2+i-p2[1]<=m2&&c2+i<n&&!l[c2+i]){
				ans2++;
				m2-=c2+i-p2[1];
				p2[1]++;
			}
			if(p2[0]-c2+i<=m2&&c2-i>=0&&!l[c2-i]){
				ans2++;
				m2-=p2[0]-c2+i;
				p2[0]--;
			}
		}
		System.out.println(ans1+" "+ans2);

	}

}
