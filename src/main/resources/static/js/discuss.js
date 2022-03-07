function like(btn, entityType, entityId, entityUserId,postId) {
    $.post(
        CONTEXT_PATH + "/like",//发送路径
        {"entityType":entityType,"entityId":entityId,"entityUserId":entityUserId,"postId":postId},//发送内容
        function(data) {
            data = $.parseJSON(data);
            if(data.code == 0) {//返回成功，处理结果
                $(btn).children("i").text(data.likeCount);
                $(btn).children("b").text(data.likeStatus==1?'已赞':"赞");
            } else {
                alert(data.msg);
            }
        }
    );
}