
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
 
 