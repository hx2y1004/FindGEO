function SaveBoard(){
         var fileinput = $('#file').val();
           console.log(fileinput+"dzcxvzxcvzxv");
           var file = "/images/"+fileinput.substr(12,100); // 파일명 출력
            console.log(file);


         var data = {
               boardtitle: $('#boardtitle').val(),
               nickname: $('#nickname').val(),
               boardcontent: $('#boardcontent').val(),
               fileinput: file,
               email: $('#email').val()
              };
              console.log(data)
   
          var token = $("meta[name='_csrf']").attr("content");
           var header = $("meta[name='_csrf_header']").attr("content");
         if(data.boardtitle === "" || data.boardcontent === ""){
            $.ajax({
                beforeSend: function(xhr){
                           xhr.setRequestHeader(header,token);
                   }
               }).done(function(){
                alert('글을 작성해주세요.');
                window.location.href="/board/postssave";
             }).fail(function(error){
                alert(JSON.stringify(error));
                window.location.href = '/board/';
             })
         }else{
            $.ajax({
                beforeSend: function(xhr){
                           xhr.setRequestHeader(header,token);
                  }, 
                type : 'POST',
                url : '/post/boardsave',
                dataType : 'json',
                contentType : 'application/json; charset=utf-8',
                data : JSON.stringify(data)
             }).done(function(){
                alert('글이 등록되었습니다.');
                window.location.href = '/board/boardlist';
             }).fail(function(error){
                alert(JSON.stringify(error));
                window.location.href = '/board/';
             })
         }
    }

function postUpdate(){
      var fileinput = $('#file').val();
           console.log(fileinput+"dzcxvzxcvzxv");
           var file = "/images/"+fileinput.substr(12,100); // 파일명 출력
            console.log(file);
        var data = {
           boardtitle: $('#boardtitle').val(),
           boardcontent: $('#boardcontent').val(),
           fileinput: file
                  };
        var boardid = $("#boardid").val();
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content")
              $.ajax({
                 beforeSend: function(xhr){
                      xhr.setRequestHeader(header,token);
                    },
                 type : 'PUT',
                 url : '/post/boardupdate/'+boardid,
                 dataType : 'json',
                 contentType : 'application/json; charset=utf-8',
                 data : JSON.stringify(data)
              }).done(function(){
                 alert('글이 수정되었습니다.');
                 window.location.href = '/post/info/'+boardid;
              }).fail(function(error){
                 alert(JSON.stringify(error));
              })
              console.log(token);
              console.log(header);
              console.log(data.boardcontent)
       };
       
function postDelete(){
        var boardid = $("#boardid").val();
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content")
              $.ajax({
                 beforeSend: function(xhr){
                      xhr.setRequestHeader(header,token);
                    },
                 type : 'DELETE',
                 url : '/post/boarddelete/'+boardid,
                 dataType : 'json',
                 contentType : 'application/json; charset=utf-8'
              }).done(function(){
                 alert('글이 삭제되었습니다.');
                 window.location.href = '/board/boardlist';
              }).fail(function(error){
                 alert(JSON.stringify(error));
              })
              console.log(token);
              console.log(header);
              console.log(data.boardcontent)
           };    

function commentSave(){
	var data = {
		content: $('#cmt_content').val(),
		email: $('#login_email').val(),
		nickname: $('#login_name').val(),
		boardid: $('#boardid').val()
	};
	console.log(data)
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		beforeSend: function(xhr){
		xhr.setRequestHeader(header,token);
		},
		type : 'POST',
		url : '/comments/save',
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		data : JSON.stringify(data)
	}).done(function(){
		var boardid = $('#boardid').val();
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			beforeSend: function(xhr){
			xhr.setRequestHeader(header,token);
			},
			dataType:'json',
			url : '/comments/'+boardid
		}).done(function(data){
			
			var html = "<table border = '1'>";
			html += "<tr>";
			html += "<th>댓글번호</th>";
			html += "<th>작성자</th>";
			html += "<th>이메일</th>";
			html += "<th>댓글내용</th>";
			html += "<th>추가</th>";
			html += "</tr>";
			html += "<div id='commentFromP'>"
			$.each(data, function(key, value){
				html += "<tr align = 'center'>";
				html += "<td id='ch_cmt_cid'>" + value.commentid + "</td>";
				html += "<td id='login_name'>" + value.nickname + "</td>";
				html += "<td id='login_email'>" + value.email + "</td>"
				html += "<td id='cmt_content'>" + value.content + "</td>";
				html += "<td><button onClick='clickcommentadd()'>답글</button>";
				html += "<button>수정</button>";
				html += "<button>삭제</button></td>";
	 			html += "</tr>";
			});
			html += "</div>"
			html += "</table>";
			$("#comments").empty();
			$("#comments").append(html);
			
		}).fail(function(e){
			alert("불러오기 에러");
		})
	}).fail(function(error){
		alert("전송 에러");
	})
}

function clickcommentadd(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		beforeSend: function(xhr){
		xhr.setRequestHeader(header,token);
		},
	}).done(function(data){
		alert("클릭");
		var html = "<div class='card-body'><textarea class='form-control' id='cmt_add_cont' rows='1'></textarea></div>";
		html += "<div class='card-footer'><button onClick = 'commentchildsave()'>등록</button></div>";
		$("#commentFromP").empty();
		$("#commentFromP").append(html);
	}).fail(function(e){
		alert("추가실패");
	})
}

function commentchildsave(){
	var data = {
		content: $('#cmt_content').val(),
		email: $('#login_email').val(),
		nickname: $('#login_name').val(),
		boardid: $('#boardid').val(),
		parentid : $('#ch_cmt_cid').val()
	};
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	console.log(data);
	$.ajax({
		beforeSend: function(xhr){
		xhr.setRequestHeader(header,token);
		},
		type : 'POST',
		url : '/comments/save',
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		data : JSON.stringify(data)
	}).done(function(data){
		alert("대댓글 등록");
	}).fail(function(e){
		alert("전송 에러");
	})
	
}

function myPage_postDelete(){
        var boardid = $("#boardid").val();
        var mypageinfo_email=$("#email").val();
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content")
              $.ajax({
                 beforeSend: function(xhr){
                      xhr.setRequestHeader(header,token);
                    },
                 type : 'DELETE',
                 url : '/post/boarddelete/'+boardid,
                 dataType : 'json',
                 contentType : 'application/json; charset=utf-8'
              }).done(function(){
                 alert('글이 삭제되었습니다.');
                 console.log(mypageinfo_email)
                 window.location.href = '/members/mypage/detail/'+mypageinfo_email;
              }).fail(function(error){
                 alert(JSON.stringify(error));
              })
              console.log(token);
              console.log(header);
              console.log(data.boardcontent)
              
           }; 
