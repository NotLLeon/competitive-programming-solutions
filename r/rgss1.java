import java.util.*;
public class rgss1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
		boolean[]fill=new boolean[c+1];
		fill[a]=true;
		fill[b]=true;
		for(int i=0;i<c;i++){
			if(fill[i]){
				if(i+a<=c)fill[i+a]=true;
				if(i+b<=c)fill[i+b]=true;
			}
		}
		for(int i=c;i>0;i--){
			if(fill[i]){
				System.out.println(i);
				break;
			}
		}

	}

}
