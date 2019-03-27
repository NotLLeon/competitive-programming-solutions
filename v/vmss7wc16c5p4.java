import java.util.*;
public class vmss7wc16c5p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int []xyz=new int[3];
		for(int i=0;i<3;i++)xyz[i]=sc.nextInt();
		Arrays.sort(xyz);
		for(int i=0,x;i<3;i++){
			x=n;
			int cnt=0;
			while(x>0){
				if(x%xyz[i]==0)x-=xyz[i];
				else if(x%xyz[(i+1)%3]==0)x-=xyz[(i+1)%3];
				else if(x%xyz[(i+2)%3]==0)x-=xyz[(i+2)%3];
				else x-=xyz[i];
				cnt++;
			}
			if(x==0){
				System.out.println(cnt);
				break;
			}
		}

	}

}
