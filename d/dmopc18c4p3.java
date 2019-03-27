import java.util.*;
import java.io.*;
public class dmopc18c4p3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[]a=new int[n], b=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)a[i]=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)b[i]=Integer.parseInt(st.nextToken());
		boolean[]pb=new boolean[n];
		int cnt=0;
		for(int i=0;i<n;i++){
			if(b[i]<a[i]){
				pb[i]=true;
				cnt++;
			}
		}
		int ans=0;
		if(cnt%2!=0){
			int mi=-1,mi1=-1, ans1=0, ans2=Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				if(pb[i]&&(mi==-1||a[i]-b[i]<a[mi]-b[mi])){
					mi=i;
				}
			}
			pb[mi]=false;
			for(int i=0;i<n;i++){
				if(pb[i])ans1+=b[i];
				else ans1+=a[i];
			}
			pb[mi]=true;
			for(int i=0;i<n;i++){
				if(!pb[i]&&(mi1==-1||b[i]-a[i]<b[mi1]-a[mi1])){
					mi1=i;
				}
			}
			if(mi1!=-1){
				ans2=0;
				pb[mi1]=true;
				for(int i=0;i<n;i++){
					if(pb[i])ans2+=b[i];
					else ans2+=a[i];
				}
			}
			ans=Math.min(ans1, ans2);
		}else{
			for(int i=0;i<n;i++){
				if(pb[i])ans+=b[i];
				else ans+=a[i];
			}
		}
		System.out.println(ans);
	}

}