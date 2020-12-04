package emalvalidator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	public static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	public static void main(String[] args) {

		List<String> lst = new ArrayList<String>();

		lst.add("s#@mail.com");
		lst.add("s.mail.com");
		lst.add("sam@mail.com");
		String email = "";
		Scanner scan;

		Pattern pattern;
		Matcher matcher;

		while (true) {
			scan = new Scanner(System.in);
			System.out.println("Write 'exit' for quiting the program");
			System.out.println("These email addresses already existed in our database if you want to check them.");
			System.out.println("You can also use any email address that you want to check.");
			for (String em : lst) {
				System.out.println(em);
			}
			System.out.println(
					"If you provide a valid email address, your email address will be added to the database for further checks.");
			System.out.println("");

			System.out.println("Enter the email address that you are looking for");
			if (scan.hasNext()) {
				email = scan.next();
				if (email.equals("exit")) {
					System.out.println("DONE");
					return;
				}
			} else {
				System.out.println("No Input");
				continue;
			}

			boolean nonExistFlag = false;
			boolean validFlag = false;
			if (lst.contains(email)) {
				System.out.println("We have your requested email address.");
			} else {
				System.out.println("We don't have your requested email address.");
				nonExistFlag = true;
			}

			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(email);

			if (matcher.matches()) {
				System.out.println("Your requested email address, '" + email + "', is valid.");
				validFlag = true;
			} else {
				System.out.println("Your requested email address, '" + email + "', is not valid.");
			}

			if (nonExistFlag == true && validFlag == true) {
				lst.add(email);
				System.out.println("Your provided email address added to our database.");
			}

			System.out.println("Good Job! Go to the next round");
			System.out.println("------------");

		}
	}

}
