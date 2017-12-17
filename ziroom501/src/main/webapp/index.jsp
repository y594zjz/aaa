<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	
	  $("#01").click(function(){
		$.ajax({
			url:"api",
			data:{name:"sdhaj"},
			success:function(){
				alert("arf");
			},
			error:function(){
				alert("error");
			}
		})
	});
	
</script>
<title>首页</title>
</head>
<body>
<button id="01">iiii</button>
</body>
</html>