import java.util.*;
public class ccc03s3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), r=sc.nextInt(), c=sc.nextInt();
		String[][]adj=new String[r][c];
		for(int i=0;i<r;i++){ 
			String s=sc.next();
			for(int j=0;j<c;j++){
				adj[i][j]=s.substring(j, j+1);
			}
		}
		LinkedList<Integer>l=new LinkedList<Integer>();
		for(int i=0;i<r;i++){ 
			for(int j=0;j<c;j++){
				if(adj[i][j].equals(".")){
					adj[i][j]="I";
					int cnt=1;
					Queue <Integer>q=new LinkedList<Integer>();
					q.add(i);q.add(j);
					while(true){
						int cury=q.poll(), curx=q.poll();
						if(cury+1>-1&&cury+1<r){
							if(adj[cury+1][curx].equals(".")){
								q.add(cury+1); q.add(curx);
								adj[cury+1][curx]="I";
								cnt++;
							}
						}
						if(cury-1>-1&&cury-1<r){
							if(adj[cury-1][curx].equals(".")){
								q.add(cury-1); q.add(curx);
								adj[cury-1][curx]="I";
								cnt++;
							}
						}
						if(curx+1>-1&&curx+1<c){
							if(adj[cury][curx+1].equals(".")){
								q.add(cury); q.add(curx+1);
								adj[cury][curx+1]="I";
								cnt++;
							}
						}
						if(curx-1>-1&&curx-1<c){
							if(adj[cury][curx-1].equals(".")){
								q.add(cury); q.add(curx-1);
								adj[cury][curx-1]="I";
								cnt++;
							}
						}
						if(q.isEmpty()){
							l.add(cnt);
							break;
						}
					}
				}
			}
		}
		Collections.sort(l);
		int rooms=0;
		boolean flag=false;
		for(int i=l.size()-1;i>-1;i--){
			if(n-l.get(i)>-1){
				n-=l.get(i);
				rooms++;
			}else{
				flag=true;
				if(rooms==1){
					System.out.println("1 room, "+n+" square metre(s) left over" );
				}else{
					System.out.println(rooms +" rooms, " +n+" square metre(s) left over" );
				}
				break;
			}
		}
		if(!flag){
			System.out.println(rooms +" rooms, " +n+" square metre(s) left over" );
		}
	}


}
