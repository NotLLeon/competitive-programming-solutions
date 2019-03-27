import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author dannyyang
 */
public class ccc17s5 {

    static int station[];
    static int passenger[];
    static int N;
    static int M;
    static int Q;
    static int shift[];
    static int blocksum[];
    static int blocksize;
    static ArrayList<Integer>[] ib, lbx, lix;//the index of the block
    

    public static void build() {
        if(blocksize==1){
        int p = 1;
        int blockindex = 1;
        int pblock = 1;
        while (p <= N) {
            int sp=station[p];
            blocksum[blockindex] += passenger[p];
            if (blockindex == ib[sp].get(ib[sp].size() - 1)) {
                ib[sp].add(blockindex);
                lbx[sp].add(passenger[p]);
                
                
                passenger[p]=ib[sp].size()-1;
            } else {
                ib[sp].add(blockindex);
                lbx[sp].add(passenger[p]);
                lix[sp].add(ib[sp].size() - 2);
                
                
                passenger[p]=ib[sp].size()-1;
            }

            p++;
            pblock++;
            if (pblock>blocksize) {
                pblock = 1;
                blockindex++;
            }
        }
        }
        else{
          int p = 1;
        int blockindex = 0;
        
        while (p <= N) {
            if (p%blocksize==1) {
                
                blockindex++;
            }
            int sp=station[p];
            blocksum[blockindex] += passenger[p];
            if (blockindex == ib[sp].get(ib[sp].size() - 1)) {
                ib[sp].add(blockindex);
                lbx[sp].add(passenger[p]);
                
                
                passenger[p]=ib[sp].size()-1;
            } else {
                ib[sp].add(blockindex);
                lbx[sp].add(passenger[p]);
                lix[sp].add(ib[sp].size() - 2);
                
                
                passenger[p]=ib[sp].size()-1;
            }

            p++;
            
            
        }  
        }
    }

    public static void Update(int x) {

        for (int i = 0; i < lix[x].size(); i++) {
            int pi = lix[x].get(i);
            if (pi == 0) {
                pi = ib[x].size() - 1;
            }
            int p2 = pi - shift[x]; 

            if (p2 < 0) {
                p2 += (ib[x].size() - 1);
            }
            if (p2 == 0) {
                p2 = ib[x].size() - 1;
            }
            int p3 = pi + 1;
            if (p3 >= ib[x].size()) {
                p3 = 1;
            }
            blocksum[ib[x].get(p3)] += lbx[x].get(p2);
            blocksum[ib[x].get(pi)] -= lbx[x].get(p2);
        }

        shift[x]++;
        shift[x] %= (ib[x].size() - 1);

    }

    public static int Query(int l, int u) {
        
        
        int c = l / blocksize;
        int d = u / blocksize;
        
        if (u % blocksize != 0) {
            d++;
        }
        int total = 0;

        for (int i = c; i <= d; i++) {
            total += blocksum[i];

        }
        int cons=Math.max(1, (c - 1) * (blocksize) + 1);
        for (int i = l - 1; i >= cons; i--) {
            int line=station[i];
            
            int indexforit = passenger[i] - shift[line];
            if (indexforit <= 0) {
                indexforit += (lbx[line].size() - 1);
            }
            
            total -= lbx[line].get(indexforit);
            
            
        }
        
        
        if (u % blocksize != 0) {
            cons=Math.min(N, (d) * blocksize);
            for (int i = u + 1; i <= cons; i++) {
                int line=station[i];
                int indexforit = passenger[i] - shift[line];
                if (indexforit <= 0) {
                    indexforit += (lbx[line].size()-1);
                }
                total -= lbx[line].get(indexforit);
                
                
            }
        }
        

      /*  for (int i = 0; i < blocksum.length; i++) {
            System.out.print(blocksum[i] + " ");
        }
        System.out.println("here");*/

        return total;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Reader input = new Reader();

        N = input.nextInt();
        M = input.nextInt();
        Q = input.nextInt();

        blocksize = (int) Math.sqrt(N);
        station = new int[N + 1];
        passenger = new int[N + 1];
        shift = new int[M + 1];
        blocksum = new int[blocksize + 3];
        ib = new ArrayList[M + 1];
        lbx = new ArrayList[M + 1];
        lix = new ArrayList[M + 1];
        
        
        for (int i = 1; i <= N; i++) {
            station[i] = input.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            passenger[i] = input.nextInt();
        }
        for (int i = 0; i < M + 1; i++) {
            ib[i] = new ArrayList<Integer>();
            ib[i].add(-1);
            lbx[i] = new ArrayList<Integer>();
            lbx[i].add(-1);
            lix[i] = new ArrayList<Integer>();
            
            

        }
        build();
        
        for (int i = 0; i < Q; i++) {
            int type = input.nextInt();
            if (type == 1) {
                
                System.out.println(Query(input.nextInt(), input.nextInt()));
            }
            else{
                
                Update(input.nextInt());
            }
        }
        

    }

 

}

class Reader {

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