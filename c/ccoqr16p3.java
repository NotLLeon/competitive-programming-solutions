import java.io.*;
import java.util.*;
public class ccoqr16p3 {
	static class coord implements Comparable<coord>{
		int x, y, rgt;
		coord(int a, int b){
			x=a;
			y=b;
			rgt=a+b-1;
		}
		public int compareTo(coord e){
			return this.y-e.y;
		}
	}
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), m=r.nextInt();
		coord[]c=new coord[m];
		for(int i=0;i<m;i++){
			int x=n-r.nextInt()+1, y=r.nextInt();
			c[i]=new coord(x,y);
		}
		Arrays.sort(c);
		int rgt=0;
		long ans=0;
		for(int i=0;i<m;i++){
			if(c[i].rgt<=rgt)continue;
			ans+=(long)(area(c[i].x));
			if(rgt>=c[i].y)ans-=(long)(area(rgt-c[i].y+1));
			rgt=c[i].rgt;
		}
		System.out.println(ans);

	}
	static long area(long r){
		return (r*(r+1))/2;
	}
	static class Reader {

	    final private int BUFFER_SIZE = 1 << 16;
	    private DataInputStream din;
	    private byte[] buffer;
	    private int bufferPointer, bytesRead;
	    private int http;

	    public Reader() {
	        din = new DataInputStream(System.in);
	        buffer = new byte[BUFFER_SIZE];
	        bufferPointer = bytesRead = 0;
	    }

	    public Reader(String file_name) throws IOException {
	        din = new DataInputStream(new FileInputStream(file_name));
	        buffer = new byte[BUFFER_SIZE];
	        bufferPointer = bytesRead = 0;
	    }

	    public String readLine() throws IOException {
	        byte[] buf = new byte[64]; // line length
	        int cnt = 0, c;
	        while ((c = read()) != -1) {
	            if (c == '\n') {
	                break;
	            }
	            buf[cnt++] = (byte) c;
	        }
	        return new String(buf, 0, cnt);
	    }

	    public int nextInt() throws IOException {
	        int ret = 0;
	        byte c = read();
	        while (c <= ' ') {
	            c = read();
	        }
	        boolean neg = (c == '-');
	        if (neg) {
	            c = read();
	        }
	        do {
	            ret = ret * 10 + c - '0';
	        } while ((c = read()) >= '0' && c <= '9');

	        if (neg) {
	            return -ret;
	        }
	        return ret;
	    }

	    public long nextLong() throws IOException {
	        long ret = 0;
	        byte c = read();
	        while (c <= ' ') {
	            c = read();
	        }
	        boolean neg = (c == '-');
	        if (neg) {
	            c = read();
	        }
	        do {
	            ret = ret * 10 + c - '0';
	        } while ((c = read()) >= '0' && c <= '9');
	        if (neg) {
	            return -ret;
	        }
	        return ret;
	    }

	    public double nextDouble() throws IOException {
	        double ret = 0, div = 1;
	        byte c = read();
	        while (c <= ' ') {
	            c = read();
	        }
	        boolean neg = (c == '-');
	        if (neg) {
	            c = read();
	        }

	        do {
	            ret = ret * 10 + c - '0';
	        } while ((c = read()) >= '0' && c <= '9');

	        if (c == '.') {
	            while ((c = read()) >= '0' && c <= '9') {
	                ret += (c - '0') / (div *= 10);
	            }
	        }

	        if (neg) {
	            return -ret;
	        }
	        return ret;
	    }

	    private void fillBuffer() throws IOException {

	        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	        if (bytesRead == -1) {
	            buffer[0] = -1;
	        }
	    }

	    private byte read() throws IOException {
	        if (bufferPointer == bytesRead) {
	            fillBuffer();
	        }
	        return buffer[bufferPointer++];
	    }

	    public void close() throws IOException {
	        if (din == null) {
	            return;
	        }
	        din.close();
	    }
	}
}
