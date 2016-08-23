package tw.jeff;

import java.io.*;

public class bankNum {

	public static void main(String[] args) {
		// 許用
		 new bankNum().change();
			}
			//下面這個method 會要求輸入一個阿拉伯數字，並將數字轉國字
			public void change(){
				try{
					System.out.println("請輸入一個正整數");
					BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
					String s=input.readLine();
					int num=s.length();
					
				     String[] resuit={"元整","拾","佰","仟","萬","拾","佰","仟","億","拾","佰","千","兆","拾","佰","仟"};
					 String[] word={"\t","壹","貳","参","肆","伍","陸","柒","捌","玖"};
					 for(int i=0;i<num;i++){
						 
						 System.out.print(word[s.charAt(i)-48]+resuit[num-i-1]);   //'0'換成 int 是 48,'1'是 49,...
					 }{
					 
				}
				
				}
				catch (Exception ex){}
				
			}

		
	}


