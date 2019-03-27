import java.util.*;
import java.io.*;
public class ccc09s5 {
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
	static int[][]adj;
	public static void main(String[] args) throws IOException {
		//wireless- 1000 1D difference arrays, for every circle, use formula to update each column
		//(brute), then use prefix sum array and find max
		Reader r = new Reader();
		int M=r.nextInt(), N=r.nextInt(), K=r.nextInt();
		adj=new int[M][N+2];
		for(int i=0;i<K;i++){
			int x=r.nextInt()-1, y=r.nextInt()-1, R=r.nextInt(), b=r.nextInt();
			adj[y][x]=-1;
			boolean[][] vis=new boolean[M+2][N+2];
			for(int j=R;j>=0;j--){
				int x1=(int)(Math.sqrt(Math.pow(R, 2)-Math.pow(j, 2)));
				//make sure that overlap doesnt occur from out of bounds catch or flooring
				//try starting search from outside in of circle to prevent overlap catch from ignoring range improvements
				//everything else should be ok, write prefix sum array code to find max and freq
				if(y+j<M){
					adj[y+j][check(x+x1, N)+1]-=b;
					adj[y+j][check(x-x1, N)]+=b;
				}
				if(y-j>=0){
					adj[y-j][check(x+x1, N)+1]-=b;
					adj[y-j][check(x-x1, N)]+=b;
				}
			}
			for(int l=0;l<M;l++){
				System.out.println();
				for(int j=0;j<N+2;j++){
					System.out.print(adj[l][j]+" ");
				}
			}
			System.out.println();
		}

	}
	static int check(int n, int ub){
		if(n<0){
			return 0;
		}else if(n>ub){
			return ub;
		}else{
			return n;
		}
	}
}