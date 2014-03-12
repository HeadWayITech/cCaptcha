package com.hw.captcha.generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.hw.captcha.dto.CaptchaBean;

public class CaptchaGenerator {

	private CaptchaBean cBean;
	private String cString;
	private Random randChars = new Random();

	public CaptchaGenerator() {
		randChars = new Random();
	}

	public CaptchaGenerator(CaptchaBean cBean) {
		this.cBean = cBean;
		randChars = new Random();
		cString = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, cBean.getiTotalChars());
	}
	
	public CaptchaGenerator(CaptchaBean cBean, String cString) {
		this.cBean = cBean;
		this.cString = cString;
		randChars = new Random();
	}

	public BufferedImage generateCaptcha() {
		
		 /* font style */
		 Font fntStyle = new Font(cBean.getFontName(), Font.BOLD, cBean.getFontSize());

		 /*
		  * TYPE_INT_RGB - does not support transpatency 
		  * TYPE_INT_ARGB - support transpatency
		  */
		 BufferedImage biImage = new BufferedImage(cBean.getiWidth(), cBean.getiHeight(), BufferedImage.TYPE_INT_RGB);
		 Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();
		 g2dImage.fillRect(0, 0, cBean.getiWidth(), cBean.getiHeight());
		 g2dImage.setFont(fntStyle);
		 for (int i = 0; i <cBean.getiTotalChars(); i++) {
		     g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
		     g2dImage.drawString(cString.substring(i, i + 1), 25 * i, 24);
		 }

		 /*
		  * Dispose function is used destory an image object
		  */
		 g2dImage.dispose();

		return biImage;
	}
	public String getcString() {
		return cString;
	}
}