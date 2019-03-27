import java.io.*;
import java.util.*;

public class bts17p7 {
	static int[][]LCA;
	static int[]lvl;
	static long[] val, inc, end;
	static int n, s, lg, d;
	static LinkedList<Integer>[]adj;
	static int[] getLCA(int x, int y){
		d=0;
		if(x==y)return new int[]{x,0};
		return findLCA(x,y,lg-1);
	}
	static int[] findLCA(int x, int y, int ind){
		if(ind<0){
			d+=2*Math.pow(2, ind+1);
			return new int[]{LCA[x][0],d};
		}
		if(lvl[x]!=lvl[y]){
			if(lvl[x]>lvl[y])x=mkLvl(x,lvl[x]-lvl[y]);
			else if(lvl[y]>lvl[x])y=mkLvl(y,lvl[y]-lvl[x]);
			if(x==y)return new int[]{x,d};
		}
		if(LCA[x][ind]==LCA[y][ind]||LCA[x][ind]==-1||LCA[y][ind]==-1){
			return findLCA(x,y,ind-1);
		}
		d+=2*Math.pow(2, ind);
		return findLCA(LCA[x][ind],LCA[y][ind],lg-1);
	}
	static int mkLvl(int x, int dis){
		d+=dis;
		int i=dis&-dis;
		while(dis>0){
			x=LCA[x][log(i)];
			dis-=i;
		}
		return x;
	}
	public static void main(String[] args)throws IOException {
		Reader r = new Reader();
		n=r.nextInt(); s=r.nextInt(); lg=(int)Math.ceil(Math.log(n)/Math.log(2))+1;
		LCA=new int[n][lg];
		lvl=new int[n];
		adj=new LinkedList[n];
		for(int i=0;i<n;i++)adj[i]=new LinkedList<Integer>();
		for(int i=0;i<n-1;i++){
			int x=r.nextInt()-1, y=r.nextInt()-1;
			adj[x].add(y);adj[y].add(x);
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<lg;j++){
				LCA[i][j]=-1;
			}
		}
		Queue<Integer>q=new LinkedList<Integer>();
		q.add(0);
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int nxt:adj[cur]){
				if(LCA[cur][0]!=nxt){
					LCA[nxt][0]=cur;
					lvl[nxt]=lvl[cur]+1;
					q.add(nxt);
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=1;j<lg;j++){
				if(LCA[i][j-1]!=-1)LCA[i][j]=LCA[LCA[i][j-1]][j-1];
			}
		}
		val=new long[n]; inc=new long[n]; end=new long[n];
		for(int i=0;i<s;i++){
			int a=r.nextInt()-1, b=r.nextInt()-1, t=r.nextInt()-1;
			int []lca1=getLCA(a,b),lca2=getLCA(lca1[0],t), lca3=getLCA(a,t), lca4=getLCA(b,t);
			
			// make simpler V V
			if(lca1[0]!=lca2[0]){ // 1
				System.out.println(1);
				if(lca1[0]==a){
					val[b]+=lca4[1];
					inc[a]+=1;
					inc[b]+=-1;
				}else if(lca1[0]==b){
					val[a]+=lca3[1];
					inc[a]+=-1;
					inc[b]+=1;
				}else{
					val[b]+=lca4[1];
					val[a]+=lca3[1];
					inc[a]+=-1;
					inc[b]+=-1;
					inc[lca1[0]]+=2;
				}
				end[lca1[0]]-=lca2[1];
			}else if(lca1[0]==a){ // 2
				System.out.println(2);
				end[a]-=lca3[1];
				val[b]+=lca4[1];
				if(lca4[0]==t){ // 2a. and 2c.
					inc[b]+=-1;
					inc[t]+=2;
					inc[a]+=-1;
				}else{ // 2b.
					inc[b]+=1;
					inc[a]+=-1;
				}
			}else if(lca1[0]==b){
				System.out.println(2);
				end[b]-=lca4[1];
				val[a]+=lca3[1];
				if(lca3[0]==t){ // 2a. and 2c.
					inc[b]+=-1;
					inc[t]+=2;
					inc[a]+=-1;
				}else{ // 2b.
					inc[b]+=-1;
					inc[a]+=1;
				}
			}else if(lca1[0]==lca2[0]){ // 3
				System.out.println(3);
				val[a]+=lca3[1];
				val[b]+=lca4[1];
				if(lca3[0]==t||lca4[0]==t){
					inc[a]+=-1;
					inc[t]+=2;
					inc[b]+=-1;
				}else if(lca3[0]==a){
					inc[a]+=1;
					inc[b]+=-1;
				}else if(lca4[0]==b){
					inc[b]+=1;
					inc[a]+=-1;
				}else{
					inc[a]+=-1;
					inc[b]+=-1;
					inc[lca1[0]]+=2;
					end[lca1[0]]-=lca2[1];
				}
			}
		}
		solve(0,-1);
		for(int i=0;i<n;i++){
			System.out.print(val[i]+" ");
		}
	}
	static void solve(int cur, int prev){
		for(int i:adj[cur]){
			if(i!=prev){
				solve(i,cur);
				val[cur]+=val[i]+inc[i]+end[i];
				inc[cur]+=inc[i];
			}
		}
	}
	static int log(int x){
		int cnt=0;
		while(x>1){
			x>>=1;
			cnt++;
		}
		return cnt;
	}
	static class Reader
	{
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader()
		{
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException
		{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			}  while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException
		{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');

			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}


}