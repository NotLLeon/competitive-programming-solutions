import java.util.*;
import java.io.*;
public class ccc14s4 {
	static class Event implements Comparable<Event>{
		int x,y1,y2,t;
		Event(int a, int b, int c, int d){
			x=a;
			y1=b;
			y2=c;
			t=d;
		}
		public int compareTo(Event e){
			return this.x-e.x;
		}
	}
	public static void main(String[] args)throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), t=r.nextInt();
		long ans=0;
		int[]ys=new int[2*n];
		LinkedList<Event>ev=new LinkedList<Event>();
		for(int i=0;i<n;i++){
			int x1=r.nextInt(), y1=r.nextInt(), x2=r.nextInt(), y2=r.nextInt(), v=r.nextInt();
			ev.add(new Event(x1,y1,y2,v));
			ev.add(new Event(x2,y1,y2,-v));
			ys[2*i]=y1;
			ys[2*i+1]=y2;
		}
		Arrays.sort(ys);
		Collections.sort(ev);
		int[]line=new int[2*n];
		int prevx=ev.peek().x;
		while(!ev.isEmpty()){
			Event nev=ev.poll();
			int ty=Arrays.binarySearch(ys, nev.y2), by=Arrays.binarySearch(ys, nev.y1);
			for(int i=0;i<line.length;i++)
				if(line[i]>=t)
					ans+=(long)(ys[i+1]-ys[i])*(nev.x-prevx);
			prevx=nev.x;
			for(int i=by;i<ty;i++)line[i]+=nev.t;
		}
		System.out.println(ans);

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