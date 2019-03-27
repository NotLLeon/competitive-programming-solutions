import java.io.*;
import java.util.*;
public class dmopc14c4p3 {
	static int[][]ways, adj, dp;
	static int g1, g2, l, d;
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
			byte[] buf = new byte[64];
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
		l=r.nextInt(); d=r.nextInt();
		adj=new int[d][l];
		dp=new int[d][l];
		dp[0][0]=adj[0][0];
		ways=new int[][]{{1,0}, {0,1},{0,-1}};
		for(int i=0;i<d;i++){
			for(int j=0;j<l;j++){
				adj[i][j]=r.nextInt();
			}
		}
		g1=r.nextInt(); g2=r.nextInt();
		System.out.println(solve(0,0,-1,-1));
	}
	static int solve(int r, int c, int pr, int pc){
		for(int i=0;i<d;i++){
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println();
		if(r==g2&&c==g1)return adj[g2][g1];
		int min=999999999;
		for(int i=0;i<ways.length;i++){
			int nr=r+ways[i][0], nc=c+ways[i][1];
			if(nr<d&&nc>=0&&nc<l&&(nr!=pr||nc!=pc)){
				if(dp[nr][nc]==0)dp[nr][nc]=solve(nr, nc, r, c);
				min=Math.min(min,dp[nr][nc]);
			}
		}
		return min+adj[r][c];
	}
}