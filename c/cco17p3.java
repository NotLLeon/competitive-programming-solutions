import java.util.*;
import java.io.*;
public class cco17p3 {
	static class event implements Comparable <event>{
		long x, v;
		int y;
		boolean q;
		event(long a, long b, boolean c){
			x=a;v=b;q=c;
		}
		public int compareTo(event e){
			if(this.x<e.x)return -1;
			else if(this.x>e.x)return 1;
			else return 0;
		}
	}
	static class coord implements Comparable <coord>{
		long y;
		int ind1, ind2;
		coord(long a, int b, int c){
			y=a;ind1=b;ind2=c;
		}
		public int compareTo(coord e){
			if(this.y<e.y)return -1;
			else if(this.y>e.y)return 1;
			else return 0;
		}
	}
	static long[]line;
	public static void main(String[] args)throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), q=r.nextInt();
		event[]evnts=new event[n*4+q];
		coord[]ys=new coord[n*2+q];
		for(int i=0;i<n;i++){
			long x=bFlip(r.nextLong()), y=bFlip(r.nextLong()),v=r.nextLong(),
					maxx=x+(x&-x)-1, minx=x-(x&-x)+1, maxy=y+(y&-y)-1, miny=y-(y&-y)+1;
			ys[2*i]=new coord(maxy+1, 4*i, 4*i+2);
			ys[2*i+1]=new coord(miny, 4*i+1, 4*i+3);
			evnts[4*i]=new event(minx, -v, false);
			evnts[4*i+1]=new event(minx, v, false);
			evnts[4*i+2]=new event(maxx+1, v, false);
			evnts[4*i+3]=new event(maxx+1, -v, false);
		}
		for(int i=0;i<q;i++){
			long x=bFlip(r.nextLong()), y=bFlip(r.nextLong());
			ys[n*2+i]=new coord(y, n*4+i, n*4+i);
			evnts[n*4+i]=new event(x,i,true);
		}
		Arrays.sort(ys);
		int rp=0;
		long prev=-1;
		for(int i=0;i<ys.length;i++){
			if(ys[i].y==prev)rp++;
			evnts[ys[i].ind1].y=i-rp;
			evnts[ys[i].ind2].y=i-rp;
			prev=ys[i].y;
		}
		Arrays.sort(evnts);
		line=new long[n*2+q-rp];
		long []ans=new long[q];
		for(int i=0;i<evnts.length;i++){
			event cur=evnts[i];
			if(!cur.q)update(cur.y+1, cur.v);
			else ans[(int)cur.v]=query(cur.y+1);
		}
		for(int i=0;i<q;i++)System.out.println(ans[i]);
	}
	static void update(int i, long val){
		for(;i<=line.length;i+=i&-i)line[i-1]+=val;
	}
	static long query(int i){
		long sum=0;
		for(;i>0;i-=i&-i)sum+=line[i-1];
		return sum;
	}
	static long bFlip(long x){
		long ans=0, b=0;
		while(x>0){
			b=x&-x;
			ans+=((long)1<<(long)(59-log(b)));
			x-=b;
		}
		return ans;
	}
	static int log(long x){
		int cnt=0;
		while(x>1){
			x>>=1;
			cnt++;
		}
		return cnt;
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
