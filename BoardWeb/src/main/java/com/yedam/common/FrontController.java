package com.yedam.common;
// 컨트롤러 : url -> 서블릿 실행.

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.command.AddBoardControl;
import com.yedam.board.command.BoardFormControl;
import com.yedam.board.command.BoardListControl;
import com.yedam.board.command.GetBoardControl;
import com.yedam.board.command.ModifyBoardControl;
import com.yedam.board.command.ModifyFormControl;
import com.yedam.board.command.RemoveBoardControl;
import com.yedam.board.command.RemoveFormControl;
import com.yedam.member.command.GetMemberControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;
import com.yedam.member.command.MemberAddJson;
import com.yedam.member.command.MemberDelJson;
import com.yedam.member.command.MemberListAjax;
import com.yedam.member.command.MemberListControl;
import com.yedam.member.command.MemberListJson;
import com.yedam.reply.command.AddReplyJson;
import com.yedam.reply.command.ChartForm;
import com.yedam.reply.command.Covid19Form;
import com.yedam.reply.command.DelReplyJson;
import com.yedam.reply.command.MapForm;
import com.yedam.reply.command.PagingListJson;
import com.yedam.reply.command.ReplyCountJson;
import com.yedam.reply.command.ReplyListJson;
import com.yedam.student.command.StudInfoCont;
import com.yedam.student.command.StudentListCont;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생명주기 : 생성자 -> init -> service() -> destroy()
	Map<String, Control> map; // <키(?) , 밸류(서블릿)>

	public FrontController() {
		System.out.println("생성자 호출.");
		map = new HashMap<String, Control>(); // 키에는 String, 값은 요청과 응답(서블릿)을 받음
	}

	@Override
	public void init(ServletConfig config) throws ServletException { // init은 가장 먼저 초기화를 위해 실행되는. 즉 초기값을 지정하기 위해 있는 함수
		System.out.println("init() 호출.");
//		map.put("/main.do", new MainControl());
//		map.put("/sub.do", new SubControl());
		// 게시판관련.
		map.put("/boardList.do", new BoardListControl()); // /boardList.do라는 url이 입력되면 BoardListControl을 실행
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/getBoard.do", new GetBoardControl());
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeForm.do", new RemoveFormControl()); //
		map.put("/removeBoard.do", new RemoveBoardControl());//

		// 회원관련.
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		
		// 관리자.
		map.put("/memberList.do", new MemberListControl());
		map.put("/getMember.do", new GetMemberControl());
		map.put("/memberListAjax.do", new MemberListAjax());
		
		// 회원관련데이터(json) 처리.
		map.put("/memberListJson.do", new MemberListJson());
		map.put("/memberAddJson.do", new MemberAddJson());
		map.put("/memberDelJson.do", new MemberDelJson());
		
		// tiles.관련...
		map.put("/studentList.do",new StudentListCont());
		map.put("/studInfo.do",new StudInfoCont());
		
		// 댓글관련. json 포맷의 데이터를 생성해서 반환.
		map.put("/replyListJson.do", new ReplyListJson());
		map.put("/delReplyJson.do", new DelReplyJson());
		map.put("/addReplyJson.do", new AddReplyJson());
		//페이지 생성하기 위한 json.
		map.put("/pagingListJson.do", new PagingListJson());
		
		// chart.
		map.put("/chart.do", new ChartForm());
		map.put("/replyCountJson.do", new ReplyCountJson());
		
		// 코로나19 관련.
		map.put("/covid19.do", new Covid19Form());
		
		// 지도api.
		map.put("/map.do", new MapForm());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // map에
																													// url
																													// 범위
																													// 지정
		req.setCharacterEncoding("utf-8");

		System.out.println("service() 호출.");
		// http:..localhost/BoardWeb/main.do ->mainControl.
		String url = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = url.substring(context.length()); // 파라미터 인식 범위 지정
		System.out.println(path);

		Control ctrl = map.get(path); // 파라미터를 키값으로 받고
		ctrl.execute(req, resp); // 웹으로 값을 출력
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출.");
	}
}
