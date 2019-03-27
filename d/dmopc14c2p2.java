import java.util.*;
public class dmopc14c2p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L=sc.nextInt();
		String log=sc.next();
		String [] l=log.split("X");
		int cnt=0;
		LinkedList <String>p=new LinkedList<String>();
		for(int i=0;i<l.length;i++){
			if(!l[i].equals("")){
				p.add(l[i]);
				cnt++;		
			}
		}
		System.out.println(cnt);
		for(int i=0;i<p.size();i++){
			System.out.println(p.get(i));
		}
	}

}
