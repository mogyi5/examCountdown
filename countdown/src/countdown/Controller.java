package countdown;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Controller {

	private Model[] objects;
	private View view;

	public Controller(Model[] myObjects, View view) {
		this.view = view;
		this.objects = myObjects;

		view.addAddListener(new AddListener());
		view.addSaveListener(new SaveListener());
		view.addLoadListener(new LoadListener());
	}

	public class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < view.getLectDone().length; i++) {
				if (e.getSource().equals(view.getLectDone()[i])) {
					objects[i].lectureFinished();
					view.getLecturesDone()[i].setText("Lecture " + String.valueOf(
							objects[i].getLecturesDone() + "/" + String.valueOf(objects[i].getTotalLectures())));
					view.getPercentages()[i].setText(String.format("%2.2f %s", objects[i].getPercentageDone(), "%"));
				}
			}
		}
	}

	public class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			try {
				FileOutputStream fileOut = new FileOutputStream("exams.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				for (Model o : objects) {
					out.writeObject(o);
				}
				out.close();
				fileOut.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	}

	public class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int count = 0;
			try {
				FileInputStream fileInputStream = new FileInputStream("exams.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				while (count < 10) {
					try {
						objects[count] = (Model) objectInputStream.readObject();
						count++;
					} catch (ClassNotFoundException ex) {
						ex.printStackTrace();
					}
				}
				objectInputStream.close();
				fileInputStream.close();
			} catch (IOException i) {
				i.printStackTrace();
			}

			for (int i = 0; i < objects.length; i++) {
				view.getLecturesDone()[i].setText("Lecture " + String
						.valueOf(objects[i].getLecturesDone() + "/" + String.valueOf(objects[i].getTotalLectures())));
				view.getPercentages()[i].setText(String.format("%2.2f %s", objects[i].getPercentageDone(), "%"));
				objects[i].refreshDate();
				if (objects[i].getDaysLeft() > 0) {
					view.getDaysLeft()[i].setText(String.valueOf(objects[i].getDaysLeft()) + " days");
				} else {
					view.getDaysLeft()[i].setText("DONE");
				}
			}
		}
	}
}
