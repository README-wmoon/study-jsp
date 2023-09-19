<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1></h1>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$.ajax({
		url: "https://infuser.odcloud.kr/oas/docs?namespace=15053336/v1",
		success: function(result){
			console.log(result.info.title);
			$("h1").html(result.info.title);
		}
	})
</script>
</html>