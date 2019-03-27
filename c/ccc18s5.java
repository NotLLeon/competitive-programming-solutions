import java.util.*;
import java.io.*;
public class ccc18s5 {
	static int [][] parv, parh;
	static class edge implements Comparable<edge>{
		int x, y;
		long w;
		boolean v;
		edge(int a, int b, long c, boolean d){
			x=a;y=b;w=c;v=d;
		}
		public int compareTo(edge e){
			return this.w<e.w?-1:1;
		}
	}
	static int find(int x, int [][]par){
		return par[x][0]==-1?x:find(par[x][0], par);
	}
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), m=r.nextInt(), p=r.nextInt(), q=r.nextInt();
		edge[]es=new edge[p+q];
		parv=new int[n][2];
		parh=new int[m][2];
		long mst=0, total=0;
		for(int i=0;i<p;i++){
			int x=r.nextInt()-1, y=r.nextInt()-1;
			long w=r.nextLong();
			es[i]=new edge(x,y,w,false);
			total+=n*w;
		}
		for(int i=0;i<q;i++){
			int x=r.nextInt()-1, y=r.nextInt()-1;
			long w=r.nextLong();
			es[p+i]=new edge(x,y,w,true);
			total+=m*w;
		}
		Arrays.sort(es);
		for(int i=0;i<n;i++)parv[i][0]=-1;
		for(int i=0;i<m;i++)parh[i][0]=-1;
		int addv=0,addh=0;
		for(int i=0;i<p+q;i++){
			edge c=es[i];
			if(c.v==true){
				int parx=find(c.x, parv), pary=find(c.y, parv);
				if(parx!=pary){
					if(parv[parx][1]>parv[pary][1]){
						parv[pary][0]=parx;
						parv[parx][1]++;
					}else {
						parv[parx][0]=pary;
						parv[pary][1]++;
					}
					addv++;
					mst+=c.w*(m-addh);
				}
			}else if(c.v==false){
				int parx=find(c.x, parh), pary=find(c.y, parh);
				if(parx!=pary){
					if(parh[parx][1]>parh[pary][1]){
						parh[pary][0]=parx;
						parh[parx][1]++;
					}else {
						parh[parx][0]=pary;
						parh[pary][1]++;
					}
					addh++;
					mst+=c.w*(n-addv);
				}
			}
		}
		System.out.println(total-mst);
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