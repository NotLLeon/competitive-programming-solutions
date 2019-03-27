import java.util.*;
public class ccc16s5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long t=sc.nextLong();sc.nextLine();
		String s=sc.nextLine();
		TreeSet<String>found=new TreeSet<String>();
		LinkedList<String>l=new LinkedList<String>(), nr=new LinkedList<String>();
		found.add(s);
		long loops=0;
		while(true){
			String r="";
			for(int j=0;j<s.length();j++){
				if(s.charAt(check(j+1,s.length()))=='1'&& s.charAt(check(j-1,s.length()))=='0')r+="1";
				else if(s.charAt(check(j+1,s.length()))=='0'&&s.charAt(check(j-1,s.length()))=='1')r+="1";
				else r+="0";
			}
			l.add(s);
			if(found.contains(r)){
				int sz=l.indexOf(r);
				for(int i=0;i<sz;i++){
					nr.add(l.pollFirst());
				}
				break;
			}
			found.add(r);
			
			s=r;
			loops++;
		}
		System.out.println(loops);
		if(t<nr.size())System.out.println(nr.get((int) t));
		else System.out.println(l.get((int) ((t-nr.size())%loops)));
	}
	static int check(int n, int x){
		if(n<0)return x+n;
		else if(n>=x)return n-x;
		else return n;
	}
}
