import java.util.*;
import java.io.*;
public class valentines19s2 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
		int[]cr=new int[n], cc=new int[n];
		HashMap<Long, Integer>tm=new HashMap<Long, Integer>();
		for(int i=0;i<q;i++){
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken()), a=Integer.parseInt(st.nextToken())-1, b=Integer.parseInt(st.nextToken())-1;
			long nv=(long) ((long)(a)*1000000+b);
			if(cmd==1){	
				if(tm.containsKey(nv))tm.put(nv, tm.remove(nv)+1);
				else tm.put(nv, 1);
				cr[a]++;
				cc[b]++;
			}else{
				long v=cr[a]+cc[b];
				if(tm.containsKey(nv))v-=tm.get(nv);
				System.out.println((v)%2);
			}
		}

	}

}
