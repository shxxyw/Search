
/**
 * ʹ�ù�ϣ�����ٵĽ����Ͳ�������
 * @author shxxy
 * ���Խ�����������ݵĹ�ϣ����
 */

import java.io.*;
import java.util.*;
class Node2{//Ĭ�ϱ�ʶ��ֻҪ��ͬһ�����оͿ�������
	int val;
	Node2 next;
	public Node2(int val) {
		this.val=val;
		this.next=null;
	}
}
public class Complete_Example_Of_Hash {
	final static int INDEXBOX=7;//��ϣ�����Ԫ��
	final static int MAXNUM=13;//������ݸ���
	static Node2 indextable[]=new Node2[INDEXBOX];//������̬����
	
	public static void main(String args[])throws IOException{
		int i,num;
		int index[]=new int [INDEXBOX];
		int data[]=new int [MAXNUM];
		Random rand = new Random();
		BufferedReader keyin = new BufferedReader(
				new InputStreamReader(System.in));
		for(i=0;i<INDEXBOX;i++)//�趨��ʼ���� ������Ӧ��ָ�������ʼ��
			indextable[i]=new Node2(-1);
		System.out.print("ԭʼ���ݣ�\n\t");
		for(i=0;i<MAXNUM;i++) {//�趨��ʼ����
			data[i]= Math.abs(rand.nextInt(30))+1;
			System.out.print("["+data[i]+"]");
			if(i%8==7)
				System.out.print("\n\t");
		}
		
		for(i=0;i<MAXNUM;i++)//������ϣ��
			creat_table(data[i]);
		System.out.println();
		
		while(true) {
			System.out.print("������������ݣ�1-30��������������-1��");
			num=Integer.parseInt(keyin.readLine());
			if(num==-1)
				break;
			i=findNum(num);
			if(i==0)
				System.out.println("####û���ҵ�"+num+"####");
			else
				System.out.println("�ҵ���"+num+",������"+i+"�Σ�");
		}
		
		System.out.println("\n ��ϣ��");
		for(i=0;i<INDEXBOX;i++)//��ӡ��ϣ��
			print_data(i);
		System.out.println();
	}
	
	public static void creat_table(int val) {//������ϣ���ӳ���
		Node2 newNode=new Node2(val);
		int hash;
		hash=val%7;//��ϣ��������7ȡ����
		Node2 current=indextable[hash];
		if(current.next==null)
			indextable[hash].next=newNode;
		else
			while(current.next!=null)
				current=current.next;
		current.next=newNode;//���ڵ���ڱ�ͷ��
	}
	
	public static void print_data(int val) {// ��ӡ��ϣ���ӳ���
		Node2 head;
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
		System.out.println("\b");//������һ��"-"����
	}
	
	public static int findNum(int num) {//��ϣ�����С����
		Node2 ptr;
		int i=0,hash;
		hash=num%7;
		ptr=indextable[hash].next;
		while(ptr != null) {
			i++;//Ѱ�Ҵ���
			if(ptr.val==num)
				return i;
			else
				ptr=ptr.next;
		}
		return 0;
	}
}
