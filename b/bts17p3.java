import java.io.*;
import java.util.*;
public class bts17p3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		double [][]a=new double[n][2];
		for(int i=0;i<n;i++){
			double n1=Double.parseDouble(br.readLine());
			if(n1%2==0){
				a[i][0]=n1-0.5;
				a[i][1]=n1+0.5;
			}else{
				a[i][0]=n1-0.4999999999999999;
				a[i][1]=n1+0.4999999999999999;
			}
		}
		double ans1=0, ans2=0;
		for(int i=0;i<n;i++){
			ans1+=a[i][0];
			ans2+=a[i][1];
		}
		if(ans1%1!=0&&ans1%0.5==0){
			if((ans1-0.5)%2==0){
				ans1-=0.5;
			}else{
				ans1+=0.5;
			}
		}
		if(ans2%1!=0&&ans2%0.5==0){
			if((ans2-0.5)%2==0){
				ans2-=0.5;
			}else{
				ans2+=0.5;
			}
		}
		ans1=Math.round(ans1);ans2=Math.round(ans2);
		System.out.printf("%.0f%n",ans1);
		System.out.printf("%.0f",ans2);

	}

}