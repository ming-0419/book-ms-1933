package com.gec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gec.bean.Book;
import com.gec.util.DBUtil;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String author = request.getParameter("author");
	double price = Double.parseDouble(request.getParameter("price"));
	DBUtil<Book> dbUtil = new DBUtil<Book>();
	int i = dbUtil.update("insert into book values(null,?,?,?)", name,author,price);
	if(i>0) {
		response.sendRedirect("BookListServlet");
	}
	
}

}
