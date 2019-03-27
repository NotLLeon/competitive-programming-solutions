import java.util.*;
import java.io.*;
public class nccc7s3 {
	static long MOD=252097800623l, MAX=Long.MAX_VALUE;
	public static void main(String[] args)throws IOException {
		Reader sc=new Reader();
		int n=sc.nextInt();
		long[][]p=new long[n][2];
		for(int i=0;i<n;i++){
			p[i][0]=sc.nextLong();
			p[i][1]=sc.nextLong();
		}
		long cnt=0,rise,run,g, slope;
		int d;
		HashMap<Long, Integer>tm=new HashMap<Long, Integer>();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j)continue;
				rise=p[i][1]-p[j][1]; run=p[i][0]-p[j][0];
				if(run==0)slope=MAX;
				else{
					g=gcd(rise,run);
					rise/=g;
					run/=g;
					slope=((rise%MOD)*48611l+run)%MOD;
				}
				if(tm.containsKey(slope)){
					d=tm.remove(slope);
					cnt+=n-2*d-2;
					tm.put(slope, d+1);
				}else {
					tm.put(slope, 1);
					cnt+=n-2;
				}
			}
			tm.clear();
		}
		System.out.println(cnt/6);
	}
	static long gcd(long a, long b){
		if(b==0)return a;
		return gcd(b,a%b);
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