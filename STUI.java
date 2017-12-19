import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

public class STUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textScanner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					STUI frame = new STUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public STUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SplayTree1 newTree = new SplayTree1();
		
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		JButton insertButton = new JButton("Insert");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try {
					newTree.insert(Integer.parseInt(textScanner.getText()));
					JOptionPane.showMessageDialog ( 
							   null, "Inserted" );
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Please Enter Valid number");
					}
			}
		});
		
		textScanner = new JTextField();
		textScanner.setBackground(SystemColor.controlHighlight);
		textScanner.setBounds(145, 11, 151, 33);
		contentPane.add(textScanner);
		textScanner.setColumns(10);
		insertButton.setBounds(54, 69, 89, 23);
		contentPane.add(insertButton);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				newTree.search(Integer.parseInt(textScanner.getText()));
				JOptionPane.showMessageDialog ( 
						   null, "Search result : "+ newTree.search(Integer.parseInt(textScanner.getText())));
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Please Enter Valid number");
				}
			}
		});
		searchButton.setBounds(180, 69, 89, 23);
		contentPane.add(searchButton);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			SplayTree1 removed = newTree; 
			public void actionPerformed(ActionEvent arg0) {
				try {
					removed.remove(Integer.parseInt(textScanner.getText()));
						JOptionPane.showMessageDialog ( 
								   null, "Removed");
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Please Enter Valid number");
					}
				
			}
		});
		removeButton.setBounds(300, 69, 89, 23);
		contentPane.add(removeButton);
		
		JButton propertyButton = new JButton("Tree Properties");
		propertyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean node = newTree.isEmpty();
					int nodeCount = newTree.count;
					JOptionPane.showMessageDialog ( 
							   null, "Tree is Empty: " + node + "\n\n"+ "Node Count:" + nodeCount + "\n\n");
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Please Enter Valid number");
					}
				

			}
		});
		propertyButton.setBounds(140, 116, 169, 23);
		contentPane.add(propertyButton);
		JButton showButton = new JButton("Show Tree");
		showButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	JDialog treeShow;
	            	treeShow = new JDialog();
	            	treeShow.setSize(new Dimension(1000,1000));
	            	treeShow.setBackground(Color.WHITE);
	            	treeShow.setTitle("Tree");
	            	treeShow.setVisible(true);
	            }
	        });
		contentPane.getRootPane().add(showButton);
		showButton.setBounds(169, 161, 117, 23);
		contentPane.add(showButton);
		
		JButton resetButton = new JButton("Reset Tree");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					newTree.clear();
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Please Enter Valid number");
					}
				JOptionPane.showMessageDialog ( 
						   null, "Reset Successful");
				
			}
		});
		resetButton.setBounds(169, 207, 117, 23);
		contentPane.add(resetButton);
		
		
	}
}
