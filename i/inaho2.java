import java.util.*;
import java.io.*;
public class inaho2 {
	static int n, q;
	static int[]sz, d,bit, ppa;
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		n=r.nextInt(); q=r.nextInt();
		sz=new int[n];
		ppa=new int [n];
		int tsz=1;
		for(int i=0;i<n;i++){
			sz[i]=r.nextInt();
			tsz*=sz[i];
		}
		d=new int[tsz];
		bit=new int[tsz];
		ppa[0]=1;
		for(int i=1;i<n;i++)ppa[i]=ppa[i-1]*sz[i-1];
		while(q-->0){
			int cmd=r.nextInt();
			if(cmd==1){
				int []mv=new int[n];
				for(int i=0;i<n;i++)mv[i]=r.nextInt();
				int x=r.nextInt();
				update(mv, 0, 0, x);
			}else{
				int []mv=new int[n];
				for(int i=0;i<n;i++)mv[i]=r.nextInt();
				for(int i=0;i<n;i++)mv[i]=r.nextInt();
				
			}
		}
	}
	static void update(int[]mv,int cind,int dim,int v){
		if(dim==n||mv[dim]==0)bit[cind]+=v-d[cind];
		else for(int i=mv[dim];i<=sz[dim];i+=i&-i)update(mv, cind+(i-1)*ppa[dim], dim+1, v);
	}
	static int query(int[]mv,int cind,int dim,int v){
		int sum=0;
		if(dim==n||mv[dim]==0)sum=bit[cind];
		else for(int i=mv[dim];i<=sz[dim];i+=i&-i)sum+=query(mv, cind+(i-1)*ppa[dim], dim+1, v);
		return sum;
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
