import java.util.*;
import java.io.*;
public class ccc19s3 {
	static long max=Long.MAX_VALUE;
	static int[]r,c;
	public static void main(String[] args)throws IOException {
		Scanner sc= new Scanner(System.in);
		StringTokenizer st;
		long[][]ar=new long[3][3];
		for(int i=0;i<3;i++){
			st=new StringTokenizer(sc.nextLine());
			for(int j=0;j<3;j++){
				String nc=st.nextToken();
				if(nc.equals("X"))ar[i][j]=max;
				else ar[i][j]=Integer.parseInt(nc);
			}
		}
		r=new int[3]; c=new int[3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(ar[i][j]!=max){
					r[i]++;
					c[j]++;
				}
			}
		}
		for(int i=0;i<3;i++){
			reduce(ar);
			long mm=max;
			for(int j=0;j<3;j++)mm=Math.min(mm, ar[i][j]);
			if(mm==max)mm=0;
			for(int j=0;j<3;j++){
				if(ar[i][j]==max){
					ar[i][j]=mm;
					r[i]++;
					c[j]++;
				}
			}
		}
		reduce(ar);
		for(int k=0;k<3;k++){
			for(int j=0;j<3;j++){
				System.out.print(ar[k][j]+" ");
			}
			System.out.println();
		}
	}
	static void reduce(long[][]ar){
		boolean go=true;
		while(go){
			go=false;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(ar[i][j]!=max)continue;
					if(r[i]==2){
						if(j==0){
							go=true;
							ar[i][j]=ar[i][1]+(ar[i][1]-ar[i][2]);
						}else if(j==1){
							if(((ar[i][2]-ar[i][0])%2)==0){
								ar[i][j]=ar[i][0]+(ar[i][2]-ar[i][0])/2;
								go=true;
							}else{
								r[i]--;
								c[j]--;
							}
						}else{
							go=true;
							ar[i][j]=ar[i][1]+(ar[i][1]-ar[i][0]);
						}
						r[i]++;
						c[j]++;
					}else if(c[j]==2){
						if(i==0){
							go=true;
							ar[i][j]=ar[1][j]+(ar[1][j]-ar[2][j]);
						}else if(i==1){
							if(((ar[2][j]-ar[0][j])%2)==0){
								go=true;
								ar[i][j]=ar[0][j]+(ar[2][j]-ar[0][j])/2;
							}else{
								r[i]--;
								c[j]--;
							}
						}else{
							go=true;
							ar[i][j]=ar[1][j]+(ar[1][j]-ar[0][j]);
						}
						r[i]++;
						c[j]++;
					}
				}
			}
		}
	}
}