package countdown;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {

	private JPanel motherPanel = new JPanel();
	private JPanel[] panels;
	private JPanel last = new JPanel();
	private Model[] objects = new Model[10];
	private JLabel[] names = new JLabel[10];
	private JLabel[] days = new JLabel[10];
	private JLabel[] lecturesDone = new JLabel[10];
	private JLabel[] percentages = new JLabel[10];
	private JButton[] lectDone = new JButton[10];
	private JButton save = new JButton("Save");
	private JButton load = new JButton("Load");

	public View(Model[] myObjects) {
		this.objects = myObjects;
		motherPanel.setLayout(new GridLayout(11, 1));
		this.add(motherPanel);

		panels = new JPanel[objects.length];
		lectDone = new JButton[objects.length];

		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			panels[i].setLayout(new FlowLayout(FlowLayout.LEADING));

			names[i] = new JLabel(objects[i].getName());
			names[i].setPreferredSize(new Dimension(300, 20));
			names[i].setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
			panels[i].add(names[i]);

			if (objects[i].getDaysLeft() > 0) {
				days[i] = new JLabel(String.valueOf(objects[i].getDaysLeft()) + " days");
			} else {
				days[i] = new JLabel("DONE");
			}
			days[i].setPreferredSize(new Dimension(80, 20));
			days[i].setFont(new Font("Bookman Old Style", Font.BOLD, 16));
			panels[i].add(days[i]);

			lecturesDone[i] = new JLabel("Lecture " + String
					.valueOf(objects[i].getLecturesDone() + "/" + String.valueOf(objects[i].getTotalLectures())));
			lecturesDone[i].setPreferredSize(new Dimension(100, 20));
			lecturesDone[i].setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
			panels[i].add(lecturesDone[i]);

			percentages[i] = new JLabel(String.valueOf(objects[i].getPercentageDone()) + "%");
			percentages[i].setFont(new Font("Bookman Old Style", Font.ITALIC, 16));
			percentages[i].setPreferredSize(new Dimension(75, 20));
			panels[i].add(percentages[i]);

			lectDone[i] = new JButton("+");
			lectDone[i].setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
			panels[i].add(lectDone[i]);

			motherPanel.add(panels[i]);
			panels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}

		last.setLayout(new FlowLayout(FlowLayout.TRAILING));
		last.add(load);
		last.add(save);
		motherPanel.add(last);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Exams");
		this.pack();
	}

	// Setters and Getters
	public JButton[] getLectDone() {
		return lectDone;
	}

	public JLabel[] getDaysLeft() {
		return days;
	}

	public JLabel[] getLecturesDone() {
		return lecturesDone;
	}

	public JLabel[] getPercentages() {
		return percentages;
	}

	public void addAddListener(ActionListener al) {
		for (JButton jb : lectDone) {
			jb.addActionListener(al);
		}
	}

	public void addSaveListener(ActionListener al) {
		save.addActionListener(al);
	}

	public void addLoadListener(ActionListener al) {
		load.addActionListener(al);
	}

}
