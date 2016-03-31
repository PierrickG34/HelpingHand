package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Core.User;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductManageView.
 */
public class ProductManageView extends JPanel implements ActionListener {
	
	/** The create. */
	JButton create = new JButton("Create a Product");
	
	/** The update. */
	JButton update = new JButton("Update a Product");
	
	/** The delete. */
	JButton delete = new JButton("Delete a Product");
	
	
	/** The current user. */
	private User currentUser;
	
	/** The vc. */
	private ViewController vc;
	
	/** The menu admin view. */
	private MenuAdminView menuAdminView;
	
	/**
	 * Instantiates a new product manage view.
	 *
	 * @param currentUser the current user
	 * @param vc the vc
	 */
	public ProductManageView(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);
        
  
        /*-------------- Veritable view --------------------*/
        JPanel manageButton = new JPanel();
        JPanel createButton = new JPanel();
        JPanel updateButton = new JPanel();
        JPanel deleteButton = new JPanel();
        
        this.create.addActionListener(this);
        this.update.addActionListener(this);
        this.delete.addActionListener(this);
        
        createButton.add(this.create);
        updateButton.add(this.update);
        deleteButton.add(this.delete);
        
        manageButton.add(createButton);
        manageButton.add(updateButton);
        manageButton.add(deleteButton);
        
        this.add(manageButton, BorderLayout.WEST);

	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create a Product") {
			this.vc.ProductCreateView();
		}
		else if(source == "Update a Product") {
			this.vc.UpdateProductAdminView();
		}
		else if(source == "Delete a Product") {
			this.vc.DeleteProductView();
		}
	}
}
