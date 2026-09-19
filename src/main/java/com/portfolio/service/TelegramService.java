package com.portfolio.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import com.portfolio.dto.ContactDto;

public class TelegramService {

	private String BOT_TOKEN;
    private String CHAT_ID;

	public TelegramService() {
	Properties properties = new Properties();

	try (InputStream input = getClass()
			.getClassLoader()
			.getResourceAsStream("db.properties")){

		properties.load(input);
		 BOT_TOKEN = properties.getProperty("telegram.bot.token");
		 CHAT_ID = properties.getProperty("telegram.chat.id");

	}catch(Exception e) {
		e.printStackTrace();
	}
	}


	public void sendContactAlert(ContactDto dto) {

	try {
//		System.out.println("BOT_TOKEN : " + BOT_TOKEN + ", CHAT_ID : " + CHAT_ID);
//		System.out.println("######TelegramService Start : " + dto);

		String message =
				"[포트폴리오 문의사항] \n"
				+ "이름 : " + dto.getName() + "\n"
				+ "이메일 : " + dto.getEmail() +"\n"
				+ "회사 : " + dto.getCompany() +"\n"
				+ "제목 : " + dto.getSubject() + "\n"
				+ "내용 : " + dto.getMessage();

		String apiUrl =
				"https://api.telegram.org/bot"
				+BOT_TOKEN
				+"/sendMessage";

		URL url = new URL(apiUrl);

		HttpURLConnection con =
				(HttpURLConnection) url.openConnection();

		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		con.setRequestProperty(
		        "Content-Type",
		        "application/json; charset=UTF-8"
		);
		
		String json =
		        "{"
		        + "\"chat_id\":\"" + CHAT_ID + "\","
		        + "\"text\":\"" + escapeJson(message) + "\""
		        + "}";
		
		try (OutputStream os = con.getOutputStream()) {
		    os.write(json.getBytes(StandardCharsets.UTF_8));
		}

		int responseCode = con.getResponseCode();
		
		System.out.println("Request Method : " + con.getRequestMethod());
		System.out.println("responseCode : " + responseCode);

		con.disconnect();
	}catch(Exception e){
		e.printStackTrace();
	}

	}
    // JSON 문자열 처리
    private String escapeJson(String value) {
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

}
