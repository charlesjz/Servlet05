package bin2file;

import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

class dlg extends Frame implements ActionListener {

	Frame fe;
	Button bt1=new Button("Delete Window"),
	       bt2=new Button("Open File"),
	       bt3=new Button("Save File");
	dlg(String str){
		super(str);
		add(bt1);
		add(bt2);
		add(bt3);
		setLayout(new FlowLayout());
		setSize(400,300);
		setVisible(true);
		addWindowListener(new koWindowListener());
		bt1.addActionListener((this));
		bt2.addActionListener((this));
		bt3.addActionListener((this));
		
	}

	String str1,str2;
	
	public String getFileName() {
		return str1;
	}


	public String getDir() {
		return str2;
	}



	public void actionPerformed(ActionEvent e) {
		Frame fe = new Frame();
		if(e.getSource()==bt1){
			dispose();
			System.exit(0);
		}
		if(e.getSource()==bt2){
			FileDialog fd1=new FileDialog(fe,"OpenFile",FileDialog.LOAD);
			fd1.show();
			File f1=new File(fd1.getFile());
			str1=fd1.getFile();
			str2=fd1.getDirectory();
			System.out.println(f1);
			System.out.println(str1);
			System.out.println(str2);
		}
		if(e.getSource()==bt3){
			FileDialog fd2=new FileDialog(fe,"SaveFile",FileDialog.SAVE);
			fd2.show();
		}
		
		

	}
}
class koWindowListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
//		dispose();
		System.exit(0);
	}

}

public class ToFileDialog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Frame fe=new dlg("www.dbhlr.com");
		fe.setBackground(Color.GRAY);
		

	}

}
