import java.io.*;
import java.util.*;
public class cco10p3 {
	static int []bit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [][]off=new int[n][3];
		int[]temp=new int[1000000];
		int n1,cur, lo, hi, mid, tg, qm, ql;
		String []in;
		char cmd;
		for(int i=0;i<n;i++){
			in=br.readLine().split(" ");
			cmd=in[0].charAt(0);
			n1=Integer.parseInt(in[1]);
			off[i][1]=n1;
			if(cmd=='N'){
				off[i][0]=0;
				off[i][2]=Integer.parseInt(in[2]);
				temp[i]=off[i][2];
			}else if(cmd=='M'){
				off[i][0]=1;
				off[i][2]=Integer.parseInt(in[2]);
				temp[i]=off[i][2];
			}else off[i][0]=2;
		}
		Arrays.sort(temp);
		HashMap<Integer, Integer>lib1=new HashMap<Integer, Integer>();
		int[]lib2=new int[1000001];
		bit=new int[temp.length+1];
		for(int i=0;i<n;i++){
			if(off[i][0]==0){
				update(Arrays.binarySearch(temp,off[i][2])+1, 1);
				lib1.put(off[i][2], off[i][1]);
				lib2[off[i][1]]=off[i][2];
			}else if(off[i][0]==1){
				update(Arrays.binarySearch(temp,lib2[off[i][1]])+1,-1);
				update(Arrays.binarySearch(temp,off[i][2])+1,1);
				lib1.remove(lib2[off[i][1]]);
				lib1.put(off[i][2],off[i][1]);
				lib2[off[i][1]]=off[i][2];
			}else{
				lo=0;hi=temp.length-1;mid=0;tg=query(bit.length-1)-off[i][1]+1;ql=0;qm=0;
				while(true){
					mid=(lo+hi)/2;
					qm=query(mid+1);ql=(mid==0?-1:query(mid));
					if(qm==tg&&ql<tg)break;
					if(qm>tg||(qm==tg&&ql==tg))hi=mid-1;
					else lo=mid+1;
				}
				System.out.println(lib1.get(temp[mid]));
			}
		}
	}
	static void update(int x, int val){
		for(;x<bit.length;x+=(x&-x))bit[x]+=val;
	}
	static int query(int x){
		int sum=0;
		for(;x>0;x-=(x&-x))sum+=bit[x];
		return sum;
	}
}