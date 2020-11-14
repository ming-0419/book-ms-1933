package com.gec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gec.bean.Book;
import com.gec.util.DBUtil;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//当用户访问Servlet时候 我们先去数据库中查询数据
		//因为我们这里这个类是要对图书类进行操作 所以这个泛型参数传入Book参数
		DBUtil<Book> dbUtil = new DBUtil<Book>();
		//去执行查询数据的代码
		List<Book> bookList = dbUtil.query("select * from book");
		//需要将查询出来的数存放到request作用域中
		request.setAttribute("bookList", bookList);
		for (Book book : bookList) {
			System.out.println(book);
		}
		//转发到页面去
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
