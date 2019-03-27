import java.util.*;
public class dmopc14c3p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String[]s=new String[n];
		int wa=0;
		for(int i=0;i<n;i++){
			s[i]=sc.next();
			if(s[i].equals("WA"))wa++;
		}
		int cntir=0;
		int cntwa=0;
		for(int i=0;i<n;i++){
			if(s[i].equals("WA")&&cntwa<Math.floor(wa*0.3)){
				s[i]="AC";
				cntwa++;
			} else if(s[i].equals("TLE")){
				s[i]="WA";
			} else if(s[i].equals("IR")){
				if(cntir<10){
					s[i]="AC";
					cntir++;
				}else if(cntir<20){
					s[i]="WA";
					cntir++;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(s[i]);
		}

	}

}
