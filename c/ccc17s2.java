import java.util.*;
public class ccc17s2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		int []l;
		int []h;
		if(n%2!=0){
			l=new int[(n+1)/2];
			for(int i=0;i<(n+1)/2;i++){
				l[i]=a[(n+1)/2-i-1];
			}
			h=new int[n/2];
			for(int i=0;i<n/2;i++){
				h[i]=a[(n+1)/2+i];
			}
		}else{
			l=new int[n/2];
			for(int i=0;i<n/2;i++){
				l[i]=a[n/2-i-1];
			}
			h=new int [n/2];
			for(int i=0;i<n/2;i++){
				h[i]=a[n/2+i];
			}
		}
		int countl=0, counth=0;
		for(int i=0;i<n;i++){
			if(i%2==0){
				a[i]=l[countl];
				countl++;
			}else{
				a[i]=h[counth];
				counth++;
			}
			System.out.print(a[i]+" ");
		}
		

	}

}
