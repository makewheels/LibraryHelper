package test;

import java.util.List;

import bean.Book;
import bean.BookHandler;
import bean.User;

public class Test {
	private static String url1 = "http://agentdockingopac.featurelib.libsou.com/showhome/searchborrowing/opacSearchBorrowing?schoolId=8194&xc=3&sn=A39CB1A632E2BBFD60866B539B0AAD9B65F9755FFEEB620F8D537E1348FC8FCC388AF8D31DF790C264718B7D5FB4C463AB98A70D33847CB43BCB062328C9935E09C565E63AFB28AE750D74CB32C089EA";
	private static String url2 = "http://agentdockingopac.featurelib.libsou.com/showhome/searchborrowing/opacSearchBorrowing?schoolId=8194&xc=3&sn=A39CB1A632E2BBFD3C8731EF6A3955A727CD254FD33657AB8D537E1348FC8FCC333A2984F493E52064718B7D5FB4C463AB98A70D33847CB4AA001B00DE818E921D13D2A00400BC30750D74CB32C089EA";

	public static void main(String[] args) {
		User user = new User();
		user.setSearchBorrowedUrl(url2);
		List<Book> borrwedBooks = BookHandler.getBorrwedBooks(user);
		for (Book book : borrwedBooks) {
			System.out.println(book);
		}
	}

}
