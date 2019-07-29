function delHtmlTag(str){
	return str.replace(/<[^>]+>/g,"");//去掉所有的html标记
}
function getArticles(){
	newMessage();
	var articles_ul = document.getElementById('articles-ul');
	articles_ul.innerHTML = "";
	//1.创建一个异步对象
      var xhe;
     if(window.XMLHttpRequest){
        xhe = new XMLHttpRequest();
     }else{
         xhe = new ActiveXObject("Microsoft.XMLHTTP");
     }
      xhe.open("post","getAllArticle.do",true);
      xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
      xhe.send(""); 
      xhe.onreadystatechange = function () {
         if(xhe.readyState === 4){
             if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
                 //5.处理返回的结果
                 var objarr = eval("("+xhe.responseText+")");
                 for(var i = 0; i < objarr.length ;i++){
                 	var who = objarr[i].user_name; 
                 	var content = objarr[i].article_content;
                 	var html = marked(content);
                 	html = delHtmlTag(html);
                 	var temp_date = new Date(objarr[i].article_time);
                 	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
 									+temp_date.getHours()+":"+temp_date.getMinutes();
                	var title = objarr[i].article_title;
                 	var kind = objarr[i].article_kind; 
                 	var id = objarr[i].article_id; 
                 	var path = "toRead.do?id="+id;
                 	var home_path = "toOtherHome.do?who="+who;
                 	var search_path = "toSearchKind.do?kind="+kind;
                 	var read_num = objarr[i].read_num; 
                 	var comment_num = objarr[i].comment_num; 
                 	var like_num = objarr[i].like_num; 
                 	var temp = "<li class='article'><div class='article-title'><a href="+path+">"+title+"</a><span class='read'>阅读数(<span class='read_num'>"+read_num+"</span>)</span></div><div class='article-content'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
	     				html+"<a href="+path+"><查看全文></a></div><div class='article-info'><span class='info'>作者:<span class='name'><a href='"+home_path+"'>"+who+"</a></span></span><span class='info'>类别:&nbsp;<span class='kind'><a href='"+search_path+"'>"+
	     				kind+"</a></span></span><span class='info'>点赞数:&nbsp;<span class='like_num'>"+like_num+"</span></span><span class='info'>评论数:&nbsp;<span class='comment_num'>"+comment_num+"</span></span><span class='info-time'>时间:&nbsp;<span class='time'>"+
	     				date_time+"</span></span></div></li>";
                 	var li = document.createElement('li');
                 	li.innerHTML = temp;
                 	document.getElementById('articles-ul').insertBefore(li, document.getElementById('articles-ul').firstChild);
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
