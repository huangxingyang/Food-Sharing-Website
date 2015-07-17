package edu.neu.webtoolFinal.filter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = {"/add"})
public class AddDishFilter implements Filter{

    private FilterConfig config = null;
    
    private final String s="[^0-9]";
    private final String s1="[^A-Za-z]";
 
    @Override
	public void init(FilterConfig config) throws ServletException {
        this.config = config;
        config.getServletContext().log("Initializing SessionCheckerFilter");
    }
    
    public boolean regexChecker(String x,String reg){
    Pattern checkRegex=Pattern.compile(reg);
    Matcher regexMatcher=checkRegex.matcher(x);
    if(regexMatcher.find()){
    return false;
    }
    return true;
    
    }
    
    public void checkNum(ServletRequest request,ServletResponse response,FilterChain chain,String checkString) throws IOException, ServletException{
        String number= request.getParameter(checkString);
        if(number==null){
        number="";
        }
        System.out.println("========="+number+"==========");
        
       HttpServletRequest servletrequest = (HttpServletRequest) request;
       HttpServletResponse servletresponse = (HttpServletResponse) response; 

       if (!regexChecker(number, s))
       {   
    	   System.out.println("=========false==========");
           PrintWriter out = servletresponse.getWriter();
           out.print("<script language='javascript'>alert(\"ERROR!!\");"
   
        + "window.history.go(-1);</script>");
       }else
       {
    	   System.out.println("=========true==========");
           chain.doFilter(request, response);
       }
   
   
   }
    
    public void checkLetter(ServletRequest request,ServletResponse response,FilterChain chain,String checkString) throws IOException, ServletException{
        String s= request.getParameter(checkString);
        if(s==null){
        s="";
        }
        System.out.println("========="+s+"==========");
        
       HttpServletRequest servletrequest = (HttpServletRequest) request;
       HttpServletResponse servletresponse = (HttpServletResponse) response; 

       if (!(regexChecker(s, s1)))
       {   System.out.println("=========false==========");
           PrintWriter out = servletresponse.getWriter();
           out.print("<script language='javascript'>alert(\"ERROR!!\");"
   
        + "window.history.go(-1);</script>");
   
       }else
       {
    	   System.out.println("=========true==========");
           chain.doFilter(request, response);
       }
       
   
   }
    
    public void checkLetterX(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
        String dishname= request.getParameter("dishname");
        String price=request.getParameter("price");

        

        
        if(dishname==null){
        dishname="";
        }
        if(price==null){
        price="0";
        }


        
       HttpServletRequest servletrequest = (HttpServletRequest) request;
       HttpServletResponse servletresponse = (HttpServletResponse) response; 

       if (!((regexChecker(dishname, s1)&&regexChecker(price, s))))
       {   System.out.println("=========false==========");
           PrintWriter out = servletresponse.getWriter();
           out.print("<script language='javascript'>alert(\"ERROR!!\");"
   
        + "window.history.go(-1);</script>");
   
       }else
       {
    	   System.out.println("=========true==========");
           chain.doFilter(request, response);
       }
       
   
   }
 
    @Override
	public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain)
            throws ServletException, IOException {
        String submit=req.getParameter("submit");
        if("Finish!".equals(submit)){
        	checkLetterX(req, res, chain);;
        	

        }else{
        	HttpServletRequest request=(HttpServletRequest) req;
        	HttpServletResponse response=(HttpServletResponse) res;
        	chain.doFilter(request, response);
        	
        	
        }
    }
 
    @Override
	public void destroy() {
        config.getServletContext().log("Destroying AddDishFilter");
    }
	
	

}
