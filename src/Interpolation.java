/**
 * 测试插值法
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
		
		//产生一个大小为50的有序排序数组
		for(i=0;i<50;i++) {
			data[i]=val;
			val+= (int) (Math.random()*100)%5+1;
		}
		while(true) {
			num=0;
			System.out.print("请输入查找键值（1-"+data[49]+"),输入-1结束");
			strM=keyin.readLine();
			val=Integer.parseInt(strM);
			if(val==-1)
				break;
			num=interpolation(data,val);
			if(num==-1)
			System.out.println("#####没有找到["+val+"]#####");
			else
				System.out.println("在第 "+(num+1)+"个位置找到"+data[num]+"]");
		}
		System.out.println("数据内容： ");
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
		System.out.println("查找处理中。。。。");
		while(low<=high && val != -1) {
			//设置插值
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
				System.out.println(val+" 介于位置"+(low+1)+"["+data[low]+"]及中间值"+
			(mid+1)+"["+data[mid]+"]之间");
				high=mid-1;
			}
				else if(val > data[mid]) {
				System.out.println(val+" 介于中间值"+(mid+1)+"["+data[mid]+"]及值"+
							(high+1)+"["+data[high]+"]之间");
				low=mid+1;	
				}
			
		}
		return -1;
	}
}
