import java.util.*;
import java.io.*;
public class gfssoc1s4 {
	static long[][][]bit;
	static int[][][]vals;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//is this even possible on java?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		bit=new long[n][n][n]; vals=new int[n][n][n];
		int q=Integer.parseInt(br.readLine());
		long total=0;
		for(int i=0;i<q;i++){
			StringTokenizer st =new StringTokenizer(br.readLine());
			String s=st.nextToken();
			if(s.equals("C")){
				int x=Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken()),z=Integer.parseInt(st.nextToken()),val=Integer.parseInt(st.nextToken());
				update(x,y,z,val);
				vals[x-1][y-1][z-1]=val;
			}else{
				int x1=Integer.parseInt(st.nextToken()), y1=Integer.parseInt(st.nextToken()), z1=Integer.parseInt(st.nextToken());
				int x2=Integer.parseInt(st.nextToken()), y2=Integer.parseInt(st.nextToken()), z2=Integer.parseInt(st.nextToken());
				total+=getSum(x1,y1,z1,x2,y2,z2);
			}
		}
		System.out.println(total);
	}
	public static void update(int x, int y, int z, int val){
		int val2=vals[x-1][y-1][z-1];
		for(int i=x;i<=n;i+=i&-i){
			for(int j=y;j<=n;j+=j&-j){
				for(int l=z;l<=n;l+=l&-l){
					bit[i-1][j-1][l-1]-=val2;
					bit[i-1][j-1][l-1]+=val;
				}
			}
		}
	}
	public static long Query(int x, int y, int z){
		long sum=0;
		for(int i=x;i>0;i-=i&-i){
			for(int j=y;j>0;j-=j&-j){
				for(int l=z;l>0;l-=l&-l){
					sum+=bit[i-1][j-1][l-1];
				}
			}
		}
		return sum;
	}
	public static long getSum(int x1, int y1, int z1, int x2, int y2, int z2){
		return(Query(x2,y2,z2)-Query(x1-1,y2,z2)-Query(x2,y1-1,z2)-Query(x2,y2,z1-1)+Query(x1-1,y1-1,z2)+Query(x2,y1-1,z1-1)+Query(x1-1,y2,z1-1)-Query(x1-1,y1-1,z1-1));
	}
}