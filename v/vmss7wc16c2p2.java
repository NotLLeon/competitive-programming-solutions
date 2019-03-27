import java.util.*;
public class vmss7wc16c2p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		int[]psa=new int[s.length()+1];
		for(int i=0;i<s.length();i++){
			psa[i+1]=psa[i]+(s.charAt(i)=='G'?1:0);
		}
		int q=sc.nextInt();
		for(int i=0;i<q;i++){
			int l=sc.nextInt();
			System.out.println(psa[sc.nextInt()+1]-psa[l]);
		}
	}

}
