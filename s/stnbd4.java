import java.util.*;
import java.io.*;
public class stnbd4 {
	static long[]bit;
	static int n;
	static class coord implements Comparable<coord>{
		int ind, val;
		coord(int a, int b){
			ind=a;
			val=b;
		}
		public int compareTo(coord e){
			return this.val-e.val;
		}
	}
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		n=r.nextInt();
		int[]arr=new int[n];
		long[]psa=new long[n+1];
		bit=new long[n+1];
		int[]c=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=r.nextInt();
			c[i]=arr[i];
		}
		Arrays.sort(c);
		psa[0]=0;
		for(int i=0;i<n;i++){
			psa[i+1]=psa[i]+query(i);
			update(n-Arrays.binarySearch(c,arr[i]));
		}
		int q=r.nextInt();
		while(q-->0){
			int i=r.nextInt(), p=r.nextInt();
			System.out.println(psa[p]-psa[i]);
		}
	}
	static void update(int x){
		for(int i=x;i<=n;i+=i&-i)bit[i]++;
	}
	static long query(int x){
		long sum=0;
		for(int i=x;i>0;i-=i&-i)sum+=bit[i];
		return sum;
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
