import java.util.*;
import java.io.*;
public class vmss7wc15c5p3 {
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
	static int[][]bit;
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt();
		long total=0;
		bit=new int[2001][2001];
		for(int i=0;i<n;i++){
			int k=r.nextInt(), R=r.nextInt(), c=r.nextInt(),x=r.nextInt();;
			if(k==1){
				update(R,c,x);
			}else{
				total+=Query(R-x,c+x)-Query(R+1,c-1);
			}
		}
		System.out.println(total%1000000007);
	}
	public static void update(int r, int c, int val){
		int i=r&-r;
		for(;c<=2001&&r>0;c+=i,r-=i){
			bit[r-1][c-1]+=val;
			i=r&-r;
		}
	}
	public static int Query(int r, int c){
		int sum=0,i=r&-r;
		for(;r<=2001&&c>0;c-=i,r+=i){
			sum+=bit[r-1][c-1];
			i=r&-r;
		}
		return sum;
	}
}
