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

public class DashboardSellerView extends JPanel implements ActionListener {

	   
	   private User currentUser;
	   
	   private ViewController vc;
	   private MenuAdminView menuAdminView;
	
	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window
	 */
	public DashboardSellerView(User currentUser, ViewController vc) {
//		super("DashBoard"); // Name of the frame
		/* Defined actions on the different buttons */
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}