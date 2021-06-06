package my;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import af.swing.AfPanel;
import af.swing.layout.AfColumnLayout;
import af.swing.layout.AfRowLayout;
import af.swing.layout.AfYLayout;

public class AddIndividual extends JDialog {

	public JTextField firstnameField = new JTextField(20);
	public JTextField lastnameField = new JTextField(20);
	public JComboBox<String> sexField = new JComboBox<>();
	public JTextField birthdateField = new JTextField("Date", 20);
	public JTextField birthplaceField = new JTextField("Place", 20);
	public JTextField deathdateField = new JTextField("Date", 20);
	public JTextField deathplaceField = new JTextField("Place", 20);
	public JTextField burialdateField = new JTextField("Date", 20);
	public JTextField burialplaceField = new JTextField("Place", 20);

	JButton okButton = new JButton("OK");

	private boolean retValue = false;

	public AddIndividual(JFrame owner) {
		super(owner, "Add Person", true);
		this.setSize(800, 500);

		AfPanel root = new AfPanel();
		this.setContentPane(root);
		root.setLayout(new AfColumnLayout(10));
		root.padding(10);

		AfPanel main = new AfPanel();
		root.add(main, "1w");
		main.setLayout(new AfColumnLayout(10));
		main.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		main.padding(10);

		if (true) {
			AfPanel row = new AfPanel();
			main.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("First name"), "70px");
			row.add(firstnameField, "1w");

		}
		if (true) {
			AfPanel row = new AfPanel();
			main.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Last name"), "70px");
			row.add(lastnameField, "1w");
		}
		if (true) {
			AfPanel row = new AfPanel();
			main.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Sex"), "70px");
			row.add(sexField, "1w");

			sexField.addItem("Female");
			sexField.addItem("Male");
		}

		/////////

		if (true) {
			AfPanel row = new AfPanel();
			main.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Birth"), "50px");
			row.add(birthdateField, "1w");
			row.add(birthplaceField, "1w");
		}

		if (true) {
			AfPanel row = new AfPanel();
			main.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Death"), "50px");
			row.add(deathdateField, "1w");
			row.add(deathplaceField, "1w");

		}

		if (true) {
			AfPanel row = new AfPanel();
			main.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Burial"), "50px");
			row.add(burialdateField, "1w");
			row.add(burialplaceField, "1w");

		}

		AfPanel bottom = new AfPanel();
		root.add(bottom, "30px");
		bottom.setLayout(new AfRowLayout(10));
		bottom.add(new JLabel(), "1w");
		bottom.add(okButton, "auto");

		okButton.addActionListener((e) -> {

			if (checkValid()) {
				retValue = true;
				setVisible(false);
			}

		});

	}

	public boolean exec() {

		Rectangle frmRect = this.getOwner().getBounds();
		int width = this.getWidth();
		int height = this.getHeight();
		int x = frmRect.x + (frmRect.width - width) / 2;
		int y = frmRect.y + (frmRect.height - height) / 2;
		this.setBounds(x, y, width, height);

		this.setVisible(true);

		return retValue;
	}

	public void setValue(Person v) {
		firstnameField.setText(v.firstname);
		lastnameField.setText(v.lastname);
		sexField.setSelectedIndex(v.sex ? 1 : 0);
		birthdateField.setText(v.birthdate);
	}

	public boolean checkValid() {
		Person v = getValue();
		if (v.firstname.isEmpty()) {
			JOptionPane.showMessageDialog(this, "firstname不得为空!");
			return false;
		}
		if (v.lastname.isEmpty()) {
			JOptionPane.showMessageDialog(this, "lastname不得为空!");
			return false;
		}
		return true;
	}

	public Person getValue() {
		Person v = new Person();
		v.firstname = firstnameField.getText().trim();
		v.lastname = lastnameField.getText().trim();
		v.sex = sexField.getSelectedIndex() == 1;
		v.birthdate = birthdateField.getText().trim();
		v.birthplace = birthplaceField.getText().trim();
		v.deathdate = deathdateField.getText().trim();
		v.deathplace = deathplaceField.getText().trim();
		v.burialdate = burialdateField.getText().trim();
		v.burialplace = burialplaceField.getText().trim();

		return v;
	}

}
