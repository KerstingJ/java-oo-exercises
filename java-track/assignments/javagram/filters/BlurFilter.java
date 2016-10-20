package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BlurFilter implements Filter{

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++ ) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  int allRed = 0;
	    	  int allGreen = 0;
	    	  int allBlue = 0;
	    	  
	    	  for (int x = i; x <= i + 4; x++){
	    		  for (int y = j; y <= j + 4; y++){
	    			  Color c;
	    			  
	    			  try {
		    			  c = original.get(x, y);

	    			  } catch (IndexOutOfBoundsException e) {
	    				  try {
		    				  if (e.toString().contains("x")) {
		    					  c = original.get(i, y);
		    				  } else {
		    					  c = original.get(x, j);
		    				  }
	    				  } catch (IndexOutOfBoundsException e2) {
	    					  c = original.get(i, j);
	    				  }
	    			  }
	    			  
	    			  int r = c.getRed();
	    	          int g = c.getGreen();
	    	          int b = c.getBlue();
	    	          allRed += r;
	    	          allBlue += b;
	    	          allGreen += g;
	    		  }
	    	  }
	          
	          //get color components from each pixel
	          
	          
	          int newBlue = allBlue / 25;
	          int newRed = allRed / 25;
	          int newGreen =  allGreen / 25;
	          
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}
}
