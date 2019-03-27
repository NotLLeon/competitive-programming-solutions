import java.util.*;
public class ccc00s4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d=sc.nextInt(), n=sc.nextInt();
		int []c=new int[n], best=new int[d+1];
		Arrays.fill(best, 999);
		best[0]=0;
		for(int i=0;i<n;i++)c[i]=sc.nextInt();
		for(int i=0;i<d;i++){
			for(int j=0;j<n;j++){
				if(i+c[j]<=d)best[i+c[j]]=Math.min(best[i]+1, best[i+c[j]]);
			}
		}
		System.out.println(best[d]==999?"Roberta acknowledges defeat.":"Roberta wins in "+best[d]+" strokes.");
	}
}
