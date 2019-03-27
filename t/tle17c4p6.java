import java.util.*;
import java.io.*;
public class tle17c4p6 {
	static int n;
	static long []bit1, bit2, bit3;
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		n=r.nextInt();
		double[]ans=new double[n];
		bit1=new long[30001];bit2=new long[30001];bit3=new long[30001];
		for(int i=0;i<n;i++){
			double x=r.nextInt();
			update(c(x)+1,3*x*x, bit1);
			update(c(x)+1,6*x, bit2);
			update(c(x)+1,3,bit3);
			double mid=0, low=-15000, high=15000, prevm=-1, y=f(mid);
			while(y!=0.0){
				if(prevm==mid)break;
				else if(y>0)low=mid;
				else high=mid;
				prevm=mid;
				mid=(low+high)/2;
				y=f(mid);
			}
			ans[i]=mid;
		}
		for(int i=0;i<n;i++)System.out.printf("%.6f\n", ans[i]);
	}
	static double f(double x){
		double total1=query(bit1.length, bit1)-2*query(c(x)+1, bit1)
				-query(bit1.length, bit2)*x+2*query(c(x)+1, bit2)*x
				+query(bit1.length, bit3)*x*x-2*query(c(x)+1, bit3)*x*x;
		return total1;
	}
	static void update(int i,double v,long[]bit){
		for(;i<=bit.length;i+=(i&-i))bit[i-1]+=v;
	}
	static double query(int i, long[]bit){
		double sum=0;
		for(;i>0;i-=(i&-i))sum+=bit[i-1];
		return sum;
	}
	static int c(double x){
		return (int) Math.floor(15000+x);
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