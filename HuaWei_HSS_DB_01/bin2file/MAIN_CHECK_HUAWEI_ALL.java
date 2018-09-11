package bin2file;

import huawei.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.String;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import huawei.check;

import bin2file.MAIN_ALL_HUAWEI.btListener;


public class MAIN_CHECK_HUAWEI_ALL extends JFrame{
	
	private JButton bt_change=new JButton("����Ŀ¼");
	private JLabel lb_change=new JLabel("��ָ��������Ŀ¼��");
	private JLabel lb_dir=new JLabel("D:\\");
	private JLabel lb_sel=new JLabel("��ѡ�����豨��");
	private JCheckBox cb01=new JCheckBox("���ʳ�;");
	private JCheckBox cb02=new JCheckBox("��������");
	private JCheckBox cb03=new JCheckBox("GPRS");
	private JCheckBox cb04=new JCheckBox("EPS");
	private JCheckBox cb05=new JCheckBox("��ֹ����");
	private JCheckBox cb06=new JCheckBox("��ֹ����");
	private JCheckBox cb07=new JCheckBox("������ʾ");
	private JButton bt_run=new JButton("��������");
	private JLabel lb_prompt=new JLabel("       ");
    private JButton bt_exit=new JButton("�˳�");
    private JLabel lb_br01=new JLabel("  ");
    private JLabel lb_br02=new JLabel("  ");
    private JLabel lb_br03=new JLabel("  ");
    private JLabel lb_br04=new JLabel("  ");
    private JLabel lb_br05=new JLabel("  ");
	

    File defaultFilePath=new File("E:/SQL/��ΪHLR���ݿ�ԭʼ�ļ�/");
    String sql,file_name,dir="E:/SQL/��ΪHLR���ݿ�ԭʼ�ļ�/",hlr_name="S11_";


