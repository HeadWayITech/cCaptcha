package com.hw.captcha.dto;

public class CaptchaBean {

	private int iHeight;
	private int iWidth;
	private int iTotalChars;
	private int fontSize;
	private String fontName;

	public CaptchaBean(){}

	public int getiHeight() {
		return iHeight;
	}
	public void setiHeight(int iHeight) {
		this.iHeight = iHeight;
	}
	public int getiWidth() {
		return iWidth;
	}
	public void setiWidth(int iWidth) {
		this.iWidth = iWidth;
	}
	public int getiTotalChars() {
		return iTotalChars;
	}
	public void setiTotalChars(int iTotalChars) {
		this.iTotalChars = iTotalChars;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
}