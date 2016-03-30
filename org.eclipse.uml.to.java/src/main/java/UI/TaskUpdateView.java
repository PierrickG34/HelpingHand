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
import javax.swing.plaf.PanelUI;

import Core.ActivityCategory;
import Core.ActivityCategoryFacade;
import Core.Product;
import Core.ProductFacade;
import Core.Task;
import Core.TaskFacade;
import Core.User;
import Persist.ActivityCategoryJDBC;

public class TaskUpdateView extends JPanel implements ActionListener {

	/**
	 * Descriptions for the windows
	 */
	JLabel updateTask = new JLabel("  Update a Task :");

	/**
	 * Description for the button validate
	 */
	JButton submit = new JButton("Submit");


	/**
	 * Define the drop down menu with the task
	 */
	JComboBox<String> comboTask = new JComboBox<String>();

	/**
	 * Define the drop down menu with the product
	 */
	JComboBox<String> comboProduct = new JComboBox<String>();

	/**
	 * Contain all the product of the database
	 */
	List<Product> allProduct = new ArrayList<Product>();

	/**
	 * Description of the property ProductFacades.
	 */
	public ProductFacade productFacades = new ProductFacade(this);

	/**
	 * Description for the choose product
	 */
	JLabel chooseProduct = new JLabel("Please select a product for your task");

	/**
	 * Text to choose the activity category to delete
	 */
	JLabel chooseTask = new JLabel("Choose a Task  :");

	/**
	 * Button who permit to validate the activity category choosen
	 */
	JButton chooseActivityCategoryButton = new JButton("Choose");

	/**
	 * Descriptions for the description of a task
	 */
	JLabel description = new JLabel("Description :");
	JTextField descriptionEntre = new JTextField("", 15);

	/**
	 * This panel permit to display information 
	 */
	JPanel panelEditAll = new JPanel(new GridLayout(2,0));

	/**
	 * Description of the property ActivityCategoryFacades.
	 */
	public TaskFacade taskFacades = new TaskFacade(this);

	/**
	 * Contain all the activity category of the database
	 */
	List<Task> allTask = new ArrayList<Task>();

	private User currentUser;
	private ViewController vc;
	private MenuAdminView menuAdminView;

	public TaskUpdateView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(vc);
		this.add(menuAdminView);
		
		/*-------------- Veritable view --------------------*/
		JPanel panelAll = new JPanel(new GridLayout(1, 2));
		JPanel panelSemiAll = new JPanel(new GridLayout(2, 0));
		JPanel panelEdit = new JPanel();
		JPanel panelButtonValidate = new JPanel();
		JPanel panelComboBoxTask = new JPanel(new GridLayout(3, 1));
		JPanel panelComboBoxProduct = new JPanel(new GridLayout(2, 0));
		JPanel panelLabels = new JPanel(new GridLayout(0,1));
		JPanel panelTextFiel = new JPanel(new GridLayout(0,1));
		JPanel panelComboBoxAllTask = new JPanel();
		JPanel panelComboBoxAllProduct = new JPanel();

		this.submit.addActionListener(this);
		this.chooseActivityCategoryButton.addActionListener(this);

		//Recuperate the task and add to the combobox
		this.allTask = this.taskFacades.getAllTask();
		for (int i = 0; i< this.allTask.size(); i++) {
			this.comboTask.addItem(this.allTask.get(i).getName());
		}
		panelComboBoxTask.add(this.chooseTask);
		panelComboBoxTask.add(this.comboTask);
		panelComboBoxTask.add(this.chooseActivityCategoryButton);
		panelComboBoxAllTask.add(panelComboBoxTask);

		// Description
		this.description.setPreferredSize(this.descriptionEntre.getPreferredSize());
		this.description.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabels.add(this.description);
		panelTextFiel.add(this.descriptionEntre);

		//Combo list product
		//Recuperate the product and add to the combobox
		this.allProduct = this.productFacades.getAllProduct();
		for (int i = 0; i< this.allProduct.size(); i++) {
			this.comboProduct.addItem(this.allProduct.get(i).getName());
		}
		panelComboBoxProduct.add(this.chooseProduct);
		panelComboBoxProduct.add(this.comboProduct);
		panelComboBoxAllProduct.add(panelComboBoxProduct);

		panelButtonValidate.add(submit, BorderLayout.CENTER);
		panelEdit.add(panelLabels);
		panelEdit.add(panelTextFiel);
		panelSemiAll.add(panelEdit);
		panelSemiAll.add(panelComboBoxAllProduct);
		this.panelEditAll.add(panelSemiAll);
		this.panelEditAll.add(panelButtonValidate);
		this.panelEditAll.setVisible(false);
		panelAll.add(panelComboBoxAllTask);
		panelAll.add(this.panelEditAll);

		this.add(panelAll, BorderLayout.CENTER);
		//this.add(this.panelEditAll, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Choose") {
			this.panelEditAll.setVisible(true);

			/* Aller dans la base de données avec l'id de la category*/
			this.descriptionEntre.setToolTipText(this.allTask.get(this.comboTask.getSelectedIndex()).getDescription());
		}
		if(source == "Submit") {
			System.out.println("BUTTON SUBMIT");
			this.taskFacades.modifyTask(this.allTask.get(this.comboTask.getSelectedIndex()), this.descriptionEntre.getText(), this.allProduct.get(this.comboProduct.getSelectedIndex()));
		}
	}
}
