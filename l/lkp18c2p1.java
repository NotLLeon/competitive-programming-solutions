import java.util.*;
public class lkp18c2p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		int[]l=new int[n];
		for(int i=0;i<n;i++)l[i]=sc.nextInt();
		for(int i=0;i<m;i++){
			int min=0;
			for(int j=0;j<n;j++){
				if(l[j]<l[min])min=j;
			}
			System.out.println(l[min]);
			l[min]++;
		}

	}

}
