package com.thalespf.dip.util;


public class Expansion {

	
	public static void globalExpansion2(double[] magnitude, int[] pixels, int width, int height) {
		double min = Double.MAX_VALUE;
		double max = -Double.MAX_VALUE;
		
		int x_y;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				x_y = x + y*width;
				
				if(magnitude[x_y] < min) min = magnitude[x_y];
				if(magnitude[x_y] > max) max = magnitude[x_y];
			}
		}
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				x_y = x + y*width;
				
				int lum;
				
				lum = (int)(255.0*((magnitude[x_y])-min) / (max-min) + 0.5);

				if(lum < 0) lum = 0;
				else if(lum > 255) lum = 255;

				pixels[x_y] = 0xFF000000 | lum << 16 | lum << 8 | lum;
			}
		}
	}


}
