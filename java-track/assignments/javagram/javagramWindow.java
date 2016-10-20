package javagram;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class javagramWindow {

	private JFrame frame;
	private JTextField FileNameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javagramWindow window = new javagramWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public javagramWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPickYourFilter = new JLabel("Pick Your Filter");
		lblPickYourFilter.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickYourFilter.setBounds(6, 72, 438, 16);
		frame.getContentPane().add(lblPickYourFilter);
		
		JLabel lblNewLabel = new JLabel("Path to File Relative to images");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 16);
		frame.getContentPane().add(lblNewLabel);
		
		FileNameField = new JTextField();
		FileNameField.setBounds(6, 34, 438, 26);
		frame.getContentPane().add(FileNameField);
		FileNameField.setColumns(10);
		
		JList<String> list = new JList<>();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Blue Filter", "Greyscale Filter", "5px Box Blur"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(6, 100, 438, 122);
		list.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Filter Image");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filter = list.getSelectedIndex() + 1;
				String fileName = FileNameField.getText();
				if (fileName == null || fileName.equals("")) { 
					lblNewLabel.setText("Please Enter A File Name");
					lblNewLabel.setForeground(Color.RED);
				} else {
					System.out.println(filter);
					Javagram.filterImage(filter, fileName);
				}
			}
		});
		btnNewButton.setBounds(6, 228, 438, 44);
		frame.getContentPane().add(btnNewButton);
	
	}
}
