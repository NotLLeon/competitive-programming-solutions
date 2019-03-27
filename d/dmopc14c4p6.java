import java.io.*;
import java.util.*;

public class dmopc14c4p6 {
	static int n;
	static ArrayList<Integer>[]adj;
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
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		n=r.nextInt();
		adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int t=r.nextInt()-1, f=r.nextInt()-1;
			adj[t].add(f);adj[f].add(t);
		}
		int a=BFS(0)[n];
		int []fromA=BFS(a);
		int b=fromA[n];
		int []fromB=BFS(b);
		for(int i=0;i<n;i++){
			System.out.println(Math.max(fromA[i], fromB[i])+1);
		}
	}
	static int[] BFS(int node){
		Queue<Integer>q=new LinkedList<Integer>();
		int []dis=new int[n+1];
		boolean []vis=new boolean[n];
		q.add(node);
		int max=0, maxn=-1;
		vis[node]=true;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int k:adj[cur]){
				if(!vis[k]){
					vis[k]=true;
					q.add(k);
					dis[k]=dis[cur]+1;
					if(dis[k]>max){
						max=dis[k];
						maxn=k;
					}
				}
			}
		}
		dis[n]=maxn;
		return dis;
	}
}