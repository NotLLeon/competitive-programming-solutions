import java.util.*;
import java.io.*;
public class cerc2000h {
	static class Subject{
		String name;
		LinkedList<Action>action;
		Subject(String a){
			name=a;
			action=new LinkedList<Action>();
		}
		void add(String[] newAct, int ind){
			action.add(new Action(newAct,ind));
		}
		boolean contradicts(Action newAA){
			for(Action a:lkup.get(0).action){
				if(a.pred.equals(newAA.pred)&&a.obj.equals(newAA.obj)&&a.neg!=newAA.neg)return true;
			}
			for(Action a:action){
				if(a.pred.equals(newAA.pred)&&a.obj.equals(newAA.obj)&&a.neg!=newAA.neg)return true;
			}
			return false;
		}
	}
	static class Action implements Comparable<Action>{
		String pred, obj;
		int ind;
		boolean neg;
		Action(String[]words, int a){
			ind=a;
			neg=false;
			int startInd=1;
			if(words[1].equals("don't")||(words[1].equals("doesn't"))){
				neg=true;
				startInd++;
			}
			pred=words[startInd];
			if(pred.charAt(pred.length()-1)=='s')pred=pred.substring(0, pred.length()-1);
			obj=words[startInd+1];
		}
		void print(boolean s, boolean d, boolean n, boolean end){
			if(n)System.out.print(d?"don't ":"doesn't ");
			System.out.print(pred+(s?"s":""));
			if(!obj.equals(""))System.out.print(" "+obj);
			if(end)System.out.println(".");
		}
		public int compareTo(Action e){
			return this.ind-e.ind;
		}
	}
	static class SString implements Comparable<SString>{
		String s;
		int ind;
		SString(String a, int b){
			s=a;
			ind=b;
		}
		public int compareTo(SString e){
			return this.ind-e.ind;
		}
	}
	static LinkedList<Subject>lkup;
	static boolean cntra;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int dia=Integer.parseInt(br.readLine());
		for(int curD=1;curD<=dia;curD++){
			System.out.println("Dialogue #"+curD+":");
			cntra=false;
			String cur=br.readLine();
			lkup=new LinkedList<Subject>();
			lkup.add(new Subject("everybody"));
			int an=0;
			while(cur.charAt(cur.length()-1)!='!'){
				if(cur.charAt(cur.length()-1)=='.'){
					cur=cur.substring(0,cur.length()-1);
					if(!cntra)addToLkup(cur, an++);
				}else{
					System.out.println(cur);
					cur=cur.substring(0,cur.length()-1);
					if(cntra)System.out.println("I am abroad.");
					else if(cur.substring(0,2).equals("do"))qType1(cur);
					else if(cur.substring(0,3).equals("who"))qType2(cur);
					else qType3(cur);
					System.out.println();
				}
				cur=br.readLine();
			}
			System.out.println(cur+"\n");
		}
	}
	static Action copy(Action old){
		Action n=new Action(new String[]{"$","$","$","$"},old.ind);
		n.obj=old.obj;
		n.pred=old.pred;
		n.neg=old.neg;
		return n;
	}
	static String[]split(String cur, boolean cut){
		cur=cur.trim();
		String[]ans=new String[4];
		for(int i=0;i<4;i++)ans[i]="";
		StringTokenizer st = new StringTokenizer(cur);
		int ind=0, tar=2;
		if(cut)st.nextToken();
		while(st.hasMoreTokens()){
			if(ind<=tar){
				ans[ind]=st.nextToken();
				if(ind==1&&(ans[ind].equals("don't")||ans[ind].equals("doesn't")))tar++;
				ind++;
			}else ans[tar]+=" "+st.nextToken();
		}
		return ans;
	}
	static void addToLkup(String cur, int ind){
		String [] curWords = split(cur, false);
		String sub=curWords[0];
		Action newA=new Action(curWords,ind);
		if(sub.equals("you"))sub="I";
		else if(sub.equals("I"))sub="you";
		else if(sub.equals("everybody")){
			for(Subject s:lkup){
				if(s.contradicts(newA)){
					cntra=true;
					return;
				}
			}
			lkup.get(0).action.add(newA);
			return;
		}else if(sub.equals("nobody")){
			newA.neg=true;
			for(Subject s:lkup){
				if(s.contradicts(newA)){
					cntra=true;
					return;
				}
			}
			lkup.get(0).action.add(newA);
			return;
		}
		int index=0;
		for(Subject s:lkup){
			if(s.name.equals(sub))break;
			index++;
		}
		if(index==lkup.size())lkup.add(new Subject(sub));
		if(lkup.get(index).contradicts(newA))cntra=true;
		else lkup.get(index).action.add(newA);
	}
	static void qType1(String cur){
		String[]words=split(cur,true);
		Action newA=new Action(words,-1);
		String sub=words[0];
		boolean iou=false;
		if(sub.equals("I")){
			sub="you";
			iou=true;
		}else if(sub.equals("you")){
			sub="I";
			iou=true;
		}
		int bool=qType1Compute(newA,sub);
		if(bool==0)System.out.println("maybe.");
		else{
			System.out.print(bool==1?"yes, ":"no, ");
			System.out.print(sub+" ");
			newA.print(!iou&&bool==1,iou,bool!=1,true);
		}
	}
	static int qType1Compute(Action newA, String sub){
		for(Action a:lkup.get(0).action){
			if(newA.obj.equals(a.obj)&&newA.pred.equals(a.pred)){
				return a.neg?-1:1;
			}
		}
		for(Subject s:lkup){
			if(s.name.equals(sub)){
				for(Action a:s.action){
					if(newA.obj.equals(a.obj)&&newA.pred.equals(a.pred)){
						return a.neg?-1:1;
					}
				}
			}
		}
		return 0;
	}
	static void qType2(String cur){
		String[]words=split(cur,false);
		Action newA=new Action(words,-1);
		for(Action a:lkup.get(0).action){
			if(a.obj.equals(newA.obj)&&a.pred.equals(newA.pred)){
				System.out.print(a.neg?"nobody ":"everybody ");
				newA.print(true, false, false, true);
				return;
			}
		}
		LinkedList<SString>ans=qType2Compute(newA);
		if(ans.isEmpty())System.out.println("I don't know.");
		else if(ans.size()==1){
			String sub=ans.remove().s;
			System.out.print(sub+" ");
			newA.print(!(sub.equals("I")||sub.equals("you")),false,false, true);
		}else{
			while(!ans.isEmpty()){
				String sub=ans.poll().s;
				System.out.print(sub);
				if(ans.size()==1)System.out.print(" and ");
				else if(ans.size()>0)System.out.print(", ");
				else System.out.print(" ");
			}
			newA.print(false,false,false,true);
		}
	}
	static LinkedList<SString> qType2Compute(Action newA){
		LinkedList<SString>ans=new LinkedList<SString>();
		for(Subject s:lkup){
			for(Action a:s.action){
				if(newA.obj.equals(a.obj)&&newA.pred.equals(a.pred)&&!a.neg)ans.add(new SString(s.name,a.ind));
			}
		}
		Collections.sort(ans);
		return ans;
	}
	static void qType3(String cur){
		String []words=cur.split(" ");
		String sub=words[2];
		if(sub.equals("I"))sub="you";
		else if(sub.equals("you"))sub="I";
		LinkedList<Action>ans=qType3Compute(sub);
		boolean iou=(sub.equals("I")||sub.equals("you"));
		if(ans.isEmpty()){
			System.out.println("I don't know.");
			return;
		}
		System.out.print(sub+" ");
		while(!ans.isEmpty()){
			Action cura=ans.remove();
			cura.print(!iou&&!cura.neg,iou,cura.neg,false);
			if(ans.size()>1)System.out.print(", ");
			else if(ans.size()>0)System.out.print(", and ");
			else System.out.println(".");
		}
	}
	static LinkedList<Action> qType3Compute(String sub){
		LinkedList<Action>ans=new LinkedList<Action>();
		for(Action a:lkup.get(0).action)ans.add(copy(a));
		int index=0;
		for(Subject s:lkup){
			if(s.name.equals(sub))break;
			index++;
		}
		if(index!=lkup.size()){
			for(Action a:lkup.get(index).action){
				boolean alr=false;
				for(Action a1:ans){
					if(a.pred.equals(a1.pred)&&a.obj.equals(a1.obj)){
						a1.ind=Math.min(a1.ind, a.ind);
						alr=true;
						break;
					}
				}
				if(!alr)ans.add(copy(a));
			}
		}
		Collections.sort(ans);
		return ans;
	}
}