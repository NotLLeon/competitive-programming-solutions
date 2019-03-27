import java.util.*;
public class tree1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	int n[][]=new int[4][4];
	int cnt=0;
	for(int row=0;row<4;row++){
		for(int col=0;col<4;col++){
			n[row][col]=sc.nextInt();
			if(n[row][col]==1){
				cnt++;
			}
		}
	}
	int a=4;
	for(int i=0;i<4;i++){
		int count=0;
		if(n[i][0]==0){
			count++;
		}
		if(count==4){
			a--;
		}
	}
	if(cnt/2==a-1){
		System.out.println("Yes");
	}else{
		System.out.println("No");
	}
		
		

	}

}