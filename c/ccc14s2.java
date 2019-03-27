import java.util.*;
public class ccc14s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		boolean borg=true;
		if(N%2!=0){
			System.out.println("bad");
			borg=false;
		} else {
			String [] list=new String[N];
			String [] list2=new String[N]; 
			for(int i=0;i<N;i++){
				list[i]=sc.next();
			}
			for(int j=0;j<N;j++){
				list2[j]=sc.next();
			}
			for(int l=0;l<N;l++){
				if(list[l].equals(list2[l])){
					System.out.println("bad");
					borg=false;
					break;
				}
			}
			
		} 
		if(borg==true){
			System.out.println("good");
		}
	}

}
