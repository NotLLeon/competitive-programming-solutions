import java.util.*;
import java.io.*;
public class ccoprep1p2 {
	static boolean [][] adj, bridge;
	static int []disc, parent, low, ind;
	static boolean[]ap, vis, visc, v;
	static int time, c;
	static long size[];
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		while(true){
			int n=r.nextInt(); 
			time=c=0;
			if(n==0)break;
			adj=new boolean[401][401];
			ap=new boolean[401];
			vis=new boolean[401];
			disc=new int[401];
			parent=new int[401];
			low=new int[401];
			ind=new int[401];
			bridge=new boolean[401][401];
			boolean []used=new boolean[401], visc=new boolean[401];
			Arrays.fill(parent, -1);
			for(int i=0;i<401;i++)ind[i]=i;
			for(int i=0;i<n;i++){
				int n1=r.nextInt()-1, n2=r.nextInt()-1;
				adj[n1][n2]=adj[n2][n1]=true;
				used[n1]=used[n2]=true;
			}
			for(int i=0;i<401;i++)if(!vis[i]&&used[i])DFS(i);
			vis=new boolean[401];
			size=new long[401];
			long second=1;
			for(int i=0;i<401;i++){
				if(vis[i]||!used[i]||ap[i])continue;
				size[ind[i]]=BFS1(i);
				second*=size[ind[i]];
			}
			long ans1=0, ans2=1;
			for(int i=0;i<401;i++){
				if(visc[ind[i]]||!used[i]||ap[i])continue;
				visc[ind[i]]=true;
				long x=BFS2(i);
				if(x==-1)continue;
				ans1++;
				ans2*=x;
			}
			if(ans1==1){
				ans1=2;
				ans2=0;
				second--;
				while(second>0)ans2+=second--;
			}
			System.out.println(ans1+" "+ans2);
		}
	} 
	static void DFS(int node){
		int children=0;
		vis[node]=true;
		disc[node]=low[node]=++time;
		for(int i=0;i<401;i++){
			if(!adj[node][i])continue;
			if (!vis[i]){
				children++;
				parent[i]=node;
				DFS(i);
				low[node]=Math.min(low[node], low[i]);
				if((parent[node]==-1&&children>1)||(parent[node]!=-1&&low[i]>=disc[node]))ap[node]=true;
				if(low[i]>disc[node])bridge[i][node]=bridge[node][i]=true;
			}else if(i != parent[node]){
				low[node]=Math.min(low[node], disc[i]);
			}
		}
	}
	static long BFS1(int node){
		Queue<Integer>q=new LinkedList<Integer>();
		q.add(node);
		vis[node]=true;
		long cnt=1;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i=0;i<401;i++){
				if(adj[cur][i]&&!vis[i]&&!ap[i]&&!bridge[cur][i]){
					vis[i]=true;
					q.add(i);
					ind[i]=node;
					cnt++;
				}
			}
		}
		return cnt;
	}
	static long BFS2(int node){
		Queue<Integer>q=new LinkedList<Integer>();
		q.add(node);
		vis=new boolean[401];
		vis[node]=true;
		int cnt=0;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i=0;i<401;i++){
				if(!adj[cur][i]||vis[i])continue;
				vis[i]=true;
				if(ap[i]){
					cnt++;
					continue;
				}
				q.add(i);
			}
		}
		if(cnt>=2)return -1;
		return size[ind[node]];
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