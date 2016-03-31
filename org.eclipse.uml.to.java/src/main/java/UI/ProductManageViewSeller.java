package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.User;

/**
 * The Class ProductManageViewSeller.
 * 
 * @author HelpingHand
 */
public class ProductManageViewSeller extends JPanel implements ActionListener {
	
	/** The create. */
	JButton create = new JButton("Create a Product");
	
	/** The update. */
	JButton update = new JButton("Update a Product");
	
	/** The delete. */
	JButton delete = new JButton("Delete a Product");
	
	
	/** The current user. */
	private User currentUser;
	
	/** The ViewController. */
	private ViewController vc;
	
	/** The menu seller view. */
	private MenuSellerView menuSellerView;
	
	/**
	 * Instantiates a new product manage view seller.
	 *
	 * @param currentUser the current user
	 * @param vc the ViewController
	 */
	public ProductManageViewSeller(User currentUser, ViewController vc) {
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuSellerView = new MenuSellerView(this.vc);
		this.add(menuSellerView);
        
  
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
			this.vc.ProductCreateViewSeller();
		}
		else if(source == "Update a Product") {
			this.vc.UpdateProductView();
		}
		else if(source == "Delete a Product") {
			this.vc.DeleteProductViewSeller();
		}
	}
}
