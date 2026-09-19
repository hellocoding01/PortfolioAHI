package com.portfolio.controller;
import java.io.IOException;

import com.portfolio.dao.ContactDao;
import com.portfolio.dto.ContactDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    	ContactDto dto = new ContactDto();
    	ContactDao dao = new ContactDao();

    	dto.setName(request.getParameter("name"));
    	dto.setEmail(request.getParameter("email"));
        dto.setCompany(request.getParameter("company"));
        dto.setSubject(request.getParameter("subject"));
        dto.setMessage(request.getParameter("message"));

        System.out.println("이름 : " + dto.getName());
        System.out.println("이메일 : " + dto.getEmail());
        System.out.println("회사 : " + dto.getCompany());
        System.out.println("제목 : " + dto.getSubject());
        System.out.println("내용 : " + dto.getMessage());

        dao.sqlInsert(dto);

        response.sendRedirect("index.html?success=true");
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().write("ContactServlet 정상 연결!");
    }


   }



