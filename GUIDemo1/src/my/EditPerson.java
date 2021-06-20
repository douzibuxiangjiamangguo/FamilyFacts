package my;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import af.swing.AfPanel;
import af.swing.layout.AfColumnLayout;
import af.swing.layout.AfRowLayout;

//！！！！！！！！！！！！！！！！！
public class EditPerson extends JDialog {

	AfPanel root = new AfPanel();
	GridLayout layout = new GridLayout(1, 2);
	JPanel mPanel = new JPanel(layout);
	JButton findButton = new JButton("Edit");

	JTable table = null;
	DefaultTableModel tableModel = new DefaultTableModel();

	public JTextField firstnameField = new JTextField(20);
	public JTextField lastnameField = new JTextField(20);
	public JComboBox<String> sexField = new JComboBox<>();
	public JTextField birthdateField = new JTextField("Date", 20);
	public JTextField birthplaceField = new JTextField("Place", 20);

	JButton cancelButton = new JButton("Cancel");

	private boolean retValue = false;

	public EditPerson(JFrame owner) {
		super(owner, "Edit Person", true);
		this.setSize(1400, 800);

		// AfPanel root = new AfPanel();
		this.setContentPane(root);
		// root.setLayout(new AfColumnLayout(10));
		root.setLayout(new AfColumnLayout(10));
		root.padding(10);

		if (true) {
			AfPanel upPanel = new AfPanel();
			root.add(upPanel, "24px");
			JLabel label = new JLabel("XXXXXXX(鼠标选中的人的名字):");// 修改
			upPanel.add(label, BorderLayout.WEST);
		}

		if (true) {
			AfPanel mbuttonPanel = new AfPanel();
			root.add(mbuttonPanel, "24px");
			mbuttonPanel.setLayout(new AfRowLayout(10));
			mbuttonPanel.add(findButton, "auto");

		}

		if (true) {
			root.add(mPanel, "500px");

			initTable();

		}

		AfPanel buttonPanel = new AfPanel();
		root.add(buttonPanel, "30px");
		buttonPanel.setLayout(new AfRowLayout(10));
		buttonPanel.add(new JLabel(), "1w");

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

	private void initTable() {

		table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		GridLayout layout1 = new GridLayout(2, 1);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEtchedBorder());

		JPanel editPanel = new JPanel(layout1);
		editPanel.setLayout(new AfColumnLayout(10));
		editPanel.setBorder(BorderFactory.createEtchedBorder());

		if (true) {
			AfPanel row = new AfPanel();
			editPanel.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("First name"), "70px");
			row.add(firstnameField, "1w");

		}
		if (true) {
			AfPanel row = new AfPanel();
			editPanel.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Last name"), "70px");
			row.add(lastnameField, "1w");
		}
		if (true) {
			AfPanel row = new AfPanel();
			editPanel.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Sex"), "70px");
			row.add(sexField, "1w");

			sexField.addItem("Female");
			sexField.addItem("Male");
		}

		/////////

		if (true) {
			AfPanel row = new AfPanel();
			editPanel.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Birth"), "50px");
			row.add(birthdateField, "1w");
			row.add(birthplaceField, "1w");
		}

		if (true) {
			AfPanel row = new AfPanel();
			editPanel.add(row, "24px");
			row.setLayout(new AfRowLayout(10));
			row.add(new JLabel("Birth"), "50px");
			row.add(birthdateField, "1w");
			row.add(birthplaceField, "1w");
		}

		JList eslist = new JList();
		String[] dd = { "XXX and XXX", "<< XXX and other spouse >>" };
		eslist = new JList(dd);
		eslist.setVisibleRowCount(2);
		JScrollPane scrollPaneES = new JScrollPane(eslist);
		JPanel mEPanel = new JPanel(layout1);
		mEPanel.setBorder(BorderFactory.createEtchedBorder());
		mPanel.add(scrollPane);
		mPanel.add(mEPanel);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		mEPanel.add(editPanel);
		mEPanel.add(scrollPaneES);

		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setRowHeight(30);

		tableModel.addColumn("Name");
		tableModel.addColumn("Birth Date");

		table.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		table.getColumnModel().getColumn(0).setPreferredWidth(110);

	}

}
