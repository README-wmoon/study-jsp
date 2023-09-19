package com.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.reply.dao.ReplyDAO;
import com.app.reply.domain.ReplyVO;

public class WriteOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		ReplyVO replyVO = new ReplyVO();
		ReplyDAO replyDAO = new ReplyDAO();
		
		replyVO.setMemberId((Long)req.getSession().getAttribute("memberId"));
		replyVO.setBoardId(Long.valueOf(req.getParameter("boardId")));
		replyVO.setReplyContent(req.getParameter("replyContent"));
		
		replyDAO.insert(replyVO);
		return null;
	}

}
