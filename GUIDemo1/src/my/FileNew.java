package my;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import af.swing.AfPanel;
import af.swing.layout.AfColumnLayout;

public class FileNew extends JDialog {

	JTextField textField = new JTextField(20);
	JButton button = new JButton("Choose");
	JButton button2 = new JButton("1");

	private boolean retValue = false;

	public FileNew(JFrame owner) {

		super(owner, "New", true);
		this.setSize(500, 100);

		JPanel root = new JPanel();
		this.setContentPane(root);
		root.setLayout(new FlowLayout());

		root.add(new JLabel("File"));
		root.add(textField);
		root.add(button);
		root.add(button2);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				test2();
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				test3();
			}
		});

	}

	private void test2() {
		JFileChooser chooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML文件", "xml");
		chooser.setFileFilter(filter);

		int ret = chooser.showSaveDialog(this);

		if (ret == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();
			textField.setText(file.getAbsolutePath());
		}
	}

	private void test3() {

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
