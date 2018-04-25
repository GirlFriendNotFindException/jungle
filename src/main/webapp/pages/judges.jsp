<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<script>
	

	/* 初始化  显示指定页面   事件 */
	
	$(function(){
		$(".judges_plus").click(function() {
			addNullRow(getTBody("judges_tbody"), getColumn("judges_table"));
		});

		$(".judges_remove").click(function() {
			deleteRow(getTBody("judges_tbody"), rowSelectedIndex);
		});
		
		$(".judges_sign").click(function() {
			/*评委表*/  
			var data=getRows("judges_table");
			var competitionFnumber=$("#competitionFnumber").html();
			addFnumberPrefix(data, competitionFnumber, "fnumber");
			 sendRequest("/jungle/admin/addJudges.action", JSON.stringify(data), function(data){
				alert(data);
			});
			 
			/*同时插入比赛详情表*/
			var courseFnumber=$("#courseFnumber").html();
			
			var arr=[];
			$.each(data, function(key , val){
				var obj={};
				obj['competition']=competitionFnumber;
				obj['course']=courseFnumber;
				obj['judges']=val['fnumber'];
				arr.push(obj);
			});
			sendRequest("/jungle/admin/addListCmpt_dtalJudges.action", JSON.stringify(arr), function(data){
				alert(data);
			});
		});
		
		
		tabelEvent("judges_table");
	});
	
	
	
	
</script>







<div class="col-md-9" id="judges">
	<div class="row">
		<div class="col-md-12" style="height: 50px">
			<div class="row">
				<div class="col-md-9"
					style="height: 50px; text-align: center; line-height: 50px; font-size: 20px; font-weight: bold;">
					<div class="col-md-6">评委信息录入</div>
					
				</div>
				<div class="col-md-3"
					style="background: white; height: 50px; padding-top: 22px;">
					<button type="button" class="btn btn-primary judges_plus">
						<span class="glyphicon glyphicon-plus"></span>
					</button>

					<button type="button" class="btn btn-primary judges_edit">
						<span class="glyphicon glyphicon-edit "></span>
					</button>

					<button type="button" class="btn btn-primary judges_remove">
						<span class="glyphicon glyphicon-remove"></span>
					</button>

					<button type="button" class="btn btn-primary judges_sign">
						<span class="glyphicon glyphicon-ok-sign"></span>
					</button>

				</div>
			</div>
		</div>
	</div>
	<!-- <div class="col-md-1"  style="background: gray;  height:300px"></div> -->

	<div class="col-md-12">
		<table class="table table-bordered table-hover judges_table"
			tabindex="1">
			<thead>
				<tr>
					<th id="">#</th>
					<th id="name">姓名</th>
					<th id="fnumber">编号</th>
					<th id="sex">性别</th>
					<th id="weight">权重</th>
					<th id="contactInfo">联系方式</th>
					<th id="description">描述</th>
				</tr>
			</thead>
			<tbody id="judges_tbody">
			</tbody>
		</table>
	</div>




	<!-- <div class="col-md-2"  style="background: gray; height:300px"></div> -->
</div>




