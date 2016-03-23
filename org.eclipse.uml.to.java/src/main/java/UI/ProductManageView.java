package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Core.User;

public class ProductManageView extends JFrame implements ActionListener {

	JButton dashboard = new JButton("Dashboard");
	JButton activityCategory = new JButton("Activity Category");
	JButton productCategory = new JButton("Product Category");
	JButton product = new JButton("Product");
	JButton account = new JButton("Account");
	JButton plan = new JButton("Plan");
	JButton task = new JButton("Task");
	   
	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");
	
	JButton create = new JButton("Create a Product");
	JButton update = new JButton("Update a Product");
	JButton delete = new JButton("Delete a Product");
	
	
	private User currentUser;
	
	public ProductManageView(User currentUser) {
		super("Product"); // Name of the frame
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
        JPanel manageButton = new JPanel(new GridLayout(3, 1));
        JPanel createButton = new JPanel();
        JPanel updateButton = new JPanel();
        JPanel deleteButton = new JPanel();
        
        this.create.addActionListener(this);
        this.update.addActionListener(this);
        this.delete.addActionListener(this);
        
        createButton.add(this.create);
        updateButton.add(this.update);
        deleteButton.add(this.delete);
        
        manageButton.add(createButton);
        manageButton.add(updateButton);
        manageButton.add(deleteButton);
        
        contentPane.add(manageButton, BorderLayout.WEST);

        //Display
        setSize(400,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create a Product") {
			System.out.println("BUTTON CREATE");
			ProductCreateView profilUserView = new ProductCreateView(this.currentUser);
		}
		else if(source == "Update a Product") {
			UpdateProductView profilUserView = new UpdateProductView(this.currentUser);
		}
		else if(source == "Delete a Product") {
			DeleteProductView profilUserView = new DeleteProductView(this.currentUser);
		}
	}
}
