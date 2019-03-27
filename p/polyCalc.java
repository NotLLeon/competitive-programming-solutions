import java.util.*;
public class polyCalc {

	// Note: I did not write all this cancer specifically for this problem.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int deg=sc.nextInt();

			int []coef=new int[deg+1];
			for(int i=deg;i>-1;i--){
				coef[i]=sc.nextInt();
			}
			while(coef.length>=2){
				int b=Math.abs(coef[0]), a=Math.abs(coef[coef.length-1]);
				LinkedList<Integer>f=new LinkedList<Integer>();
				if(b!=0){
					for(int i=1;i<b+1;i++){
						if(b%i==0){
							f.add(i);
							f.add(-i);
						}
					}
				}else{
					f.add(0);
				}
				int []fac=new int[f.size()];
				int i=0;
				while(!f.isEmpty()){
					fac[i]=f.poll();
					i++;
				}
				boolean flg=false;
				for(i=1;i<a+1;i++){
					if(a%i==0){
						for(int j=0;j<fac.length;j++){
							int bf=fac[j];
							if(sub(-bf,i, coef)){
								int []ar1={bf,i}, ar2=new int[coef.length-1];
								coef=divide(ar1,coef,ar2, coef.length-1, coef[coef.length-1]);
								flg=true;
								System.out.print(-ar1[0]/ar1[1]+" ");
								break;
							}
						}
					}
					if(flg)break;
				}
				if(!flg){
					break;
				}
			}
			System.out.println();
		}
	}
	static int[] divide(int []divisor, int[]dividend, int[]quo, int ind, int a){
		if(divisor.length>dividend.length||ind==0)return quo;
		quo[ind-1]=a/divisor[1];
		int ans=dividend[ind-1]-divisor[0]*quo[ind-1];
		ind--;
		return divide(divisor, dividend, quo,  ind, ans);
	}
	static boolean sub(int b, int a, int[]coef){
		double total=0, ba=(double)b/(double)a;
		for(int i=0;i<coef.length;i++){
			total+=Math.round(coef[i]*Math.pow(ba, i)*1000.0)/1000.0;
		}
		if(total==0)return true;
		else return false;
	}
}