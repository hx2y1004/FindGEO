function SaveBoard() {
	var data = {
		boardtitle: $('#boardtitle').val(),
		nickname: $('#nickname').val(),
		boardcontent: $('#boardcontent').val(),
		email: $('#email').val()
	};
	console.log(data)

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	if (data.boardtitle === "" || data.boardcontent === "") {
		$.ajax({
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			}
		}).done(function() {
			alert('글을 작성해주세요.');
			window.location.href = "/board/postssave";
		}).fail(function(error) {
			alert(JSON.stringify(error));
			window.location.href = '/board/';
		})
	} else {
		$.ajax({
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
			type: 'POST',
			url: '/post/boardsave',
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(data)
		}).done(function() {
			alert('글이 등록되었습니다.');
			window.location.href = '/board/boardlist';
		}).fail(function(error) {
			alert(JSON.stringify(error));
			window.location.href = '/board/';
		})
	}
}

function postUpdate() {
	var data = {
		boardtitle: $('#boardtitle').val(),
		boardcontent: $('#boardcontent').val()
	};
	var boardid = $("#boardid").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content")
	$.ajax({
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		type: 'PUT',
		url: '/post/boardupdate/' + boardid,
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		data: JSON.stringify(data)
	}).done(function() {
		alert('글이 수정되었습니다.');
		window.location.href = '/post/info/' + boardid;
	}).fail(function(error) {
		alert(JSON.stringify(error));
	})
	console.log(token);
	console.log(header);
	console.log(data.boardcontent)
};

function postDelete() {
	var boardid = $("#boardid").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content")
	$.ajax({
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		type: 'DELETE',
		url: '/post/boarddelete/' + boardid,
		dataType: 'json',
		contentType: 'application/json; charset=utf-8'
	}).done(function() {
		alert('글이 삭제되었습니다.');
		window.location.href = '/board/boardlist';
	}).fail(function(error) {
		alert(JSON.stringify(error));
	})
	console.log(token);
	console.log(header);
	console.log(data.boardcontent)
};

function commentSave() {
	var data = {
		content: $('#cmt_content').val(),
		email: $('#login_email').val(),
		nickname: $('#login_name').val(),
		boardid: $('#boardid').val(),
		picture: $('#login_picture').val()
	};
	console.log(data)

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		type: 'POST',
		url: '/comments/save',
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		data: JSON.stringify(data)
	}).done(function() {
		if (data.content === "") {
			alert("내용을 작성해주세요");
			none;
		}


		var boardid = $('#boardid').val();
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		var email = $("#login_email").val();
		$.ajax({
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
			dataType: 'json',
			url: '/comments/' + boardid
		}).done(function(data) {


			var html = "<table>";
			html += "<tr>";
			html += "<th></th>";
			html += "<th></th>";
			html += "<th></th>";
			html += "<th></th>";
			html += "</table>";


			$.each(data, function(key, value) {
				html += "<div style='display: none;'><p id='ch_cmt_cid'>" + value.commentid + "</p></div>";
				html += "<img id='login_picture' src='"+value.picture+"' style=' height: 30px; width: 30px; border-radius: 50%;'/>";
				html += "<span id='login_name'>" + value.nickname + "</span>";
				html += "<span style='display:inline-block;' id='login_email'>" + "\u00A0" + "(" + value.email.split('@')[0] + "@*******" + ")" + "</span>"
				html += "<p id='cmt_content'>" + "\u00A0" + "💬" + value.content + "</p>";
				//html += "<button id='c_btn' onClick='clickcommentadd()'>답글</button>";
				//html += "<button>수정</button>";
				if (email === value.email) {
					html += "<button id='c_btn' onClick='deletecomment(" + value.commentid + ")'>❎</button>";
				}
				html += "<div id='commentFromP" + value.commentid + "'></div>";
			});



			$("#comments").empty();
			$("#comments").append(html);
			$('#cmt_content').val('');
		}).fail(function(e) {
			alert("불러오기 에러");
		})
	}).fail(function(error) {
		alert("전송 에러");
	})
}

function deletecomment(commentid) {
	console.log("삭제" + commentid);
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var boardid = $('#boardid').val();
	console.log("boardid chk" + boardid);
	$.ajax({
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		type: 'DELETE',
		url: '/comments/delete/' + commentid,
		//dataType: 'json',
		//contentType: 'application/json; charset=utf-8'
	}).done(function(data) {
		alert("삭제 완료");
		window.location.reload();
	}).fail(function(e) {
		alert("삭제 실패" + JSON.stringify(e));
	})
}

/*
function clickcommentadd() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var commentid = $("#ch_cmt_cid").text();
	console.log(commentid);
	$.ajax({
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
	}).done(function(data) {
		var html = "<div class='card-body'><textarea class='form-control' id='cmt_add_cont' rows='1'></textarea></div>";
		html += "<div class='card-footer'><button onClick = 'commentchildsave()'>등록</button></div>";
		$("#commentFromP" + commentid).empty();
		$("#commentFromP" + commentid).append(html);
	}).fail(function(e) {
		alert("추가실패" + "#commentFromP" + commentid + "//" + e);
	})
}
*/


function myPage_postDelete() {
	var boardid = $("#boardid").val();
	var mypageinfo_email = $("#email").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content")
	$.ajax({
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		type: 'DELETE',
		url: '/post/boarddelete/' + boardid,
		dataType: 'json',
		contentType: 'application/json; charset=utf-8'
	}).done(function() {
		alert('글이 삭제되었습니다.');
		console.log(mypageinfo_email)
		window.location.href = '/members/mypage/detail/' + mypageinfo_email;
	}).fail(function(error) {
		alert(JSON.stringify(error));
	})
	console.log(token);
	console.log(header);
	console.log(data.boardcontent)

}; 