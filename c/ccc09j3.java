import java.util.Scanner;
public class ccc09j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int O=sc.nextInt();
		int V=0;
		int v=O-300;
		if(v<0){
			V=2360+v;
		} else {
			V=v;
		}
		if(V==2205){
			V=2245;
		}
		for(int b=100;b>0;b=b+100){
			if(V-b<100 && V-b>0){
				if(V-b>59){
					int s1=V-b+40;
					V=b+s1;
				}
			}
		}
		
		int E=V+100;
		
		int W=E+100;
		
		int T=O;
		
		int h=T+100;
		int H=0;
		if(h>2359){
			H=h-2360;
		} else {
			H=h;
		}
		
		int s=H+30;
		int S=0;
		if(s>2359){
			S=s-2360;
		} else {
			S=s;
		}
		for(int a=0;a>0;a=a+100){
			if(S-a<100 && S-a>0){
				if(S-a>59){
					int s1=S-a+40;
					S=a+s1;
				}
			}
		}
		if(V==2205){
			V=2245;
		}
		if(S==275){
			S=315;
		}
		if(W==2445){
			W=45;
		}
			
		
	 
	 
		System.out.println(O+" in Ottawa");
		System.out.println(V+" in Victoria");
		System.out.println(E+" in Edmonton");
		System.out.println(W+" in Winnipeg");
		System.out.println(T+" in Toronto");
		System.out.println(H+" in Halifax");
		System.out.println(S+" in St. John's");
		

	}

}
