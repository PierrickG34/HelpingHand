package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Core.User;
import Core.UserFacade;

public class ProfileUserModifyView extends JFrame implements ActionListener {

	/**
	 * Describe the current user
	 */
	private User currentUser;
	private UserFacade userFacade;

	/**
	 * Descriptions for the mobile field
	 */
	JLabel mobile = new JLabel("Mobile :");
	JTextField mobileEntre = new JTextField("", 15);

	/**
	 * Descriptions for the address field
	 */
	JLabel address = new JLabel("Address :");
	JTextField addressEntre = new JTextField("", 15);

	/**
	 * Description for the password information
	 */
	JLabel password = new JLabel("Password:");
	JPasswordField passwordEntre = new JPasswordField("", 15);

	/**
	 * Description for the button validate
	 */
	JButton validate = new JButton("Validate");

	/**
	 * Describe error message
	 */
	JLabel errorMessage = new JLabel("");

	/**
	 * 
	 * @param currentUser
	 */
	public ProfileUserModifyView(User currentUser) {
		super("Edit Profile");
		this.currentUser = currentUser;
		this.userFacade = new UserFacade(currentUser);
		
		Container contentPane = getContentPane(); 
		contentPane.setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1000,500));
		setMaximumSize(new Dimension(1000,500));

		/*##### Display the menu bar #####*/
		JPanel panelButton = new JPanel(new GridLayout(2, 1)); // 2 rows x 1 column
		JPanel panelTopButton = new JPanel();
		JPanel panelBottomButton = new JPanel();
		JButton dashboard = new JButton("Dashboard");
		JButton journal = new JButton("Journal");
		JButton myPlans = new JButton("My Plans");
		JButton myFavorites = new JButton("My Favorites");
		JButton shoppingCart = new JButton("Shopping Cart");

		JButton profile = new JButton("Profile");
		JButton notifications = new JButton("Notifications");
		panelTopButton.add(dashboard);
		panelTopButton.add(journal);
		panelTopButton.add(myPlans);
		panelTopButton.add(myFavorites);
		panelTopButton.add(shoppingCart);
		panelBottomButton.add(profile);
		panelBottomButton.add(notifications);
		panelButton.add(panelTopButton);
		panelButton.add(panelBottomButton);

		/*##### Display and edit the information #####*/
		JPanel panelEditInformation = new JPanel();
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextField = new JPanel(new GridLayout(0,1));
		JPanel panelButtonValidate = new JPanel(new GridLayout(0,1));

		//Mobile
		this.mobile.setPreferredSize(this.mobileEntre.getPreferredSize());
		this.mobile.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.mobile);
		//Address
		this.address.setPreferredSize(this.addressEntre.getPreferredSize());
		this.address.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.address);
		//Password
		this.password.setPreferredSize(this.passwordEntre.getPreferredSize());
		this.password.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.password);

		this.mobileEntre.setToolTipText(this.currentUser.getMobile());
		this.addressEntre.setToolTipText(this.currentUser.getAddress());
		this.passwordEntre.setToolTipText(this.currentUser.getPassword());
		panelTextField.add(this.mobileEntre);
		panelTextField.add(this.addressEntre);
		panelTextField.add(this.passwordEntre);

		this.errorMessage.setHorizontalAlignment(JLabel.CENTER);
		this.errorMessage.setVisible(false);

		panelEditInformation.add(this.errorMessage);

		panelEditInformation.add(panelLabels);
		panelEditInformation.add(panelTextField);
		panelButtonValidate.add(validate);
		panelEditInformation.add(panelButtonValidate, BorderLayout.SOUTH);
		this.validate.addActionListener(this);


		contentPane.add(panelButton,BorderLayout.NORTH);
		contentPane.add(panelEditInformation, BorderLayout.CENTER);

		//Display
		setSize(400,120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Check if the mobile number is correct or not (10 int is a valid format)
	 * @param enteredMobile
	 * @return
	 */
	public static boolean isValidMobile(String enteredMobile){
		String EMAIL_REGIX = "(0)[1-9][0-9]{8}";
		Pattern pattern = Pattern.compile(EMAIL_REGIX);
		Matcher matcher = pattern.matcher(enteredMobile);
		return ((!enteredMobile.isEmpty()) && (enteredMobile!=null) && (matcher.matches()));
	}

	/**
	 * Encrypt in md5 format the password enter by the user
	 * @param mdp
	 * @return the string encrypted in md5 format
	 */
	public String encrypt(String mdp) {
		String passwordToEncript = mdp;

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(passwordToEncript.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Validate") {
			boolean isValideMobile = false;
			if(!this.mobileEntre.getText().isEmpty()) {
				if (!isValidMobile(this.mobileEntre.getText())) {
					this.errorMessage.setText("Mobile number invalid");
					this.errorMessage.setVisible(true);
					this.errorMessage.setForeground(Color.red);
					this.mobile.setForeground(Color.red);
				}
				else {
					this.mobile.setForeground(Color.black);
					this.errorMessage.setVisible(false);
					isValideMobile = true;
				}
			}

			if(isValideMobile || !this.addressEntre.getText().isEmpty() ||
					this.passwordEntre.getPassword().length != 0) {
				this.userFacade.modifyAccount(this.mobileEntre.getText(), this.addressEntre.getText(), encrypt(String.valueOf((this.passwordEntre.getPassword()))));
			}
		}
	}
}
