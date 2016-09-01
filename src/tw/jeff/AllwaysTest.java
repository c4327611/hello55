package tw.jeff;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AllwaysTest {

	public static void main(String[] args) {
        
        JFrame fm=new JFrame("元件配置練習");
        JLabel lb1=new JLabel("預設");
        JLabel lb2=new JLabel("靠左",JLabel.LEFT);
        JLabel lb3=new JLabel("置中",JLabel.CENTER);
        JLabel lb4=new JLabel("靠右",JLabel.RIGHT);
        JLabel lb5=new JLabel("其他");
        
        lb1.setBounds(8, 0, 180, 30);
        lb2.setBounds(8, 35, 180, 30);
        lb3.setBounds(8, 70, 180, 30);
        lb4.setBounds(8, 105, 180, 30);
        lb5.setBounds(50, 140, 100, 30);
                
        fm.setBounds(100, 100, 200, 200);
        fm.setVisible(true);
        fm.setResizable(false);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setLayout(null);
        fm.add(lb1);
        fm.add(lb2);
        fm.add(lb3);
        fm.add(lb4);
        fm.add(lb5);

}

}