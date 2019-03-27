import java.util.*;
public class gfssoc2s2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), t=sc.nextInt();
		LinkedList<String>s=new LinkedList<String>();
		int[]f=new int[n];
		for(int i=0;i<n;i++){
			s.add(sc.next());
			f[i]=sc.nextInt();
		}
		LinkedList<String>ans=new LinkedList<String>();
		for(int i=0;i<n-2;i++){
			for(int j=i+1;j<n-1;j++){
				for(int k=j+1;k<n;k++){
					if(f[i]+f[j]+f[k]<=t){
						String[]sm=new String[3];
						sm[0]=s.get(i);sm[1]=s.get(j);sm[2]=s.get(k);
						Arrays.sort(sm);
						String as="";
						for(int g=0;g<3;g++){
							as+=sm[g]+" ";
						}
						ans.add(as);
					}
				}
			}
		}
		Collections.sort(ans);
		for(int i=0;i<ans.size();i++){
			System.out.println(ans.get(i));
		}

	}

}