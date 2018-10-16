/**
 * 再哈希
 * @author shxxy
 * 测试再哈希（利用链表）
 */

import java.io.*;
import java.util.*;

class Node{
	int val;
	Node next;
	public Node(int val) {
		this.val=val;
		this.next=null;
	}
}

public class Repeat_Hash {
	final static int INDEXBOX=7;//哈希表最大元素
	final static int MAXNUM=13;//最大数据个数
	static Node indextable[]=new Node[INDEXBOX];//声明动态数组
	
	public static void main(String args[])throws IOException{
		int i;
		int index[]=new int [INDEXBOX];
		int data[]=new int [MAXNUM];
		Random rand = new Random();
		for(i=0;i<INDEXBOX;i++)
			indextable[i]=new Node(-1);//清除哈希表
		System.out.print("原始数据： \n\t");
		for(i=0;i<MAXNUM;i++) {
			data[i]= Math.abs(rand.nextInt(30))+1;
			System.out.print("["+data[i]+"]");
			if(i%8==7)
				System.out.print("\n\t");
		}
		System.out.println("\n 哈希表");
		for(i=0;i<MAXNUM;i++)
			creat_table(data[i]);
		for(i=0;i<INDEXBOX;i++)
			print_data(i);
		System.out.println();
	}
	
	public static void creat_table(int val) {//建立哈希表子程序
		Node newnode=new Node(val);
		int hash;
		hash=val%7;//哈希函数除以7取余数
		Node current=indextable[hash];
		if(current.next==null)
			indextable[hash].next=newnode;
		else
			while(current.next!=null)
				current=current.next;
		current.next=newnode;//将节点加在表头后
	}
	
	public static void print_data(int val) {// 打印哈希表子程序
		Node head;
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
		System.out.print("\b \n");//清除最后一个"-"符号
	}

}
