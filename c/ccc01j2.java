import java.util.*;
public class ccc01j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int m=sc.nextInt();
		boolean flag=false;
		for(int i=0;i<m+1;i++){
			if((x*i)%m==1){
				System.out.println(i);
				flag=true;
				break;
			}
		}

		if(flag==false){
			System.out.println("No such integer exists.");
		}
	}

}
