import java.io.*;
import java.util.*;
public class ccc15s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g=Integer.parseInt(br.readLine()), p=Integer.parseInt(br.readLine()), cnt=0;
		TreeMap<Integer, Integer> gate=new TreeMap<Integer, Integer>();
		for(int i=0;i<g;i++){
			gate.put(i, i);
		}
		for(int i=0;i<p;i++){
			int n=Integer.parseInt(br.readLine());
			if(gate.lowerKey(n)!=null){
				cnt++;
				gate.remove(gate.lowerKey(n));
			}else{
				break;
			}
		}
		System.out.println(cnt);

	}

}
