import java.util.*;
import java.util.Map.Entry;
public class dmopc17c1p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		int []a=new int[n];
		long max=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();

		}
		TreeMap<Long, Long>tm=new TreeMap<Long, Long>();
		long cumSum = 0;
		for (int i=0; i<n; i++)
		{
			cumSum += a[i]%m;
			if(!tm.containsKey((cumSum+m)%m)){
				tm.put((cumSum+m)%m, (long) 1);
			}else{
				tm.put((cumSum+m)%m, tm.get((cumSum+m)%m)+1);
			}
		}
		long result=0;
		result+=tm.get(0);
		for (int i=0; i<tm.size(); i++){
			Entry<Long, Long> x=tm.pollFirstEntry();
			if (x.getValue() > 1){
				result += (x.getValue()*(x.getValue()-1))/2;
			}
		}
		System.out.println(result);
	}
}