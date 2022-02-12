package com.product.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import com.product.Exception.ProductNotFoundException;
import com.product.persistance.Product;
import com.product.service.ProductService;
import com.product.service.ProductServiceImpl;

@WebServlet("/productController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService productservice=new ProductServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires",0);
		
		String action=request.getParameter("action");
		
		if(action.equals("showall"))
		{
			List<Product> products = productservice.getAll();
			request.setAttribute("products", products);
			RequestDispatcher rd=request.getRequestDispatcher("allProducts.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("addProduct"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("addProduct.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("deleteProduct"))
		{
			Integer id=Integer.parseInt(request.getParameter("id"));
			productservice.deleteProduct(id);
			response.sendRedirect("ProductController?action=showall");
		}
		else if(action.equals("updateProduct"))
		{
			Integer id=Integer.parseInt(request.getParameter("id"));
			Product product=null;
				product = productservice.getById(id);
				request.setAttribute("product", product);
				RequestDispatcher rd=request.getRequestDispatcher("updateProduct.jsp");
				rd.forward(request, response);
				
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Integer id=Integer.parseInt(request.getParameter("id"));
			String pname=request.getParameter("pname");
			double pprice =Double.parseDouble(request.getParameter("price"));
			int qty=Integer.parseInt(request.getParameter("qty"));
			Date mdate=null,idate = null;
		
			
			mdate=Date.valueOf(request.getParameter("manudate"));
			idate=Date.valueOf(request.getParameter("inpdate"));
			Product product=new Product(pname,pprice,qty,mdate,idate);
				if(id==0)
				{
			
					productservice.addProduct(product);
				}
				else
				{
					productservice.updateProduct(id, product);
					
				}
			
			response.sendRedirect("ProductController?action=showall");
			
	}

}
