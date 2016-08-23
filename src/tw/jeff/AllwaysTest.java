package tw.jeff;
import java.io.*;
public class AllwaysTest {

	public static void main(String[] args) throws IOException {
		System.out.print("請輸入:");
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine(); //指定變數v1為使用者輸入值
		System.out.println(s);

	}

}
