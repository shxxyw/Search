/**
 * ���Զ��ֲ��ҷ�
 * @author shxxy
 *ʱ�临�Ӷ�O��logn��
 */

import java.io.*;
public class Binary_Search {
	public static void main(String[] args) throws IOException{
		int i,j,val=1,num;
		int data[] = new int [50];
		String strM;
		BufferedReader keyin = new BufferedReader(
				new InputStreamReader(System.in));
		//������������
		for(i=0;i<50;i++) {
			data[i]=val;
			val+=(int)(Math.random()*100)%5+1;
		}
		
		while(true) {
			num=0;
			System.out.println("��������Ҽ�ֵ��1~150��������-1����");
			strM = keyin.readLine();
			val=Integer.parseInt(strM);
			if(val==-1)
				break;
			num=bin_search(data,val);
			if(num==-1)
				System.out.println("###û���ҵ�["+val+"]###");
			else
				System.out.println("�ڵ� "+(num+1)+"��λ���ҵ�["+data[num]+"]");
		}
		System.out.println("��������");
		for(i=0;i<5;i++) {
			for(j=0;j<10;j++)
				System.out.print((i*10+j+1)+"["+data[i*10+j]+"] ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static int bin_search(int data[],int val) {
		int low,high,mid;
		low=0;
		high=49;
		System.out.println("���Ҵ�����......");
		while(low<=high && val != -1) {
			mid=(low+high)/2;
			if(val<data[mid]) {
				System.out.println(val+" ����λ��"+(low+1)+"["+data[low]+"]���м�ֵ "
			+(mid+1)+"["+data[mid]+"]֮��");
				high=mid-1;
			}else if(val>data[mid]) {
				System.out.println(val+" �����м�λ��"+(mid+1)+"["+data[mid]+"]�� "
						+(high+1)+"["+data[high]+"]֮��");
				low=mid+1;
			}else
				return mid;
		}
		return -1;
	}
}
