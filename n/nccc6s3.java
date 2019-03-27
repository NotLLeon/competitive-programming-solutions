import java.util.*;
public class nccc6s3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt(), y=sc.nextInt(), n=sc.nextInt(),sx=sc.nextInt(),
				sy=sc.nextInt(), ex=sc.nextInt(), ey=sc.nextInt();
		boolean[][]no=new boolean[x+1][y+1];
		for(int i=0;i<n;i++)no[sc.nextInt()][sc.nextInt()]=true;
		Queue<Integer>pos=new LinkedList<Integer>(), vel=new LinkedList<Integer>(), cnt=new LinkedList<Integer>();
		cnt.add(1);
		pos.add(sx);pos.add(sy);
		vel.add(0);vel.add(0);
		BitSet[][]vv=new BitSet[x+1][y+1];
		for(int i=0;i<=x;i++){
			for(int j=0;j<=y;j++)vv[i][j]=new BitSet();
		}
		vv[sx][sy].set(hash(0,0));
		int[][]mv={{0,1},{0,-1},{1,0},{-1,0},{0,0}};
		while(!pos.isEmpty()){
			int cx=pos.poll(), cy=pos.poll(), xv=vel.poll(), yv=vel.poll(), cc=cnt.poll();
			for(int i=0;i<5;i++){
				int nvx=xv+mv[i][0], nvy=yv+mv[i][1];
				int nx=cx+nvx,ny=cy+nvy;
				if(nx>-1&&nx<=x&&ny>-1&&ny<=y&&!vv[nx][ny].get(hash(nvx,nvy))){
					if(nx==ex&&ny==ey&&nvy==0&&nvx==0){
						System.out.println(cc);
						return;
					}
					int mx=0, my=0, tx=cx, ty=cy;
					if(nvx*nvy==0){
						if(nvx==0&&nvy!=0)my=nvy/Math.abs(nvy);
						else if(nvy==0&&nvx!=0)mx=nvx/Math.abs(nvx);
					}else{
						int gcd=gcd(Math.abs(nvx),Math.abs(nvy));
						mx=nvx/gcd; my=nvy/gcd;
					}
					boolean yes=true;
					while(true){
						if(tx==nx&&ty==ny)break;
						tx+=mx;
						ty+=my;
						if(no[tx][ty]){
							yes=false;
							break;
						}
					}
					if(yes){
						vv[nx][ny].set(hash(nvx,nvy));
						pos.add(nx);
						pos.add(ny);
						vel.add(nvx);
						vel.add(nvy);
						cnt.add(cc+1);
					}
				}
			}
		}
		System.out.println(-1);
	}
	static int hash(int a, int b){
		return (a+101)*101+b+101;
	}
	static int gcd(int a, int b){
		if(a<b)return gcd(b,a);
		if(b==0)return a;
		return gcd(a-b,b);
	}

}
