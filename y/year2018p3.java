import java.util.*;
import java.util.Map.Entry;
public class year2018p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt(), min=Integer.MAX_VALUE, f=0;
		int []h=new int[n];
		for(int i=0;i<n;i++){
			h[i]=sc.nextInt();
			if(h[i]==min)f++;
			min=Math.min(min, h[i]);
		}
		if(k==1){
			f++;
			int cnt=0, maxcnt=0;
			for(int i=0;i<m;i++){
				if(h[i]==min)cnt++;
			}
			maxcnt=cnt;
			for(int i=m;i<n;i++){
				if(h[i]==min)cnt++;
				if(h[i-m]==min)cnt--;
				maxcnt=Math.max(maxcnt, cnt);
			}
			if(maxcnt==f)System.out.println(min+1);
			else System.out.println(min);
		}else{
			TreeMap<Integer, Integer>u=new TreeMap<Integer, Integer>();
			for(int i=0;i<n;i++){
				if(u.containsKey(h[i])){
					int r=u.get(h[i]);
					u.remove(h[i]);
					u.put(h[i], r+1);
				}else{
					u.put(h[i], 1);
				}
			}
			Entry<Integer, Integer> first=u.ceilingEntry(min-1);
			while(k!=0){
				Entry<Integer, Integer> second=u.ceilingEntry(min+1);
				if(second==null){
					System.out.println(first.getKey()+k/first.getValue());
					return;
				}
				if(k-((second.getKey()-first.getKey())*first.getValue())>=0){
					u.remove(second.getKey());
					u.put(second.getKey(), second.getValue()+first.getValue());
					k-=((second.getKey()-first.getKey())*first.getValue());
					first=second;
				}else{
					break;
				}
			}
			System.out.println(u.firstKey());
			
		}
	}

}
