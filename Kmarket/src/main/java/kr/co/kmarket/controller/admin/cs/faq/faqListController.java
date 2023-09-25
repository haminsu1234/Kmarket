package kr.co.kmarket.controller.admin.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.admin.adminArticleDTO;
import kr.co.kmarket.dto.cs.ArticleDTO;
import kr.co.kmarket.service.admin.adminArticleService;
import kr.co.kmarket.service.cs.ArticleService;

@WebServlet("/admin/cs/faq/list.do")
public class faqListController extends HttpServlet {

	private static final long serialVersionUID = -6495265662381672507L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArticleService service = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String no = req.getParameter("no");
		
		
		List<ArticleDTO> articles = service.selectArticles(group, cate, 0);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}

}
