import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.event.*;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class Calculator extends JFrame implements ActionListener
{
    private JTextField jtf;
    private JPanel jp;
    String str[]={"sqrt","+/-","CE","C","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};

    public Calculator()
    {
        super("¼ÆËãÆ÷");
        this.jtf=new JTextField();
        jtf.setEditable(false);
        pack();
        this.setSize(400,400);
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp=new JPanel(new GridLayout(5,4));
        jp.setBackground(Color.white);
        jp.setSize(400,400);
        for(int i=0;i<str.length;i++)
        {
            JButton jb=new JButton(str[i]);
            jb.addActionListener(this);
            jp.add(jb);
        }
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(jtf);
        this.getContentPane().add(jp);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getActionCommand().equals("sqrt"))
        {
            String text = jtf.getText();
            jtf.setText(text.substring(0, text.length() - 1));
        }
        else if(ev.getActionCommand().equals("CE")||ev.getActionCommand().equals("C"))
        {
            jtf.setText("");
        }
        else if(!ev.getActionCommand().equals("="))
        {
            String shizi;
            shizi=jtf.getText();
            jtf.setText(shizi+ev.getActionCommand());
        }
        else if(ev.getActionCommand().equals("="))
        {
            try {
                jisuan();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void jisuan() throws ScriptException
    {
        String str =jtf.getText();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(str);
        jtf.setText(""+result);
    }

    public static void main(String args[])
    {
        new Calculator();
    }
}
