import java.util.*;
public class coci17c4p2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n =sc.nextInt(), m=sc.nextInt(), k=sc.nextInt();
		int[][]v=new int[n][m];
		int[]c=new int[m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				v[i][j]=sc.nextInt();
				if(j==0)c[v[i][j]-1]++;
			}
		}
		int max=0;
		for(int i=0;i<m;i++){
			if(c[i]>c[max])max=i;
		}
		System.out.println(max+1);
		int min=Integer.MAX_VALUE;;
		for(int i=0;i<(1<<m)-1;i++){
			c=new int[m];
			for(int j=0;j<n;j++){
				for(int l=0;l<m;l++){
					if((i&(1<<(v[j][l]-1)))==0){
						c[v[j][l]-1]++;
						break;
					}
				}
			}
			max=0;
			for(int j=0;j<m;j++){
				if(c[j]>c[max]){
					max=j;
				}
			}
			if(max+1==k)min=Math.min(min, Integer.bitCount(i));
		}	
		System.out.println(min);

	}

}
