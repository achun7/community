$(function(){
	$("#publishBtn").click(publish);
});

function publish() {
	$("#publishModal").modal("hide");
	//发异步请求
	//获取标题和内容
	var title = $("#recipient-name").val();//获取值
	var content = $("#message-text").val();
	//发送异步请求
	$.post(//三步
		CONTEXT_PATH + "/discuss/add",//发送路径
		{"title":title,"content":content},//发送内容
		function(data) {//返回处理
			data = $.parseJSON(data);
			//在提示框中显示返回消息
			$("#hintBody").text(data.msg);
			//显示提示框，两秒后隐藏
			$("#hintModal").modal("show");
			setTimeout(function(){
				$("#hintModal").modal("hide");
				//刷新页面
				if(data.code == 0) {
					window.location.reload();
				}
			}, 2000);
		}
	)


}