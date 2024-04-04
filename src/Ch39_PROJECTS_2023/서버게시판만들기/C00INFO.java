package Ch39_PROJECTS_2023.서버게시판만들기;

public class C00INFO {
	
// 1 프로젝트 주제 정하기
// ex 게시판 구현 


// 2 요구사항 선별하기
	//사용자별 접속 - 소켓 / 스레드 / Collection에 저장
	//사용자별 게시판서비스 이용가능?
	//게시글에 대한 댓글서비스?
	
// 3 요구사항 구체적으로 정리
	
	//1 사용자별로 서버게시판에 접속이 가능해야된다
	//2 서버는 사용자를 구별할 수 있어야 한다
	//3 사용자가 글을 등록 요청을 하면 서버에서는 받아서 지정된 DB에 내용을 등록하고
	//메시지를 전달한다
	//4 나머지 CRUD도 동일하게 처리된다//

// 4 Service별 EndPoint 정리
//	ex 게시판 
// 	Req_EndPoint			Parameter		Response
//	/req_board_insert	 	writer			boolean		
//							content
	
//	/req_board_update	 	no				boolean
//							writer
//							content

//	/req_board_delete	 	no				boolean
//	->사전에 글쓴이가 맞는지 인증확인이 되어야함
	
	
//	/req_board_selectAll 	null			boolean
//							
	
//	/req_board_select 		no				no
//											writer
//											content
//											regDate

	
	
	
	

}
