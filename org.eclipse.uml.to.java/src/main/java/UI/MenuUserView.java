package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The Class MenuUserView.
 * 
 * @author HelpingHand
 */
public class MenuUserView extends JPanel implements ActionListener {

	/** The dashboard. */
	private JButton dashboard = new JButton("Dashboard");
	
	/** The journal. */
	private JButton journal = new JButton("Journal");
	
	/** The my plans. */
	private JButton myPlans = new JButton("My Plans");
	
	/** The my favorites. */
	private JButton myFavorites = new JButton("My Favorites");
	
	/** The shopping cart. */
	private JButton shoppingCart = new JButton("Shopping Cart");

	/** The profile. */
	private JButton profile = new JButton("Profile");
	
	/** The notifications. */
	private JButton notifications = new JButton("Notifications");
	
	/** The ViewController. */
	private ViewController vc;
	
	/**
	 * Instantiates a new menu user view.
	 *
	 * @param vc the ViewController
	 */
	public MenuUserView(ViewController  vc) {
		this.vc = vc;
		
		/* Defined actions on the different buttons */
		this.dashboard.addActionListener(this);
		this.journal.addActionListener(this);
		this.journal.setEnabled(false);
		this.myPlans.addActionListener(this);
		this.myFavorites.addActionListener(this);
		this.myFavorites.setEnabled(false);
		this.shoppingCart.addActionListener(this);
		this.shoppingCart.setEnabled(false);
		this.profile.addActionListener(this);
		this.notifications.addActionListener(this);
		this.notifications.setEnabled(false);
		
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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
			this.vc.MyPlanViewUser();
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
