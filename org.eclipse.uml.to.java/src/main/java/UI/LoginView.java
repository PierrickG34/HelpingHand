/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.User;
import Core.UserFacade;
import Excpetion.LoginException;
import Excpetion.PasswordException;

// TODO: Auto-generated Javadoc
// Start of user code (user defined imports)

// End of user code

/**
 * Description of LoginView.
 * 
 * @author pierrickgiuliani
 */
public class LoginView extends JFrame implements ActionListener {

	 /** Descriptions for the email field. */
    JLabel email = new JLabel("Email :");
    
    /** The email entre. */
    JTextField emailEntre = new JTextField("", 15);
    
    /** Describe error message. */
    JLabel errorMessage = new JLabel("");
 
    /** Descriptions for the password field. */
    JLabel password = new JLabel("Password:");
    
    /** The password entre. */
    JPasswordField passwordEntre = new JPasswordField("", 15);
    
    /** Descriptions for the validate button. */
    JButton validate = new JButton("Validate");
    
    /** Descriptions for the signup button. */
    JButton signUp = new JButton("Sign Up");

	/**
	 * Description of the property userFacades.
	 */
	public UserFacade userFacades = new UserFacade(this);

	// Start of user code (user defined attributes for LoginView)

	// End of user code

	/**
	 * The constructor who create the window.
	 */
	public LoginView() {
		super("Login"); // Name of the frame
		validate.addActionListener(this);
		signUp.addActionListener(this);
        Container contentPane = getContentPane(); 
        contentPane.setLayout(new BorderLayout());
        setMinimumSize(new Dimension(400,160));
        setMaximumSize(new Dimension(400,160));
        
        JPanel panelIn = new JPanel();
        
        JPanel panelLabels = new JPanel(new GridLayout(0,1)); 
        email.setPreferredSize(emailEntre.getPreferredSize());
        email.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(email);
        
        password.setPreferredSize(passwordEntre.getPreferredSize());
        password.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(password);
        
        JPanel panelTextFiel = new JPanel(new GridLayout(0,1));
        panelTextFiel.add(emailEntre);
        panelTextFiel.add(passwordEntre);
        
        panelIn.add(panelLabels);
        panelIn.add(panelTextFiel);
        
        JPanel error = new JPanel(new GridLayout(0,1));
        this.errorMessage.setHorizontalAlignment(JLabel.CENTER);
        error.add(this.errorMessage);
        this.errorMessage.setVisible(false);
        
        // button panel
        JPanel button_panel = new JPanel();
        button_panel.add(validate);
        button_panel.add(signUp);

        contentPane.add(panelIn,BorderLayout.NORTH);
        contentPane.add(button_panel,BorderLayout.SOUTH);
        contentPane.add(error, BorderLayout.CENTER);
        
        
        //Display
        setSize(400,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This function take no entry and return a String corresponding to the user login, contain in the JTextField Login.
	 *
	 * @return the login text
	 */
	public String getLoginText() {
		// Start of user code for method getLoginText
		String getLoginText = "";
		return getLoginText;
		// End of user code
	}

	/**
	 * This function take no entry and return a String corresponding to the user password, contain in the JTextField Password.
	 *
	 * @return the password text
	 */
	public String getPasswordText() {
		// Start of user code for method getPasswordText
		String getPasswordText = "";
		return getPasswordText;
		// End of user code
	}


	// Start of user code (user defined methods for LoginView)

	// End of user code
	/**
	 * Returns validate.
	 * @return validate 
	 */
	public JButton getValidateButton() {
		return this.validate;
	}

	/**
	 * Sets a value to attribute validateButton. 
	 *
	 * @param newValidateButton the new validate button
	 */
	public void setValidateButton(JButton newValidateButton) {
		this.validate = newValidateButton;
	}

	/**
	 * Returns loginField.
	 * @return loginField 
	 */
	public JTextField getLoginField() {
		return this.emailEntre;
	}

	/**
	 * Sets a value to attribute loginField. 
	 *
	 * @param newLoginField the new login field
	 */
	public void setLoginField(JTextField newLoginField) {
		this.emailEntre = newLoginField;
	}

	/**
	 * Returns passwordField.
	 * @return passwordField 
	 */
	public JPasswordField getPasswordField() {
		return this.passwordEntre;
	}

	/**
	 * Sets a value to attribute passwordField. 
	 *
	 * @param newPasswordField the new password field
	 */
	public void setPasswordField(JPasswordField newPasswordField) {
		this.passwordEntre = newPasswordField;
	}

	/**
	 * Returns userFacades.
	 * @return userFacades 
	 */
	public UserFacade getUserFacades() {
		return this.userFacades;
	}

	/**
	 * Sets a value to attribute userFacades. 
	 *
	 * @param newUserFacades the new user facades
	 */
	public void setUserFacades(UserFacade newUserFacades) {
		this.userFacades = newUserFacades;
	}

	
	/**
	 *  Action when the user click on the button validate.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source == "Validate") {
			if (isValidEmail(this.emailEntre.getText())) { // If the address mail is valid, we encrypt and go in the database
				String passwordEncrypted;
				//Set the default color
				this.emailEntre.setBackground(Color.white);
				this.email.setForeground(Color.black);
				this.password.setForeground(Color.black);
				this.errorMessage.setVisible(false);
				this.errorMessage.setForeground(Color.black);
				
				
				passwordEncrypted = encrypt(String.valueOf((this.passwordEntre.getPassword())));
				try {
					User currentUser = this.userFacades.login(this.emailEntre.getText(), passwordEncrypted);
					if (currentUser != null) {
						ViewController vc = new ViewController(currentUser);
						if(currentUser.getAdmin() == true) {
							//DashboardAdminView dashAdmin = new DashboardAdminView(currentUser);
							vc.dashboardAdminView();
						}
						else if (!currentUser.getSiretNumber().isEmpty()) {
							//DashboardSellerView dashSeller = new DashboardSellerView(currentUser);
							vc.dashboardSellerView();
						}
						else {
							//DashboardUserView dashUser = new DashboardUserView(currentUser);
							vc.dashboardUserView();
						}
						this.dispose();
						//DashboardAdminView test = new DashboardAdminView(currentUser);
					}
				} catch (LoginException errorLogin) {
					this.errorMessage.setText(errorLogin.getNameError());
					this.errorMessage.setForeground(Color.red);
					this.errorMessage.setVisible(true);
				} catch (PasswordException errorPassword) {
					this.errorMessage.setText(errorPassword.getNameError());
					this.errorMessage.setForeground(Color.red);
					this.errorMessage.setVisible(true);
				}
			}
			else { // Else we put in the textfield email error message, the user can try again
				this.errorMessage.setText("Invalid mail format");
				this.errorMessage.setForeground(Color.red);
				this.errorMessage.setVisible(true);
			}
		}
		else if(source == "Sign Up") {
			SignUpView signup = new SignUpView();
			this.dispose();
			/*Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, 19990);
			calendar.set(Calendar.DAY_OF_MONTH, 19990);
			calendar.set(Calendar.MONTH, 19990);
			java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			this.userFacades.signUp("a", "b", "c", "d", "e", date , "f", "g", "h");*/
			
			//this.userFacades.signUp(firstName, surName, mobile, mailAddress, password, dateOfBirth, profilePicture, webSiteURL, siretNumber);
		}
	}
	
	/**
	 * Check if the mail address is valid or not ("xx@xx.xx" is a valid format) 
	 * @param enteredEmail Mail address enter by the user
	 * @return Boolean if the email address is valid, or not
	 */
	public static boolean isValidEmail(String enteredEmail){
        String EMAIL_REGIX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_REGIX);
        Matcher matcher = pattern.matcher(enteredEmail);
        return ((!enteredEmail.isEmpty()) && (enteredEmail!=null) && (matcher.matches()));
    }
	
	/**
	 * Encrypt in md5 format the password enter by the user.
	 *
	 * @param mdp the mdp
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

		System.out.println("mdp original:" + passwordToEncript);
		return sb.toString();
	}

}
