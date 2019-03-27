import java.util.*;
public class ccc13s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Y=sc.nextInt();
		if(Y>=9876){
			System.out.println("10234");
		}
		String y=Integer.toString(Y);
		for(int i=Y+1;i<10000;i++){
			String I=Integer.toString(i);
			if(y.length()==1){
				System.out.println(Y+1);
				break;
		}else if(I.length()==4){
				int m=I.charAt(0);
				int m1=I.charAt(1);
				int m2=I.charAt(2);
				int m3=I.charAt(3);
				if(m!=m1&&m1!=m2&&m2!=m3&&m!=m2&&m!=m3&&m1!=m3){
					System.out.println(i);
					break;
				}
			} else if (I.length()==3){
				int m=I.charAt(0);
				int m1=I.charAt(1);
				int m2=I.charAt(2);
				if(m!=m1&&m1!=m2&&m!=m2){
					System.out.println(i);
					break;
			} 
			}else if (I.length()==2){
				int m=I.charAt(0);
				int m1=I.charAt(1);
				if(m!=m1){
					System.out.println(i);
					break;
				}
			}
		}
	}
}
