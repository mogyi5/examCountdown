package countdown;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Model implements Serializable {

	// Variables
	private String name;
	private int daysLeft;
	private int lecturesDone;
	private int totalLectures;
	private Date exam;
	private double percentageDone;

	// Constructor
	public Model(String name, Date exam, int totalLectures) {
		Date now = new Date();
		this.name = name;
		this.exam = exam;
		this.daysLeft = daysBetween(now, exam);
		this.totalLectures = totalLectures;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public int getLecturesDone() {
		return lecturesDone;
	}

	public int getTotalLectures() {
		return totalLectures;
	}

	public void setPercentageDone() {
		percentageDone = (double) lecturesDone / totalLectures * 100.0;
	}

	public double getPercentageDone() {
		return percentageDone;
	}

	// Methods
	public void lectureFinished() {
		if (lecturesDone < totalLectures) {
			lecturesDone++;
			setPercentageDone();
		}
	}
	
	public void refreshDate() {
		Date now = new Date();
		this.daysLeft = daysBetween(now, exam);
	}

	private int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

}
