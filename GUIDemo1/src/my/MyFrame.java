package my;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import af.common.json.AfJSON;
import af.swing.AfPanel;
import af.swing.layout.AfColumnLayout;
import af.swing.layout.AfRowLayout;
import net.miginfocom.swing.MigLayout;

public class MyFrame extends JFrame {

	JPanel root = new JPanel();
	JTable table = null;

	List<Person> dataList = new ArrayList<>();
	DefaultTableModel tableModel = new DefaultTableModel();

	static GridLayout layout = new GridLayout(2, 1);// familyPanel

	static JTable familytable = null;
	static DefaultTableModel familytableModel = new DefaultTableModel();

	static MigLayout ml = new MigLayout();

	static JPanel pedigreePanel = new JPanel(ml);

	static JPanel familyPanel = new JPanel(layout);
	static JTabbedPane tabbedPane = buildJTabbedPane(pedigreePanel, familyPanel);

	public MyFrame(String title) {
		super(title);

		// Content Pane
		this.setContentPane(root);
		root.setLayout(new BorderLayout(5, 5));
		root.add(tabbedPane);
		// add Menu
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);

		// Menu File
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		JMenuItem fileNewCmd = new JMenuItem("New");
		JMenuItem fileOpenCmd = new JMenuItem("Open");
		JMenuItem fileRenameCmd = new JMenuItem("Rename");
		JMenuItem fileDelectCmd = new JMenuItem("Delect");

		fileMenu.add(fileNewCmd);
		fileMenu.add(fileOpenCmd);
		fileMenu.add(fileRenameCmd);
		fileMenu.add(fileDelectCmd);

		JMenuItem fileExitCmd = new JMenuItem("Exit");
		fileMenu.addSeparator();
		fileMenu.add(fileExitCmd);

