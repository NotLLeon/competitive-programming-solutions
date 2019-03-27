import java.util.*;
public class ccc13j4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int C=sc.nextInt();
		int []chore=new int[C];
		for(int i=0;i<C;i++){
			chore[i]=sc.nextInt();
		}
		Arrays.sort(chore);
		for(int j=0;j<C;j++){
			if(T-chore[j]<0){
				System.out.println(j);
				break;
			}else{
			T=T-chore[j];
			}
		}
		
	
	}

}
