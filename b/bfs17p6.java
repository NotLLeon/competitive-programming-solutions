import java.util.*;
import java.io.*;
public class bfs17p6 {
	// not complete
	static int n;
	static long[][]bit;
	static int[][]inds;
	static int[]prev;
	static block[]bs;
	static class block implements Comparable<block>{
		int l,w,h, ind;
		long pop;
		block(int a, int b, int c, int d, long e){
			l=Math.max(a, b);
			w=Math.min(a, b);
			h=c;
			ind=d;
			pop=e;
		}
		public int compareTo(block e){
			if(this.h==e.h){
				if(this.l==e.l)return this.w-e.w;
				return this.l-e.l;
			}
			return this.h-e.h;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		bit=new long[5001][5001];
		inds=new int[n+1][n+1];
		prev=new int[n];
		bs=new block[n];
		StringTokenizer st;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			bs[i]=new block(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),i,Long.parseLong(st.nextToken()));
		}
		Arrays.sort(bs);
		
	}
	static void update(int i, int j,long pop, int ind){
		i++;j++;
		for(;i<bit.length;i+=(i&-i)){
			for(int k=j;k<bit.length;k+=(k&-k)){
				if(pop>bit[i][k]){
					bit[i][k]=pop;
					inds[i][k]=ind;
				}
			}
		}
	}
	static long query(int i, int j, int ind){
		i++;j++;
		long cur=0;
		int mi=0;
		for(;i>0;i-=(i&-i)){
			for(int k=j;k>0;k-=(k&-k)){
				if(bit[i][k]>cur){
					cur=bit[i][k];
					mi=inds[i][k];
				}
			}
		}
		prev[ind]=mi;
		return cur;
	}

}