		fileNewCmd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onFileNew();
			}
		});

		fileOpenCmd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onFileOpen();
			}
		});

		// Menu Edit
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		JMenuItem editPerson = new JMenuItem("Person");
		JMenu editDelete = new JMenu("Delete");// 存在子菜单
		JMenu editUnlink = new JMenu("Unlink");// 存在子菜单
		JMenuItem editSwap = new JMenuItem("Swap Husband and wife");

		editPerson.addActionListener((e) -> {
			oneditperson();

		});

		editSwap.addActionListener((e) -> {
			oneditswap();

		});

		// 子菜单
		JMenuItem editDeletePerson = new JMenuItem("Person");
		JMenuItem editDeleteFamily = new JMenuItem("Family");
		JMenuItem editUnlinkFromParent = new JMenuItem("From Parent");
		JMenuItem editUnlinkFromSpouse = new JMenuItem("From Spouse");

		editDelete.add(editDeletePerson);
		editDelete.add(editDeleteFamily);
		editUnlink.add(editUnlinkFromParent);
		editUnlink.add(editUnlinkFromSpouse);

		editMenu.add(editPerson);
		editMenu.add(editDelete);
		editMenu.add(editUnlink);
		editMenu.add(editSwap);

		// Menu List
		JMenu listMenu = new JMenu("List");
		menubar.add(listMenu);
		JMenuItem listAddress = new JMenuItem("Address List");
		JMenuItem listRepository = new JMenuItem("Repository List");
		listMenu.add(listAddress);
		listMenu.add(listRepository);

		listAddress.addActionListener((e) -> {
			onListAddress();

		});

		listRepository.addActionListener((e) -> {
			onListRepository();

		});

		// Menu Add
		JMenu addMenu = new JMenu("Add");
		menubar.add(addMenu);
		JMenuItem addIndividual = new JMenuItem("Individual");
		JMenuItem addSpouse = new JMenuItem("Spouse");
		JMenuItem addParents = new JMenuItem("Parents");
		JMenuItem addChild = new JMenuItem("Child");

		addIndividual.addActionListener((e) -> {
			onAddIndividual();
		});

		addSpouse.addActionListener((e) -> {
			onAddSpouse();
		});

		addParents.addActionListener((e) -> {
			onAddFather();
			onAddMother();

		});
		addChild.addActionListener((e) -> {
			onAddChild();

		});

		addMenu.add(addIndividual);
		addMenu.add(addSpouse);
		addMenu.add(addParents);
		addMenu.add(addChild);

		// Menu View
		JMenu viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		JMenuItem viewPedigree = new JMenuItem("Pedigree");
		JMenuItem viewFamily = new JMenuItem("Family");
		viewMenu.add(viewPedigree);
		viewMenu.add(viewFamily);

		// Menu Search
		JMenu searchMenu = new JMenu("Search");
		menubar.add(searchMenu);
		JMenuItem searchPersonList = new JMenuItem("Person List");
		JMenuItem searchFamilyList = new JMenuItem("Family List");
		searchMenu.add(searchPersonList);
		searchMenu.add(searchFamilyList);

		searchPersonList.addActionListener((e) -> {
			onSearchPersonList();

		});

		searchFamilyList.addActionListener((e) -> {
			onSearchFamilyList();

		});

		fileExitCmd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		initTable();

		loadData();

	}

	private static JTabbedPane buildJTabbedPane(JPanel pedigreePanel, JPanel familyPanel) {

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Pedigree", pedigreePanel);
		tabbedPane.add("Family", familyPanel);

		JTextField parent;

		parent = new JTextField();
		pedigreePanel.add(parent, "cell 0 17");
		parent.setColumns(10);
		// parent.setFont(new Font("",Font.BOLD,15));

//		
//		JTextField ptextField1 = new JTextField();
//		pedigreePanel.add(ptextField1, "cell 1 9");
//		ptextField1.setColumns(20);
//		JTextField ptextField2 = new JTextField();
//		pedigreePanel.add(ptextField2, "cell 1 25");
//		ptextField2.setColumns(20);
//		

		for (int i = 9; i < 37; i += 16) {
			JTextField textField = new JTextField();
			pedigreePanel.add(textField, "cell 1 " + i);
			textField.setColumns(10);
		}

		for (int i = 5; i < 36; i += 8) {
			JTextField textField = new JTextField();
			pedigreePanel.add(textField, "cell 2 " + i);
			textField.setColumns(10);
		}

		for (int i = 1; i < 31; i += 4) {
			JTextField textField = new JTextField();
			pedigreePanel.add(textField, "cell 4 " + i);
			textField.setColumns(10);
		}
		for (int i = 0; i < 32; i += 2) {
			JTextField textField = new JTextField();
			pedigreePanel.add(textField, "cell 5 " + i);
			textField.setColumns(10);
		}

//		JTextField gtextField1 = new JTextField();
//		pedigreePanel.add(gtextField1, "cell 2 2");
//		gtextField1.setColumns(20);
//		JTextField gtextField2 = new JTextField();
//		pedigreePanel.add(gtextField2, "cell 2 6");
//		gtextField2.setColumns(20);
//		JTextField gtextField3 = new JTextField();
//		pedigreePanel.add(gtextField3, "cell 2 10");
//		gtextField3.setColumns(20);
//		JTextField gtextField4 = new JTextField();
//		pedigreePanel.add(gtextField4, "cell 2 14");
//		gtextField4.setColumns(20);
//		
//		JTextField ggtextField1 = new JTextField();
//		pedigreePanel.add(ggtextField1, "cell 4 1");
//		ggtextField1.setColumns(20);
//		JTextField ggtextField2 = new JTextField();
//		pedigreePanel.add(ggtextField2, "cell 4 3");
//		ggtextField2.setColumns(20);
//		JTextField ggtextField3 = new JTextField();
//		pedigreePanel.add(ggtextField3, "cell 4 5");
//		ggtextField3.setColumns(20);
//		JTextField ggtextField4 = new JTextField();
//		pedigreePanel.add(ggtextField4, "cell 4 7");
//		ggtextField4.setColumns(20);
//		JTextField ggtextField5 = new JTextField();
//		pedigreePanel.add(ggtextField5, "cell 4 9");
//		ggtextField5.setColumns(20);
//		JTextField ggtextField6 = new JTextField();
//		pedigreePanel.add(ggtextField6, "cell 4 11");
//		ggtextField6.setColumns(20);
//		JTextField ggtextField7 = new JTextField();
//		pedigreePanel.add(ggtextField7, "cell 4 13");
//		ggtextField7.setColumns(20);
//		JTextField ggtextField8 = new JTextField();
//		pedigreePanel.add(ggtextField8, "cell 4 15");
//		ggtextField8.setColumns(20);

//        //设置布局一共16行 4列
//		JTextField parent;
//		//设置第一列
//		parent = new JTextField();
//		pedigreePanel.add(parent, "cell 0 7");
//		parent.setColumns(20);
//		//parent.setFont(new Font("",Font.BOLD,15));
//		
//		
//		JTextField ptextField1 = new JTextField();
//		pedigreePanel.add(ptextField1, "cell 1 4");
//		ptextField1.setColumns(20);
//		JTextField ptextField2 = new JTextField();
//		pedigreePanel.add(ptextField2, "cell 1 12");
//		ptextField2.setColumns(20);
//		
//		JTextField gtextField1 = new JTextField();
//		pedigreePanel.add(gtextField1, "cell 2 2");
//		gtextField1.setColumns(20);
//		JTextField gtextField2 = new JTextField();
//		pedigreePanel.add(gtextField2, "cell 2 6");
//		gtextField2.setColumns(20);
//		JTextField gtextField3 = new JTextField();
//		pedigreePanel.add(gtextField3, "cell 2 10");
//		gtextField3.setColumns(20);
//		JTextField gtextField4 = new JTextField();
//		pedigreePanel.add(gtextField4, "cell 2 14");
//		gtextField4.setColumns(20);
//		
//		JTextField ggtextField1 = new JTextField();
//		pedigreePanel.add(ggtextField1, "cell 3 1");
//		ggtextField1.setColumns(20);
//		JTextField ggtextField2 = new JTextField();
//		pedigreePanel.add(ggtextField2, "cell 3 3");
//		ggtextField2.setColumns(20);
//		JTextField ggtextField3 = new JTextField();
//		pedigreePanel.add(ggtextField3, "cell 3 5");
//		ggtextField3.setColumns(20);
//		JTextField ggtextField4 = new JTextField();
//		pedigreePanel.add(ggtextField4, "cell 3 7");
//		ggtextField4.setColumns(20);
//		JTextField ggtextField5 = new JTextField();
//		pedigreePanel.add(ggtextField5, "cell 3 9");
//		ggtextField5.setColumns(20);
//		JTextField ggtextField6 = new JTextField();
//		pedigreePanel.add(ggtextField6, "cell 3 11");
//		ggtextField6.setColumns(20);
//		JTextField ggtextField7 = new JTextField();
//		pedigreePanel.add(ggtextField7, "cell 3 13");
//		ggtextField7.setColumns(20);
//		JTextField ggtextField8 = new JTextField();
//		pedigreePanel.add(ggtextField8, "cell 3 15");
//		ggtextField8.setColumns(20);

		// pedigreePanel.getPreferredSize();

		GridLayout nfamilyPanellayout = new GridLayout(2, 2);// nfamilyPanellayout
		JPanel nfamilyPanel = new JPanel(nfamilyPanellayout);
		familyPanel.add(nfamilyPanel);
		JPanel nfamilyPanel1 = new JPanel();// z1
		JPanel nfamilyPanel2 = new JPanel();// y2
		JPanel nfamilyPanel3 = new JPanel();// z3
		JPanel nfamilyPanel4 = new JPanel();// y4
		nfamilyPanel.add(nfamilyPanel1);
		nfamilyPanel.add(nfamilyPanel2);
		nfamilyPanel.add(nfamilyPanel3);
		nfamilyPanel.add(nfamilyPanel4);

		nfamilyPanel1.setLayout(new BorderLayout());
		nfamilyPanel3.setLayout(new BorderLayout());

		JPanel ntfamilyPanel1 = new JPanel();// zs1
		JPanel ntfamilyPanel2 = new JPanel();// zx3
		nfamilyPanel1.add(ntfamilyPanel1, BorderLayout.NORTH);
		nfamilyPanel3.add(ntfamilyPanel2, BorderLayout.NORTH);

		JButton buttontest1 = new JButton("1");

		JButton buttontest3 = new JButton("3");

		JLabel label1 = new JLabel("Father:");
		JLabel label2 = new JLabel("Father's Parents:");
		JLabel label3 = new JLabel("Mother:");
		JLabel label4 = new JLabel("Mother's Parents:");

		ntfamilyPanel1.add(label1);// z1
		ntfamilyPanel1.add(buttontest1);// z1
		ntfamilyPanel1.add(label3);// z3
		ntfamilyPanel1.add(buttontest3);// z3

		JList addnFamilylist1 = new JList();
		String[] dd = { "XXX(name)" };
		addnFamilylist1 = new JList(dd);
		addnFamilylist1.setVisibleRowCount(2);
		JScrollPane nscrollPane1 = new JScrollPane(addnFamilylist1);
		nscrollPane1.setPreferredSize(new Dimension(300, 100));
		nfamilyPanel1.add(nscrollPane1, BorderLayout.CENTER);

		JList addnFamilylist2 = new JList();
		String[] ddd = { "XXX(name)!!" };
		addnFamilylist2 = new JList(ddd);
		addnFamilylist2.setVisibleRowCount(2);
		JScrollPane nscrollPane2 = new JScrollPane(addnFamilylist2);
		nscrollPane2.setPreferredSize(new Dimension(300, 100));
		nfamilyPanel3.add(nscrollPane2, BorderLayout.CENTER);

		nfamilyPanel2.setLayout(new AfColumnLayout(10));
		JTextField ffatherfield = new JTextField("+ Click to add Father", 20);
		JTextField mfatherfield = new JTextField("+ Click to add Mother", 20);
		nfamilyPanel2.add(label2);// y2
		nfamilyPanel2.add(ffatherfield);
		nfamilyPanel2.add(mfatherfield);

		nfamilyPanel4.setLayout(new AfColumnLayout(10));
		JTextField fmotherfield = new JTextField("+ Click to add Father", 20);
		JTextField mmotherfield = new JTextField("+ Click to add Mother", 20);
		nfamilyPanel4.add(label4);// y2
		nfamilyPanel4.add(fmotherfield);
		nfamilyPanel4.add(mmotherfield);

		JPanel sfamilyPanel = new JPanel();
		familytable = new JTable(familytableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane sscrollfamilyPane = new JScrollPane(familytable);
		familyPanel.add(sfamilyPanel.add(sscrollfamilyPane));

		familytable.setFillsViewportHeight(true);
		familytable.setRowSelectionAllowed(true);
		familytable.setRowHeight(30);

		familytableModel.addColumn("Children");
		familytableModel.addColumn("Sex");
		familytableModel.addColumn("Birth Date");
		familytableModel.addColumn("Birth Place");
		familytableModel.addColumn("Death Date");
		familytableModel.addColumn("Death Place");
		familytableModel.addColumn("Relation");

		familytable.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		familytable.getColumnModel().getColumn(0).setPreferredWidth(110);

		return tabbedPane;

	}

	private void initTable() {

		table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollPane = new JScrollPane(table);
		root.add(scrollPane, BorderLayout.WEST);
		scrollPane.setPreferredSize(new Dimension(300, 0));

		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setRowHeight(30);

		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Sex");
		tableModel.addColumn("Birth Date");

		table.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
	}

	private void addTableRow(Person item) {

		Vector<Object> rowData = new Vector<>();
		rowData.add(item.firstname);
		rowData.add(item.lastname);
		rowData.add(item.sex);
		rowData.add(item.birthdate);
		rowData.add(item.birthplace);
		rowData.add(item.deathdate);
		rowData.add(item.deathplace);
		rowData.add(item.burialdate);
		rowData.add(item.burialplace);
		tableModel.addRow(rowData);
	}

	private void addToDataList(Person s) {
		dataList.add(s);
	}

	private void onAddIndividual() {
		AddIndividual ai = new AddIndividual(this);
		if (ai.exec()) {
			Person person = ai.getValue();

			addToDataList(person);
			addTableRow(person);
			saveData();
		}
	}

	private void onAddFather() {
		AddFather af = new AddFather(this);
		if (af.exec()) {

		}
	}

	private void onAddMother() {
		AddMother am = new AddMother(this);
		if (am.exec()) {

		}
	}

	private void onAddSpouse() {
		AddSpouse as = new AddSpouse(this);
		if (as.exec()) {

		}
	}

	private void onAddChild() {
		AddChild ac = new AddChild(this);
		if (ac.exec()) {

		}
	}

	private void oneditperson() {
		EditPerson ep = new EditPerson(this);
		if (ep.exec()) {

		}
	}

	private void oneditswap() {
		Swap s = new Swap(this);
		if (s.exec()) {

		}
	}

	private void onSearchPersonList() {
		SearchPersonList spl = new SearchPersonList(this);
		if (spl.exec()) {

		}
	}

	private void onSearchFamilyList() {
		SearchFamilyList sfl = new SearchFamilyList(this);
		if (sfl.exec()) {

		}
	}

	private void onListAddress() {
		ListAddress la = new ListAddress(this);
		if (la.exec()) {

		}
	}

	private void onListRepository() {
		ListRepository lr = new ListRepository(this);
		if (lr.exec()) {

		}
	}

	private void onFileOpen() {
		FileOpen fileopen = new FileOpen(this);
		if (fileopen.exec()) {

		}

	}

	private void onFileNew() {
		FileNew filenew = new FileNew(this);
		if (filenew.exec()) {

		}

	}

	private void saveData() {

		JSONArray array = new JSONArray();
		for (int i = 0; i < dataList.size(); i++) {
			Person s = dataList.get(i);
			JSONObject j1 = new JSONObject();
			j1.put("firstname", s.firstname);
			j1.put("lastname", s.lastname);
			j1.put("sex", s.sex);
			j1.put("birthdate", s.birthdate);
			j1.put("birthplace", s.birthplace);
			j1.put("deathdate", s.deathdate);
			j1.put("deathplace", s.deathplace);
			j1.put("burialdate", s.burialdate);
			j1.put("burialplace", s.burialplace);

			array.put(j1);
		}

		File file = new File("person.json");
		try {
			AfJSON.toFile(array, file, "UTF-8");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
	}

	private void loadData() {

		File file = new File("person.json");
		if (!file.exists())
			return;

		JSONArray array = null;
		try {
			array = (JSONArray) AfJSON.fromFile(file, "UTF-8");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
			return;
		}

		dataList.clear();
		tableModel.setRowCount(0);
		for (int i = 0; i < array.length(); i++) {
			JSONObject j1 = array.getJSONObject(i);
			Person s = new Person();
			s.firstname = j1.getString("firstname");
			s.lastname = j1.getString("lastname");
			s.sex = j1.getBoolean("sex");
			s.birthdate = j1.getString("birthdate");

			addToDataList(s);
			addTableRow(s);
		}
	}

}
