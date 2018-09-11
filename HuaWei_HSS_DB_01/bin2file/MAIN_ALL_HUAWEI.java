package bin2file;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.io.File;

import huawei.*;
 
public class MAIN_ALL_HUAWEI extends JFrame{
	private JButton bt_clr_db=new JButton("清空数据库");
	
    private JButton bt1=new JButton("文件1");
    private JButton bt2=new JButton("文件2");
    private JButton bt3=new JButton("文件3");
    private JButton bt4=new JButton("文件4");
    private JButton bt5=new JButton("文件5");
    private JButton bt6=new JButton("文件6");
    private JButton bt7=new JButton("文件7");
    private JButton bt8=new JButton("文件8");
    private JButton bt9=new JButton("文件9");
    private JButton bt10=new JButton("文件10");
    private JButton bt_run=new JButton("运行");
    private JButton bt_exit=new JButton("退出");
    private JLabel lb_clr_db=new JLabel("            ");//    数据库已清空
    private JLabel lb1=new JLabel("(空)");
    private JLabel lb2=new JLabel("(空)");
    private JLabel lb3=new JLabel("(空)");
    private JLabel lb4=new JLabel("(空)");
    private JLabel lb5=new JLabel("(空)");
    private JLabel lb6=new JLabel("(空)");
    private JLabel lb7=new JLabel("(空)");
    private JLabel lb8=new JLabel("(空)");
    private JLabel lb9=new JLabel("(空)");
    private JLabel lb10=new JLabel("(空)");
    private JLabel lbb1=new JLabel(" ");
    private JLabel lbb2=new JLabel(" ");
    private JLabel lbb3=new JLabel(" ");
    private JLabel lbb4=new JLabel(" ");
    private JDialog dialog=new JDialog(this);
    
    File defaultFilePath=new File("E:/SQL/华为HLR数据库原始文件/HSS DB/DSU/0_82_27.fdb");
    String []dir=new String[10];
    String directory,filename;
     
    public MAIN_ALL_HUAWEI(String title){
        super(title);
        setSize(480,450);
        setLocation(100,100);
        setVisible(true);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.add(bt_clr_db);
        this.add(lbb2);
        this.add(lb_clr_db);
        this.add(lbb3);
        this.add(bt1);
        this.add(lb1);
        this.add(bt2);
        this.add(lb2);
        this.add(bt3);
        this.add(lb3);
        this.add(bt4);
        this.add(lb4);
        this.add(bt5);
        this.add(lb5);
        this.add(bt6);
        this.add(lb6);
        this.add(bt7);
        this.add(lb7);
        this.add(bt8);
        this.add(lb8);
        this.add(bt9);
        this.add(lb9);
        this.add(bt10);
        this.add(lb10);
        this.add(bt_run);
        this.add(lbb4);
        this.add(bt_exit);

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        
       
        gbc.gridwidth=2;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_clr_db, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lbb2, gbc);
        
        gbc.gridwidth=2;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(lb_clr_db, gbc);
      
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lbb3, gbc);
                
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt1, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb1, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt2, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb2, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt3, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb3, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt4, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb4, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt5, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb5, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt6, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb6, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt7, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb7, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt8, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb8, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt9, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb9, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt10, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb10, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_run, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(lbb4, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(bt_exit, gbc);
        
        
        
        addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e) {
        	dispose();
        	} } );

        bt_clr_db.addActionListener(new btListener());
        bt1.addActionListener(new btListener());
        bt2.addActionListener(new btListener());
        bt3.addActionListener(new btListener());
        bt4.addActionListener(new btListener());
        bt5.addActionListener(new btListener());
        bt6.addActionListener(new btListener());
        bt7.addActionListener(new btListener());
        bt8.addActionListener(new btListener());
        bt9.addActionListener(new btListener());
        bt10.addActionListener(new btListener());
        bt_run.addActionListener(new btListener());
        bt_exit.addActionListener(new btListener());
                
    }
    class btListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	        JFileChooser fc = new JFileChooser();  
	            // 打开的窗口路径为当前路径  
	        fc.setCurrentDirectory(defaultFilePath);  
	        fc.setDialogTitle("打开文件");  
	            // 添加文件过滤  
	        fc.addChoosableFileFilter(new FileNameExtensionFilter(".fdb", "fdb"));  

			if(e.getSource()==bt_clr_db)
				try {
					HW_Process.init();
					bt_clr_db.setVisible(false);
					lb_clr_db.setText("数据库已清空");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			else if(e.getSource()==bt1){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb1.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt2){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb2.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt3){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb3.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt4){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb4.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt5){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb5.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt6){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb6.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt7){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb7.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt8){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb8.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt9){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb9.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt10){
	    		fc.showOpenDialog(null);
	    		defaultFilePath=fc.getSelectedFile();
				lb10.setText(fc.getSelectedFile().getAbsolutePath());
			}
			else if(e.getSource()==bt_run && bt_run.getText().equals("运行")){
				dir[0]=lb1.getText();
				dir[1]=lb2.getText();
				dir[2]=lb3.getText();
				dir[3]=lb4.getText();
				dir[4]=lb5.getText();
				dir[5]=lb6.getText();
				dir[6]=lb7.getText();
				dir[7]=lb8.getText();
				dir[8]=lb9.getText();
				dir[9]=lb10.getText();
				
				for(int i=0;i<10;i++){
					if(dir[i].equals("(空)"))
							continue;
					dir[i]=dir[i].replace('/', '\\');
					directory=dir[i].substring(0, dir[i].lastIndexOf('\\')+1);
					filename=dir[i].substring(dir[i].lastIndexOf('\\')+1);
					bt_run.setText("已完成，请退出");

					try {
						HW_Process.action01(directory,filename);
						HW_Process.action02(directory,filename);
						HW_Process.action03(directory,filename);
						HW_Process.action04(directory,filename);
						HW_Process.action05(directory,filename);
						switch(i){
						case 0:
							bt1.setBackground(Color.GREEN);
							break;
						case 1:
							bt2.setBackground(Color.GREEN);
							break;
						case 2:
							bt3.setBackground(Color.GREEN);
							break;
						case 3:
							bt4.setBackground(Color.GREEN);
							break;
						case 4:
							bt5.setBackground(Color.GREEN);
							break;
						case 5:
							bt6.setBackground(Color.GREEN);
							break;
						case 6:
							bt7.setBackground(Color.GREEN);
							break;
						case 7:
							bt8.setBackground(Color.GREEN);
							break;
						case 8:
							bt9.setBackground(Color.GREEN);
							break;
						case 9:
							bt10.setBackground(Color.GREEN);
							break;
						default:break;	
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			else {
				dispose();
				System.exit(0);
			}
		
		}
    	
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MAIN_ALL_HUAWEI("HuaWei HLR into DB - www.HLRDB.com");
    }
 
}