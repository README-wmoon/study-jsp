const $replyWrite = $("#reply-write-wrap");
const $writeButton = $("#reply-write-wrap button");
const $writeTextarea = $("form[name='writeForm'] textarea");
const replyTexts = ['취소', ' ', '댓글 달기'];
const $ul = $("#replies-wrap ul");
const $dimmed = $("div.logo-area");
/*=======================================================================*/
/*Ajax CRUD*/
/*=======================================================================*/
let page = 1;
showList();

/*$(window).scroll(function(){
	//if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
		page++;
		showList();
	}
});*/

/*삭제*/
$("#replies-wrap ul").on("click", ".delete", function(){
	$(".infinite_rotating_logo").show();
	$.ajax({
		url: contextPath + `/deleteOk.reply?replyId=${$(this).data("reply-id")}`,
		success: function(){
			$(".infinite_rotating_logo").hide();
			$("#replies-wrap ul").html("");
			page = 1;
			showList();
		}
	});
});

/*수정*/
$("#replies-wrap ul").on("click", ".update-done", function(){
	$(".infinite_rotating_logo").show();
	let $updateWrap = $(this).closest(".reply-update-wrap");
	let replyId = $(this).attr("id");
	let replyContent = $("#" + replyId).val();
	$.ajax({
		url: contextPath + "/updateOk.reply",
		type: "post",
		data: {replyContent: $("#" + $(this).attr("id")).val(), replyId: $(this).attr("id")},
		async: false,
		success: function(){
			$(".infinite_rotating_logo").hide();
			let $replyUpdate = $updateWrap;
			$replyUpdate.prev().text(replyContent);
		    $replyUpdate.hide();
		    $replyUpdate.prev().show();
		    $replyUpdate.next().show();
		}
	});
});

/*작성*/
$("#reply-write-wrap button").on("click", function(){
	$(".infinite_rotating_logo").show();
	$.ajax({
		url: contextPath + "/writeOk.reply",
		type: "post",
		data: {replyContent: $("#reply-content").val(), boardId: boardId},
		success: function(){
			$(".infinite_rotating_logo").hide();
			$("#replies-wrap ul").html("");
			$("#reply-content").val("");
			page = 1;
			showList();
		}
	});
});

/*더보기*/
$("#more-replies").on("click", function(){
	page++;
	showList();
})

/*목록*/
function showList(){
	$(".infinite_rotating_logo").show();
	$.ajax({
		url: contextPath + `/listOk.reply?boardId=${boardId}&page=${page}`,
		dataType: "json",
		success: function(replies){
			$(".infinite_rotating_logo").hide();
			let text = "";
			
			replies.forEach(reply => {
				text += `
					<li>
	                    <div>
	                        <section class="content-container">
	                            <div class="profile">
	                                <div><img src="/static/images/reply_profile.png" width="15px"></div>
	                                <h6 class="writer">${reply.memberName}</h6>
	                            </div>
	                            <h4 class="title">${reply.replyContent}</h4>
								<section class="reply-update-wrap">
			                        <textarea id="${reply.replyId}" cols="30" rows="1" placeholder="내 댓글"></textarea>
			                        <div class="button-wrap">
			                            <button id="${reply.replyId}" class="update-done">작성완료</button>
			                            <button class="cancel">취소</button>
			                        </div>
			                    </section>
	                            <h6 clss="board-info">
	                                <span class="date">${elapsedTime(reply.replyRegisterDate)}</span>
					`
				if(reply.memberId == memberId){
				text += `
			                        <span class="date">·</span>
			                        <span class="update">수정</span>
			                        <span class="date">·</span>
			                        <span class="delete" data-reply-id="${reply.replyId}">삭제</span>
						`
				}
				text += `
	                            </h6>
	                        </section>
	                    </div>
	                </li>
				`;
			})
			
			$("#replies-wrap ul").append(text);				
		}
	});
}


/*=======================================================================*/
/*퍼블리싱*/
/*=======================================================================*/
let flag = 1;

function showReply(){
    $replyWrite.slideToggle(function(){
        flag *= -1;
        $("#show-reply a").text(replyTexts[flag + 1]);
    });
}

$writeButton.on("mouseover", function(){
    $(this).css("background-color", "#F3F5F7");
});

$writeButton.on("mouseout", function(){
    $(this).css("background-color", "rgb(255 255 255)");
});


$("#replies-wrap ul").on("click", "span.update", function(){
	let i = $("#replies-wrap ul").find("span.update").index(this);
	showUpdate(i);
});

$("#replies-wrap ul").on("click", "button.cancel", function(){
	let i = $("#replies-wrap ul").find("button.cancel").index(this);
	hideUpdate(i);
});

function showUpdate(i){
	let $replyUpdate = $("#replies-wrap ul").find(".reply-update-wrap").eq(i);
    let content = $replyUpdate.prev().text().trim();
    let $textarea = $replyUpdate.find("textarea");
    $textarea.val(content);
    $replyUpdate.prev().hide();
    $replyUpdate.next().hide();
    $replyUpdate.show();
}

function hideUpdate(i){
	let $replyUpdate = $("#replies-wrap ul").find(".reply-update-wrap").eq(i);
    $replyUpdate.hide();
    $replyUpdate.prev().show();
    $replyUpdate.next().show();
}

$writeTextarea.on("focus", function(){
    $(this).closest("span").css('border', '1px solid rgb(235 124 120)');
});

$writeTextarea.on("blur", function(){
    $(this).closest("span").css('border', '1px solid rgba(0, 0, 0, 0.1)');
});














