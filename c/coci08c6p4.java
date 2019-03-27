import java.util.*;
public class coci08c6p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		LinkedList<Integer>[]l=new LinkedList[3];
		int[]m=new int[3];
		for(int i=0;i<3;i++)l[i]=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			l[x%3].add(x);
			m[x%3]++;
		}
		if(m[0]==0&&m[1]>0&&m[2]==0)while(!l[1].isEmpty())System.out.print(l[1].poll()+" ");
		else if(m[0]==0&&m[2]>0&&m[1]==0)while(!l[2].isEmpty())System.out.print(l[2].poll()+" ");
		else if(m[0]>m[1]+m[2]+1)System.out.println("impossible");
		else if(m[0]==0&&m[1]>0&&m[2]>0)System.out.println("impossible");
		else{
			Deque<Integer>dq=new LinkedList<Integer>();
			dq.add(0);
			m[0]--;
			while(m[1]>0){
				if(dq.peekFirst()==0){
					dq.addFirst(1);
					m[1]--;
				}else if(dq.peekFirst()==1){
					if(m[0]==0){
						dq.addFirst(1);
						m[1]--;
					}else{
						dq.addFirst(0);
						m[0]--;
					}
				}
			}
			while(m[2]>0){
				if(dq.peekLast()==0){
					dq.addLast(2);
					m[2]--;
				}else if(dq.peekLast()==2){
					if(m[0]==0){
						dq.addLast(2);
						m[2]--;
					}else {
						dq.addLast(0);
						m[0]--;
					}
				}
			}
			while(m[0]>0){
				if(dq.peekLast()!=0){
					dq.addLast(0);
					m[0]--;
				}else if(dq.peekFirst()!=0){
					dq.addFirst(0);
					m[0]--;
				}
			}
			while(!dq.isEmpty()){
				System.out.print(l[dq.poll()].poll()+" ");
			}
		}

	}

}
