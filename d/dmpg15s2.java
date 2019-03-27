import java.util.*; 
public class dmpg15s2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt(); int n=sc.nextInt();
		int [] a=new int[r*4];
		int cnt=0;
		for(int i=0;i<r*4;i+=4){
			int x=sc.nextInt();int y=sc.nextInt();int w=sc.nextInt();int l=sc.nextInt();
			a[i]=x; a[i+1]=x+w-1; a[i+2]=y;a[i+3]=y+l-1;
			//System.out.println(Arrays.toString(a));
		}
		for(int i=0;i<n;i++){
			int x1=sc.nextInt();int y1=sc.nextInt();
			for(int j=0;j<r*4;j+=4){
			//	System.out.println(a[j]+" "+x1+" "+a [j+1]+" "+a[j+2]+" "+y1+" "+a[j+3]);
				if(a[j]<=x1&&a[j+1]>=x1&&a[j+2]<=y1&&a[j+3]>=y1){
					//System.out.println("Y");
					a[j]=-1;a[j+1]=-1;a[j+2]=-1;a[j+3]=-1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
