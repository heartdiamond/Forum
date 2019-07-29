function like( ) {
	var curPath=window.document.location.href;  
	var strs = curPath.split("=");
	var article_id = strs[1];
	var who = document.getElementById("who").innerHTML;
	var like_num = document.getElementById("like_num");
	var like_statu = document.getElementById("like_statu");
	var pic = document.getElementById("like_pic");
	if(like_statu.innerHTML == "点赞"){
		//1.创建一个异步对象
	    var xhe;
	    if(window.XMLHttpRequest){
	       xhe = new XMLHttpRequest();
	    }else{
	       xhe = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	    xhe.open("post","like.do",true);
	    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xhe.send("article_id="+article_id+"&who="+who);
	    like_statu.innerHTML = "已点赞";
	    pic.src = "imges/like.png";
	    like_num.innerHTML = like_num.innerHTML*1+1;
	}else{
		//1.创建一个异步对象
	    var xhe;
	    if(window.XMLHttpRequest){
	       xhe = new XMLHttpRequest();
	    }else{
	        xhe = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	    xhe.open("post","dislike.do",true);
	    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xhe.send("article_id="+article_id+"&who="+who);
	    like_statu.innerHTML = "点赞";
	    pic.src = "imges/unlike.png";
	    like_num.innerHTML = like_num.innerHTML*1-1;
	}
	
}

function init(){
	convert();
	newMessage();
	var who_name = document.getElementById("who_name").innerHTML;
	var temp0 = "<a href='toOtherHome.do?who="+who_name+"'>"+who_name+"</a>";
	var who1 = document.getElementById("who1");
	who1.innerHTML = temp0;
	var who_kind = document.getElementById("who_kind").innerHTML;
	var temp1 = "<a href='toSearch.do?content="+who_kind+"'>"+who_kind+"</a>";
	var kind2 = document.getElementById("kind2");
	kind2.innerHTML = temp1;
	
	
	var time = document.getElementById("time").innerHTML;
	var temp = time.split("-");
	var year = temp[0];
	var month = temp[1];
	var temp1 = temp[2];
	var temp2 = temp1.split(" ");
	var day = temp2[0];
	var temp3 = temp2[1].split(":");
	var hour = temp3[0];
	var minute = temp3[1];
	text = year+"年"+month+"月"+day+"日 "+hour+":"+minute;
	var realtime = document.getElementById("real-time");
	realtime.innerHTML = text;
	isLike();
	getAllComments();
}
function init1(){
	convert();
}
function isLike(){
	var like_statu = document.getElementById("like_statu");
	var pic = document.getElementById("like_pic");
	var curPath=window.document.location.href;  
	var strs = curPath.split("=");
	var article_id = strs[1];
	var who = document.getElementById("who").innerHTML;
	//1.创建一个异步对象
    var xhe;
   if(window.XMLHttpRequest){
      xhe = new XMLHttpRequest();
   }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
   }
    xhe.open("post","isLike.do",true);
    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhe.send("article_id="+article_id+"&who="+who); 
    xhe.onreadystatechange = function () {
        if(xhe.readyState === 4){
            if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
                //5.处理返回的结果
                var obj = xhe.responseText;
                	if(obj === "yes"){
                		like_statu.innerHTML = "已点赞";
                		pic.src = "imges/like.png";
                	}else{
                		like_statu.innerHTML = "点赞";
                		pic.src = "imges/unlike.png";
                	}
                }
            }else{
            	
            }
        }
}
function tip(){
	alert("请先登录!");
}
function tip1(){
	alert("请先登录!");
}
function addComment(){
	var content = document.getElementById("comment-content").value.trim();
	var user_id = document.getElementById("who").innerHTML;
	var user_name = document.getElementById("user_name").innerHTML;
	var temp_date = new Date();
   	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+
   				"月"+temp_date.getDate()+"日 "+temp_date.getHours()+":"+temp_date.getMinutes();
	var curPath=window.document.location.href;  
	var strs = curPath.split("=");
	var article_id = strs[1];
	if(content != ""){
			//1.创建一个异步对象
        var xhe;
        if(window.XMLHttpRequest){
           xhe = new XMLHttpRequest();
        }else{
            xhe = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhe.open("post","addComment.do",true);
        xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhe.send("article_id="+article_id+"&user_id="+user_id+"&content="+content);
        document.getElementById("comment-content").value = "";
        var home_path = "toOtherHome.do?who="+user_name;
        var temp = "<div class='comment-content'><span class='comment-num'>新增:</span><span class='comment-time'>"
        	+date_time+"</span><span><a href='toMyHome.do'>"+user_name+":</a><xmp>"+content+"</xmp></span></div>"
        var li = document.createElement('li');
       	li.innerHTML = temp;
       	document.getElementById('comment-ul').appendChild(li);
       	var comment_num = document.getElementById("comment_num");
       	comment_num.innerHTML = like_num.innerHTML*1+1;
	}
}
function getAllComments(){
	var curPath=window.document.location.href;  
	var strs = curPath.split("=");
	var article_id = strs[1];
	//1.创建一个异步对象
    var xhe;
   if(window.XMLHttpRequest){
      xhe = new XMLHttpRequest();
   }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
   }
    xhe.open("post","getAllComments.do",true);
    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhe.send("article_id="+article_id); 
    xhe.onreadystatechange = function () {
        if(xhe.readyState === 4){
            if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
                //5.处理返回的结果
            	var objarr = eval("("+xhe.responseText+")");
            		for(var i = 0; i < objarr.length ;i++){
	                 	var user_name = objarr[i].user_name; 
	                 	var temp_date = new Date(objarr[i].comment_time);
	                 	var home_path = "toOtherHome.do?who="+user_name;
	                 	var content = objarr[i].comment_content;
	                 	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
     							+temp_date.getHours()+":"+temp_date.getMinutes();
	                 	var temp = "<div class='comment-content'><span class='comment-num'>"+(i+1)+"楼</span><span class='comment-time'>"+
	                 				date_time+"</span><span><a href='"+home_path+"'>"+user_name+":</a><xmp>"+content+"</xmp></span></div>"
	                    var li = document.createElement('li');
	                   	li.innerHTML = temp;
	                   	document.getElementById('comment-ul').appendChild(li);
            			}
            		}
            }else{
            	
            }
        }
}
function convert(){
    var text = document.getElementById("test1").innerHTML;
    var html = marked(text);
    var obj = document.getElementById("test2");
    obj.innerHTML = html;
    console.log(obj);
    
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