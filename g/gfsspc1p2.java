import java.util.*;
public class gfsspc1p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		boolean flag=false;
		boolean lob=false;
		for(int i=0;i<n/2;i++){
			String h1=sc.next();
			String h2=sc.next();
			if(!h1.equals(h2)&&(h1.equals("lob")||h2.equals("lob"))){
				flag=true;
				lob=true;
			}else if(h2.equals("lob")){
				lob=true;
			}
		}
		if(lob==false){
			System.out.println("Not enough information");
		}else if(flag==false&&lob==true){
			System.out.println("Possible Bruno");
		}else{
			System.out.println("BruNO");
		}
	}

}
