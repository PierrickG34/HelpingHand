package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Core.User;

public class ProfileUserView extends JFrame implements ActionListener {

	JButton dashboard = new JButton("Dashboard");
	JButton journal = new JButton("Journal");
	JButton myPlans = new JButton("My Plans");
	JButton myFavorites = new JButton("My Favorites");
	JButton shoppingCart = new JButton("Shopping Cart");

	JButton profile = new JButton("Profile");
	JButton notifications = new JButton("Notifications");

	/**
	 * Description for the firstname information
	 */
	JLabel firstName = new JLabel("");

	/**
	 * Description for the surname information
	 */
	JLabel surName = new JLabel("");

	/**
	 * Description for the mobile information
	 */
	JLabel mobile = new JLabel("");

	/**
	 * Description for the mail information
	 */
	JLabel mail = new JLabel("");

	/**
	 * Description for the dateOfBirth information
	 */
	JLabel dateOfBirth = new JLabel("");

	/**
	 * Description for the password information
	 */
	JLabel password = new JLabel("");

	/**
	 * Description for the address information
	 */
	JLabel address = new JLabel("");

	/**
	 * Description for the button permits to modify this informations
	 */
	JButton modify = new JButton("Modify informations");

	/**
	 * 
	 */
	private User currentUser;



	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window
	 */
	public ProfileUserView(User currentUser) {
		super("Profile"); // Name of the frame
		this.currentUser = currentUser;

		/*##### Display the menu bar #####*/
		/* Defined actions on the different buttons */
		this.dashboard.addActionListener(this);
		this.journal.addActionListener(this);
		this.myPlans.addActionListener(this);
		this.myFavorites.addActionListener(this);
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
		panelTopButton.add(shoppingCart);
		panelBottomButton.add(profile);
		panelBottomButton.add(notifications);
		panelButton.add(panelTopButton);
		panelButton.add(panelBottomButton);

		/*##### Display the information of the user #####*/
		this.firstName.setText(this.currentUser.getFirstName());
		this.firstName.setHorizontalAlignment(JLabel.CENTER);
		this.surName.setText(this.currentUser.getSurName());
		this.surName.setHorizontalAlignment(JLabel.CENTER);
		this.mobile.setText(this.currentUser.getMobile());
		this.mobile.setHorizontalAlignment(JLabel.CENTER);
		this.mail.setText(this.currentUser.getMailAddress());
		this.mail.setHorizontalAlignment(JLabel.CENTER);
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// Get the date today using Calendar object.
		Date dateOfBirthToParse = this.currentUser.getDateOfBirth();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(dateOfBirthToParse);
		this.dateOfBirth.setText(reportDate);
		this.dateOfBirth.setHorizontalAlignment(JLabel.CENTER);
		this.password.setText(this.currentUser.getPassword());
		this.password.setHorizontalAlignment(JLabel.CENTER);
		this.address.setText(this.currentUser.getAddress());
		this.address.setHorizontalAlignment(JLabel.CENTER);;
		JPanel panelInformations = new JPanel(new GridLayout(7,1));
		JPanel panelButtonValidate = new JPanel();
		panelInformations.add(this.firstName);
		panelInformations.add(this.surName);
		panelInformations.add(this.mobile);
		panelInformations.add(this.mail);
		panelInformations.add(this.dateOfBirth);
		panelInformations.add(this.password);
		panelInformations.add(this.address);
		panelButtonValidate.add(this.modify);
		this.modify.addActionListener(this);


		contentPane.add(panelButton,BorderLayout.NORTH);
		contentPane.add(panelInformations, BorderLayout.CENTER);
		contentPane.add(panelButtonValidate,  BorderLayout.SOUTH);

		//Display
		setSize(400,120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Modify informations") {
			ProfileUserModifyView profileUserModifyView = new ProfileUserModifyView(this.currentUser);
		}

	}

}
