package com.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.reply.controller.ListOkController;

public class ReplyFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");

		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		Result result = null;

		if (target.equals("listOk")) {
			result = new ListOkController().execute(req, resp);

		} else if (target.equals("writeOk")) {
			result = new WriteOkController().execute(req, resp);
		} else if (target.equals("updateOk")) {
			result = new UpdateOkController().execute(req, resp);
		} else if (target.equals("deleteOk")) {
			result = new DeleteOkController().execute(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
