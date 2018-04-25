<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>

<%@include file="../pages/header.jsp" %>

<script >
function add(){
	var list=new Array();
	list.push({"name":"saber",  "date":"2018-03-24", "organizers":"小李", "venue":"xxx", "description":"xxx"  });

	$.ajax({
		
		url:"/jungle/addCompetition.action",
		type:"post",
		dataType:"JSON",
		data:JSON.stringify(list),
		contentType:"application/json; charset=UTF-8",
		success:function(data){
			alert(data);
		}
	});
}

function add1(){
	var list=new Array();
	list.push({"cmpt_fid":"1",  "compititor":"1",  "judges":"1" });

	$.ajax({
		
		url:"/jungle/addCmpt_dtal.action",
		type:"post",
		dataType:"JSON",
		data:JSON.stringify(list),
		contentType:"application/json;charset=UTF-8",
		success:function(data){
			alert(data);
		}
	});
}




</script>


<p>小李</p>
<input type="button" name="btn" value="click" onclick="add()"/>
<input type="button" name="btn" value="click1" onclick="add1()"/>

<%@include file="../pages/footer.jsp" %>

