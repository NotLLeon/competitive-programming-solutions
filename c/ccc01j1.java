import java.util.*;
public class ccc01j1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H=sc.nextInt();
		String[] l =new String[(H+1)/2];
		String s="*";
		for(int j=0;j<H;j++){
			if(j<(H+1)/2){
				l[j]=s;
				for(int i=0;i<(H*2-2*s.length());i++){
					l[j]+=" ";
				}
				l[j]+=s;
				s+="**";
				System.out.println(l[j]);
			}else{
				System.out.println(l[H-j-1]);
			}
		}
	}
}
