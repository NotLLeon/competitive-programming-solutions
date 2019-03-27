import java.util.*;
public class bfs17p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int []c=new int[6];
		for(int i=0;i<n;i++){
			String s= sc.next();
			if(s.equals("red")){
				c[0]++;
			}else if(s.equals("orange")){
				c[1]++;
			}else if(s.equals("yellow")){
				c[2]++;
			}else if(s.equals("green")){
				c[3]++;
			}else if(s.equals("blue")){
				c[4]++;
			}else if(s.equals("black")){
				c[5]++;
			}
		}
		int prev=-1, size=0;

		for(int i=0;i<n;i++){
			int max=-1, ind=0;
			for(int j=0;j<6;j++){
				if(c[j]>max&&j!=prev){
					max=c[j];
					ind=j;
				}
			}
			if(max==0)break;
			size++;
			c[ind]--;
			prev=ind;
		}
		System.out.println(size);
	}
}
