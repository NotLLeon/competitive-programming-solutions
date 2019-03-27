
import java.util.Scanner;
public class p108ex9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	int T = sc.nextInt();
	for(int i=0;i<T;i++){
		double p=0;
		double l1=sc.nextDouble();
		double l2=sc.nextDouble();
		String l3=sc.next();
		String l4=sc.next();
		if(l2>=40){
			double o=(l2-40)*2;
			p=l1*40+o*l1;
		}else{
		p=l2*l1;
		}
		if(l3.equals("A")){
			p=p;
		} else if (l3.equals("B")){
			p=p*0.90;
		} else if (l3.equals("C")){
			p=p*0.80;
		} else if (l3.equals("D")){
			p=p*0.71;
		} else if (l3.equals("E")){
			p=p*0.65;
		}
		if(l4.equals("y")){
			p=p-10;
		} else {
			p=p;
		}

		System.out.printf("%.2f%n", p);
	}

	}

}
