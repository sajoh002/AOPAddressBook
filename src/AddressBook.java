import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;

public class AddressBook extends Frame {
	static HashMap<String, Address> addressBook;
	static String oldName;
	static Address oldAddress;
	
	static Label nameLabel;
	static Label streetLabel;
	static Label cityLabel;
	static Label stateLabel;
	static Label zipLabel;
	static Label phoneLabel;
	
	static TextField nameInput;
	static TextField streetInput;
	static TextField cityInput;
	static TextField stateInput;
	static TextField zipInput;
	static TextField phoneInput;
	static TextArea displayAddBk;
	
	static Button addBtn;
	static Button deleteBtn;
	static Button updateBtn;
	static Button displayBtn;

	public AddressBook() {
		Panel addressDisplay = new Panel(new GridLayout(6, 2));
		nameLabel = new Label("Enter the first and last name:");
		addressDisplay.add(nameLabel);
		nameInput = new TextField();
		addressDisplay.add(nameInput);
		streetLabel = new Label("Enter address:");
		addressDisplay.add(streetLabel);
		streetInput = new TextField();
		addressDisplay.add(streetInput);
		cityLabel = new Label("City:");
		addressDisplay.add(cityLabel);
		cityInput = new TextField();
		addressDisplay.add(cityInput);
		stateLabel = new Label("State:");
		addressDisplay.add(stateLabel);
		stateInput = new TextField();
		addressDisplay.add(stateInput);
		zipLabel = new Label("Zipcode:");
		addressDisplay.add(zipLabel);
		zipInput = new TextField();
		addressDisplay.add(zipInput);
		phoneLabel = new Label("Phone Number (XXX-XXX-XXXX):");
		addressDisplay.add(phoneLabel);
		phoneInput = new TextField();
		addressDisplay.add(phoneInput);
		
		Panel buttonDisplay = new Panel(new GridLayout(1, 4));
		addBtn = new Button("Add");
		buttonDisplay.add(addBtn);
		deleteBtn = new Button("Delete");
		buttonDisplay.add(deleteBtn);
		updateBtn = new Button("Update");
		buttonDisplay.add(updateBtn);
		displayBtn = new Button("Display");
		buttonDisplay.add(displayBtn);
		
		Panel addBkDisplay = new Panel(new FlowLayout());
		displayAddBk = new TextArea(10, 60);
		displayAddBk.setEditable(false);
		addBkDisplay.add(displayAddBk);
		
		BtnAddListener addListener = new BtnAddListener();
		addBtn.addActionListener(addListener);
		
		BtnDelListener delListener = new BtnDelListener();
		deleteBtn.addActionListener(delListener);
		
		BtnUpdListener updListener = new BtnUpdListener();
		updateBtn.addActionListener(updListener);
		
		BtnDisplayListener displayListener = new BtnDisplayListener();
		displayBtn.addActionListener(displayListener);
				
		setLayout(new BorderLayout());
		add(addressDisplay, BorderLayout.NORTH);
		add(buttonDisplay, BorderLayout.CENTER);
		add(addBkDisplay, BorderLayout.SOUTH);
		
		addWindowListener(new MyWindowListener());
		
		setTitle("Address Book");
		setSize(500, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		addressBook = new HashMap<>();

		new AddressBook();
		
		
	}
	
	private class BtnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String name = nameInput.getText();
			Address address = new Address(streetInput.getText(), cityInput.getText(), 
					stateInput.getText(), zipInput.getText(), phoneInput.getText());
			addressBook.put(name, address);
		}
	}
	
	private class BtnDelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String name = nameInput.getText();
			Address address = addressBook.get(name);
			saveContact(name, address);
			addressBook.remove(name);
		}
	}
	
	private class BtnUpdListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String name = nameInput.getText();
			Address address = addressBook.get(name);
			saveContact(name, address);
			Address updatedAddress = new Address(streetInput.getText(), cityInput.getText(), 
					stateInput.getText(), zipInput.getText(), phoneInput.getText());
			addressBook.put(name, updatedAddress);
		}
	}
		
	private class BtnDisplayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String displayAdds = "";
			for (Map.Entry<String, Address> e: addressBook.entrySet()) {
				String name = e.getKey();
				Address address = e.getValue();
				displayAdds = displayAdds.concat(name + " " + address + "\n");
			}
			displayAddBk.setText(displayAdds);
		}
	}
	
	private class MyWindowListener implements WindowListener {
		@Override
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Window Activated");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Window Deactivated");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Window Deiconified");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Window Iconified");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void saveContact(String name, Address address) {
		this.oldName = name;
		this.oldAddress = address;
	}

}