	public MAIN_CHECK_HUAWEI_ALL(String title) {
		// TODO Auto-generated constructor stub
        super(title);
        setSize(450,300);
        setVisible(true);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

//      1st line  
        this.add(lb_change);
        this.add(lb_br01);
//      2nd line  
        this.add(bt_change);
        this.add(lb_dir);
        this.add(lb_br02);
//      3rd line 
        this.add(lb_sel);
        this.add(lb_br03);
//      4th line
        this.add(cb01);
        this.add(cb02);
        this.add(cb03);
        this.add(cb04);
        this.add(cb05);
        this.add(lb_br04);
        this.add(cb06);
        this.add(cb07);
        this.add(lb_br05);
//      5th line  
        this.add(bt_run);
        this.add(lb_prompt);
        this.add(bt_exit);

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        
//      1st line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(lb_change, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br01, gbc);
//      2nd line  
        gbc.gridwidth=4;
        gbc.weightx=1;
        gbc.weighty=1;
        layout.setConstraints(lb_dir, gbc);

        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=1;
        layout.setConstraints(lb_br02, gbc);

//      3rd line  
        gbc.gridwidth=5;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_sel, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br03, gbc);
        
//      4th line  
        gbc.gridwidth=1;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(cb03, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(cb04, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(cb05, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br04, gbc);
        
//      5th line  
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br05, gbc);
        
//      6th line  
        gbc.gridwidth=2;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(bt_run, gbc);
        
        gbc.gridwidth=1;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_prompt, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(bt_exit, gbc);
        
 
        

        addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e) {
        	dispose();
        	System.exit(0);
        	} } );

        bt_change.addActionListener(new btListener());
        bt_run.addActionListener(new btListener());
        bt_exit.addActionListener(new btListener());

	}

    class btListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		    //����һ���ļ�ѡ����
			JFileChooser jChooser = new JFileChooser();
		    //����Ĭ�ϵĴ�Ŀ¼,�������Ļ�����window��Ĭ��Ŀ¼(�ҵ��ĵ�)
		    jChooser.setCurrentDirectory(defaultFilePath);
		    //���ô��ļ�����,�˴����ó�ֻ��ѡ���ļ��У�����ѡ���ļ�
		if(e.getSource()==bt_change)
			try {
			    jChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//ֻ�ܴ��ļ���
			    //��һ���Ի���
			    int index = jChooser.showDialog(null, "ѡ���ļ���");
			    if (index == JFileChooser.APPROVE_OPTION) {
			     //�ѻ�ȡ�����ļ��ľ���·����ʾ���ı��༭����
			     lb_dir.setText(jChooser.getSelectedFile().getAbsolutePath()+"\\");
			     dir=lb_dir.getText();
			     System.out.println(lb_dir.getText());
			    }


			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		else if(e.getSource()==bt_run){
//			private JCheckBox cb01=new JCheckBox("���ʳ�;");
//			private JCheckBox cb02=new JCheckBox("��������");
//			private JCheckBox cb03=new JCheckBox("GPRS");
//			private JCheckBox cb04=new JCheckBox("EPS");
//			private JCheckBox cb05=new JCheckBox("��ֹ����");
//			private JCheckBox cb06=new JCheckBox("��ֹ����");
//			private JCheckBox cb07=new JCheckBox("������ʾ");
			System.out.println("_run");
			
			file_name=dir + hlr_name + "STAT_RESULT_DATA.TXT";
			sql = "select * from STAT_RESULT_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "DSMETATABLE.TXT";
			sql = "select * from DSMETATABLE";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_AUC_DATA.TXT";
			sql = "select * from W_AUC_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_COMMON_SER_DATA.TXT";
			sql = "select * from W_COMMON_SER_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_CS_SER_DATA.TXT";
			sql = "select * from W_CS_SER_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_CS_BSG_DATA.TXT";
			sql = "select * from W_CS_BSG_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_CS_BSG_CF_DATA.TXT";
			sql = "select * from W_CS_BSG_CF_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_CS_BSG_CBCWCL_DATA.TXT";
			sql = "select * from W_CS_BSG_CBCWCL_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_ISDN_DATA.TXT";
			sql = "select * from W_ISDN_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_IMSI_DATA.TXT";
			sql = "select * from W_IMSI_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_PS_SER_DATA.TXT";
			sql = "select * from W_PS_SER_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_PS_OPTSER_DATA.TXT";
			sql = "select * from W_PS_OPTSER_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_SUB_DYN_CS_DATA.TXT";
			sql = "select * from W_SUB_DYN_CS_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_SUB_DYN_PS_DATA.TXT";
			sql = "select * from W_SUB_DYN_PS_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_SCMSG_DATA.TXT";
			sql = "select * from W_SCMSG_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_SID_DATA.TXT";
			sql = "select * from W_SID_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_LICENCE_CHECK_DATA.TXT";
			sql = "select * from W_LICENCE_CHECK_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_HLRSN_LICENSE_CHECK_DATA.TXT";
			sql = "select * from W_HLRSN_LICENSE_CHECK_DATA";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_IMSIBASICDYNINFO.TXT";
			sql = "select * from W_IMSIBASICDYNINFO";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "W_EPSSTAINFO.TXT";
			sql = "select * from W_EPSSTAINFO";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "DSMETAFIELD.TXT";
			sql = "select * from DSMETAFIELD";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "DSMETANODEVERIFY.TXT";
			sql = "select * from DSMETANODEVERIFY";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "DSMETANODEVERIFY.TXT";
			sql = "select * from W_IMSIAPNDYNINFO";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "DSIDXCHECK.TXT";
			sql = "select * from DSIDXCHECK";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "DSIDXFIELDS.TXT";
			sql = "select * from DSIDXFIELDS";
			check.ret(dir,hlr_name,sql,file_name);

			file_name=dir + hlr_name + "US_DATAVERSION.TXT";
			sql = "select * from US_DATAVERSION";
			check.ret(dir,hlr_name,sql,file_name);

			
			if(cb01.isSelected()){
//				���ʳ�;
				System.out.println("_cb01");
				file_name=dir + hlr_name + "���ʳ�;�û�.TXT";
				sql = "SELECT IMSI,MSISDN FROM W_COMMON_SER_DATA WHERE ODBOC=0";
				check.ret(dir,hlr_name,sql,file_name);
			}
			if(cb02.isSelected()){
//				��������
				file_name=dir + hlr_name + "���������û�.TXT";
				sql = "SELECT IMSI,MSISDN FROM W_COMMON_SER_DATA WHERE ODBROAM=0";
				check.ret(dir,hlr_name,sql,file_name);
			}
			if(cb03.isSelected()){
//				GPRS
				file_name=dir + hlr_name + "GPRS�û�.TXT";
				sql = "SELECT IMSI,MSISDN FROM W_COMMON_SER_DATA WHERE GPRS=1";
				check.ret(dir,hlr_name,sql,file_name);
			}
			if(cb04.isSelected()){
//				EPS
				file_name=dir + hlr_name + "EPS�û�.TXT";
				sql = "SELECT A.IMSI,A.MSISDN FROM W_COMMON_SER_DATA A JOIN W_EPSSTAINFO B ON A.SID=B.SID";
				check.ret(dir,hlr_name,sql,file_name);
			}
			if(cb05.isSelected()){
//				��ֹ����
				file_name=dir + hlr_name + "��ֹ�����û�.TXT";
				sql = "SELECT IMSI,MSISDN FROM W_COMMON_SER_DATA WHERE ODBOC=1";
				check.ret(dir,hlr_name,sql,file_name);
			}
			if(cb06.isSelected()){
//				��ֹ����
				file_name=dir + hlr_name + "��ֹ�����û�.TXT";
				sql = "SELECT IMSI,MSISDN FROM W_COMMON_SER_DATA WHERE ODBIC=1";
				check.ret(dir,hlr_name,sql,file_name);
			}
			if(cb07.isSelected()){
//				������ʾ
				file_name=dir + hlr_name + "������ʾ�û�.TXT";
				sql = "SELECT IMSI,MSISDN FROM W_CS_SER_DATA WHERE CLIP=1";
				check.ret(dir,hlr_name,sql,file_name);
			}
			lb_prompt.setText("�����ѵ���");
			
		}else{
			dispose();
			System.exit(0);
		}
			
		}
    	
    }
    
	public static void main(String[] args) throws Exception {
        new MAIN_CHECK_HUAWEI_ALL("HuaWei HLR Report - www.HLRDB.com");

	}

}
