package bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import us.codecraft.xsoup.Xsoup;

/**
 * 图书工具类
 * 
 * @author Administrator
 *
 */
public class BookHandler {
	/**
	 * 解析日期字符串到Date
	 * 
	 * @param dateString
	 * @return
	 */
	private static Date parseDate(String dateString) {
		Date date = null;
		try {
			date = DateUtils.parseDate(dateString, Locale.CHINA,
					DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.getPattern());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 查指定用户已借图书
	 * 
	 * @param user
	 * @return 返回已借图书列表 <br>
	 *         如果没借书，则返回null
	 */
	public static List<Book> getBorrwedBooks(User user) {
		// 发送请求查询已借记录
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(user.getSearchBorrowedUrl());
		CloseableHttpResponse response = null;
		try {
			response = client.execute(httpGet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int statusCode = response.getStatusLine().getStatusCode();
		// 如果是重定向到，目前借阅0本页面。那就说明没借书，返回null
		if (statusCode == 302) {
			Header[] headers = response.getHeaders("Location");
			if (headers.length == 1) {
				if (headers[0].getValue()
						.equals("http://agentdockingopac.featurelib.libsou.com/html/borrow/borrow.html")) {
					return null;
				}
			}
		} else {
			// 有已借书，开始解析拼装
			List<Book> bookList = new ArrayList<>();
			HttpEntity entity = response.getEntity();
			Document document = null;
			try {
				document = Jsoup.parse(EntityUtils.toString(entity));
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
			// 拿到书列表
			Elements children = Xsoup.select(document, "/html/body/div/div/div/article").getElements().get(0)
					.children();
			// 遍历每一本书
			for (Element eachBookElement : children) {
				String name = eachBookElement.child(0).child(1).text().trim();
				Element tbody = eachBookElement.child(1).child(0).child(0);
				Element barCodeLine = tbody.child(0);
				Element barCodeElement = barCodeLine.child(1);
				String barCode = barCodeElement.ownText();
				String href = barCodeElement.child(0).attr("href");
				String argList = StringUtils.substringBetween(href, "javascript:renew('", "');");
				argList = argList.replace("', '", "','");
				String[] args = argList.split("','");
				String renewArg_sn = args[0];
				String renewArg_code = args[1];
				String renewArg_check = args[2];
				String renewArg_schoolId = args[3];
				String renewArg_pdsToken = args[4];
				Date borrowDate = parseDate(tbody.child(1).child(1).text());
				Date shouldReturnDate = parseDate(tbody.child(2).child(1).text());
				String storagePlace = tbody.child(3).child(1).text();
				int renewedTimes = Integer.parseInt(tbody.child(4).child(1).text());
				Book book = new Book(name, barCode, borrowDate, shouldReturnDate, storagePlace, renewedTimes,
						renewArg_sn, renewArg_code, renewArg_check, renewArg_schoolId, renewArg_pdsToken);
				bookList.add(book);
			}
			return bookList;
		}
		return null;
	}

}
