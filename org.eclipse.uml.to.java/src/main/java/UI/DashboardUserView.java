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

public class DashboardUserView extends JPanel implements ActionListener {

   User currentUser;
   private ViewController vc;
   private MenuUserView menuUserView;
	
	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window
	 */
	public DashboardUserView(User currentUser, ViewController vc) {
//		super("Profile"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuUserView = new MenuUserView(this.vc);
		this.add(menuUserView);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}