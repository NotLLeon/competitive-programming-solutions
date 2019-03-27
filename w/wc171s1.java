import java.util.*;
public class wc171s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt(), min1=99999, min2=99999;
		int []p1=new int[n], p2=new int[m];
		for(int i=0;i<n;i++){
			p1[i]=sc.nextInt();
			if(p1[i]<min1)min1=p1[i];
		}
		for(int i=0;i<m;i++){
			p2[i]=sc.nextInt();
			if(p2[i]<min2)min2=p2[i];
		}
		int cnt=0;
		if(min1<min2){
			for(int i=0;i<n;i++){
				if(p1[i]<min2)cnt++;
			}
			System.out.println(cnt+" "+0);
		}else{
			for(int i=0;i<m;i++){
				if(p2[i]<min1)cnt++;
			}
			System.out.println(0+" "+cnt);
		}
	

	}

}
