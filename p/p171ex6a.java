import java.util.Scanner;
public class p171ex6a {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		double []num=new double[N];
		double max=0;
		boolean b=false;
		for(int i=0;i<N;i++){
			num[i]=sc.nextDouble();
			if(b==false){
				max=num[i];
				b=true;
			}
			max=Math.max(num[i], max);
		}
		System.out.printf("%.4f",max);
	}

}
