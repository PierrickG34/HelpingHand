package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Core.ActivityCategory;
import Core.ActivityCategoryFacade;
import Core.User;
import Persist.ActivityCategoryJDBC;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateActivityCategoryView.
 */
public class UpdateActivityCategoryView extends JPanel implements ActionListener {
	
	/** Descriptions for the windows label. */
	JLabel updateActivityCategory = new JLabel("  Update an activity category :");

	/** Description for the button validate button. */
	JButton submit = new JButton("Submit");


	/** Define the drop down menu with the activity category. */
	JComboBox<String> combo = new JComboBox<String>();

	/** Text to choose the activity category to delete. */
	JLabel chooseActivityCategory = new JLabel("Choose an activity category :");

	/** Button who permit to validate the activity category choosen. */
	JButton chooseActivityCategoryButton = new JButton("Choose");

	
	/** Descriptions for the short detail of an activity category. */
	JLabel shortDetailActivityCategory = new JLabel("Short detail :");
	
	/** The short detail activity category entre. */
	JTextField shortDetailActivityCategoryEntre = new JTextField("", 15);

	/** Descriptions for the short detail of an activity category. */
	JLabel longDetailActivityCategory = new JLabel("Long detail :");
	
	/** The long detail activity category entre. */
	JTextField longDetailActivityCategoryEntre = new JTextField("", 15);
	
	/** This panel permit to display information. */
	JPanel panelEditAll = new JPanel(new GridLayout(2,0));
	
	/** Define the current activit category that the admin choose. */
	ActivityCategoryJDBC currentActivityCategory;

	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public ActivityCategoryFacade activityCategoryFacades = new ActivityCategoryFacade(this);
	
	/** Contain all the activity category of the database. */
	List<ActivityCategory> allActivityCategory = new ArrayList<ActivityCategory>();

	/** The current user. */
	private User currentUser;
	
	/** The vc. */
	private ViewController vc;
	
	/** The menu admin view. */
	private MenuAdminView menuAdminView;

	/**
	 * Instantiates a new update activity category view.
	 *
	 * @param currentUser the current user
	 * @param vc the vc
	 */
	public UpdateActivityCategoryView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(vc);
		this.add(menuAdminView);
		
		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel();
		JPanel panelEdit = new JPanel();
		JPanel panelButtonValidate = new JPanel();
		JPanel panelComboBox = new JPanel(new GridLayout(3, 1));
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextFiel = new JPanel(new GridLayout(0,1));

		this.submit.addActionListener(this);
		this.chooseActivityCategoryButton.addActionListener(this);

		//Recuperate the activity Category and add to the combobox
		this.allActivityCategory = this.activityCategoryFacades.getAllCategories();
		for (int i = 0; i< this.allActivityCategory.size(); i++) {
			this.combo.addItem(this.allActivityCategory.get(i).getName());
		}
		panelComboBox.add(this.chooseActivityCategory);
		panelComboBox.add(this.combo);
		panelComboBox.add(this.chooseActivityCategoryButton);
        
        // Short detail 
        this.shortDetailActivityCategory.setPreferredSize(this.shortDetailActivityCategoryEntre.getPreferredSize());
        this.shortDetailActivityCategory.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.shortDetailActivityCategory);
        panelTextFiel.add(this.shortDetailActivityCategoryEntre);

        // Long detail
        this.longDetailActivityCategory.setPreferredSize(this.longDetailActivityCategoryEntre.getPreferredSize());
        this.longDetailActivityCategory.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLabels.add(this.longDetailActivityCategory);
        panelTextFiel.add(this.longDetailActivityCategoryEntre);
        
		panelButtonValidate.add(submit, BorderLayout.CENTER);
		panelAll.add(panelComboBox);
		panelEdit.add(panelLabels);
		panelEdit.add(panelTextFiel);
		this.panelEditAll.setVisible(false);
		this.panelEditAll.add(panelEdit);
		this.panelEditAll.add(panelButtonValidate);
		panelAll.add(this.panelEditAll);

		this.add(panelAll, BorderLayout.WEST);
	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Choose") {
			this.panelEditAll.setVisible(true);
			
			/* Aller dans la base de données avec l'id de la category*/
			this.shortDetailActivityCategoryEntre.setToolTipText(this.allActivityCategory.get(this.combo.getSelectedIndex()).getShortDetail());
			this.longDetailActivityCategoryEntre.setToolTipText(this.allActivityCategory.get(this.combo.getSelectedIndex()).getLongDetail());
		}
		if(source == "Submit") {
			this.activityCategoryFacades.modifyActivityCategory(this.allActivityCategory.get(this.combo.getSelectedIndex()), this.shortDetailActivityCategoryEntre.getText(), this.longDetailActivityCategoryEntre.getText());
			this.vc.ActivtyCategoryManageView();
		}
	}
}
