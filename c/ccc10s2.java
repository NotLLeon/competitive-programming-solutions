import java.util.*;
public class ccc10s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		String [] s=new String[N];
		String [] n=new String[N];
		for(int i=0;i<N;i++){
			s[i]=sc.next().trim();
			n[i]=sc.next().trim();
//			System.out.println(s[i]+" "+n[i]);
		}
		String l=sc.next().trim();

		for(int i=0;i<l.length()+1;i++){
			boolean flag=false;
			for(int j=i+1;j<l.length()+1;j++){
				if(flag==true){
					break;
				}
				for(int k=0;k<n.length;k++){
					if(l.substring(i, j).equals(n[k])){
						System.out.print(s[k]);
//						System.out.println(l.substring(i, j)+" "+i+" "+j);
						i+=j-i-1;
//						System.out.println(i);
						flag=true;
						break;
					}
				}
			}
		}

	}

}
