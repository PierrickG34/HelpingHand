package UI;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.User;
import Core.UserFacade;

public class DashboardSellerView extends JFrame implements ActionListener {

	   
	   private User currentUser;
	   JButton dashboard = new JButton("Dashboard");
	   JButton journal = new JButton("Journal");
	   JButton myPlans = new JButton("My Plans");
	   JButton myFavorites = new JButton("My Favorites");
	   JButton myProducts = new JButton("My Products");
	   JButton shoppingCart = new JButton("Shopping Cart");
	   
	   JButton profile = new JButton("Profile");
	   JButton notifications = new JButton("Notifications");
	
	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window
	 */
	public DashboardSellerView(User currentUser) {
		super("DashBoard"); // Name of the frame
		/* Defined actions on the different buttons */
		this.currentUser = currentUser;
		this.dashboard.addActionListener(this);
		this.journal.addActionListener(this);
		this.myPlans.addActionListener(this);
		this.myFavorites.addActionListener(this);
		this.myProducts.addActionListener(this);
		this.shoppingCart.addActionListener(this);
		this.profile.addActionListener(this);
		this.notifications.addActionListener(this);
		
        Container contentPane = getContentPane(); 
        contentPane.setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1000,500));
        setMaximumSize(new Dimension(1000,500));
        
        JPanel panelButton = new JPanel(new GridLayout(2, 1)); // 2 rows x 1 column
        JPanel panelTopButton = new JPanel();
        JPanel panelBottomButton = new JPanel();
        
        panelTopButton.add(dashboard);
        panelTopButton.add(journal);
        panelTopButton.add(myPlans);
        panelTopButton.add(myFavorites);
        panelTopButton.add(myProducts);
        panelTopButton.add(shoppingCart);
        
        panelBottomButton.add(profile);
        panelBottomButton.add(notifications);
        
        panelButton.add(panelTopButton);
        panelButton.add(panelBottomButton);
        
  
        contentPane.add(panelButton,BorderLayout.NORTH);

        //Display
        setSize(400,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Dashboard") {
			System.out.println("Je suis Dashboard");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Journal" ){
			System.out.println("Je suis Journal");
			System.out.println("Action a définir ici...");
		}
		else if (source == "My Plans"){
			System.out.println("Je suis My Plans");
			System.out.println("Action a définir ici...");
		}
		else if (source == "My Favorites"){
			System.out.println("Je suis My Favorites");
			System.out.println("Action a définir ici...");
		}
		else if (source == "My Products"){
			ProductCreateView profilUserView = new ProductCreateView(this.currentUser);
		}
		else if (source == "Shopping Cart"){
			System.out.println("Je suis Shopping Cart");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Profile"){
			System.out.println("Je suis Profile");
			System.out.println("Action a définir ici...");
		}
		else if (source == "Notifications"){
			System.out.println("Je suis Notifications");
			System.out.println("Action a définir ici...");
		}
	}
}