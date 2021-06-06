package my;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import af.swing.AfPanel;
import af.swing.layout.AfRowLayout;

public class SearchFamilyList extends JDialog {

	AfPanel root = new AfPanel();
	AfPanel mPanel = new AfPanel();
	// AfPanel mbuttonPanel = new AfPanel();

	String[] parent = { "Father", "Mother" };
	JComboBox jcb1 = new JComboBox(parent);
	JButton editfatherButton = new JButton("Edit Father");
	JButton editmotherButton = new JButton("Edit Mother");

	JTable table = null;

	DefaultTableModel tableModel = new DefaultTableModel();

	JButton okButton = new JButton("OK");
	JButton cancelButton = new JButton("Cancel");

	private boolean retValue = false;

	public SearchFamilyList(JFrame owner) {
		super(owner, "Family List", true);
		this.setSize(500, 400);

		// AfPanel root = new AfPanel();
		this.setContentPane(root);
		// root.setLayout(new AfColumnLayout(10));
		root.setLayout(new BorderLayout());
		root.padding(10);

		JLabel label = new JLabel("Family List:");
		root.add(label, BorderLayout.NORTH);

		// AfPanel mPanel = new AfPanel();
		root.add(mPanel, BorderLayout.CENTER);

		AfPanel buttonPanel = new AfPanel();
		root.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new AfRowLayout(10));
		buttonPanel.add(new JLabel(), "1w");
		buttonPanel.add(okButton, "auto");
		buttonPanel.add(cancelButton, "auto");

		AfPanel mbuttonPanel = new AfPanel();
		mPanel.add(mbuttonPanel, BorderLayout.NORTH);
		mbuttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
		mbuttonPanel.add(editfatherButton, "auto");
		mbuttonPanel.add(editmotherButton, "auto");
		mbuttonPanel.add(jcb1, "auto");

		initTable();

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
		JScrollPane scrollPane = new JScrollPane(table);
		mPanel.add(scrollPane, BorderLayout.WEST);
		scrollPane.setPreferredSize(new Dimension(300, 200));

		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setRowHeight(30);

		tableModel.addColumn("Father");
		tableModel.addColumn("Mother");
		tableModel.addColumn("Marriage");

		table.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
	}

}
