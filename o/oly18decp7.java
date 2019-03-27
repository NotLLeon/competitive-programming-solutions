import java.util.*;
public class oly18decp7 {
	static double []ar;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		ar=new double[n];
		for(int i=0;i<n;i++)ar[i]=sc.nextDouble();
		Arrays.sort(ar);
		double min=getMed(1,n), max=getMed(0,n-1);
		min=(ar[0]+min)/2;
		max=(ar[n-1]+max)/2;
		if(n>2){
			min=Math.min(min, ar[1]);
			max=Math.max(max, ar[n-2]);
		}
		System.out.printf("%.2f %.2f\n",min,max);
	}
    static double getMed(int l, int r){
		if((r-l)%2!=0)return ar[(l+r)/2];
		else return (ar[(l+r)/2]+ar[(l+r)/2-1])/2;
	}
}
