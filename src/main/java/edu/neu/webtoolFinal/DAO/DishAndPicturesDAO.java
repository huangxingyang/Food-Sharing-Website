package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;

import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.DishAndPictures;
import edu.neu.webtoolFinal.model.User;

public class DishAndPicturesDAO {
	
	public ArrayList selectAllDishes(){
		ArrayList<DishAndPictures> dpl=new ArrayList<DishAndPictures>();
		DishDAO dd=new DishDAO();
		PictureDAO pd=new PictureDAO();
		ArrayList<Dish> dl=dd.selectAllDishes();
		HotDAO hd=new HotDAO();
		//ArrayList<Hot> hdl=hd.g
		
		for(int i=0;i<dl.size();i++){
			DishAndPictures da=new DishAndPictures();
			da.setDish(dl.get(i));
			da.setHl(hd.getHotByDish(dl.get(i)));
			
			da.setApd(pd.selectPictureByDish(dl.get(i)));

			da.setUrl(pd.selectPictureByUser(dl.get(i).getUser()));
			dpl.add(da);

		}
		
		return dpl;
		
		
	}
	public ArrayList selectDishByUser(User user){
		ArrayList<DishAndPictures> dpl=new ArrayList<DishAndPictures>();
		DishDAO dd=new DishDAO();
		PictureDAO pd=new PictureDAO();
		ArrayList<Dish> dl=dd.selectDishByUser(user);
		HotDAO hd=new HotDAO();
		for(int i=0;i<dl.size();i++){
			DishAndPictures da=new DishAndPictures();
			da.setDish(dl.get(i));
			da.setHl(hd.getHotByDish(dl.get(i)));
			da.setApd(pd.selectPictureByDish(dl.get(i)));
			da.setUrl(pd.selectPictureByUser(dl.get(i).getUser()));
			dpl.add(da);
			
			
			
			
		}
		
		return dpl;
		
		
		
	}
	
	public ArrayList selectDishByName(String name){
		ArrayList<DishAndPictures> dpl=new ArrayList<DishAndPictures>();
		DishDAO dd=new DishDAO();
		PictureDAO pd=new PictureDAO();
		ArrayList<Dish> dl=dd.selectDishByName(name);
		HotDAO hd=new HotDAO();
		for(int i=0;i<dl.size();i++){
			DishAndPictures da=new DishAndPictures();
			da.setDish(dl.get(i));
			da.setHl(hd.getHotByDish(dl.get(i)));
			da.setApd(pd.selectPictureByDish(dl.get(i)));
			da.setUrl(pd.selectPictureByUser(dl.get(i).getUser()));
			dpl.add(da);
			
			
			
			
		}
		
		return dpl;
		
		
		
	}

}
