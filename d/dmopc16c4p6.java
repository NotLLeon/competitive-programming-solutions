import java.util.*;
import java.io.*;
public class dmopc16c4p6 {
	//uses reader
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
	static class node{
		int h, ind;
		long l, r;
		node(int a, int b){
			h=a;
			ind=b;
			l=r=1;
		}
	}
	public static void main(String[] args) throws IOException {
		Reader r=new Reader();
		int N=r.nextInt(), q=r.nextInt();
		long[]ans=new long[1000002];
		Stack<node>s=new Stack<node>();
		s.push(new node(-1, 0));
		for(int i=0;i<N;i++){
			int h=r.nextInt();
			node n=new node(h, i+1);
			n.r=N-i;
			while(s.peek().h>h){
				node p=s.pop();
				long old=p.l*p.r;
				p.r=Math.min(p.r, n.ind-p.ind);
				ans[p.h]+=p.l*p.r-old;
			}
			int lr=n.ind-s.peek().ind;
			n.l=lr;
			if(s.peek().h==h){
				s.peek().r=lr;
			}
			s.push(n);
			ans[n.h]+=n.l*n.r;
		}
		for(int i=1;i<ans.length;i++){
			ans[i]=ans[i]+ans[i-1];
		}
		for(int i=0;i<q;i++){
			int t=r.nextInt();
			System.out.println(ans[r.nextInt()]-ans[t-1]);
		}
	}
}