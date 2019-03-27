import java.util.*;
public class ccc13s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue <Integer>Q=new LinkedList<Integer>();
		int W=sc.nextInt(),N=sc.nextInt();
		int [] cars=new int[N];
		for(int i=0;i<N;i++){
			cars[i]=sc.nextInt();
		}
		int nofc=0,tW=0,i=0;
		while(true){
			if(tW>W){
				break;
			}
			if(tW+cars[i]<=W&&Q.size()<4){
				Q.add(cars[i]);
				tW+=cars[i];
			}else if(Q.size()==4&&tW+cars[i]-cars[i-4]<=W){
					tW-=Q.poll();
					tW+=cars[i];
					Q.add(cars[i]);
					nofc++;
			}else{
				break;
			}
			i++;

			if(i==cars.length){
				break;
			}

		}

		System.out.println(nofc+Q.size());
	}

}