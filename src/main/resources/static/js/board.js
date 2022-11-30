
function SaveBoard(){
		 var data = {
			 boardtitle: $('#boardtitle').val(),
			 nickname: $('#nickname').val(),
			 boardcontent: $('#boardcontent').val()
		 };
		var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
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

function postUpdate(){
        var data = {
        	boardtitle: $('#boardtitle').val(),
        	boardcontent: $('#boardcontent').val()
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

 
 