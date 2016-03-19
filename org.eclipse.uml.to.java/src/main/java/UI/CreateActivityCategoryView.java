package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.User;

public class CreateActivityCategoryView extends JFrame implements ActionListener {

	JButton dashboard = new JButton("Dashboard");
	JButton activityCategory = new JButton("Activity Category");
	JButton productCategory = new JButton("Product Category");
	JButton product = new JButton("Product");
	JButton account = new JButton("Account");
	JButton plan = new JButton("Plan");
	JButton task = new JButton("Task");
	   
	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");
	
	/**
	 * Descriptions for the mobile field
	 */
	JLabel name = new JLabel("Name :");
	JTextField nameEntre = new JTextField("", 15);
	
	/**
	 * Descriptions for the mobile field
	 */
	JLabel shortDetail = new JLabel("Short Detail :");
	JTextField shortDetailEntre = new JTextField("", 15);
	
	/**
	 * Descriptions for the mobile field
	 */
	JLabel longDetail = new JLabel("Long Detail :");
	JTextField longDetailEntre = new JTextField("", 15);
	
	/**
	 * Description for the button validate
	 */
	JButton validate = new JButton("Validate");
	
	private User currentUser;
	
	public CreateActivityCategoryView(User currentUser) {
		super("DashBoard"); // Name of the frame
		this.currentUser = currentUser;
		/* Defined actions on the different buttons */
		this.dashboard.addActionListener(this);
		this.activityCategory.addActionListener(this);
		this.productCategory.addActionListener(this);
		this.product.addActionListener(this);
		this.account.addActionListener(this);
		this.plan.addActionListener(this);
		this.task.addActionListener(this);
		this.profile.addActionListener(this);
		this.notifications.addActionListener(this);
		
        Container contentPane = getContentPane(); 
        contentPane.setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1000,500));
        setMaximumSize(new Dimension(1000,500));
        
        JPanel panelButton = new JPanel(new GridLayout(2, 1)); // 2 rows x 1 column
        JPanel panelTopButton = new JPanel();
        JPanel panelBottomButton = new JPanel();
        
        panelTopButton.add(this.dashboard);
        panelTopButton.add(this.activityCategory);
        panelTopButton.add(this.productCategory);
        panelTopButton.add(this.product);
        panelTopButton.add(this.account);
        panelTopButton.add(this.plan);
        panelTopButton.add(this.task);
        
        panelBottomButton.add(this.profile);
        panelBottomButton.add(this.notifications);
        
        panelButton.add(panelTopButton);
        panelButton.add(panelBottomButton);
        
        contentPane.add(panelButton,BorderLayout.NORTH);
        
  
        /*-------------- Veritable view --------------------*/
        JPanel panelCreateActivityCategory = new JPanel();
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextField = new JPanel(new GridLayout(0,1));
		JPanel panelButtonValidate = new JPanel(new GridLayout(0,1));
		
		//Name
		this.name.setPreferredSize(this.nameEntre.getPreferredSize());
		this.name.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.name);
		panelTextField.add(this.nameEntre);
		
		//Short Detail
		this.shortDetail.setPreferredSize(this.shortDetailEntre.getPreferredSize());
		this.shortDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.shortDetail);
		panelTextField.add(this.shortDetailEntre);
		
		//Long Detail
		this.longDetail.setPreferredSize(this.longDetailEntre.getPreferredSize());
		this.longDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.longDetail);
		panelTextField.add(this.longDetailEntre);
		
		panelCreateActivityCategory.add(panelLabels);
		panelCreateActivityCategory.add(panelTextField);
		panelButtonValidate.add(validate);
		panelCreateActivityCategory.add(panelButtonValidate, BorderLayout.SOUTH);
		this.validate.addActionListener(this);
		
		contentPane.add(panelCreateActivityCategory, BorderLayout.WEST);

        //Display
        setSize(400,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Validate") {
			System.out.println("BUTTON VALIDATE");
		}
	}
}
