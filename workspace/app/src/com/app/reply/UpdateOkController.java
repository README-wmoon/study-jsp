package com.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.reply.dao.ReplyDAO;
import com.app.reply.domain.ReplyVO;

public class UpdateOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		ReplyVO replyVO = new ReplyVO();
		ReplyDAO replyDAO = new ReplyDAO();
		
		replyVO.setReplyContent(req.getParameter("replyContent"));
		replyVO.setReplyId(Long.valueOf(req.getParameter("replyId")));
		
		replyDAO.update(replyVO);
		return null;
	}

}
