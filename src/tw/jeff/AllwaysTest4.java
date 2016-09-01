package tw.jeff;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AllwaysTest4 extends JFrame {
	
	private JButton select;
	private JLabel Output;
	
		public AllwaysTest4(){
		
		super("樂透號碼產生器");
		select = new JButton("49選6");
		Output = new JLabel("輸出");
		
		setSize(480, 320); //設定大小
		setVisible(true); //顯示
		setDefaultCloseOperation(EXIT_ON_CLOSE); //結束視窗.定義在JFram
        
        setLayout(new BorderLayout());
        add(select,BorderLayout.NORTH);
		add(Output,BorderLayout.CENTER);
		
		select.setFont(new Font("標楷體", Font.BOLD, 28));
		Output.setFont(new Font("標楷體", Font.BOLD, 25));
		}

	public static void main(String[] args) {
		new AllwaysTest4();

	}

}
