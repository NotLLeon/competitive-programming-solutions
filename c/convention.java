/*
ID: NotLeon
LANG: JAVA
TASK: convention
*/
import java.util.*;
import java.io.*;
public class convention {
	static int n,m,c;
	static int[]t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());c=Integer.parseInt(st.nextToken());
		t=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)t[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(t);
		int lo=0, hi=1000000000, mid=0;
		while(true){
			mid=(lo+hi)/2;
			if(check(mid)&&!check(mid-1))break;
			if(check(mid))hi=mid-1;
			else lo=mid+1;
		}
		out.println(mid);
		out.close();
	}
	static boolean check(int max){
		int cnt=1, strt=t[0], cp=0;
		for(int i=0;i<n;i++){
			if(t[i]-strt>max||cp==c){
				cnt++;
				strt=t[i];
				cp=0;
			}
			cp++;
		}
		return cnt<=m;
	}

}