package edu.neu.webtoolFinal;


import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.neu.webtoolFinal.DAO.CategoryDAO;
import edu.neu.webtoolFinal.DAO.DiscussDAO;
import edu.neu.webtoolFinal.DAO.DishAndPicturesDAO;
import edu.neu.webtoolFinal.DAO.DishDAO;
import edu.neu.webtoolFinal.DAO.FlavorDAO;
import edu.neu.webtoolFinal.DAO.HibernateUtil;
import edu.neu.webtoolFinal.DAO.HotDAO;
import edu.neu.webtoolFinal.DAO.LocationDAO;
import edu.neu.webtoolFinal.DAO.PictureDAO;
import edu.neu.webtoolFinal.DAO.RoleDAO;
import edu.neu.webtoolFinal.DAO.SortDAO;
import edu.neu.webtoolFinal.DAO.UserDAO;
import edu.neu.webtoolFinal.DAO.fildDAO;
import edu.neu.webtoolFinal.model.Category;
import edu.neu.webtoolFinal.model.Disguess;
import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.DishAndPictures;
import edu.neu.webtoolFinal.model.Flavor;
import edu.neu.webtoolFinal.model.Location;
import edu.neu.webtoolFinal.model.PictureForDish;
import edu.neu.webtoolFinal.model.PictureForUser;
import edu.neu.webtoolFinal.model.Role;
import edu.neu.webtoolFinal.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@Autowired
	@Qualifier("SigninValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)

		public String initUserLoginForm(Model model, HttpServletRequest request)
			throws Exception {
			Cookie[] cookies = request.getCookies();
			String uname = "";
			String pwd = "";
			if(cookies!=null){
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("uname"))
					uname = cookie.getValue();
				if (cookie.getName().equals("pwd"))
					pwd = cookie.getValue();
			}
			UserDAO ud=new UserDAO();
			User u =ud.selectUserByUserNameAndPassword(uname, pwd);
			if (u != null) {
				try {
                  //go to main page
					
					 HttpSession session=request.getSession();
					 session.setAttribute("user", u);
					 DishAndPicturesDAO dao=new DishAndPicturesDAO();
					 ArrayList<DishAndPictures> dps=dao.selectAllDishes();
					 

					 
					 model.addAttribute("user", u);
	                 
					 model.addAttribute("dishList", dps);
					 System.out.println(u.getRole().getName());
					 if("Admin".equals(u.getRole().getName())){
						 return "adminPage";
						 
					 }else{
					 
					 return "mainPage";
					 }

				}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				
				
				User user = new User();
				model.addAttribute("user", user);

			}
			}
			else {
				
			
				User user = new User();
				model.addAttribute("user", user);

			}
			return "home";
	}
	
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public String addStateFunction(Model model,HttpServletRequest request,HttpServletResponse response,
			@Valid @ModelAttribute("user")User user,
			BindingResult result
			) {
		String submit=request.getParameter("submit");
		String returnVal="home";
		
		
		if("Register".equals(submit))
		{
			returnVal="register";
			
		}else{
			if (result.hasErrors()) {
				System.out.println("error in validator");
				returnVal = "home";
			}
//			String username=request.getParameter("username");
//			String password=request.getParameter("password");
			String username=user.getName();
			String password=user.getPassword();
			UserDAO ud=new UserDAO();
		    user=ud.selectUserByUserNameAndPassword(username, password);
			
			 if(null!=user){
				 HttpSession session=request.getSession();
				 session.setAttribute("user", user);
				 DishAndPicturesDAO dao=new DishAndPicturesDAO();
				 ArrayList<DishAndPictures> dps=dao.selectAllDishes();
				 
					Cookie c1 = new Cookie("uname", user.getName());
					Cookie c2 = new Cookie("pwd", user.getPassword());
					response.addCookie(c1);
					response.addCookie(c2);
					c1.setMaxAge(60 * 24 * 60 * 7);
					c2.setMaxAge(60 * 24 * 60 * 7);
				 
				 
				 
                 
				 model.addAttribute("dishList", dps);
				 System.out.println(user.getRole().getName());
				 if("Admin".equals(user.getRole().getName())){
					 return "adminPage";
					 
				 }else{
				 
				 return "mainPage";
				 }
				 
			 }			
			
		}
		

		return returnVal;
		
		
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createNewUser(Model model,HttpServletRequest request){
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String gender=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		String location=request.getParameter("location");
		
		LocationDAO ld=new LocationDAO();
		Location l=ld.insertLocation(location);
		RoleDAO rd=new RoleDAO();
		Role role=rd.getRoleByName("Customer");
		UserDAO dao=new UserDAO();
		
		if(dao.checkUserName(name)){
			dao.CreateUser(name, gender, age, l, role, password);
			return "home";
			
			
		}else{
			String message="Please select another name ┐(´д`)┌";
			model.addAttribute("nameErr", message);
			
			return "register";
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	@RequestMapping(value = "/goToHome", method = RequestMethod.GET)

	public String goHome(Model model, HttpServletRequest request)
		throws Exception {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        DishAndPicturesDAO dpd=new DishAndPicturesDAO();
        ArrayList list=dpd.selectDishByUser(user);
        model.addAttribute("user",user);
        model.addAttribute("dishList", list);
        
        
        
		
		
		return "myHome";
}
	
	
	@RequestMapping(value = "/changeProfile", method = RequestMethod.GET)
    
	public String changeMyProfile(Model model, HttpServletRequest request)
		throws Exception {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        PictureDAO dao=new PictureDAO();
        String url=dao.selectPictureByUser(user);
        
        model.addAttribute("url", url);
        model.addAttribute("user",user);
        
        
        
		
		
		return "changeProfilePage";
}
	
	@RequestMapping(value = "/addNewDish", method = RequestMethod.POST)

	public String addNewDish(Model model, HttpServletRequest request)
		throws Exception {

		
		return "upload";
	}
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)

	public String uploadPicture(Model model, HttpServletRequest request)
		throws Exception {
		fildDAO fd=new fildDAO();
		ArrayList<String> pictureNames=fd.insertPicture(model, request);
		

	    HttpSession session=request.getSession();
	    session.setAttribute("pictures", pictureNames);
	    model.addAttribute("pictures",pictureNames);
	    
		FlavorDAO fdd=new FlavorDAO();
		CategoryDAO cd=new CategoryDAO();
		ArrayList<Flavor> list=fdd.selectFlavor();
		ArrayList cls=cd.selectCategory();
		model.addAttribute("fls", list);
		model.addAttribute("cls", cls);

       return "addNewDish"; 


	
}
	@RequestMapping(value = "/uploadprofile", method = RequestMethod.POST)

	public String uploadUserPicture(Model model, HttpServletRequest request)
		throws Exception {
		fildDAO fd=new fildDAO();
		ArrayList<String> pictureNames=fd.insertPicture(model, request);
		

		   PictureDAO pd=new PictureDAO();
		   User user=(User) request.getSession().getAttribute("user");
	   for(int i=0;i<pictureNames.size();i++){
		   
		  pd.creatPictureForUser(pictureNames.get(i), user,"U");
	   }
		   
       DishAndPicturesDAO dpd=new DishAndPicturesDAO();
       ArrayList list=dpd.selectDishByUser(user);
       model.addAttribute("user",user);
       model.addAttribute("dishList", list);  

		   
	   return "myHome";   


	
}

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDish(Model model, HttpServletRequest request){
		ArrayList<String> pictureNames=(ArrayList<String>) request.getSession().getAttribute("pictures");
		
		
	    String name=request.getParameter("dishname");
	    int price=Integer.parseInt(request.getParameter("price"));
	    CategoryDAO cd=new CategoryDAO();
	    String categoryName=request.getParameter("category");
	    Category c=cd.selectCategoryByName(categoryName);
	    LocationDAO ld=new LocationDAO();
	    String loc=request.getParameter("location");
	    Location l=ld.insertLocation(loc);
	    String f=request.getParameter("flavor");
	    FlavorDAO fdd=new FlavorDAO();
	    Flavor ff=fdd.selectFlavorByName(f);
	    HttpSession session=request.getSession();
	    User u=(User) session.getAttribute("user");
	    
	    
        DishDAO dd=new DishDAO();
        Dish d=dd.createDish(name, price, c, l, ff, u);
        
        PictureDAO pd=new PictureDAO();
        for(int i=0;i<pictureNames.size();i++){
        	pd.createPictureForDish(pictureNames.get(i),d,"D");     	
        }
        
        User user=(User) request.getSession().getAttribute("user");
        DishAndPicturesDAO dpd=new DishAndPicturesDAO();
        ArrayList list=dpd.selectDishByUser(user);
        model.addAttribute("user",user);
        model.addAttribute("dishList", list);  
        
        
        return "myHome";
		
		
		
		
	}
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String updateStringProfile(Model model, HttpServletRequest request){
		ArrayList<String> pictureNames=(ArrayList<String>) request.getSession().getAttribute("pictures");
		
		
	    String name=request.getParameter("dishname");
	    int price=Integer.parseInt(request.getParameter("price"));
	    CategoryDAO cd=new CategoryDAO();
	    String categoryName=request.getParameter("category");
	    Category c=cd.selectCategoryByName(categoryName);
	    LocationDAO ld=new LocationDAO();
	    String loc=request.getParameter("location");
	    Location l=ld.insertLocation(loc);
	    String f=request.getParameter("flavor");
	    FlavorDAO fdd=new FlavorDAO();
	    Flavor ff=fdd.selectFlavorByName(f);
	    HttpSession session=request.getSession();
	    User u=(User) session.getAttribute("user");
	    
	    
        DishDAO dd=new DishDAO();
        Dish d=dd.createDish(name, price, c, l, ff, u);
        
        PictureDAO pd=new PictureDAO();
        for(int i=0;i<pictureNames.size();i++){
        	pd.createPictureForDish(pictureNames.get(i),d,"D");     	
        }
        
        User user=(User) request.getSession().getAttribute("user");
        DishAndPicturesDAO dpd=new DishAndPicturesDAO();
        ArrayList list=dpd.selectDishByUser(user);
        model.addAttribute("user",user);
        model.addAttribute("dishList", list);  
        
        
        return "myHome";
		
		
		
		
	}
	
	@RequestMapping(value = "/liked", method = RequestMethod.GET)
	public String liked(Model model, @RequestParam("id") String id, HttpServletRequest request){
		HotDAO hd=new HotDAO();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		int idn=Integer.parseInt(id);
		DishDAO dd=new DishDAO();
		Dish dish=dd.selectDishByID(idn);
		hd.newHot(dish, user);
		model.addAttribute("string","Liked");
		return "result";
		
		
		
	}
	
	@RequestMapping(value = "/discuss", method = RequestMethod.POST)
	public String goToDiscussPage(Model model, HttpServletRequest request){
		DiscussDAO disd=new DiscussDAO();
		DishDAO dd=new DishDAO();
		String id=request.getParameter("discussDish");
		Dish d=dd.selectDishByID(Integer.parseInt(id));
		//User user=(User) request.getSession().getAttribute("user");
		//String text=request.getParameter("text");
		ArrayList<Disguess> dl=disd.selectDisguess(d);
		
		PictureDAO pd=new PictureDAO();
		ArrayList<PictureForDish> pfd=pd.selectPictureByDish(d);
		
		model.addAttribute("dishPictures", pfd);
		model.addAttribute("discussList", dl);
		model.addAttribute("dish",d);
		
		
        return "DishDiscuss";

		
		
	}
	
	@RequestMapping(value = "/newDiscuss", method = RequestMethod.GET)
	public String newDiscuss(Model model, @RequestParam("id") String id,@RequestParam("text") String text, HttpServletRequest request){
		DiscussDAO dd=new DiscussDAO();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		int idn=Integer.parseInt(id);
		DishDAO dishd=new DishDAO();
		Dish dish=dishd.selectDishByID(idn);
		Disguess dis=dd.addNewDiscuss(user, dish, text);
		String s="";
		s=s+user.getName()+",";
		s=s+dis.getText()+",";
		s=s+dis.getDate();
		model.addAttribute("dis",s);
		return "result1";
		
		
		
	}
	
	@RequestMapping(value = "/adminAction", method = RequestMethod.POST)
	public String adminAction(Model model,HttpServletRequest request){
		String submit=request.getParameter("submit");
		if("delete".equals(submit)){
			DishDAO dd=new DishDAO();
			int id=Integer.parseInt(request.getParameter("discussDish"));
			Dish d=dd.selectDishByID(id);
			dd.deleteDish(d);
			 DishAndPicturesDAO dao=new DishAndPicturesDAO();
			 ArrayList<DishAndPictures> dps=dao.selectAllDishes();
            
			 model.addAttribute("dishList", dps);
			
			
			
			return "adminPage";
			
			
		}else{
			DiscussDAO disd=new DiscussDAO();
			DishDAO dd=new DishDAO();
			String id=request.getParameter("discussDish");
			Dish d=dd.selectDishByID(Integer.parseInt(id));
			//User user=(User) request.getSession().getAttribute("user");
			//String text=request.getParameter("text");
			ArrayList<Disguess> dl=disd.selectDisguess(d);
			
			PictureDAO pd=new PictureDAO();
			ArrayList<PictureForDish> pfd=pd.selectPictureByDish(d);
			
			model.addAttribute("dishPictures", pfd);
			model.addAttribute("discussList", dl);
			model.addAttribute("dish",d);
			
			
	        return "AdminDishDiscuss";	
			
			
			
		}
		
	}
		
		
		@RequestMapping(value = "/deleteDiscuss", method = RequestMethod.POST)
		public String deleteDiscuss(Model model,HttpServletRequest request){
			String submit=request.getParameter("submit");
            String id=request.getParameter("id");
            DiscussDAO dd=new DiscussDAO();
            Disguess d=dd.selectDiscussById(Integer.parseInt(id));
            Dish ds=d.getDish();
            dd.deleteDiscuss(d);
            
            
			ArrayList<Disguess> dl=dd.selectDisguess(ds);
			
			PictureDAO pd=new PictureDAO();
			ArrayList<PictureForDish> pfd=pd.selectPictureByDish(ds);
			
			model.addAttribute("dishPictures", pfd);
			if(dl.size()!=0){
			model.addAttribute("discussList", dl);}
			model.addAttribute("dish",ds);
			
            
            
            
            
            
            return "AdminDishDiscuss";	
            
            
			
		
			
			
			
			
			
		}
		@RequestMapping(value = "/mainPage", method = RequestMethod.GET)

		public String goToMainPage(Model model, HttpServletRequest request)
			throws Exception {


			 DishAndPicturesDAO dao=new DishAndPicturesDAO();
			 ArrayList<DishAndPictures> dps=dao.selectAllDishes();
            
			 model.addAttribute("dishList", dps);
			 User user=(User) request.getSession().getAttribute("user");
			 if("Admin".equals(user.getRole().getName())){
				 return "adminPage";
				 
			 }else{
			 
			 return "mainPage";
			 }
			
			
			
	
			
			
			
			
		}
		
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
			public String logoutContact(Model model, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				
					Cookie[] cookies = request.getCookies();

					if (cookies != null)
						for (int i = 0; i < cookies.length; i++) {
							cookies[i].setValue("");
							cookies[i].setPath("/");
							cookies[i].setMaxAge(0);
							response.addCookie(cookies[i]);
		
						}
				
				return initUserLoginForm(model, request);

			}
		@RequestMapping(value="/search",method=RequestMethod.POST)
		public String searchDish(Model model, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			DishAndPicturesDAO dao=new DishAndPicturesDAO();
			String name=request.getParameter("name");
			ArrayList<Dish> dl=dao.selectDishByName(name);
			
			model.addAttribute("dishList", dl);
			return "searchResult";
			
			
			
			
		}
		
		@RequestMapping(value = "/otherPage", method = RequestMethod.GET)
		public String otherPage(Model model, @RequestParam("dish") String dishId, HttpServletRequest request){

			DishDAO dd=new DishDAO();
			Dish dish=dd.selectDishByID(Integer.parseInt(dishId));
			int x=dish.getUser().getId();
			Session session=(Session) HibernateUtil.getSessionFactory().openSession();
			User uo=(User) session.get(User.class, x);
			
		//	User uo=dish.getUser();
			User user=(User) request.getSession().getAttribute("user");
			if(user.getId()==uo.getId())
			{
		        DishAndPicturesDAO dpd=new DishAndPicturesDAO();
		        ArrayList list=dpd.selectDishByUser(uo);
		        model.addAttribute("user",user);
		        model.addAttribute("dishList", list);  
				
			return "myHome";	
				
				
			}	
				
	        DishAndPicturesDAO dpd=new DishAndPicturesDAO();
	        ArrayList list=dpd.selectDishByUser(uo);
	        model.addAttribute("user",user);
	        model.addAttribute("visit", uo);
	        model.addAttribute("dishList", list);  
	        

			return "OtherPage";
			
			
			
		}
		
		@RequestMapping(value = "/broseByHot", method = RequestMethod.GET)
		public String broseByHot(Model model, HttpServletRequest request)throws Exception {
			SortDAO sd=new SortDAO();
			ArrayList list=sd.selectAllDishesOrderByHot();
			 model.addAttribute("dishList", list);
			 User user=(User) request.getSession().getAttribute("user");
			 if("Admin".equals(user.getRole().getName())){
				 return "adminPage";
				 
			 }else{
			 
			 return "mainPage";
			 }
			
			
			
			
			
			
			
			
		}

			
			
		}
		
		
		
		
		
	
	
	


