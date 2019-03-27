import java.util.*;
import java.io.*;
public class valentines19s4 {
	static class seg1 implements Comparable<seg1>{
		int l, r, ind;
		seg1(int a, int b, int i){
			l=a;
			r=b;
			ind=i;
		}
		public int compareTo(seg1 e){
			return this.r-e.r;
		}
	}
	static class seg2 implements Comparable<seg2>{
		int l, r, ind;
		seg2(int a, int b, int i){
			l=a;
			r=b;
			ind=i;
		}
		public int compareTo(seg2 e){
			if(this.l==e.l)return this.r-e.r;
			return this.l-e.l;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		seg1[]s1=new seg1[n];
		seg2[]s2=new seg2[n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken()), e=Integer.parseInt(st.nextToken());
			s1[i]=new seg1(s,e,i);
			s2[i]=new seg2(s,e,i);
		}
		Arrays.sort(s2);
		Arrays.sort(s1);
		int last=0;
		LinkedList<Integer>us=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			if(s2[i].l>last){
				us.add(i);
				last=s2[i].r;
			}
		}
		int max=us.size();
		for(int i:us){
			int cnt=0;
			last=0;
			for(int j=0;j<n;j++){
				boolean cntn=true;
				for(int l:us){
					if(l!=i&&s1[j].r>=s2[l].l&&s1[j].l<=s2[l].r){
						cntn=false;
						break;
					}
				}
				if(!cntn)continue;
				if(s1[j].l>last&&s1[j].ind!=s2[i].ind){
					cnt++;
					last=s1[j].r;
				}
			}
			max=Math.max(max, cnt+us.size()-1);
		}
		System.out.println(max);	
	}
}
