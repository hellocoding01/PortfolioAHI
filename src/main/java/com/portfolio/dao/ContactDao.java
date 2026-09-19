package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.portfolio.dto.ContactDto;
import com.portfolio.service.TelegramService;
import com.portfolio.utill.DbUtill;

public class ContactDao {
	int result;

	public int sqlInsert(ContactDto dto) {

		String sql = "insert into TB_MYRESUME_CONTACT "
				+ "(name, email, company, subject, message, date) "
				+ "values(?,?,?,?,?, NOW())";

		try( Connection con = DbUtill.mySqlConnact();
				PreparedStatement pmt = con.prepareStatement(sql);
			){

			pmt.setString(1, dto.getName());
			pmt.setString(2, dto.getEmail());
			pmt.setString(3, dto.getCompany());
			pmt.setString(4, dto.getSubject());
			pmt.setString(5, dto.getMessage());

			System.out.println("#####pmt : " + pmt);
			result = pmt.executeUpdate();
			System.out.println("#####result : " + result);

			if(result > 0) {
				TelegramService alertSC = new TelegramService();

				System.out.println("#####텔레그램 서비스 이동");
				alertSC.sendContactAlert(dto);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
