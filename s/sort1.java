import java.util.*;
public class sort1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte n=sc.nextByte();
		short [] arr=new short[n];
		for(byte i=0;i<n;i++){
			arr[i]=sc.nextShort();
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		boolean sorted = false;
		while(!sorted){
			sorted = true;
			for(byte i=0;i<n-1;i++){
				if(arr[i]>arr[i+1]){
					short swap=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=swap;
					for(byte j=0;j<n;j++)System.out.print(arr[j]+" ");
					System.out.println();
					sorted = false;
				}
			}
			
		}
	}

}
