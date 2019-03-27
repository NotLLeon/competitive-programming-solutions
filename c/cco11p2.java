import java.util.*;
import java.io.*;
public class cco11p2 {
	static class pair implements Comparable<pair>{
		int ind, dis;
		pair(int a, int b){
			ind=a;
			dis=b;
		}
		public int compareTo(pair e){
			if(this.dis < e.dis)return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int k=r.nextInt(), n=r.nextInt(), m=r.nextInt();
		LinkedList<Integer> [][]adj=new LinkedList[n][3];
		for(int i=0;i<n;i++){
			adj[i][0]=new LinkedList<Integer>();adj[i][1]=new LinkedList<Integer>();adj[i][2]=new LinkedList<Integer>();
		}
		for(int i=0;i<m;i++){
			int a=r.nextInt(), b=r.nextInt(),t=r.nextInt(), h=r.nextInt();
			adj[a][0].add(b);adj[a][1].add(t);adj[a][2].add(h);
			adj[b][0].add(a);adj[b][1].add(t);adj[b][2].add(h);
		}
		int A=0, B=n-1;
		PriorityQueue<pair>q=new PriorityQueue<pair>();
		int [][]dis=new int[n][k];
		for(int i=0;i<n;i++){
			for(int j=0;j<k;j++){
				dis[i][j]=99999999;
			}
		}
		boolean[]vis=new boolean[n];
		vis[A]=true;
		dis[A][0]=0;
		q.add(new pair(A,0));
		while(!q.isEmpty()){
			int cur=q.poll().ind;
			vis[cur]=false;
			for(int i=0;i<adj[cur][0].size();i++){
				int l=adj[cur][0].get(i);
				for(int j=0;j+adj[cur][2].get(i)<k;j++){
					int hl=dis[cur][j]+adj[cur][1].get(i);
					if(hl<dis[l][j+adj[cur][2].get(i)]){
						dis[l][j+adj[cur][2].get(i)]=hl;
						if(!vis[l]){
							q.add(new pair(l, hl));
							vis[l]=true;
						}
					}
				}
			}
		}
		int min=99999999;
		for(int i=0;i<k;i++)min=Math.min(min, dis[B][i]);
		if(min==99999999)System.out.println(-1);
		else System.out.println(min);
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