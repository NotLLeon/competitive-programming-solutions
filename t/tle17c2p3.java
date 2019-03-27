import java.io.*;
import java.util.*;
public class tle17c2p3 {
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
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(),k=r.nextInt();
		int [][]adj=new int[n][5];
		for(int i=0;i<n;i++){
			adj[i][0]=r.nextInt();
			adj[i][1]=r.nextInt();
			adj[i][2]=r.nextInt();
			adj[i][3]=r.nextInt();
			adj[i][4]=r.nextInt();
		}
		double t1=Math.abs(adj[0][0]-adj[0][2])/adj[0][4];
		for(int i=1;i<n;i++){
			if(Math.abs(adj[i][1]-adj[0][1])<=k){
				double ex=Math.sqrt(Math.pow(k,2)-Math.pow(Math.abs(adj[i][1]-adj[0][1]), 2));
				double time=ex/adj[i][4];
				double t2=Math.abs(adj[i][0]-adj[i][2])/adj[i][4];
				if((adj[i][0]<adj[i][2]&&adj[0][0]>adj[0][2])||(adj[i][0]>adj[i][2]&&adj[0][0]<adj[0][2])){
					System.out.println(i+1);
				}else if(t2<=t1){
					System.out.println(i+1);
				}else if(t2-t1<=ex){
					System.out.println(i+1);
				}
			}
		}
	}
}
