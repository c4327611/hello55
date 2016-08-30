package tw.jeff;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AllwaysTest {

	JFrame frame;
    JButton button;
    JPanel panel,panel2;
    JLabel label;
    JTextField textField;
    JTextArea textArea;
    static int count;
    static String answer=createAnswer(4);
	public static void main(String[] args) {
		AllwaysTest guessNum=new AllwaysTest();
         guessNum.gui();
//         if(count==11){
//    		 JOptionPane.showMessageDialog(null, "嗐, 魯蛇, \n答案是:"+answer);	
//    	 }
	}
 void gui(){
	 //以下是版面配置
	 frame=new JFrame("GuessNumber");
	 button=new JButton("猜");
	 textField=new JTextField(20);         //表是最多輸入二十字，不是像素
	 textArea=new JTextArea(100,100);
	 label=new JLabel("請輸入四個數字");
	 panel=new JPanel();
	 panel2=new JPanel();
	 //新增一個控制捲動盤
	 JScrollPane scroller=new JScrollPane(textArea);
	 //打開控制上下捲動的桿
	 scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 //不使用水平捲軸
	 scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 panel.add(label);
	 panel.add(textField);
	 panel.add(button);
	 panel2.add(scroller);
	 frame.setSize(200,400);
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	 frame.getContentPane().add(BorderLayout.NORTH,panel);
	 frame.getContentPane().add(BorderLayout.CENTER,panel2);
	 //以下是按鈕功能
	 button.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent ae){
			 go();
			 //count++;
			 System.out.println(count);
			 if(count>10){
				 JOptionPane.showMessageDialog(frame, "嗐, 魯蛇, \n答案是:"+answer);	
			 }
		 }
	 });
	 //因為count是在button.addActionListener中的go方法做count++，雖然將int count
	 //定為static int count，但java並沒有global 的variable，跳出button.addActionListener
	 //這個方法時，count會從新給值 值為零，所以會導致下面的if述句不會被執行
	 //解決方法有二，一是將if述句放到go()中，二是將if述句放到button.addActionListener中
//	 if(count>10){
//		 JOptionPane.showMessageDialog(frame, "嗐, 魯蛇, \n答案是:"+answer);	
//	 }
	 
 }//close method gui
	

void go(){
	 String playerGuess=textField.getText();
	 textField.setText("");
	 String result=checkAB(answer,playerGuess);
		 if(playerGuess.equals(answer)){
	          textArea.append(playerGuess+"=>"+result+"\n");
	          JOptionPane.showMessageDialog(null, "恭喜老爺,賀喜夫人...");
		 }
		 else{
			 textArea.append(playerGuess+"=>"+result+"\n");
		 }
	 count++;
//	 if(count>10){
//		 JOptionPane.showMessageDialog(frame, "嗐, 魯蛇, \n答案是:"+answer);	
//	 }
 }//close method go()
 
 static String checkAB(String answer,String playerGuess){
	 int A=0,B=0;
	 for(int i=0;i<playerGuess.length();i++){
		 if(playerGuess.charAt(i)==answer.charAt(i)){
			A++; 
		 }
		 else if(answer.indexOf(playerGuess.charAt(i))!=-1){
			 B++;
		 }
	 }
	 return A+"A"+B+"B";
 }
 
 static String createAnswer(int n){
		// 洗牌
		int[] poker = new int[n];	// 0,0,...0
		int rand;
		boolean isOK;
		for (int i=0; i<poker.length; i++){
			
			do {
				rand = (int)(Math.random()*10);
				// 檢查機制
				isOK = true;
				for (int j=0;j<i;j++){
					if (poker[j]==rand){
						isOK = false;
						break;
					}
				}
				
			}while (!isOK);
			
			poker[i] = rand;
			//System.out.println(poker[i]);
		}
		StringBuffer ret =new StringBuffer("");
		for (int v : poker) ret.append(v);
		  String rets=ret.toString();
		return rets;
	}//close method
}//close class