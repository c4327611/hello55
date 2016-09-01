package tw.jeff;

public class AllwaysTest3 {

	public static void main(String[] args) {
		int[] num = new int[6];
      int rand;
		boolean isOK;
      for (int i=0;i<6;i++){
      	num[i] = (int)(Math.random()*49+1);
      	do {
				rand = (int)(Math.random()*49+1);
				// 檢查機制
				isOK = true;
				for (int j=0;j<i;j++){
					if (num[j]==rand){
						isOK = false;
						break;
					}
				}
      	
				
			}while (!isOK);
			
			num[i] = rand;
			System.out.println(num[i]);


	}
      

}
}
