import java.util.*;
public class waterloof2017a {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[]ar=new int[5];
		for(int i=0;i<5;i++)ar[i]=sc.nextInt();
		Arrays.sort(ar);
		int cnt=0;
		for(int i=0;i<3;i++){
			for(int j=i+1;j<4;j++){
				for(int k=j+1;k<5;k++){
					if(ar[i]+ar[j]>ar[k])cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
