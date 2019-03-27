import java.util.*;
import java.io.*;
public class dmopc15c2p4 {
	static int n;
	static anime[]a;
	static long[]dp;
	static class anime implements Comparable<anime>{
		long a, b, h;
		anime(long a1,long a2, long a3){
			a=a1;b=a2;h=a3;
		}
		public int compareTo(anime e){
			if(this.b<e.b)return -1;
			return 1;
		}
	}
	public static void main(String[] args)throws IOException {
		Reader sc = new Reader();
		n=sc.nextInt();
		a=new anime[n];
		dp=new long[n];
		for(int i=0;i<n;i++){
			long r=sc.nextLong(), l=sc.nextLong(), h=sc.nextLong();
			a[i]=new anime(r,r+l,h);
		}
		Arrays.sort(a);
		dp[0]=a[0].h;
		for(int i=1;i<n;i++){
			long cur=a[i].h;
			int l=bSearch(0,i,a[i].a);
			if(l!=-1)cur+=dp[l];
			dp[i]=Math.max(dp[i-1], cur);
		}
		System.out.println(dp[n-1]);
	}
	static int bSearch(int lo, int hi, long val){
		if(lo>hi)return -1;
		int mid=(lo+hi)/2;
		if(a[mid].b<=val&&a[mid+1].b>val)return mid;
		if(a[mid].b<=val)lo=mid+1;
		else hi=mid-1;
		return bSearch(lo, hi, val);
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
