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

public class ProductManageView extends JPanel implements ActionListener {
	
	JButton create = new JButton("Create a Product");
	JButton update = new JButton("Update a Product");
	JButton delete = new JButton("Delete a Product");
	
	
	private User currentUser;
	private ViewController vc;
	private MenuAdminView menuAdminView;
	
	public ProductManageView(User currentUser, ViewController vc) {
//		super("Product"); // Name of the frame
		this.currentUser = currentUser;
		this.vc = vc;
		this.menuAdminView = new MenuAdminView(this.vc);
		this.add(menuAdminView);
        
  
        /*-------------- Veritable view --------------------*/
        JPanel manageButton = new JPanel(new GridLayout(3, 1));
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
        
//        contentPane.add(manageButton, BorderLayout.WEST);
        this.add(manageButton, BorderLayout.WEST);

        //Display
//        setSize(400,120);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "Create a Product") {
			System.out.println("BUTTON CREATE");
			this.vc.ProductCreateView();
		}
		else if(source == "Update a Product") {
			this.vc.UpdateProductView();
		}
		else if(source == "Delete a Product") {
			this.vc.DeleteProductView();
		}
	}
}
