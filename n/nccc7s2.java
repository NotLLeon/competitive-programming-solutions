import java.util.*;
import java.awt.geom.*;
public class nccc7s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt(), y=sc.nextInt();
		int x1=sc.nextInt(), y1=sc.nextInt(), x2=sc.nextInt(), y2=sc.nextInt();
		double min=9999999;
		min=Math.min(min, dis(x1,x2,y1,x,y));
		min=Math.min(min, dis(x1,x2,y2,x,y));
		min=Math.min(min, dis(y1,y2,x1,y,x));
		min=Math.min(min, dis(y1,y2,x2,y,x));
		System.out.printf("%.3f\n",min);
	}
	static double dis(int x1, int x2,int y1, int x, int y){
		double d=0.0;
		if(x<=x1||x>=x2){
			d=Math.min(dis1(x1,y1,x,y),dis1(x2,y1,x,y));
		}else{
			d=Math.abs(y-y1);
		}
		return d;
	}
	static double dis1(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
}
