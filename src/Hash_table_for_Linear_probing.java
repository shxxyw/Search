/**
 * 哈希查找表
 * @author shxxy
 * 对于哈希表中冲突的情况，使用线性探测法进行处理
 */

import java.io.*;
import java.util.*;
public class Hash_table_for_Linear_probing {
	final static int  INDEXBOX=10;//哈希表最大元素
	final static int MAXNUM=7;//最大数据个数
	public static void main(String[] args) throws IOException{
		int i;
		int index[]=new int [INDEXBOX];
		int data[]=new int[MAXNUM];
		Random rand = new Random();
		System.out.print("原始数组值： \n");
		for(i=0;i<MAXNUM;i++) //设定起始数据
			data[i]=(Math.abs(rand.nextInt(20)))+1;
		
		for(i=0;i<INDEXBOX;i++)//清除哈希表
			index[i]=-1;
		
		print_data(data,MAXNUM);//打印起始数据
		System.out.print("哈希表内容： \n");
		for(i=0;i<MAXNUM;i++) {//建立哈希表
			creat_table(data[i],index);
			System.out.print(" "+data[i]+"=>");//打印单一元素哈希表位置
			print_data(index,INDEXBOX);
		}
		System.out.print("完成哈希表： \n");
		print_data(index,INDEXBOX);//打印最后完成的结果
	}
	
	public static void print_data(int data[],int max) {//打印数组的子程序
		int i;
		System.out.print("\t");
		for(i=0;i<max;i++)
			System.out.print("["+data[i]+"] ");
		System.out.println();
	}
	
	public static void creat_table(int num,int index[]) {//建立哈希表子程序
		int tmp;
		tmp=num%INDEXBOX;//哈希函数=数据%INDEXBOX（除数最好为质数）
		while(true) {
			if(index[tmp]==-1) {//如果对应数据为空
				index[tmp]=num;//则直接存入数据
				break;
			}else
				tmp=(tmp+1)%INDEXBOX;//否则则往后找数据存放（线性探测法精髓）
		}
	}
	

}
