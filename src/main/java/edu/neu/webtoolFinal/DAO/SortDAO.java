package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;

import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.DishAndPictures;

public class SortDAO {

	public ArrayList selectAllDishesOrderByHot(){
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
		sort(dpl);
		return dpl;
		
		
	}
	
	public void sort(ArrayList<DishAndPictures> dpl){
		for(int i=1;i<dpl.size();i++){
			for(int j=0;j<i;j++){
				DishAndPictures temp=null;
				if(dpl.get(j).getHl().size()<dpl.get(i).getHl().size()){
					temp=dpl.get(i);
					dpl.set(i, dpl.get(j));
					dpl.set(j, temp);
					
					
					
					
				}
				
				
				
			}
			
			
			
			
		}
		
		
		
		
		
	}
}
