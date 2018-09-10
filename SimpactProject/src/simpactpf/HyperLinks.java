package simpactpf;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.lang.String;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HyperLinks extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lb_describe=new JLabel("Useful links:");
	private JButton bt_01=new JButton("www.simpactpf.org");
	private JButton bt_02=new JButton("www.youtube.com");
	private JButton bt_03=new JButton("www.yahoo.ca");
	private JButton bt_04=new JButton("www.facebook.com");
	private JButton bt_05=new JButton("www.amazon.ca");
	private JButton bt_06=new JButton("www.ebay.com");
	private JButton bt_07=new JButton("www.wikipedia.org");
	private JButton bt_08=new JButton("www.google.ca");
	private JButton bt_09=new JButton("www.reddit.com");
	private JButton bt_10=new JButton("www.netflix.com");
    private JButton bt_exit=new JButton("Exit");

    private JLabel lb_br00=new JLabel("  ");
    private JLabel lb_br01=new JLabel("  ");
    private JLabel lb_br02=new JLabel("  ");
    private JLabel lb_br03=new JLabel("  ");
    private JLabel lb_br04=new JLabel("  ");
    private JLabel lb_br05=new JLabel("  ");
    private JLabel lb_br06=new JLabel("  ");
    private JLabel lb_br07=new JLabel("  ");
    private JLabel lb_br08=new JLabel("  ");
    private JLabel lb_br09=new JLabel("  ");
    private JLabel lb_br10=new JLabel("  ");
    
    private JLabel lb_nl00=new JLabel("  ");
    private JLabel lb_nl01=new JLabel("  ");
    private JLabel lb_nl02=new JLabel("  ");
    private JLabel lb_nl03=new JLabel("  ");
    private JLabel lb_nl04=new JLabel("  ");
    private JLabel lb_nl05=new JLabel("  ");
    private JLabel lb_nl06=new JLabel("  ");
    private JLabel lb_nl07=new JLabel("  ");
    private JLabel lb_nl08=new JLabel("  ");
    private JLabel lb_nl09=new JLabel("  ");
    private JLabel lb_nl10=new JLabel("  ");

//    private JLabel lb_br03=new JLabel("  ");
//    private JLabel lb_br04=new JLabel("  ");
//    private JLabel lb_br05=new JLabel("  ");

	public HyperLinks(String title) {
		// TODO Auto-generated constructor stub
        super(title);
        setLocation(1200,400);
        setSize(400,600);
//        setSize(450,300);
        setVisible(true);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

//      1st line  
        this.add(lb_describe);
        this.add(lb_br00);
        this.add(lb_nl00);
//      2nd line  
        this.add(bt_01);
        this.add(lb_br01);
        this.add(lb_nl01);
//      3rd line  
        this.add(bt_02);
        this.add(lb_br02);
        this.add(lb_nl02);
//      4th line  
        this.add(bt_03);
        this.add(lb_br03);
        this.add(lb_nl03);
//      5th line  
        this.add(bt_04);
        this.add(lb_br04);
        this.add(lb_nl04);
//      6th line  
        this.add(bt_05);
        this.add(lb_br05);
        this.add(lb_nl05);
//      7th line  
        this.add(bt_06);
        this.add(lb_br06);
        this.add(lb_nl06);
//      8th line  
        this.add(bt_07);
        this.add(lb_br07);
        this.add(lb_nl07);
//      9th line  
        this.add(bt_08);
        this.add(lb_br08);
        this.add(lb_nl08);
//      10th line  
        this.add(bt_09);
        this.add(lb_br09);
        this.add(lb_nl09);
//      11th line  
        this.add(bt_10);
        this.add(lb_br10);

        this.add(lb_nl10);
        
        this.add(bt_exit);

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        
//      1st line
        gbc.gridwidth=5;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_describe, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br00, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl00, gbc);
 
        
//      2nd line
        gbc.gridwidth=5;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(bt_01, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br01, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl01, gbc);
 
//      3rd line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_02, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br02, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl02, gbc);
 
//      4th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_03, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br03, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl03, gbc);
 
//      5th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_04, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br04, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl04, gbc);
 
//      6th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_05, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br05, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl05, gbc);
 
//      7th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_06, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br06, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl06, gbc);
 
//      8th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_07, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br07, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl07, gbc);
 
//      9th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_08, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br08, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl08, gbc);
 
//      10th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_09, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br09, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl09, gbc);
 
//      11th line
        gbc.gridwidth=5;
        gbc.weightx=0;
        gbc.weighty=0;
        layout.setConstraints(bt_10, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_br10, gbc);
        
        gbc.gridwidth=0;
        gbc.weightx=1;
        gbc.weighty=0;
        layout.setConstraints(lb_nl10, gbc);
 
        
        
 
        

        addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e) {
        	dispose();
        	System.exit(0);
        	} } );

        bt_01.addActionListener(new btListener());
        bt_02.addActionListener(new btListener());
        bt_03.addActionListener(new btListener());
        bt_04.addActionListener(new btListener());
        bt_05.addActionListener(new btListener());
        bt_06.addActionListener(new btListener());
        bt_07.addActionListener(new btListener());
        bt_08.addActionListener(new btListener());
        bt_09.addActionListener(new btListener());
        bt_10.addActionListener(new btListener());
        bt_exit.addActionListener(new btListener());

	}

    class btListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bt_01){		openUrl(bt_01);			}
			else if(e.getSource()==bt_02){	openUrl(bt_02);			}
			else if(e.getSource()==bt_03){	openUrl(bt_03);			}
			else if(e.getSource()==bt_04){	openUrl(bt_04);			}
			else if(e.getSource()==bt_05){	openUrl(bt_05);			}
			else if(e.getSource()==bt_06){	openUrl(bt_06);			}
			else if(e.getSource()==bt_07){	openUrl(bt_07);			}
			else if(e.getSource()==bt_08){	openUrl(bt_08);			}
			else if(e.getSource()==bt_09){	openUrl(bt_09);			}
			else if(e.getSource()==bt_10){	openUrl(bt_10);			}
			else if(e.getSource()==bt_exit){
				System.out.println("quit");
				dispose();
				System.exit(0);
			}
			
			}
    	
		}

	private void openUrl(JButton b) {
			Desktop desktop = Desktop.getDesktop();
				URI uri;
				try {
					uri = new URI(b.getText());
					desktop.browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	}
    
	public static void main(String[] args) throws Exception {
        new HyperLinks("Simpactpf - Links");

	}

}





