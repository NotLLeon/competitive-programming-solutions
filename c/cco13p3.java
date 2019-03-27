import java.io.*;
import java.util.*;

public class cco13p3 {
	static LinkedList<Integer>[]adj;
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt();
		int []dc=new int[n];
		Queue<Integer>q=new LinkedList<Integer>();
		adj=new LinkedList[n];
		for(int i=0;i<n;i++)adj[i]=new LinkedList<Integer>();
		for(int i=0;i<n-1;i++){
			int n1=r.nextInt()-1, n2=r.nextInt()-1;
			adj[n1].add(n2);adj[n2].add(n1);
		}
		for(int i=0;i<n;i++){
			dc[i]=adj[i].size();
			if(adj[i].size()==1){
				q.add(i);
				dc[i]--;
			}
		}
		int ctr=-1;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i:adj[cur]){
				dc[i]--;
				if(dc[i]==1){
					q.add(i);
				}
			}
			ctr=cur;
		}
		long[]best=new long[2];
		int ind=0;
		LinkedList<Long>f=new LinkedList<Long>();
		long first=0, firstf=0, sec=0, secf=0, total=0;
		for(int i:adj[ctr]){
			best=solve(i, ctr);
			if(best[0]>first){
				sec=first;
				secf=total;
				first=best[0];
				f=new LinkedList<Long>();
				firstf=best[1];
				total=best[1];
				f.add(best[1]);
			}else if(best[0]==first){
				f.add(best[1]);
				total+=best[1];
			}else if(best[0]>sec){
				sec=best[0];
				secf=best[1];
			}else if(best[0]==sec){
				secf+=best[1];
			}
			ind++;
		}
		if(f.size()>1){
			long ans=0, cnt=0;
			while(!f.isEmpty()){
				long t=f.poll();
				ans+=cnt*t;
				cnt+=t;
			}
			System.out.println(first*2+1+" "+ans);
		}else{
			System.out.println(first+sec+1+" "+secf*firstf);
		}
	}
	static long[] solve(int cur, int prev){
		long[]ans=new long[2], temp=new long[2];
		boolean flag=false;
		for(int i:adj[cur]){
			if(i!=prev){
				flag=true;
				temp=solve(i, cur);
				if(temp[0]>ans[0]){
					ans[0]=temp[0];
					ans[1]=temp[1];
				}else if(temp[0]==ans[0]){
					ans[1]+=temp[1];
				}
			}
		}
		ans[0]++;
		if(!flag)return new long[]{1,1};
		else return ans;
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