
/**
 * 使用哈希法快速的建立和查找数据
 * @author shxxy
 * 测试建立与查找数据的哈希表功能
 */

import java.io.*;
import java.util.*;
class Node2{//默认标识符只要在同一个包中就可以引用
	int val;
	Node2 next;
	public Node2(int val) {
		this.val=val;
		this.next=null;
	}
}
public class Complete_Example_Of_Hash {
	final static int INDEXBOX=7;//哈希表最大元素
	final static int MAXNUM=13;//最大数据个数
	static Node2 indextable[]=new Node2[INDEXBOX];//声明动态数组
	
	public static void main(String args[])throws IOException{
		int i,num;
		int index[]=new int [INDEXBOX];
		int data[]=new int [MAXNUM];
		Random rand = new Random();
		BufferedReader keyin = new BufferedReader(
				new InputStreamReader(System.in));
		for(i=0;i<INDEXBOX;i++)//设定初始条件 并将相应的指针数组初始化
			indextable[i]=new Node2(-1);
		System.out.print("原始数据：\n\t");
		for(i=0;i<MAXNUM;i++) {//设定初始数据
			data[i]= Math.abs(rand.nextInt(30))+1;
			System.out.print("["+data[i]+"]");
			if(i%8==7)
				System.out.print("\n\t");
		}
		
		for(i=0;i<MAXNUM;i++)//建立哈希表
			creat_table(data[i]);
		System.out.println();
		
		while(true) {
			System.out.print("请输入查找数据（1-30），结束请输入-1：");
			num=Integer.parseInt(keyin.readLine());
			if(num==-1)
				break;
			i=findNum(num);
			if(i==0)
				System.out.println("####没有找到"+num+"####");
			else
				System.out.println("找到了"+num+",共找了"+i+"次！");
		}
		
		System.out.println("\n 哈希表：");
		for(i=0;i<INDEXBOX;i++)//打印哈希表
			print_data(i);
		System.out.println();
	}
	
	public static void creat_table(int val) {//建立哈希表子程序
		Node2 newNode=new Node2(val);
		int hash;
		hash=val%7;//哈希函数除以7取余数
		Node2 current=indextable[hash];
		if(current.next==null)
			indextable[hash].next=newNode;
		else
			while(current.next!=null)
				current=current.next;
		current.next=newNode;//将节点加在表头后
	}
	
	public static void print_data(int val) {// 打印哈希表子程序
		Node2 head;
		int i=0;
		head=indextable[val].next;// 起始指针
		System.out.print(" "+val+": \t");//索引地址
		while(head!=null) {
			System.out.print("["+head.val+"]-");
			i++;
			if(i%8==7)
				System.out.print("\n\t");
			head=head.next;
		}
		System.out.println("\b");//清除最后一个"-"符号
	}
	
	public static int findNum(int num) {//哈希表查找小程序
		Node2 ptr;
		int i=0,hash;
		hash=num%7;
		ptr=indextable[hash].next;
		while(ptr != null) {
			i++;//寻找次数
			if(ptr.val==num)
				return i;
			else
				ptr=ptr.next;
		}
		return 0;
	}
}
