import java.util.*;
import java.io.*;
public class ccc16s3 {
	static LinkedList<Integer>[]adj;
	static boolean[]pho, dia, used;
	static int[]prev, dis;
	static int n, m;
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		n=r.nextInt(); m=r.nextInt();
		adj=new LinkedList[n];
		for(int i=0;i<n;i++)adj[i]=new LinkedList<Integer>();
		pho=new boolean[n];
		dia=new boolean[n];
		used=new boolean[n];
		int []size=new int[n];
		Arrays.fill(used, true);
		for(int i=0;i<m;i++)pho[r.nextInt()]=true;
		for(int i=0;i<n-1;i++){
			int x=r.nextInt(), y=r.nextInt();
			adj[x].add(y);adj[y].add(x);
			size[y]++;size[x]++;
		}
		boolean []vis=new boolean[n];
		Queue<Integer>q=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			if(!pho[i]&&size[i]<=1){
				q.add(i);
				vis[i]=true;
				used[i]=false;
			}
		}
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i:adj[cur]){
				size[i]--;
				if(!pho[i]&&size[i]<=1&&!vis[i]){
					q.add(i);
					used[i]=false;
					vis[i]=true;
				}
			}
		}
		dis=new int[n];
		prev=new int[n];
		prev[0]=-1;
		for(int i=0;i<n;i++)if(used[i]){DFS1(i);break;}
		int end1=-1, end2=-1, max1=-1, max2=-1;
		for(int i=0;i<n;i++){
			if(dis[i]>max1){
				end1=i;
				max1=dis[i];
			}
		}
		prev[end1]=-1;
		dis[end1]=0;
		DFS1(end1);
		for(int i=0;i<n;i++){
			if(dis[i]>max2){
				end2=i;
				max2=dis[i];
			}
		}
		dia[end1]=true;
		int total=1;
		while(end2!=end1){
			dia[end2]=true;
			total++;
			end2=prev[end2];
		}
		for(int i=0;i<n;i++){
			if(!pho[i]||dia[i])continue;
			prev[i]=-1;
			int []d=DFS2(i);
			total+=d[0]*2;
			while(d[1]!=-1){
				dia[d[1]]=true;
				d[1]=prev[d[1]];
			}
		}
		System.out.println(total-1);
	}

	static void DFS1(int cur){
		for(int i:adj[cur]){
			if(i!=prev[cur]&&used[i]){
				dis[i]=dis[cur]+1;
				prev[i]=cur;
				DFS1(i);
			}
		}
	}
	static int[] DFS2(int cur){
		if(dia[cur])return new int[]{0,cur};
		int min=99999999, ind=-1;
		for(int i:adj[cur]){
			if(i!=prev[cur]&&used[i]){
				prev[i]=cur;
				int[] r=DFS2(i);
				if(r[0]<min){
					min=r[0];
					ind=r[1];
				}
			}
		}
		return new int[]{min+1, ind};
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