package tw.jeff; //YH

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Lotto extends JFrame implements ActionListener {
     int[] ans= new int[6]; 
     JLabel result=new JLabel("這一期是:");
     
    public Lotto()
    {
        super("樂透");
        JButton btn=new JButton("報名牌");
         
        setLayout(new FlowLayout());
        add(result);
        add(btn);
        btn.addActionListener(this);
       
        setVisible(true);
        setSize(320,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    
    
    }
    
    public static void main(String[] args)
    {
     new Lotto();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] lotto= new int[42];
       
        int rand;
        int temp;
        for(int i=0;i<lotto.length;i++)
        {
          lotto[i]=i+1;
        }
        
        for(int i=lotto.length-1;i>0;i--)
        {
          rand=(int)(Math.random()*i);
          temp=lotto[rand];
          lotto[rand]=lotto[i];
          lotto[i]=temp;
         
        }
         
        for (int i=0;i<6;i++)
        {
            ans[i]=lotto[i];
        }
        Arrays.sort(ans);
        String text="";
        for(int v:ans)
        {
           text+=v;
           text+="   ";
        }
        result.setText(text);
    
    }

    
}
