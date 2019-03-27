import java.util.*;
public class ccc10j5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1=sc.nextInt()-1; int y1=sc.nextInt()-1;
		int x2=sc.nextInt()-1; int y2=sc.nextInt()-1;
		int[] X = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] Y = {2, 1, -1, -2, -2, -1, 1, 2};
		int [][] board=new int[8][8];
		int n=0;
		LinkedList <Integer> l=new LinkedList<Integer>();
		l.add(x1); l.add(y1);
		board[x1][y1]=1;
		int s1=x1; int s2=y1;
		while(true){
			boolean flag=true;
			int x=l.poll();
			int y=l.poll();
			if(x==x2&&y==y2){
				System.out.println(n);
				break;
			}
			for(int i=0;i<X.length;i++){
				if(x+X[i]<8&&x+X[i]>-1&&y+Y[i]<8&&y+Y[i]>-1){
					if(board[x+X[i]][y+Y[i]]!=1){
						board[x+X[i]][y+Y[i]]=1;
						l.add(x+X[i]);l.add(y+Y[i]);	
					}
				}
			}

			for(int i=0;i<l.size()-1;i+=2){
				if(l.get(i)==s1&&l.get(i+1)==s2){
					flag=false;
					break;
				}
			}
			if(flag==true){
				n++;
				s2=l.get(l.size()-1);
				s1=l.get(l.size()-2);
			}

		}

	}

}