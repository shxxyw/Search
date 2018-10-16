/**
 * �ٹ�ϣ
 * @author shxxy
 * �����ٹ�ϣ����������
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
	final static int INDEXBOX=7;//��ϣ�����Ԫ��
	final static int MAXNUM=13;//������ݸ���
	static Node indextable[]=new Node[INDEXBOX];//������̬����
	
	public static void main(String args[])throws IOException{
		int i;
		int index[]=new int [INDEXBOX];
		int data[]=new int [MAXNUM];
		Random rand = new Random();
		for(i=0;i<INDEXBOX;i++)
			indextable[i]=new Node(-1);//�����ϣ��
		System.out.print("ԭʼ���ݣ� \n\t");
		for(i=0;i<MAXNUM;i++) {
			data[i]= Math.abs(rand.nextInt(30))+1;
			System.out.print("["+data[i]+"]");
			if(i%8==7)
				System.out.print("\n\t");
		}
		System.out.println("\n ��ϣ��");
		for(i=0;i<MAXNUM;i++)
			creat_table(data[i]);
		for(i=0;i<INDEXBOX;i++)
			print_data(i);
		System.out.println();
	}
	
	public static void creat_table(int val) {//������ϣ���ӳ���
		Node newnode=new Node(val);
		int hash;
		hash=val%7;//��ϣ��������7ȡ����
		Node current=indextable[hash];
		if(current.next==null)
			indextable[hash].next=newnode;
		else
			while(current.next!=null)
				current=current.next;
		current.next=newnode;//���ڵ���ڱ�ͷ��
	}
	
	public static void print_data(int val) {// ��ӡ��ϣ���ӳ���
		Node head;
		int i=0;
		head=indextable[val].next;// ��ʼָ��
		System.out.print(" "+val+": \t");//������ַ
		while(head!=null) {
			System.out.print("["+head.val+"]-");
			i++;
			if(i%8==7)
				System.out.print("\n\t");
			head=head.next;
		}
		System.out.print("\b \n");//������һ��"-"����
	}

}
