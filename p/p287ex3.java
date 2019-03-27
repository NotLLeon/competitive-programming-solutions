import java.util.*;
public class p287ex3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		double []num=new double[N];
		double min=0;
		boolean b=false;
		for(int i=0;i<N;i++){
			num[i]=sc.nextDouble();
			if(b==false){
				min=num[i];
				b=true;
			}
			min=Math.min(num[i], min);
		}
		System.out.printf("%.2f",min);
	}

}
