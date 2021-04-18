import java.awt.image.BufferedImage;
import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.lang.Math;

public class ChangeImage {

	public ChangeImage() {

		try {

			 //zapis do pliku zmodyfikowanego obrazu
				File ouptut;
				ouptut = new File("res/rozjasGrodno.jpg");
				ImageIO.write(transformLiniova("res/grodno.jpg", 120), "jpg", ouptut);
				ouptut = new File("res/przyGrodno.jpg");
				ImageIO.write(transformLiniova("res/grodno.jpg", -100), "jpg", ouptut);
				
				ouptut = new File("res/negativGrodno.jpg");
				ImageIO.write(negativ("res/grodno.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/rozPotGrodno.jpg");
				ImageIO.write(transformPotegova("res/grodno.jpg", 0.33), "jpg", ouptut);
				ouptut = new File("res/przPotGrodno.jpg");
				ImageIO.write(transformPotegova("res/grodno.jpg", 2), "jpg", ouptut);
			
				ouptut = new File("res/alg1Grodno.jpg");
				ImageIO.write(Algoritm1("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg2Grodno.jpg");
				ImageIO.write(Algoritm2("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg3Grodno.jpg");
				ImageIO.write(Algoritm3("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg4Grodno.jpg");
				ImageIO.write(Algoritm4("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg5Grodno.jpg");
				ImageIO.write(Algoritm5("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg6Grodno.jpg");
				ImageIO.write(Algoritm6("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg7Grodno.jpg");
				ImageIO.write(Algoritm7("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg8Grodno.jpg");
				ImageIO.write(Algoritm8("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg9Grodno.jpg");
				ImageIO.write(Algoritm9("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg10Grodno.jpg");
				ImageIO.write(Algoritm10("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg11Grodno.jpg");
				ImageIO.write(Algoritm11("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg12Grodno.jpg");
				ImageIO.write(Algoritm12("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				
				ouptut = new File("res/alg13Grodno.jpg");
				ImageIO.write(Algoritm13("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg14Grodno.jpg");
				ImageIO.write(Algoritm14("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
				
				ouptut = new File("res/alg15Grodno.jpg");
				ImageIO.write(Algoritm15("res/2.jpg", "res/5.jpg"), "jpg", ouptut);
								
				ouptut = new File("res/alg16Grodno.jpg");
				ImageIO.write(Algoritm16("res/2.jpg", "res/5.jpg", 0.5), "jpg", ouptut);
				
		} catch (Exception e) {}
	}
	
	// Transformacje liniowe
	public BufferedImage transformLiniova(String strImg, int b) throws IOException {
		BufferedImage img = ImageIO.read(new File(strImg));
		int width = img.getWidth();
		int height = img.getHeight();
		
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){
	
				 Color c = new Color(img.getRGB(j, i));
				 int red = (int)(c.getRed());
				 int green = (int)(c.getGreen());
				 int blue = (int)(c.getBlue());

				 red = red + b;
				 green = green+b;
				 blue = blue + b;
				
				 red = sprawdzenie(red);
				 green = sprawdzenie(green);
				 blue = sprawdzenie(blue);
	 
				 Color newColor = new Color(red, green,blue);
				 img.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img;
	}
	
	// Transformacja potegowa
	public BufferedImage transformPotegova(String strImg, double y) throws IOException {
		BufferedImage img = ImageIO.read(new File(strImg));
		int width = img.getWidth();
		int height = img.getHeight();
		
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){
				 
				 Color c = new Color(img.getRGB(j, i));
				 double red1 = (double)(c.getRed()) / 255;
				 double green1 = (double)(c.getGreen()) / 255;
				 double blue1 = (double)(c.getBlue()) / 255;
	
				 red1 =  Math.pow(red1, y);
				 green1 = Math.pow(green1, y);
				 blue1 = Math.pow(blue1, y);
				 
				 red1 = sprawdzenie2(red1);
				 green1 = sprawdzenie2(green1);
				 blue1 = sprawdzenie2(blue1);
				 
				 int red = (int)(red1 * 255);
				 int green = (int)(green1 * 255);
				 int blue = (int)(blue1 * 255);

				 
				 Color newColor = new Color(red, green,blue);
				 img.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img;
	}
	
	// Transformacje liniowe - negatyw
	public BufferedImage negativ(String strImg) throws IOException {
		BufferedImage img = ImageIO.read(new File(strImg));
		int width = img.getWidth();
		int height = img.getHeight();
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){
				 
				 Color c = new Color(img.getRGB(j, i));
				 int red = (int)(c.getRed());
				 int green = (int)(c.getGreen());
				 int blue = (int)(c.getBlue());

				 red = 255 - red;
				 green = 255 - green;
				 blue = 255 - blue;

				 Color newColor = new Color(red, green,blue);
				 img.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img;
	}
	
	// Mieszanie dwoch obrazow (16 algorytmow)
	
	public BufferedImage Algoritm1(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){
				 
				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 red1 = red1 + red2;
				 green1 = green1 + green2;
				 blue1 = blue1 + blue2;
				 
				 red1 = sprawdzenie(red1);
				 green1 = sprawdzenie(green1);
				 blue1 = sprawdzenie(blue1);
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img1;	
	}

	public BufferedImage Algoritm2(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){
				 
				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 red1 = red1 + red2 - 255;
				 green1 = green1 + green2 -255;
				 blue1 = blue1 + blue2 - 255;
				 
				 red1 = sprawdzenie(red1);
				 green1 = sprawdzenie(green1);
				 blue1 = sprawdzenie(blue1);
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img1;	
	}
	
	public BufferedImage Algoritm3(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){

				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 red1 = red1 - red2;
				 green1 = green1 - green2;
				 blue1 = blue1 - blue2;
				 
				 red1 = Math.abs(red1);
				 green1 = Math.abs(green1);
				 blue1 = Math.abs(blue1);
				 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img1;	
	}
	
	public BufferedImage Algoritm4(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){

				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 red1 = red1 * red2 / 255;
				 green1 = green1 * green2 /255;
				 blue1 = blue1 * blue2 /255;
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img1;	
	}
	
	public BufferedImage Algoritm5(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){

				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 red1 = 255 - ((255 -red1) * (255 - red2) ) / 255;
				 green1 = 255 - ((255 -green1) * (255 - green2) ) /255;
				 blue1 = 255 - ((255 -blue1) * (255 - blue2) ) /255;
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img1;	
	}
	
	public BufferedImage Algoritm6(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 
			 for(int j=0; j<width; j++){

				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 red1 = 255 - Math.abs(255 -red1 - red2);
				 green1 = 255 - Math.abs(255 - green1 - green2);
				 blue1 = 255 - Math.abs(255 - blue1 - blue2) ;
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());

			 }
		}
	
		return img1;	
	}
	
	public BufferedImage Algoritm7(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 if (red1 > red2) {
					 red1  = red2;
				 }
				 if (green1 > green2) {
					 green1  = green2;
				 }
				 if (blue1 > blue2) {
					 blue1  = blue2;
				 }
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;
	}
	
	public BufferedImage Algoritm8(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
			int width = img1.getWidth();
			int height = img1.getHeight();
			for(int i=0; i<height; i++){
				 for(int j=0; j<width; j++){
					 Color c1 = new Color(img1.getRGB(j, i));
					 int red1 = (int)(c1.getRed());
					 int green1 = (int)(c1.getGreen());
					 int blue1 = (int)(c1.getBlue());
					 
					 Color c2 = new Color(img2.getRGB(j, i));
					 int red2 = (int)(c2.getRed());
					 int green2 = (int)(c2.getGreen());
					 int blue2 = (int)(c2.getBlue());

					 if (red1 < red2) {
						 red1  = red2;
					 }
					 if (green1 < green2) {
						 green1  = green2;
					 }
					 if (blue1 < blue2) {
						 blue1  = blue2;
					 }
		 
					 Color newColor = new Color(red1, green1,blue1);
					 img1.setRGB(j,i,newColor.getRGB());
				 }
			}
		return img1;	
	}
	
	public BufferedImage Algoritm9(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());
				 
				 red1 = red1 + red2 -2 * red1 * red2 / 255;
				 green1 = green1 + green2 -2 * green1 * green2 / 255;
				 blue1 = blue1 + blue2 -2 * blue1 * blue2 / 255;
	 
				 red1 = sprawdzenie(red1);
				 green1 = sprawdzenie(green1);
				 blue1 = sprawdzenie(blue1);
				 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}
	
	public BufferedImage Algoritm10(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 if (red1 < 128) {
					 red1  = 2 * red1 * red2 / 255;
				 }
				 else {
					 red1 = 255- 2 * (255 - red1) * (255 - red2) / 255;
				 }
				 
				 if (green1 < 128) {
					 green1  = 2 * green1 * green2 / 255;
				 }
				 else {
					 green1 = 255- 2 * (255 - green1) * (255 - green2) / 255;
				 }
				 
				 if (blue1 < 128) {
					 blue1  = 2 * blue1 * blue2 / 255;
				 }
				 else {
					 blue1 = 255- 2 * (255 - blue1) * (255 - blue2) / 255;
				 }
				 
				 red1 = sprawdzenie(red1);
				 green1 = sprawdzenie(green1);
				 blue1 = sprawdzenie(blue1);
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}

	public BufferedImage Algoritm11(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 int red1 = (int)(c1.getRed());
				 int green1 = (int)(c1.getGreen());
				 int blue1 = (int)(c1.getBlue());
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 int red2 = (int)(c2.getRed());
				 int green2 = (int)(c2.getGreen());
				 int blue2 = (int)(c2.getBlue());

				 if (red2 < 128) {
					 red1  = 2 * red1 * red2 / 255;
				 }
				 else {
					 red1 = 255- 2 * (255 - red1) * (255 - red2) / 255;
				 }
				 
				 if (green2 < 128) {
					 green1  = 2 * green1 * green2 / 255;
				 }
				 else {
					 green1 = 255- 2 * (255 - green1) * (255 - green2) / 255;
				 }
				 
				 if (blue2 < 128) {
					 blue1  = 2 * blue1 * blue2 / 255;
				 }
				 else {
					 blue1 = 255- 2 * (255 - blue1) * (255 - blue2) / 255;
				 }
				 
				 red1 = sprawdzenie(red1);
				 green1 = sprawdzenie(green1);
				 blue1 = sprawdzenie(blue1);
	 
				 Color newColor = new Color(red1, green1,blue1);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}
	
	public BufferedImage Algoritm12(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 double red1 = (double)(c1.getRed()) / 255;
				 double green1 = (double)(c1.getGreen()) / 255;
				 double blue1 = (double)(c1.getBlue()) / 255;
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 double red2 = (double)(c2.getRed()) / 255;
				 double green2 = (double)(c2.getGreen()) / 255;
				 double blue2 = (double)(c2.getBlue()) / 255;

				 if (red2 < 0.5) {
					 red1  = 2 * red1 * red2  + red1 * red1 * (1 - 2 * red2) ;
				 }
				 else {
					 red1 = Math.sqrt(red1) * (2 * red2 - 1) + 2 * red1 * (1 - red2);
				 }
				 
				 if (green2 < 0.5) {
					 green1  = 2 * green1 * green2  + green1 * green1 * (1 - 2 * green2) ;
				 }
				 else {
					 green1 = Math.sqrt(green1) * (2 * green2 - 1) + 2 * green1 * (1 - green2);
				 }
				 
				 if (blue2 < 0.5) {
					 blue1  = 2 * blue1 * blue2  + blue1 * blue1 * (1 - 2 * blue2) ;
				 }
				 else {
					 blue1 = Math.sqrt(blue1) * (2 * blue2 - 1) + 2 * blue1 * (1 - blue2);
				 }
				 
				 red1 = sprawdzenie2(red1);
				 green1 = sprawdzenie2(green1);
				 blue1 = sprawdzenie2(blue1);
				 
				 int red = (int)(red1 * 255);
				 int green = (int)(green1 * 255);
				 int blue = (int)(blue1 * 255);
				 
				 Color newColor = new Color(red, green,blue);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}

	public BufferedImage Algoritm13(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 double red1 = (double)(c1.getRed()) / 255;
				 double green1 = (double)(c1.getGreen()) / 255;
				 double blue1 = (double)(c1.getBlue()) / 255;
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 double red2 = (double)(c2.getRed()) / 255;
				 double green2 = (double)(c2.getGreen()) / 255;
				 double blue2 = (double)(c2.getBlue()) / 255;
				 
				 red1 = red1 / (1 - red2);
				 green1 = green1 / (1 - green2);
				 blue1 = blue1 / (1 - blue2);
				
				 red1 = sprawdzenie2(red1);
				 green1 = sprawdzenie2(green1);
				 blue1 = sprawdzenie2(blue1);
				 
				 int red = (int)(red1 * 255);
				 int green = (int)(green1 * 255);
				 int blue = (int)(blue1 * 255);
				 
				 Color newColor = new Color(red, green,blue);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}
	
	public BufferedImage Algoritm14(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 double red1 = (double)(c1.getRed()) / 255;
				 double green1 = (double)(c1.getGreen()) / 255;
				 double blue1 = (double)(c1.getBlue()) / 255;
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 double red2 = (double)(c2.getRed()) / 255;
				 double green2 = (double)(c2.getGreen()) / 255;
				 double blue2 = (double)(c2.getBlue()) / 255;
				 
				 red1 = 1 - (1 - red1) / red2;
				 green1 = 1 - (1 - green1) / green2;
				 blue1 = 1 - (1 - blue1) / blue2;
				
				 red1 = sprawdzenie2(red1);
				 green1 = sprawdzenie2(green1);
				 blue1 = sprawdzenie2(blue1);
				 
				 int red = (int)(red1 * 255);
				 int green = (int)(green1 * 255);
				 int blue = (int)(blue1 * 255);
				 
				 Color newColor = new Color(red, green,blue);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}
	
	public BufferedImage Algoritm15(String strImg1, String strImg2 )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
				 Color c1 = new Color(img1.getRGB(j, i));
				 double red1 = (double)(c1.getRed()) / 255;
				 double green1 = (double)(c1.getGreen()) / 255;
				 double blue1 = (double)(c1.getBlue()) / 255;
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 double red2 = (double)(c2.getRed()) / 255;
				 double green2 = (double)(c2.getGreen()) / 255;
				 double blue2 = (double)(c2.getBlue()) / 255;
				 
				 red1 = red1 * red1 * (1 - red2);
				 green1 = green1 * green1 * (1 - green2);
				 blue1 = blue1 * blue1 * (1 - blue2);
				
				 red1 = sprawdzenie2(red1);
				 green1 = sprawdzenie2(green1);
				 blue1 = sprawdzenie2(blue1);
				 
				 int red = (int)(red1 * 255);
				 int green = (int)(green1 * 255);
				 int blue = (int)(blue1 * 255);
				 
				 Color newColor = new Color(red, green,blue);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}
	
	public BufferedImage Algoritm16(String strImg1, String strImg2, double A )throws IOException {
		BufferedImage img1 = ImageIO.read(new File(strImg1));
		BufferedImage img2 = ImageIO.read(new File(strImg2));
		
		int width = img1.getWidth();
		int height = img1.getHeight();
		for(int i=0; i<height; i++){
			 for(int j=0; j<width; j++){
			
				 Color c1 = new Color(img1.getRGB(j, i));
				 double red1 = (double)(c1.getRed()) / 255;
				 double green1 = (double)(c1.getGreen()) / 255;
				 double blue1 = (double)(c1.getBlue()) / 255;
				 
				 Color c2 = new Color(img2.getRGB(j, i));
				 double red2 = (double)(c2.getRed()) / 255;
				 double green2 = (double)(c2.getGreen()) / 255;
				 double blue2 = (double)(c2.getBlue()) / 255;
				 
				 red1 = (1 - A) * red2 + A * red1;
				 green1 = (1 - A) * green2 + A * green1;
				 blue1 = (1 - A) * blue2 + A * blue1;
				
				 red1 = sprawdzenie2(red1);
				 green1 = sprawdzenie2(green1);
				 blue1 = sprawdzenie2(blue1);
				 
				 int red = (int)(red1 * 255);
				 int green = (int)(green1 * 255);
				 int blue = (int)(blue1 * 255);
				 
				 Color newColor = new Color(red, green,blue);
				 img1.setRGB(j,i,newColor.getRGB());
			 }
		}
		return img1;	
	}
	
	// jasnosc kazdego pikselu image musi byc w przedziale od 0 do 255
	int sprawdzenie(int x)
    {
        if (x > 255)
            return 255;
        else if (x < 0)
            return 0;
        else
        	return x;
    }
	
	// wartosc musi byc z przedzialu [0..1]
	double sprawdzenie2(double x)
    {
        if (x > 1)
            return 1;
        else if (x < 0)
            return 0;
        else
        	return x;
    }
	
	public static void main(String[] args) {
		
		ChangeImage obj = new ChangeImage();
	}

}
