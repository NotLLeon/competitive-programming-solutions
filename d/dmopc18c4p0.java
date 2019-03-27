import java.util.*;
public class dmopc18c4p0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r=sc.nextInt(), x=sc.nextInt(), y=sc.nextInt(), max=0;
		int[][]s=new int[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				s[i][j]=sc.nextInt();
			}
			if(s[i][2]<s[max][2])max=i;
		}
		if(Math.sqrt(Math.pow(x-s[max][0],2)+Math.pow(y-s[max][1],2))<r)System.out.println("What a beauty!");
		else System.out.println("Time to move my telescope!");

	}

}
