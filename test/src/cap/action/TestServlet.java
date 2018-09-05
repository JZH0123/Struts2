package cap.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cap.bean.Test;
import cap.dao.TestDAO;
import cap.dao.impl.TestDAOImpl;
import cap.service.TestService;
import cap.service.impl.TestServiceImpl;
import cap.util.PageBean;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestDAO testDAO=null;
	private TestService testService=null;
	private int pageNo;
  
    public TestServlet() {
    	testDAO=new TestDAOImpl();
    	testService=new TestServiceImpl();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("pager")) {
			String pageNoStr=request.getParameter("pageNo");			
			if(pageNoStr==null){
				pageNo=1;
			}else
			{
				pageNo=Integer.parseInt(pageNoStr);
			}
			PageBean pg=testService.findByPage(pageNo, 5);
			request.getSession().setAttribute("pg", pg);
			request.getRequestDispatcher("testList.jsp").forward(request, response);
		}
		else if(action.equals("edit"))
		{
			int id=Integer.parseInt(request.getParameter("id")); 
			Test test=testDAO.findById(id);
			HttpSession session=request.getSession();
			session.setAttribute("test", test);
			request.getRequestDispatcher("edit_test.jsp").forward(request, response);
			
		}
		
		else if(action.equals("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id")); 
			int res=testDAO.delById(id);
			if(res>0)
			{
				request.getRequestDispatcher("test?action=pager").forward(request, response);
			}else
			{
				PrintWriter out=response.getWriter();
				out.print("É¾³ıÊ§°Ü");
				out.close();
			}
			
		}else if(action.equals("update"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String username=new String(request.getParameter("username"));
			String password=new String(request.getParameter("password"));
			Test test=new Test(id,username,password);
			int res=testDAO.updateTest(test);
			if(res>0)
			{
				request.getRequestDispatcher("test?action=pager").forward(request, response);
			}else
			{
				PrintWriter out=response.getWriter();
				out.print("¸üĞÂÊ§°Ü");
				out.close();
			}
			
		}else if(action.equals("add"))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Test test=new Test(username,password);
			int res=testDAO.addTest(test);
			if(res>0)
			{
				request.getRequestDispatcher("test?action=pager").forward(request, response);
			}else
			{
				PrintWriter out=response.getWriter();
				out.print("Ôö¼ÓÊ§°Ü");
				out.close();
			}
		}
		 
		}
		
	}
	


