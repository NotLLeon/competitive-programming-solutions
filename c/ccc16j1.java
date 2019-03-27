import java.util.*;
public class ccc16j1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wcount=0;
		for(int i=0;i<6;i++){
			String a=sc.nextLine();
			if(a.equals("W")){
				wcount++;
			}
		}
		int group=-1;
		if(wcount==5 || wcount==6){
			group=1;
		}if(wcount==3|| wcount==4){
			group=2;
		}if(wcount==1 || wcount==2){
			group=3;
		}
		System.out.println(group);
	}

}
