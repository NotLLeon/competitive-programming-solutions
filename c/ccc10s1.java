import java.util.*;
public class ccc10s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String max1="";
		int m1=0;
		String max2="";
		int m2=0;
		for(int i=0;i<n;i++){
			String s=sc.next();
			int R=sc.nextInt();
			int S=sc.nextInt();
			int D=sc.nextInt();
			int g=(2*R)+(3*S)+D;
			if(g>=m1){
				if(g==m1){
					if(s.charAt(0)<max1.charAt(0)){
						max2=max1;
						m2=m1;
						max1=s;
						m1=g;
					}else{
						max2=s;
						m2=g;
					}
				}else {
					max2=max1;
					m2=m1;
					max1=s;
					m1=g;
				}
			}else if(g>=m2){
				if(g==m2){
					if(s.charAt(0)<max2.charAt(0)){
						max2=s;
						m2=g;
					}
				}else {
					max2=s;
					m2=g;
				}
			}
		}
		System.out.println(max1);
		System.out.println(max2);

	}

}
