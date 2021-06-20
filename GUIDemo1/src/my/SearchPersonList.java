package my;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import af.swing.AfPanel;
import af.swing.layout.AfColumnLayout;
import af.swing.layout.AfRowLayout;

public class SearchPersonList extends JDialog {

	AfPanel root = new AfPanel();
	GridLayout layout = new GridLayout(1, 2);
	JPanel mPanel = new JPanel(layout);
	// AfPanel mbuttonPanel = new AfPanel();

	JButton findButton = new JButton("Find");

	JTable table = null;
	JTable tableEN = null;

	DefaultTableModel tableModel = new DefaultTableModel();
	DefaultTableModel tableENModel = new DefaultTableModel();

	JButton selectButton = new JButton("Select");
	JButton cancelButton = new JButton("Cancel");

	private boolean retValue = false;

	public SearchPersonList(JFrame owner) {
		super(owner, "Search Person List", true);
		this.setSize(1400, 800);

		// AfPanel root = new AfPanel();
		this.setContentPane(root);
		// root.setLayout(new AfColumnLayout(10));
		root.setLayout(new AfColumnLayout(10));
		root.padding(10);

		if (true) {
			AfPanel upPanel = new AfPanel();
			root.add(upPanel, "24px");
			JLabel label = new JLabel("Person List:");
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
			// initENTable();
		}

		AfPanel buttonPanel = new AfPanel();
		root.add(buttonPanel, "30px");
		buttonPanel.setLayout(new AfRowLayout(10));
		buttonPanel.add(new JLabel(), "1w");
		buttonPanel.add(selectButton, "auto");
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
		tableEN = new JTable(tableENModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		GridLayout layout1 = new GridLayout(2, 1);
		JScrollPane scrollPane = new JScrollPane(table);
		JScrollPane scrollPaneEN = new JScrollPane(tableEN);
		JList eslist = new JList();
		String[] dd = { "XXX and XXX", "<< XXX and other spouse >>" };
		eslist = new JList(dd);
		eslist.setVisibleRowCount(2);
		JScrollPane scrollPaneES = new JScrollPane(eslist);
		JPanel mEPanel = new JPanel(layout1);
		mPanel.add(scrollPane);
		mPanel.add(mEPanel);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		mEPanel.add(scrollPaneEN);
		mEPanel.add(scrollPaneES);

		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setRowHeight(30);

		tableModel.addColumn("Name");
		tableModel.addColumn("Birth Date");

		table.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		table.getColumnModel().getColumn(0).setPreferredWidth(110);

		tableEN.setFillsViewportHeight(true);
		tableEN.setRowSelectionAllowed(true);
		tableEN.setRowHeight(30);

		tableENModel.addColumn("Facts");
		tableENModel.addColumn("Content");

		tableEN.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		tableEN.getColumnModel().getColumn(0).setPreferredWidth(110);

	}

	private void initENTable() {

		tableEN = new JTable(tableENModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		AfPanel mEPanel = new AfPanel();
		JScrollPane scrollPaneEN = new JScrollPane(tableEN);
		JScrollPane scrollPaneES = new JScrollPane(tableEN);
		mPanel.add(mEPanel, BorderLayout.CENTER);
		mEPanel.add(scrollPaneEN, BorderLayout.NORTH);
		mEPanel.add(scrollPaneES, BorderLayout.CENTER);
		scrollPaneEN.setPreferredSize(new Dimension(300, 200));
		scrollPaneES.setPreferredSize(new Dimension(300, 200));

		tableEN.setFillsViewportHeight(true);
		tableEN.setRowSelectionAllowed(true);
		tableEN.setRowHeight(30);

		tableENModel.addColumn("Facts");
		tableENModel.addColumn("Content");

		tableEN.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		tableEN.getColumnModel().getColumn(0).setPreferredWidth(110);

	}

}
