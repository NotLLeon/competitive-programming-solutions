import java.util.*;
public class ccc15s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K=sc.nextInt();
		int count=0;
		ArrayList<Integer> num=new ArrayList<Integer>();
		
		for(int i=0;i<K;i++){
	 		num.add(sc.nextInt());
		}
		
		for(int l=K;l>0;l--){
			if(num.get(l-1)==0){
				count++;
			} else{
				if(count>0){
					num.remove(l-1);
					count--;
				}
				
			}
		}
		int total=0;
		for(int j=0;j<num.size();j++){
			
			total=total+num.get(j);
		}
		System.out.println(total);

	}

}
