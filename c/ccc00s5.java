import java.util.*;
public class ccc00s5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		double [][]sheep=new double[n][2];
		for(int i=0;i<n;i++){
			sheep[i][0]=sc.nextDouble();
			sheep[i][1]=sc.nextDouble();
		}
		boolean []used=new boolean[n];
		LinkedList<Integer>ans=new LinkedList<Integer>();
		for(double i=0.0;i<=1000.0;i+=0.01){
			double min=Double.MAX_VALUE;
			for(int j=0;j<n;j++){
				double dis=Math.sqrt(Math.pow(Math.abs(sheep[j][0]-i), 2)+Math.pow(sheep[j][1], 2));
				if(dis<min){
					ans=new LinkedList<Integer>();
					ans.add(j);
					min=dis;
				}else if(dis==min){
					ans.add(j);
				}
			}
			while(!ans.isEmpty()){
				int close=ans.poll();
				if(!used[close]){
					used[close]=true;
					System.out.printf("%s%.2f%s%.2f%s\n","The sheep at (",sheep[close][0],", ",sheep[close][1],") might be eaten.");
				}
			}
		}
	} 
}
