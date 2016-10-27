package javagram.filters;

import java.awt.Color;
//import java.util.Random;

import javagram.Picture;

public class InverseFilter implements Filter{
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
		//Random number = new Random();
		
		
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          r = Math.abs(r-255); //255 to inverse
	          g = Math.abs(g-255);
	          b = Math.abs(b-255);
	          
	          processed.set(i, j, new Color(r,g,b));
	    	  
	      }
	    }
		
		return processed;
	}
	
}
