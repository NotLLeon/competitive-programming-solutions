import java.util.*;
public class ccc16j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int high=1;
		for(int i=0;i<a.length();i++){
			for(int j=i+high;j<a.length()+1;j++){
				String b=a.substring(i,j);
				boolean flag=false;
				for(int c=0;c<b.length()/2;c++){
					if(b.charAt(c)!=b.charAt(b.length()-c-1)){
						flag=true;
						break;
					}
				}
				if(!flag){
					high= b.length();
				}
			}
		}
		System.out.println(high);
	}

}
