/**
 * ��ϣ���ұ�
 * @author shxxy
 * ���ڹ�ϣ���г�ͻ�������ʹ������̽�ⷨ���д���
 */

import java.io.*;
import java.util.*;
public class Hash_table_for_Linear_probing {
	final static int  INDEXBOX=10;//��ϣ�����Ԫ��
	final static int MAXNUM=7;//������ݸ���
	public static void main(String[] args) throws IOException{
		int i;
		int index[]=new int [INDEXBOX];
		int data[]=new int[MAXNUM];
		Random rand = new Random();
		System.out.print("ԭʼ����ֵ�� \n");
		for(i=0;i<MAXNUM;i++) //�趨��ʼ����
			data[i]=(Math.abs(rand.nextInt(20)))+1;
		
		for(i=0;i<INDEXBOX;i++)//�����ϣ��
			index[i]=-1;
		
		print_data(data,MAXNUM);//��ӡ��ʼ����
		System.out.print("��ϣ�����ݣ� \n");
		for(i=0;i<MAXNUM;i++) {//������ϣ��
			creat_table(data[i],index);
			System.out.print(" "+data[i]+"=>");//��ӡ��һԪ�ع�ϣ��λ��
			print_data(index,INDEXBOX);
		}
		System.out.print("��ɹ�ϣ�� \n");
		print_data(index,INDEXBOX);//��ӡ�����ɵĽ��
	}
	
	public static void print_data(int data[],int max) {//��ӡ������ӳ���
		int i;
		System.out.print("\t");
		for(i=0;i<max;i++)
			System.out.print("["+data[i]+"] ");
		System.out.println();
	}
	
	public static void creat_table(int num,int index[]) {//������ϣ���ӳ���
		int tmp;
		tmp=num%INDEXBOX;//��ϣ����=����%INDEXBOX���������Ϊ������
		while(true) {
			if(index[tmp]==-1) {//�����Ӧ����Ϊ��
				index[tmp]=num;//��ֱ�Ӵ�������
				break;
			}else
				tmp=(tmp+1)%INDEXBOX;//���������������ݴ�ţ�����̽�ⷨ���裩
		}
	}
}
