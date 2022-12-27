function SaveBoard(){
		   var fileinput = $('#file').val();
        	console.log(fileinput+"dzcxvzxcvzxv");
           var file = fileinput.substr(12,17); // 파일명 출력
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

 
 