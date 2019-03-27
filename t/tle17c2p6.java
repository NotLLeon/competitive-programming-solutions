import java.io.*;
import java.util.*;
public class tle17c2p6 {
	static int h, l;
	static long[][]adj, way;
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
		Reader re = new Reader();
		int n=re.nextInt();
		h=re.nextInt(); l=re.nextInt();
		int s=re.nextInt();
		adj=new long[h][l+1];
		way=new long[h][l+1];
		for(int i=0;i<h;i++){
			for(int j=0;j<=l;j++){
				way[i][j]=-1;
			}
		}
		way[0][s]=0;
		for(int i=0;i<n;i++){
			int x=re.nextInt();
			adj[re.nextInt()][x]=1;
		}
		System.out.println(getWays(0,s,-1,-1)%1000000007);
	}
	static long getWays(int r, int c, int pr, int pc){
		if(c==l)return 1;
		long ways=0;
		if(c+1<l+1&&adj[r][c+1]!=1&&(r!=pr||c+1!=pc)){
			if(way[r][c+1]==-1)way[r][c+1]=getWays(r, c+1, r, c);
			ways+=way[r][c+1];
		}
		if(c+1<l+1&&r+1<h&&adj[r+1][c+1]!=1&&(r+1!=pr||c+1!=pc)){
			if(way[r+1][c+1]==-1)way[r+1][c+1]=getWays(r+1, c+1, r, c);
			ways+=way[r+1][c+1];
		}
		if(c+1<l+1&&r-1>=0&&adj[r-1][c+1]!=1&&(r-1!=pr||c+1!=pc)){
			if(way[r-1][c+1]==-1)way[r-1][c+1]=getWays(r-1, c+1, r, c);
			ways+=way[r-1][c+1];
		}
		if(c+1<l+1){
			if((r+1>=h||adj[r+1][c+1]==1)&&(r-1<0||adj[r-1][c+1]==1)&&adj[r][c+1]==1){
				if(r+1<h&&adj[r+1][c]!=1&&(r+1!=pr||c!=pc)){
					if(way[r+1][c]==-1)way[r+1][c]=getWays(r+1, c, r, c);
					ways+=way[r+1][c];
				}
				if(r-1>=0&&adj[r-1][c]!=1&&(r-1!=pr||c!=pc)){
					if(way[r-1][c]==-1)way[r-1][c]=getWays(r-1, c, r, c);
					ways+=way[r-1][c];
				}
			}
		}
		way[r][c]=ways%1000000007;
		return way[r][c];
	}
}
