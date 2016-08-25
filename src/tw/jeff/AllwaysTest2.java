package tw.jeff;
import java.io.*;
import java.util.*;
public class AllwaysTest2 {

	public static void main(String[] args) throws IOException{
		 int chose=0,year=0,month=0,first_day=0,end_day=0;
		 boolean temp_year,temp_month,check=true;
		 Date date=new Date();
		 while(check){
	     BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	     System.out.println("--------------萬年曆------------------------");
	     System.out.println("   (1).列印指定年份及月分(月曆)");
	     System.out.println("   (2).列印指定年份月曆");
	     System.out.println("   (0).離開");
	      chose=Integer.parseInt(input.readLine());
	     switch(chose){
	     case 0:
	    	 System.out.println("The program will be exit");
	    	 check=false;
	    	 break;
	     case 1:
	    	 temp_year=true;
	    	 temp_month=true;
	    	 while(temp_year){
	    	   System.out.println("請輸入年份");
	           year=Integer.parseInt(input.readLine());
	    	   if(year<0||year>30000000){
	    		  System.out.println("請輸入合理的年份");
	    	   }
	    	   else{
	    		 temp_year=false;
	    	   }
	    	 }//end while
	    	 while(temp_month){
	    	   System.out.println("請輸入月份");
	    	   month=Integer.parseInt(input.readLine());
	    	   if(month<0||month>12){
	    		   System.out.println("請重新輸入合理的月份");
	    	   }
	    	   else{
	    		   temp_month=false;
	    	   }
	    	 }//end while  
	    	 System.out.println("---------------萬年曆------------------");
	    	 System.out.println("西元 \t"+year+"\t年\t"+month+"\t月\t");
	    	 int theFirst_day=date.count_first_day(year,month);
	    	 end_day=date.count_days(year,month);
			 System.out.println("---------------");
	    	 if(year==1752&&month==9){
	    		 date.special_program();
	    	 }
	    	 else{
	    	 date.print(theFirst_day,end_day);
	    	 }
	    	 break;
	     case 2:
	     temp_year=true;
	     while(temp_year){
	        System.out.println("請輸入年份");
	        year=Integer.parseInt(input.readLine());
	        if(year<0||year>300000000){
	    	System.out.println("請輸入合理的年份");
	        }
	        else{
	        	temp_year=false;
	        }
	     }//end while
	     for( month=1;month<=12;month++){
	       theFirst_day=date.count_first_day(year,month);
	       end_day=date.count_days(year, month);
	       if(year==1752&&month==9){
	       date.special_program();
	       }
	       else{
	       System.out.println("西元 \t"+year+"\t年\t"+month+"\t月\t");
	       date.print(theFirst_day, end_day);   
	       }
	     }
	     break;
	     }//end switch
		 }//end while
	  }//close method main

	}//cloes class

	class Date{
		//以下為計算該年該月有多少天，因為英美曆法在1752年前採四年一閏；
		//1752年後四連一閏，逢百不閏，但每四百年又置閏年
		
		static int  count_days(int year,int month){
			int days;
			if(year<=1752&&year%4==0&&month==2){
				days=29;
			}
			else if(year>1752&&((year%4==0&&year%100!=0)||year%400==0)&&month==2){
				days=29;
			}
			else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
				days=31;
			}
			else if(month==4||month==6||month==9||month==11){
				days=30;
			}
			else{
				days=28;
			}
			return (days);
		}//close method count_days
		//決定該年該月第一天是星期幾，會分成幾個部分運算
		//(1)在西元1752年八月(包含八月)以西元1年1月1日星期六為基準，
		//及mod 7的餘數來計算所求年月的第一天為星期幾
		//(2)英美曆法在西元1752年9月有調整過，1752年10~12月以1752年10月1日星期日為基準點，及mod 7餘數
		//來計算所求該年該月第一天是星期幾
		//(3)西元1753年以後以1753年1月1日星期一依為基準，及mod7餘數來計算
		//1752年後四連一閏，逢百不閏，但每四百年又置閏年)
	      static int count_first_day(int year,int month){
	    	  int f_day=0;
	    	  if(year<1752||(year==1752&&month<=8)){
	    		  f_day=6;
	    		  //計算該年一月一日為星期幾
	    		  for(int i=1;i<year;i++){
	    			  if(i%4==0){
	    				  f_day=(f_day+366)%7;    				 
	    			  }
	    			  else{
	    				  f_day=(f_day+365)%7; 
	    			  }
	    		  }//end for loop(計算該年第一天為星期幾)
	    		  for(int j=0;j<month;j++){
	    			  f_day=(f_day+count_days(year,j))%7;
	    		  }//end for loop (計算該月第一天為星期幾)
	    	  }
	    	  else if(year==1752&&month>=10){
	    		  f_day=0; 
	    		  for(int j=10;j<month;j++){
	    			  f_day=(f_day+count_days(year,j))%7;
	    		  }//end for loop(計算1752年十月後所求月份的第一天為星期幾)
	    	  }
	    	  else if(year>1752){
	    		  f_day=1; 
	    		  for(int i=1753;i<year;i++){
	    			  if((i%4==0&&i%100!=0)||i%400==0){
	    				  f_day=(f_day+366)%7;
	    			  }
	    			  else{
	    				  f_day=(f_day+365)%7;
	    			  }
	    		  }//end for loop (計算該年第一天(1/1)為星期幾)
	    		  for(int j=1;j<month;j++){
	    			f_day=(f_day+count_days(year,j))%7;  
	    		  }//end for loop(計算該月第一天為星期幾)
	    	  }
	    	  return (f_day);
	      } //close method count_first_day
		 /* 此為特例之副程式，由於1752年9月無3～13日，故寫一專門處理該年月之副程式。 */
		  static void special_program(){
		        int counter,days,first_day,end_day;
		        first_day=2;
		        end_day=30;
		        System.out.println("\t   西元     1752       年        九        月 ");
		        String s="日\t一\t二\t三\t四\t五\t六\n";
		        for(counter=0;counter<first_day;counter++){
		           s+="\t";
		        }//end for loop
		        for(days=1;days<=end_day;days++){
				  s+=Integer.toString(days)+"\t"; 	
		          if((first_day+days)%7==4&&days!=2){
		             s+="\n";
		          }
		          if(days==2){
		               days=14;
		              s+=Integer.toString(days)+"\t";
		          }			 
		        }//end for loop
		       System.out.println(s);
	    }//close method special_program
		//以下為列印月曆之method，藉由該月第一天為星期幾及該月有幾天來決定如何列印  
		void print(int first_day,int end_day){
			String[][] num=new String[7][7]; 
			num[0]=new String[]{"日","一","二","三","四","五","六"};
			for(String s:num[0])
			System.out.print(s+"\t");
			System.out.println();
	        int k=1;
	        int i=1;

	        for( i=1;i<num.length;i++){
	        	for( int j=0;j<num[0].length;j++){
//	        		if(k>end_day){
//	        			k=0;
//	        		}
	        		String s=String.valueOf(k);
	        		if(i==1&&j<first_day){
	        		  System.out.print("\t");
	        		}
	        		else{
	        			if(k<=end_day){
	        			num[i][j]=s;
	        			k++;
	        			System.out.print(s+"\t");
	        			}
	        		}
	        		
	        	}//end for loop
	        	System.out.println();
	        }//end for loop
		}//close method print(int first_day,end_day)
	}//close  class