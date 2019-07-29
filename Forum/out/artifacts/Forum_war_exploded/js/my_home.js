function init() {
	newMessage();
	var table = document.getElementById('articles-table');
	//1.创建一个异步对象
    var xhe;
   if(window.XMLHttpRequest){
      xhe = new XMLHttpRequest();
   }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
   }
    xhe.open("post","getArticlesByUserId.do",true);
    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhe.send(""); 
    xhe.onreadystatechange = function () {
       if(xhe.readyState === 4){
           if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
               //5.处理返回的结果
               var objarr = eval("("+xhe.responseText+")");
				if(objarr.length == 0){
					table.innerHTML = "";
					var temp =
						"<th>你还没有发表过任何文章哦,快去 <a href='toPublish.do'>发帖</a> 吧</th>";
					var tr = document.createElement('tr');
					tr.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr);
				}
               for(var i = 0; i < objarr.length ;i++){
               	var temp_date = new Date(objarr[i].article_time);
               	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
								+temp_date.getHours()+":"+temp_date.getMinutes();
               	var title = objarr[i].article_title;
               	var kind = objarr[i].article_kind; 
               	var id = objarr[i].article_id; 
               	var readPath = "toRead.do?id="+id;
               	var kindPath = "";
               	var editPath = "toEdit.do?id="+id;
               	var deletePath = "toDelete.do?id="+id;
               	var read_num = objarr[i].read_num; 
               	var comment_num = objarr[i].comment_num; 
               	var like_num = objarr[i].like_num; 
               	var temp = 
		  					"<td><a href='"+readPath+"'>"+title+"</a><span class='article_id'>"+id+"</span></td>"+
		 					"<td class='content-td'><a>"+kind+"</a></td>"+
		 					"<td class='content-td'>"+like_num+"</td>"+
		 					"<td class='content-td'>"+comment_num+"</td>"+
		 					"<td class='content-td'>"+read_num+"</td>"+
		 					"<td class='content-td'>"+date_time+"</td>"+
		 					"<th><a href='"+editPath+"'>编辑</a></th>"+
		 					"<th><a href='"+deletePath+"'>删除</a></th>";
               	var tr1 = document.createElement('tr');
             	tr1.innerHTML = temp;
             	console.log(tr1);
             	document.getElementById('articles-table').appendChild(tr1);
               }
           }else{
               //5.处理返回的结果
               alert("失败");
           }
       }
   };

}
function newMessage(){
	var xhe;
    if(window.XMLHttpRequest){
       xhe = new XMLHttpRequest();
    }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
    }
     xhe.open("post","newMessage.do",true);
     xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     xhe.send(""); 
     xhe.onreadystatechange = function () {
        if(xhe.readyState === 4){
            if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
                //5.处理返回的结果
                var result = xhe.responseText;
                if(result === "yes"){
                	var obj = document.getElementById("my-message");
                	obj.innerHTML = "<a href='toMyMessage.do' class='newMessageClass'>新 的 消 息</a>"
                }else if(result === "no"){
                	
                }
            }else{
                //5.处理返回的结果
                alert("失败");
            }
        }
    };
}
function getLearn(){
	var table = document.getElementById('articles-table');
	table.innerHTML = "";
	var title =
		"<th class='first-tr-title'>文章标题</th>" +
		"<th class='first-tr-other'>类别</th>" +
		"<th class='first-tr-other'>点赞数</th>" +
		"<th class='first-tr-other'>评论数</th>" +
		"<th class='first-tr-other'>阅读数</th>" +
		"<th class='first-tr-time'>发表时间</th>" +
		"<th class='first-tr-other' colspan='2'>操作</th>";
	var tr = document.createElement('tr');
	tr.innerHTML = title;
	document.getElementById('articles-table').appendChild(tr);
	//1.创建一个异步对象
    var xhe;
   if(window.XMLHttpRequest){
      xhe = new XMLHttpRequest();
   }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
   }
    xhe.open("post","getArticlesByKind.do",true);
    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhe.send("kind=学习类"); 
    xhe.onreadystatechange = function () {
       if(xhe.readyState === 4){
           if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
               //5.处理返回的结果
               var objarr = eval("("+xhe.responseText+")");
				if(objarr.length == 0){
					table.innerHTML = "";
					var temp =
						"<th>你还没有发表过学习类文章哦,快去 <a href='toPublish.do'>发帖</a> 吧</th>";
					var tr = document.createElement('tr');
					tr.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr);
				}
               for(var i = 0; i < objarr.length ;i++){
               	var temp_date = new Date(objarr[i].article_time);
               	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
               					+temp_date.getHours()+":"+temp_date.getMinutes();
               	var title = objarr[i].article_title;
               	var kind = objarr[i].article_kind; 
               	var id = objarr[i].article_id; 
               	var readPath = "toRead.do?id="+id;
            	var kindPath = "";
               	var editPath = "toEdit.do?id="+id;
               	var deletePath = "toDelete.do?id="+id;
               	var read_num = objarr[i].read_num; 
               	var comment_num = objarr[i].comment_num; 
               	var like_num = objarr[i].like_num; 
               	var temp = 
		  					"<td><a href='"+readPath+"'>"+title+"</a><span class='article_id'>"+id+"</span></td>"+
		 					"<td class='content-td'><a>"+kind+"</a></td>"+
		 					"<td class='content-td'>"+like_num+"</td>"+
		 					"<td class='content-td'>"+comment_num+"</td>"+
		 					"<td class='content-td'>"+read_num+"</td>"+
		 					"<td class='content-td'>"+date_time+"</td>"+
		 					"<th><a href='"+editPath+"'>编辑</a></th>"+
		 					"<th><a href='"+deletePath+"'>删除</a></th>";
               	var tr1 = document.createElement('tr');
             	tr1.innerHTML = temp;
             	console.log(tr1);
             	document.getElementById('articles-table').appendChild(tr1);
               }
           }else{
               //5.处理返回的结果
               alert("失败");
           }
       }
   };

}
function getTech(){
	var table = document.getElementById('articles-table');
	table.innerHTML = "";
	var title =
			"<th class='first-tr-title'>文章标题</th>" +
			"<th class='first-tr-other'>类别</th>" +
			"<th class='first-tr-other'>点赞数</th>" +
			"<th class='first-tr-other'>评论数</th>" +
			"<th class='first-tr-other'>阅读数</th>" +
			"<th class='first-tr-time'>发表时间</th>" +
			"<th class='first-tr-other' colspan='2'>操作</th>";
	var tr = document.createElement('tr');
	tr.innerHTML = title;
	document.getElementById('articles-table').appendChild(tr);
	//1.创建一个异步对象
	var xhe;
	if(window.XMLHttpRequest){
		xhe = new XMLHttpRequest();
	}else{
		xhe = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhe.open("post","getArticlesByKind.do",true);
	xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhe.send("kind=技术类"); 
	xhe.onreadystatechange = function () {
		if(xhe.readyState === 4){
			if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
				//5.处理返回的结果
				var objarr = eval("("+xhe.responseText+")");
				if(objarr.length == 0){
					table.innerHTML = "";
					var temp =
						"<th>你还没有发表过技术类文章哦,快去 <a href='toPublish.do'>发帖</a> 吧</th>";
					var tr = document.createElement('tr');
					tr.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr);
				}
				for(var i = 0; i < objarr.length ;i++){
					var temp_date = new Date(objarr[i].article_time);
					var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
									+temp_date.getHours()+":"+temp_date.getMinutes();
					var title = objarr[i].article_title;
					var kind = objarr[i].article_kind; 
					var id = objarr[i].article_id; 
					var readPath = "toRead.do?id="+id;
					var kindPath = "";
					var editPath = "toEdit.do?id="+id;
					var deletePath = "toDelete.do?id="+id;
					var read_num = objarr[i].read_num; 
					var comment_num = objarr[i].comment_num; 
					var like_num = objarr[i].like_num; 
					var temp = 
						"<td><a href='"+readPath+"'>"+title+"</a><span class='article_id'>"+id+"</span></td>"+
						"<td class='content-td'><a>"+kind+"</a></td>"+
						"<td class='content-td'>"+like_num+"</td>"+
						"<td class='content-td'>"+comment_num+"</td>"+
						"<td class='content-td'>"+read_num+"</td>"+
						"<td class='content-td'>"+date_time+"</td>"+
						"<th><a href='"+editPath+"'>编辑</a></th>"+
						"<th><a href='"+deletePath+"'>删除</a></th>";
					var tr1 = document.createElement('tr');
					tr1.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr1);
				}
			}else{
				//5.处理返回的结果
				alert("失败");
			}
		}
	};
	
}
function getLife(){
	var table = document.getElementById('articles-table');
	table.innerHTML = "";
	var title =
		"<th class='first-tr-title'>文章标题</th>" +
		"<th class='first-tr-other'>类别</th>" +
		"<th class='first-tr-other'>点赞数</th>" +
		"<th class='first-tr-other'>评论数</th>" +
		"<th class='first-tr-other'>阅读数</th>" +
		"<th class='first-tr-time'>发表时间</th>" +
		"<th class='first-tr-other' colspan='2'>操作</th>";
	var tr = document.createElement('tr');
	tr.innerHTML = title;
	document.getElementById('articles-table').appendChild(tr);
	//1.创建一个异步对象
	var xhe;
	if(window.XMLHttpRequest){
		xhe = new XMLHttpRequest();
	}else{
		xhe = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhe.open("post","getArticlesByKind.do",true);
	xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhe.send("kind=生活类"); 
	xhe.onreadystatechange = function () {
		if(xhe.readyState === 4){
			if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
				//5.处理返回的结果
				var objarr = eval("("+xhe.responseText+")");
				if(objarr.length == 0){
					table.innerHTML = "";
					var temp =
						"<th>你还没有发表过生活类文章哦,快去 <a href='toPublish.do'>发帖</a> 吧</th>";
					var tr = document.createElement('tr');
					tr.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr);
				}
				for(var i = 0; i < objarr.length ;i++){
					var temp_date = new Date(objarr[i].article_time);
					var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
									+temp_date.getHours()+":"+temp_date.getMinutes();
					var title = objarr[i].article_title;
					var kind = objarr[i].article_kind; 
					var id = objarr[i].article_id; 
					var readPath = "toRead.do?id="+id;
					var kindPath = "";
					var editPath = "toEdit.do?id="+id;
					var deletePath = "toDelete.do?id="+id;
					var read_num = objarr[i].read_num; 
					var comment_num = objarr[i].comment_num; 
					var like_num = objarr[i].like_num; 
					var temp = 
						"<td><a href='"+readPath+"'>"+title+"</a><span class='article_id'>"+id+"</span></td>"+
						"<td class='content-td'><a>"+kind+"</a></td>"+
						"<td class='content-td'>"+like_num+"</td>"+
						"<td class='content-td'>"+comment_num+"</td>"+
						"<td class='content-td'>"+read_num+"</td>"+
						"<td class='content-td'>"+date_time+"</td>"+
						"<th><a href='"+editPath+"'>编辑</a></th>"+
						"<th><a href='"+deletePath+"'>删除</a></th>";
					var tr1 = document.createElement('tr');
					tr1.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr1);
				}
			}else{
				//5.处理返回的结果
				alert("失败");
			}
		}
	};
	
}
function getLike(){
	var table = document.getElementById('articles-table');
	table.innerHTML = "";
	var title =
		"<th class='first-tr-title'>文章标题</th>" +
		"<th class='first-tr-other'>类别</th>" +
		"<th class='first-tr-other'>作者</th>" +
		"<th class='first-tr-other'>点赞数</th>" +
		"<th class='first-tr-other'>评论数</th>" +
		"<th class='first-tr-other'>阅读数</th>" +
		"<th class='first-tr-time'>发表时间</th>";
	var tr = document.createElement('tr');
	tr.innerHTML = title;
	document.getElementById('articles-table').appendChild(tr);
	//1.创建一个异步对象
	var xhe;
	if(window.XMLHttpRequest){
		xhe = new XMLHttpRequest();
	}else{
		xhe = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhe.open("post","getArticlesByLike.do",true);
	xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhe.send(""); 
	xhe.onreadystatechange = function () {
		if(xhe.readyState === 4){
			if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
				//5.处理返回的结果
				var objarr = eval("("+xhe.responseText+")");
				if(objarr.length == 0){
					table.innerHTML = "";
					var temp =
						"<th>你还没有点赞过任何文章哦,快去 <a href='toMain.do'>首页</a> 看看吧</th>";
					var tr = document.createElement('tr');
					tr.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr);
				}
				for(var i = 0; i < objarr.length ;i++){
					var temp_date = new Date(objarr[i].article_time);
					var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
									+temp_date.getHours()+":"+temp_date.getMinutes();
					var title = objarr[i].article_title;
					var kind = objarr[i].article_kind; 
					var id = objarr[i].article_id; 
					var readPath = "toRead.do?id="+id;
					var kindPath = "";
					var editPath = "toEdit.do?id="+id;
					var deletePath = "toDelete.do?id="+id;
					var read_num = objarr[i].read_num; 
					var comment_num = objarr[i].comment_num; 
					var like_num = objarr[i].like_num; 
					var who = objarr[i].user_name; 
					var temp = 
						"<td><a href='"+readPath+"'>"+title+"</a><span class='article_id'>"+id+"</span></td>"+
						"<td class='content-td'><a>"+kind+"</a></td>"+
						"<td class='content-td'><a>"+who+"</a></td>"+
						"<td class='content-td'>"+like_num+"</td>"+
						"<td class='content-td'>"+comment_num+"</td>"+
						"<td class='content-td'>"+read_num+"</td>"+
						"<td class='content-td'>"+date_time+"</td>";
					var tr1 = document.createElement('tr');
					tr1.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr1);
				}
			}else{
				//5.处理返回的结果
				alert("失败");
			}
		}
	};
	
}
function getComment(){
	var table = document.getElementById('articles-table');
	table.innerHTML = "";
	var title =
		"<th class='first-tr-title'>文章标题</th>" +
		"<th class='first-tr-other'>类别</th>" +
		"<th class='first-tr-other'>作者</th>" +
		"<th class='first-tr-other'>点赞数</th>" +
		"<th class='first-tr-other'>评论数</th>" +
		"<th class='first-tr-other'>阅读数</th>" +
		"<th class='first-tr-time'>发表时间</th>";
	var tr = document.createElement('tr');
	tr.innerHTML = title;
	document.getElementById('articles-table').appendChild(tr);
	//1.创建一个异步对象
	var xhe;
	if(window.XMLHttpRequest){
		xhe = new XMLHttpRequest();
	}else{
		xhe = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhe.open("post","getArticlesByComment.do",true);
	xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhe.send(""); 
	xhe.onreadystatechange = function () {
		if(xhe.readyState === 4){
			if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
				//5.处理返回的结果
				var objarr = eval("("+xhe.responseText+")");
				if(objarr.length == 0){
					table.innerHTML = "";
					var temp =
						"<th>你还没有评论过任何文章哦,快去 <a href='toMain.do'>首页</a> 看看吧</th>";
					var tr = document.createElement('tr');
					tr.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr);
				}
				for(var i = 0; i < objarr.length ;i++){
					var temp_date = new Date(objarr[i].article_time);
					var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
									+temp_date.getHours()+":"+temp_date.getMinutes();
					var title = objarr[i].article_title;
					var kind = objarr[i].article_kind; 
					var id = objarr[i].article_id; 
					var readPath = "toRead.do?id="+id;
					var kindPath = "";
					var editPath = "toEdit.do?id="+id;
					var deletePath = "toDelete.do?id="+id;
					var read_num = objarr[i].read_num; 
					var comment_num = objarr[i].comment_num; 
					var like_num = objarr[i].like_num; 
					var who = objarr[i].user_name; 
					var temp = 
						"<td><a href='"+readPath+"'>"+title+"</a><span class='article_id'>"+id+"</span></td>"+
						"<td class='content-td'><a>"+kind+"</a></td>"+
						"<td class='content-td'><a>"+who+"</a></td>"+
						"<td class='content-td'>"+like_num+"</td>"+
						"<td class='content-td'>"+comment_num+"</td>"+
						"<td class='content-td'>"+read_num+"</td>"+
						"<td class='content-td'>"+date_time+"</td>";
					var tr1 = document.createElement('tr');
					tr1.innerHTML = temp;
					document.getElementById('articles-table').appendChild(tr1);
				}
			}else{
				//5.处理返回的结果
				alert("失败");
			}
		}
	};
	
}