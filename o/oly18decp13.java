import java.util.*;
public class oly18decp13 {
	static class coord implements Comparable<coord>{
		int x,y1,y2,v;
		coord(int a, int b,int c, int d){
			x=a;
			y1=b;
			y2=c;
			v=d;
		}
		public int compareTo(coord e){
			return this.x-e.x;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[]cmp=new int[n*2];
		coord[]evnts=new coord[n*2];
		for(int i=0;i<n;i++){
			int x1=sc.nextInt(), y1=sc.nextInt(), x2=sc.nextInt(), y2=sc.nextInt();
			cmp[i*2]=y1;
			cmp[i*2+1]=y2;
			evnts[i*2]=new coord(x1,y1,y2,1);
			evnts[i*2+1]=new coord(x2,y1,y2,-1);
		}
		Arrays.sort(evnts);
		Arrays.sort(cmp);
		long s=0, cc=0, prev=0;
		int[]line=new int[n*2];
		for(int i=0;i<n*2;i++){
			if(i!=0){
				cc=0;
				for(int j=0;j<n*2;j++)if(line[j]>0)cc+=cmp[j+1]-cmp[j];
				s+=cc*(long)(evnts[i].x-prev);
			}
			prev=evnts[i].x;
			int c1=Arrays.binarySearch(cmp, evnts[i].y1), c2=Arrays.binarySearch(cmp, evnts[i].y2);
			for(int j=c2;j<c1;j++)line[j]+=evnts[i].v;
		}
		System.out.println(s);



	}

}
