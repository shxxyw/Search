/**
 * 测试二分查找法
 * @author shxxy
 *时间复杂度O（logn）
 */

import java.io.*;
public class Binary_Search {
	public static void main(String[] args) throws IOException{
		int i,j,val=1,num;
		int data[] = new int [50];
		String strM;
		BufferedReader keyin = new BufferedReader(
				new InputStreamReader(System.in));
		//设置有序序列
		for(i=0;i<50;i++) {
			data[i]=val;
			val+=(int)(Math.random()*100)%5+1;
		}
		
		while(true) {
			num=0;
			System.out.println("请输入查找键值（1~150），输入-1结束");
			strM = keyin.readLine();
			val=Integer.parseInt(strM);
			if(val==-1)
				break;
			num=bin_search(data,val);
			if(num==-1)
				System.out.println("###没有找到["+val+"]###");
			else
				System.out.println("在第 "+(num+1)+"个位置找到["+data[num]+"]");
		}
		System.out.println("数据内容");
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
		System.out.println("查找处理中......");
		while(low<=high && val != -1) {
			mid=(low+high)/2;
			if(val<data[mid]) {
				System.out.println(val+" 介于位置"+(low+1)+"["+data[low]+"]及中间值 "
			+(mid+1)+"["+data[mid]+"]之间");
				high=mid-1;
			}else if(val>data[mid]) {
				System.out.println(val+" 介于中间位置"+(mid+1)+"["+data[mid]+"]及 "
						+(high+1)+"["+data[high]+"]之间");
				low=mid+1;
			}else
				return mid;
		}
		return -1;
	}
}
