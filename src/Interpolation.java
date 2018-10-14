/**
 * ���Բ�ֵ��
 * @author shxxy
 *
 */

import java.io.*;
public class Interpolation {
	public static void main(String[] args) throws IOException {
		int i,j,val=1,num;
		int data[]=new int[50];
		String strM;
		BufferedReader keyin = new BufferedReader(
				new InputStreamReader(System.in));
		
		//����һ����СΪ50��������������
		for(i=0;i<50;i++) {
			data[i]=val;
			val+= (int) (Math.random()*100)%5+1;
		}
		while(true) {
			num=0;
			System.out.print("��������Ҽ�ֵ��1-"+data[49]+"),����-1����");
			strM=keyin.readLine();
			val=Integer.parseInt(strM);
			if(val==-1)
				break;
			num=interpolation(data,val);
			if(num==-1)
			System.out.println("#####û���ҵ�["+val+"]#####");
			else
				System.out.println("�ڵ� "+(num+1)+"��λ���ҵ�"+data[num]+"]");
		}
		System.out.println("�������ݣ� ");
		for(i=0;i<5;i++) {
			for(j=0;j<10;j++)
				System.out.print((i*10+j+1)+"-"+data[i*10+j]+" ");
			System.out.println();
		}
	}
	
	public static int interpolation(int data[],int val) {
		int low,mid,high;
		low=0;
		high=49;
		int tmp;
		System.out.println("���Ҵ����С�������");
		while(low<=high && val != -1) {
			//���ò�ֵ
			tmp=(int) ( (float)(val-data[low])*(high-low)/(data[high]-data[low]) );
			mid=low+tmp;
			if(mid>50 || mid < -1) 
				return -1;
			if(val<data[low] && val<data[high])
				return -1;
			else if(val>data[low] && val>data[high])
				return -1;
			if(val==data[mid])
				return mid;
			else if(val < data[mid]) {
				System.out.println(val+" ����λ��"+(low+1)+"["+data[low]+"]���м�ֵ"+
			(mid+1)+"["+data[mid]+"]֮��");
				high=mid-1;
			}
				else if(val > data[mid]) {
				System.out.println(val+" �����м�ֵ"+(mid+1)+"["+data[mid]+"]��ֵ"+
							(high+1)+"["+data[high]+"]֮��");
				low=mid+1;	
				}
			
		}
		return -1;
	}
}
