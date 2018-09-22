package printVideoDuration;
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class CalcDuration extends JFrame implements ActionListener
{
 
    private static final long serialVersionUID = 1L;
 
    JButton btn = null;
 
    JTextField textField = null;
    
    JTextField textFieldResult = null;
 
    public CalcDuration()
    {
        this.setTitle("选择文件窗口");
        FlowLayout layout = new FlowLayout();// 布局
        JLabel label = new JLabel("请选择文件：");// 标签
        textField = new JTextField(30);// 文本域
        btn = new JButton("浏览");// 钮1
        textFieldResult = new JTextField(35);
 
        // 设置布局
        layout.setAlignment(FlowLayout.LEFT);// 左对齐
        this.setLayout(layout);
        this.setBounds(400, 200, 600, 100);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(this);
        this.add(label);
        this.add(textField);
        this.add(btn);
        this.add(textFieldResult);
 
    }
 
    public static void main(String[] args)
    {
        new CalcDuration();
    }
 
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JFileChooser chooser = new JFileChooser();
        //
        Preferences pref = Preferences.userRoot().node(this.getClass().getName()); 
        String lastPath = pref.get("lastPath", ""); 
           if(!lastPath.equals("")){ 
           chooser = new JFileChooser(lastPath); 
           } 
           else
           chooser=new JFileChooser();
        //   
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showDialog(new JLabel(), "选择");
        File file = chooser.getSelectedFile();
        //
        pref.put("lastPath",file.getParent());
        //
        textField.setText(file.getAbsoluteFile().toString());
        CalcVideoDuration cdv = new CalcVideoDuration();
        
        try {
        	textFieldResult.setVisible(true);
        	textFieldResult.setText(cdv.readVideoTime(file.getAbsoluteFile().toString()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
}





