import java.util.*;
public class dmopc18c5p0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		double[]a=new double[3], b=new double[3];
		for(int i=0;i<3;i++)a[i]=sc.nextDouble();
		for(int i=0;i<3;i++)b[i]=sc.nextDouble();
		if(s.equals("Multiply")){
			for(int i=0;i<3;i++){
				System.out.printf("%.7f",a[i]*b[i]);
				System.out.print(" ");
			}
			System.out.println();
		}else if(s.equals("Screen")){
			for(int i=0;i<3;i++){
				System.out.printf("%.7f",1-(1-a[i])*(1-b[i]));
				System.out.print(" ");
			}
			System.out.println();
		}else{
			for(int i=0;i<3;i++){
				if(a[i]<0.5)System.out.printf("%.7f",2*a[i]*b[i]);
				else System.out.printf("%.7f",1-2*(1-a[i])*(1-b[i]));
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
