/**
 * ����˳����ҷ�
 * @author shxxy
 *
 */

import java.io.*;

public class Search_In_order {
	public static void main(String[] args)throws IOException {
		String strM;
		BufferedReader keyin = new BufferedReader(
				new InputStreamReader(System.in));
		int data[] = new int [100];
		int i,j,find,val=0;
		for(i=0;i<80;i++)
			//Math.random()  ����һ��0~1֮��������
			//�������һ��1~150�������
			data[i]=((int)(Math.random()*150))%150+1;
			
			while(val !=-1) {
				find=0;
				System.out.print("��������Ҽ�ֵ��1~150��������-1�뿪��");
				strM=keyin.readLine();
				val=Integer.parseInt(strM);
				for(i=0;i<80;i++) {
					if(data[i]==val) {
						System.out.println("�ڵ�"+(i+1)+"��λ�����ҵ��ü�ֵ"+data[i]);
						find++;
					}
				}
				if(find==0 && val!=-1) {
					System.out.println("######û���ҵ�[" + val +"]######");
				}
				System.out.println("�������ݣ�");
				for(i=0;i<10;i++) {
					for(j=0;j<8;j++) 
						System.out.print((i*8+j+1)+"["+data[i*8+j]+"] ");
					System.out.println();
				}
			}
		
	}
}
