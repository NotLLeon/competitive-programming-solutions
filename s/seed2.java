import java.util.*;
public class seed2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n=1000000000;
		System.out.println(n);
		System.out.flush();
		long min=0;
		long max=2000000000;
		for(int i=0;i<31;i++){
			String s=sc.next();

			if(s.equals("SINKS")){
				min=n;
				n=(min+max)/2;
			}else if(s.equals("FLOATS")){
				max=n;
				n=(min+max)/2;
			}else if(s.equals("OK")){
				break;
			}
			System.out.println(n);
			System.out.flush();
			
		}

	}
	public static void placeholder(){
		
	}

}
