package com.hw.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.captcha.dto.CaptchaBean;
import com.hw.captcha.generator.CaptchaGenerator;

public class CaptchaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CaptchaBean cBean = parseContext();
		response.setContentType("image/jpg");
		CaptchaGenerator captchaGanerator = new CaptchaGenerator(cBean);
		HttpSession session = request.getSession();
		session.setAttribute("dns_security_code", captchaGanerator.getcString());
		OutputStream osImage = response.getOutputStream();
		ImageIO.write(captchaGanerator.generateCaptcha(), "jpeg", osImage);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private CaptchaBean parseContext() {
		CaptchaBean cBean = new CaptchaBean();
		Integer iHeight = new Integer(40);
		Integer iWidth = new Integer(150);
		String fontName = "Arial";
		Integer iTotalChars = new Integer(3);
		Integer iFontSize = new Integer(30);
		try {
			Context env = (Context)new InitialContext().lookup("java:comp/env");
			fontName = (String)env.lookup("captch-font");
			iFontSize = (Integer) env.lookup("captch-font-size");
			iHeight = (Integer)env.lookup("captch-height");
			iWidth = (Integer)env.lookup("captch-width");
			iTotalChars = (Integer)env.lookup("captch-char-size");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		cBean.setFontName(fontName);
		cBean.setFontSize(iFontSize.intValue());
		cBean.setiHeight(iHeight.intValue());
		cBean.setiWidth(iWidth.intValue());
		cBean.setiTotalChars(iTotalChars.intValue());
		return cBean;
	}
}