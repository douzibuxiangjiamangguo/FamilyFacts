package my;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import af.common.json.AfJSON;
import af.swing.AfPanel;
import af.swing.layout.AfAnyWhere;
import af.swing.layout.AfColumnLayout;
import af.swing.layout.AfMargin;
import af.swing.layout.AfRowLayout;
import af.swing.layout.AfXLayout;

public class AddSpouse extends JDialog {

	List<Person> dataList = new ArrayList<>();
	DefaultTableModel tableModel = new DefaultTableModel();

	JButton addnewpersonButton = new JButton("Add New Person");
	JButton selectexistingpersonButton = new JButton("Select Existing Person");
	JButton cancelButton = new JButton("Cancel");

	private boolean retValue = false;

	public AddSpouse(JFrame owner) {
		super(owner, "Add Spouse", true);
		this.setSize(500, 300);

		AfPanel root = new AfPanel();
		this.setContentPane(root);
		root.setLayout(new AfColumnLayout(10));
		root.padding(10);

		AfPanel mainPanel = new AfPanel();
		root.add(mainPanel, "1w");
		mainPanel.setLayout(new AfColumnLayout(10));
		mainPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		mainPanel.padding(10);

		mainPanel.add(new JLabel("Add a Spouse to XXXXX"), "200px");

		AfPanel buttonPanel = new AfPanel();
		root.add(buttonPanel, "30px");
		buttonPanel.setLayout(new AfRowLayout(10));
		// buttonPanel.add(new JLabel(), "1w");
		buttonPanel.add(addnewpersonButton, "auto");
		addnewpersonButton.addActionListener((e) -> {

		});

		buttonPanel.add(selectexistingpersonButton, "auto");
		buttonPanel.add(cancelButton, "auto");

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

}
