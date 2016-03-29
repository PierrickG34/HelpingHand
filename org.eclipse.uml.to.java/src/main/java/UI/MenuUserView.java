package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuUserView extends JPanel implements ActionListener {

	private JButton dashboard = new JButton("Dashboard");
	private JButton journal = new JButton("Journal");
	private JButton myPlans = new JButton("My Plans");
	private JButton myFavorites = new JButton("My Favorites");
	private JButton shoppingCart = new JButton("Shopping Cart");

	private JButton profile = new JButton("Profile");
	private JButton notifications = new JButton("Notifications");
	
	private ViewController vc;
	
	public MenuUserView(ViewController  vc) {
		this.vc = vc;
		
		/* Defined actions on the different buttons */
		this.dashboard.addActionListener(this);
		this.journal.addActionListener(this);
		this.myPlans.addActionListener(this);
		this.myFavorites.addActionListener(this);
		this.shoppingCart.addActionListener(this);
		this.profile.addActionListener(this);
		this.notifications.addActionListener(this);
		
		JPanel panelButton = new JPanel(new GridLayout(2, 1)); // 2 rows x 1 column
        JPanel panelTopButton = new JPanel();
        JPanel panelBottomButton = new JPanel();
        
        panelTopButton.add(dashboard);
        panelTopButton.add(journal);
        panelTopButton.add(myPlans);
        panelTopButton.add(myFavorites);
        panelTopButton.add(shoppingCart);
        
        panelBottomButton.add(profile);
        panelBottomButton.add(notifications);
        
        panelButton.add(panelTopButton);
        panelButton.add(panelBottomButton);
        
        this.add(panelButton,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Dashboard") {
			this.vc.dashboardUserView();
		}
		else if (source == "Journal" ){
			System.out.println("Action pas faite");
		}
		else if (source == "My Plans"){
			this.vc.CreatePlanView();
		}
		else if (source == "My Favorites"){
			System.out.println("Action pas faite");
		}
		else if (source == "Shopping Cart"){
			System.out.println("Action pas faite");
		}
		else if (source == "Profile"){
			this.vc.ProfileUserView();
		}
		else if (source == "Notifications"){
			System.out.println("Action pas faite");
		}
	}	
}
