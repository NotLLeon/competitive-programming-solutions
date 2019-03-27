import java.util.*;
import java.io.*;
public class ccc17s4 {
	static int [][]nodes;
	static class path implements Comparable<path>{
		int fr,to, w,nw ;
		path(int a, int b, int c, int d){
			fr=a;to=b;w=c;nw=d;
		}
		public int compareTo(path e){
			if(this.w<e.w||(this.w==e.w&&this.nw<e.nw))return -1;
			else if(this.w>e.w||(this.w==e.w&&this.nw>e.nw))return 1;
			else return 0;
		}
	}
	static int find(int cur){
		if(nodes[cur][0]==-1)return cur;
		else return find(nodes[cur][0]);
	}
	static void union(int x, int y){
		if(nodes[x][1]>nodes[y][1])nodes[y][0]=x;
		else if(nodes[x][1]<nodes[y][1]) nodes[x][0]=y;
		else{
			nodes[y][0]=x;
			nodes[x][1]++;
		}
	}
	public static void main(String[] args) throws IOException{
		Reader r = new Reader();
		int n=r.nextInt(), m=r.nextInt(), d=r.nextInt();
		nodes=new int[n][2];
		LinkedList<path>paths=new LinkedList<path>();
		for(int i=0;i<n;i++)nodes[i][0]=-1;
		for(int i=0;i<m;i++){
			int a=r.nextInt()-1, b=r.nextInt()-1, w=r.nextInt();
			if(i<n-1){
				paths.add(new path(a,b,w,0));
			}else{
				paths.add(new path(a,b,w,1));
			}
		}
		Collections.sort(paths);
		int days=0, max=0, maxn=0;
		for(int i=0;i<m;i++){
			path p = paths.poll();
			int xR=find(p.fr), yR=find(p.to);
			if(xR!=yR){
				union(xR,yR);
				days+=p.nw;
				max=p.w;
				maxn=p.nw;
			}
			paths.add(p);
		}
		for(int i=0;i<n;i++)nodes[i][0]=-1;
		if(maxn==1){
			for(int i=0;i<m;i++){
				path p =paths.poll();
				int xR=find(p.fr), yR=find(p.to);
				if(xR!=yR){
					if(p.w<max||(p.w==max&&p.nw==0)){
						union(xR, yR);
					}else if(p.nw==0&&p.w<=d){
						days--;
						break;
					}
				}
				paths.add(p);
			}
		}
		System.out.println(days);
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