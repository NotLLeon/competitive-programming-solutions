import java.util.*;
public class year2018p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), cnt=0;
		for(int i=0;i<n;i++){
			int f=sc.nextInt();
			if(f==2){
				cnt++;
				continue;
			}else if(f==1){
				continue;
			}
			for(int j=2;j<=Math.ceil(Math.sqrt(f));j++){
				if(f%j==0){
					cnt--;
					break;
				}
			}
			cnt++;
		}
		System.out.println(cnt);

	}

}
