/*
ID: NotLeon
LANG: JAVA
TASK: cowpatibility
*/
import java.util.*;
import java.io.*;
public class cowpatibility {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowpatibility.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowpatibility.out")));
		int n=Integer.parseInt(br.readLine());
		int[][]f=new int[n][5];
		BitSet[]bs=new BitSet[1000001];
		for(int i=0;i<1000001;i++)bs[i]=new BitSet();
		StringTokenizer st;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++){
				f[i][j]=Integer.parseInt(st.nextToken());
				bs[f[i][j]].set(i);
			}
		}
		long cnt=0;
		BitSet cur=new BitSet();
		for(int i=0;i<n;i++){
			cur=new BitSet();
			for(int j=0;j<5;j++)cur.or(bs[f[i][j]]);
			cnt+=cur.cardinality()-1;
		}
		long lz=(long)n;
		out.println(lz*(lz-1)/2-cnt/2);
		out.close();
	}

}