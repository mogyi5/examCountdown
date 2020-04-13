package countdown;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date myDate1 = parseDate("2019-04-25");
		Model model1 = new Model("Systems and Networks", myDate1, 11);

		Date myDate2 = parseDate("2019-04-26");
		Model model2 = new Model("Database Theory and Applications", myDate2, 9);

		Date myDate3 = parseDate("2019-04-29");
		Model model3 = new Model("Advanced Programming", myDate3, 4);

		Date myDate4 = parseDate("2019-04-30");
		Model model4 = new Model("Enterprise Cyber Security", myDate4, 16);

		Date myDate5 = parseDate("2019-05-01");
		Model model5 = new Model("Programming", myDate5, 15);

		Date myDate6 = parseDate("2019-05-02");
		Model model6 = new Model("Software Project Mgmt", myDate6, 19);

		Date myDate7 = parseDate("2019-05-03");
		Model model7 = new Model("Algorithms and Data Structures", myDate7, 12);

		Date myDate8 = parseDate("2019-05-07");
		Model model8 = new Model("Cyber Sec Fundamentals", myDate8, 8);

		Date myDate9 = parseDate("2019-05-10");
		Model model9 = new Model("Internet Technology", myDate9, 19);

		Date myDate10 = parseDate("2019-05-16");
		Model model10 = new Model("Software Engineering", myDate10, 10);

		Model[] exams = { model1, model2, model3, model4, model5, model6, model7, model8, model9, model10 };

		View view = new View(exams);
		Controller controller = new Controller(exams, view);
		view.setVisible(true);
		
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

}
