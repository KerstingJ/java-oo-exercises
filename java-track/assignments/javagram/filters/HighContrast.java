package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class HighContrast implements Filter {
	@Override
	public Picture process(Picture original) {

		Picture processed = new Picture(original.width(), original.height());

		// get each pixel one by one
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {

				Color c = original.get(i, j);

				// get color components from each pixel
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();

				if ((r + g + b) > 120) {
					r = inRange((int) Math.round(r * 1.20));
					g = inRange((int) Math.round(g * 1.10));
					b = inRange((int) Math.round(b * 1.10));
				} else {
					r = inRange((int) Math.round(r * 0.76));
					g = inRange((int) Math.round(g * 0.83));
					b = inRange((int) Math.round(b * 0.87));
				}
				
				
				//System.out.println(String.format(("rgb: %d, %d, %d"), r, g, b));
				processed.set(i, j, new Color(r, g, b));

			}
		}

		return processed;
	}

	private int inRange(int col) {
		
		if (col >= 255) {
			col = 254;
		} else if (col < 2) {
			col = 1;
		}
		
		return col;
	}

}
