function init () {
	haveNewMessage ();
	
};
function haveNewMessage () {
	//1.创建一个异步对象
    var xhe;
   if(window.XMLHttpRequest){
      xhe = new XMLHttpRequest();
   }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
   }
    xhe.open("post","getAllDynamic.do",true);
    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhe.send(""); 
    xhe.onreadystatechange = function () {
       if(xhe.readyState === 4){
           if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
               //5.处理返回的结果
               var objarr = eval("("+xhe.responseText+")");
               if(objarr.length == 0){
        		   var obj = document.getElementById("messages");
        		   var op = document.getElementById("op");
        		   op.style.cssText ="display:none;"
        		   obj.innerHTML = "<span class='tip'>你没有收到任何消息哦~</span>";
        		   
        	   }else{
        		   
        	   }
               for(var i = 0; i < objarr.length ;i++){
            	   var home_path = "toOtherHome.do?who="+objarr[i].user_name;
            	   var read_path = "toRead.do?id="+objarr[i].article_id;
            	   var who = objarr[i].user_name;
            	   var article_title = objarr[i].article_title;
            	   var temp_date = new Date(objarr[i].dynamic_time);
            	   var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
									+temp_date.getHours()+":"+temp_date.getMinutes();
            	   var comment_content = objarr[i].comment_content;
            	   if(objarr[i].dynamic_kind == 1){
            		   //当消息是点赞型时
            		   var temp =   "<div class='like'>" +
            		   				"<span class ='time'>"+date_time+"</span> -- <a href='"+home_path+"'> "+who+" </a> 点赞了你的文章 *<a href='"+read_path+"'>"+article_title+"</a>*" +
            		   				"<div>";
            		   if(objarr[i].islooked == 0){
            			   //未读
            			    var li = document.createElement('li');
                        	li.innerHTML = temp;
                        	document.getElementById('new_ul').insertBefore(li, document.getElementById('new_ul').firstChild);
            		   }else if(objarr[i].islooked == "1"){
            			    var li = document.createElement('li');
            			    li.innerHTML = temp;
            			    document.getElementById('old_ul').insertBefore(li, document.getElementById('old_ul').firstChild);
            		   }
            	   }else if(objarr[i].dynamic_kind == 2){
            		   //当消息是评论型时
            		   var temp =   "<div class='comment'>" +
            		   					"<span class ='time'>"+date_time+"</span> -- <a href='"+home_path+"'> "+who+" </a> 在你的文章 *" +
            		   					"<a href='"+read_path+"'>"+article_title+"</a> *下评论:" +
            		   					"<span class='comment_content'>"+comment_content+"</span>" +
            		   				"</div>";
            		   if(objarr[i].islooked === 0){
            			   //未读
            			    var li = document.createElement('li');
                        	li.innerHTML = temp;
                        	document.getElementById('new_ul').insertBefore(li, document.getElementById('new_ul').firstChild);
            		   }else if(objarr[i].islooked == 1){
            			   var li = document.createElement('li');
            			   li.innerHTML = temp;
            			   document.getElementById('old_ul').insertBefore(li, document.getElementById('old_ul').firstChild);
            		   }
            	   }
               }
           }else{
               //5.数据返回失败
           }
       }
   };
}
