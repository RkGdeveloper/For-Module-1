package com.bookshow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshow.dto.BookShow;
import com.bookshow.service.BookShowServiceImpl;
import com.bookshow.service.IBookShowService;

/**
 * Servlet implementation class ShowController
 */
@WebServlet("/ShowController")
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			IBookShowService s = new BookShowServiceImpl();
			
			String action = request.getParameter("action");
			String target = null;
			System.out.println(action);
			
			if (action != null && action.equalsIgnoreCase("getAll")) {
				
				
				ArrayList<BookShow> alBook = s.getAllShowDetails();
				for(BookShow sb:alBook){
					System.out.println(sb);
					
				}

				HttpSession session = request.getSession(true);
				session.setAttribute("alShow", alBook);
				target = "showDetails.jsp";
				
			}
			if (action != null && action.equalsIgnoreCase("bookShow")) {
			
				String showId = request.getParameter("showId");
				
				BookShow showbean = s.getShowById(showId);
				
				System.out.println("Bean BookShow"+showbean);
				HttpSession session = request.getSession(false);
				session.setAttribute("sBean", showbean);
				System.out.println(showId);
				target = "bookNow.jsp";
				
			}
				
			if (action != null && action.equalsIgnoreCase("Book")) {
				System.out.println("in success Method");
				
				HttpSession session = request.getSession(false);
				BookShow showbean = (BookShow)session.getAttribute("sBean");
				System.out.println("in Final method "+showbean);
				
				String cName = request.getParameter("cname");
				String mobNum = request.getParameter("mobNum");
				
				int bookSeat = Integer.parseInt(request.getParameter("noOfSeat"));
				System.out.println(cName + "  "+mobNum + " " + bookSeat);
				
				double totalPrice  = bookSeat * showbean.getPriceTicket();
				
				session.setAttribute("showName", showbean.getShowName());
				session.setAttribute("custName", cName);
				session.setAttribute("mobile", mobNum);
				session.setAttribute("seats", bookSeat);
				session.setAttribute("totalP", totalPrice);
				
				int updateResult = s.updateSeatForShow(bookSeat,showbean.getShowId());
				System.out.println(updateResult);
				
				target="success.jsp";
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		
		}

}
