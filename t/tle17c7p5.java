import java.util.*;
public class tle17c7p5 {
	static boolean[]vis, mr, mc;
	static boolean[][]ans, r, c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m[][]=new int[n][2], f[][]=new int[n][2];
		double [][] adj=new double[n][n], temp=new double[n][n];
		for(int i=0;i<n;i++){
			m[i][0]=sc.nextInt();
			m[i][1]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			f[i][0]=sc.nextInt();
			f[i][1]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int m1=Math.abs(m[i][0]-f[j][0]), m2=Math.abs(m[i][1]-f[j][1]);
				adj[i][j]=Math.sqrt(m1*m1+m2*m2);
			}
		}
		int cross=0;
		double min=999999;
		for(int i=0;i<n;i++)for(int j=0;j<n;j++)temp[i][j]=adj[i][j];
		for(int i=0;i<n;i++){
			min=999999;
			for(int j=0;j<n;j++)min=Math.min(min, temp[i][j]);
			for(int j=0;j<n;j++)temp[i][j]-=min;
		}
		for(int i=0;i<n;i++){
			min=999999;
			for(int j=0;j<n;j++)min=Math.min(min, temp[j][i]);
			for(int j=0;j<n;j++)temp[j][i]-=min;
		}
		while(true){
			mr=new boolean [n]; mc=new boolean[n];
			cross=getCross(temp, n);
			if(cross==n)break;
			min=9999999;
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(!mr[i]&&!mc[j])min=Math.min(min, temp[i][j]);
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(!mr[i]&&!mc[j])temp[i][j]-=min;
					else if(mr[i]&&mc[j])temp[i][j]+=min;
				}
			}
		}
		vis=new boolean[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<2;j++){
				r[i][j]=false;
				c[i][j]=false;
			}
		}
		ans=assign(temp, n);
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(ans[i][j])
					System.out.println((i+1)+" "+(j+1));
	}
	static int getCross(double[][]a,int n){
		r=new boolean[n][2]; c=new boolean[n][2];
		boolean [][]asgn=new boolean[n][n];
		int cntr=0, cntc=0;
		asgn=assign(a, n);
		for(int i=0;i<n;i++){
			if(!r[i][0]){
				r[i][1]=true;
				cntr++;
			}
		}
		boolean move=true;
		while(move){
			move=false;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(a[i][j]<0.0000001&&r[i][1]&&!c[j][1]){
						c[j][1]=true;
						mc[j]=true;
						cntc++;
						move=true;
					}
				}
			}
			for(int i=0;i<n;i++){	
				for(int j=0;j<n;j++){
					if(asgn[i][j]&&c[j][1]&&!r[i][1]){
						r[i][1]=true;
						cntr++;
						move=true;
					}
				}
			}
		}
		for(int i=0;i<n;i++)if(!r[i][1])mr[i]=true;	
		return cntc+n-cntr;
	}
	static boolean[][]assign(double [][] a, int n){
		boolean[][]asgn=new boolean[n][n];
		int []zr=new int[n], zc=new int[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]<0.0000001){
					zr[i]++;
					zc[j]++;
				}
			}
		}
		boolean mv=true;
		while(mv){
			mv=false;
			for(int i=0;i<n;i++){
				if(zr[i]==1&&!r[i][0]){
					for(int j=0;j<n;j++){
						if(a[i][j]<0.0000001&&!c[j][0]){
							mv=true;
							asgn[i][j]=true;
							zc[j]--;
							zr[i]--;
							r[i][0]=true;
							c[j][0]=true;
							break;
						}
					}
				}
				if(zc[i]==1&&!c[i][0]){
					for(int j=0;j<n;j++){
						if(a[j][i]<0.0000001&&!r[j][0]){
							mv=true;
							asgn[j][i]=true;
							zr[j]--;
							c[i][0]=true;
							zc[i]--; 
							r[j][0]=true;
							break;
						}
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			if(!r[i][0]&&zr[i]>0){
				for(int j=0;j<n;j++){
					if(a[i][j]<0.0000001&&!c[j][0]){
						c[j][0]=true;
						r[i][0]=true;
						zr[i]--;
						zc[j]--;
						asgn[i][j]=true;
						break;
					}
				}
			}
			if(!c[i][0]&&zc[i]>0){
				for(int j=0;j<n;j++){
					if(a[j][i]<0.0000001&&!r[j][0]){
						r[j][0]=true;
						c[i][0]=true;
						zr[j]--;
						zc[i]--;
						asgn[j][i]=true;
						break;
					}
				}
			}
		}
		return asgn;
	}
}