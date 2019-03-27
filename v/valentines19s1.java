import java.util.*;
import java.io.*;
public class valentines19s1 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
		String[]can=new String[n];
		for(int i=0;i<n;i++)can[i]=br.readLine();
		int[][]chs=new int[m][20];
		for(int i=0;i<m;i++)Arrays.fill(chs[i], -1);
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			for(int j=0;j<x;j++){
				String nv=st.nextToken();
				for(int k=0;k<n;k++){
					if(nv.equals(can[k])){
						chs[i][j]=k;
						break;
					}
				}
			}
		}
		int[]v=new int[n];
		for(int i=0;i<m;i++)v[chs[i][0]]++;
		int cnt=n;
		while(cnt-->1){
			int min=0;
			for(int i=0;i<n;i++){
				if(v[i]!=-1&&(v[i]<v[min]||v[min]==-1))min=i;
			}
			v[min]=-1;
			for(int i=0;i<n;i++)if(v[i]!=-1)v[i]=0;
			for(int i=0;i<m;i++){
				for(int j=0;j<21;j++){
					if(chs[i][j]==-1)break;
					if(v[chs[i][j]]!=-1){
						v[chs[i][j]]++;
						break;
					}
				}
			}
		}
		for(int i=0;i<n;i++)if(v[i]!=-1)System.out.println(can[i]);
	}

}
