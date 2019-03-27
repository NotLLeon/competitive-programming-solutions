import java.util.*;
public class dmopc17c2p4 {
	static boolean isPalin(String s){
		boolean flag=false;
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1)){
				flag=true;
				break;
			}
		}
		if(flag)return false;
		else return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		int max=0;
		LinkedList<String>p=new LinkedList<String>();
		for(int j=1+max;j<s.length();j++){
			String ss=s.substring(0, j);
			if(isPalin(ss))p.add(ss);
		}
		String [] ap=new String[p.size()];
		Arrays.fill(ap, "");
		int ind=0;
		while(!p.isEmpty()){
			ap[ind]=p.poll();
			ind++;
		}
		ind = 0;
		int ind1=0;
		for(int i=1;i<s.length();i++){
			if(ind<ap[ind1].length()&&(s.charAt(i)==ap[ind1].charAt(ind))){
				ind++;
			}else if(s.charAt(i)==ap[ind1+1].charAt(ind)){
				ind1++;
				ind++;
			}else{
				ind1=0;
				i-=ind;
				max=Math.max(max, ind);
				ind=0;
			}
			
		}
		System.out.println(max);

	}

}
