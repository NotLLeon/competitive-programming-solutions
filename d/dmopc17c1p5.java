import java.io.*;
import java.util.*;

public class dmopc17c1p5 {
	static class query implements Comparable<query>{
		int l, r, ind;
		query(int a, int b, int c){
			l=a;
			r=b;
			ind=c;
		}
		public int compareTo(query e){
			if(this.l < e.l)return 1;
			else return -1;
		}
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
	static int []bit;
	public static void main(String[] args) throws IOException{
		Reader r = new Reader();
		int n=r.nextInt(), q=r.nextInt();
		bit=new int[n+1];
		int []ans=new int[q];
		LinkedList<Integer> []dep=new LinkedList[n+1];
		for(int i=0;i<=n;i++)dep[i]=new LinkedList<Integer >();
		Stack<int[]>s=new Stack<int[]>();
		s.add(new int[]{Integer.MAX_VALUE, 0});
		for(int i=0;i<n;i++){
			int a=r.nextInt();
			while(a>s.peek()[0]){
				s.pop();
			}
			dep[s.peek()[1]].add(i+1);
			s.add(new int[]{a,i+1});
		}
		PriorityQueue<query>qs=new PriorityQueue<query>();
		for(int i=0;i<q;i++){
			qs.add(new query(r.nextInt(), r.nextInt(),i));
		}
		for(int i=0;i<q;i++){
			query d=qs.poll();
			System.out.println(dep[d.l-1]+" "+d.l);
			for(int j=0;j<dep[d.l-1].size();j++){
				int nxt=dep[d.l-1].poll();
				update(nxt, 1);
				System.out.println(nxt+"nxt");
				for(int l=0;l<dep[nxt].size();l++){
					int k1=dep[nxt].poll();
					update(k1, -1);
					dep[nxt].add(k1);
				}
				dep[d.l-1].add(nxt);
			}
			ans[d.ind]=getSum(d.r);
		}
		for(int i=0;i<q;i++){
			System.out.println(ans[i]);
		}
	}
	static void update(int idx, int val){
		for(;idx<=bit.length;idx+=(-idx&idx)){
			bit[idx-1]+=val;
		}
	}
	static int getSum(int idx){
		int sum=0;
		for(;idx>0;idx-=(-idx&idx)){
			sum+=bit[idx-1];
		}
		return sum;
	}
}