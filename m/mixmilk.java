/*
ID: NotLeon
LANG: JAVA
TASK: mixmilk
 */
import java.util.*;
import java.io.*;
public class mixmilk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		int[]c=new int[3], m=new int[3];
		for(int i=0;i<3;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			c[i]=Integer.parseInt(st.nextToken());
			m[i]=Integer.parseInt(st.nextToken());
		}
		for(int j=0;j<100;j++){
			int i=j%3;
			int nxt=(i+1)%3;
			if(m[i]+m[nxt]>c[nxt]){
				m[i]-=c[nxt]-m[nxt];
				m[nxt]=c[nxt];

			}else{
				m[nxt]+=m[i];
				m[i]=0;
			}
		}
		for(int i=0;i<3;i++)out.println(m[i]);
		out.close();
	}

}