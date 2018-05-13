<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>



<script>
	

	/* 初始化  显示指定页面   事件 */
	$(function() {

		$(".competitor_plus").click(function() {
			addNullRow(getTBody("competitor_tbody"), getColumn("competitor_table"));
		});

		$(".competitor_remove").click(function() {
			deleteRow(getTBody("competitor_tbody"), rowSelectedIndex);
		});

		
		tabelEvent("competitor_table");
		
		
		$(".competitor_sign").click(function() {
			/*参赛者表*/  
			 var data=getRows("competitor_table");
			var competitionFnumber=$("#competitionFnumber").html();
			addFnumberPrefix(data, competitionFnumber, "fnumber");
			 sendRequest("/jungle/admin/addCompetitor.action", JSON.stringify(data), function(data){
				alert(data);
			}); 
			 
			/*同时插入比赛详情表*/
			var courseFnumber=$("#courseFnumber").html();
			
			var arr=[];
			$.each(data, function(key , val){
				var obj={};
				obj['competition']=competitionFnumber;
				obj['course']=courseFnumber;
				obj['competitor']=val['fnumber'];
				arr.push(obj);
			});
			sendRequest("/jungle/admin/addListCmpt_dtalCompetitor.action", JSON.stringify(arr), function(data){
				alert(data);
			}); 
			
		});
		
	});
</script>





<!-- 打分界面 -->
<div class="col-md-9" id="competitor">
	<div class="row">
		<div class="col-md-12" style="height: 50px">
			<div class="row">
				<div class="col-md-9"
					style="height: 50px; text-align: center; line-height: 50px; font-size: 20px; font-weight: bold;">
					<div class="col-md-6">参赛者信息录入</div>
				</div>
				<div class="col-md-3"
					style="background: white; height: 50px; padding-top: 22px;">
					<button type="button" class="btn btn-primary competitor_plus">
						<span class="glyphicon glyphicon-plus"></span>
					</button>

					<button type="button" class="btn btn-primary competitor_edit">
						<span class="glyphicon glyphicon-edit "></span>
					</button>

					<button type="button" class="btn btn-primary competitor_remove">
						<span class="glyphicon glyphicon-remove"></span>
					</button>

					<button type="button" class="btn btn-primary competitor_sign">
						<span class="glyphicon glyphicon-ok-sign"></span>
					</button>

				</div>
			</div>
		</div>
	</div>
	<!-- <div class="col-md-1"  style="background: gray;  height:300px"></div> -->

	<div class="col-md-12">
		<table class="table table-bordered table-hover competitor_table"
			tabindex="1">
			<thead>
				<tr>
					<th width="10%">#</th>
					<th width="15%" id="name">姓名</th>
					<th width="15%" id="fnumber">编号</th>
					<th width="15%" id="sex">性别</th>
					<th width="15%" id="age">年龄</th>
					<th width="15%" id="contactInfo">联系方式</th>
					<th width="15%" id="description">描述</th>
				</tr>
			</thead>
			<tbody id="competitor_tbody">
			</tbody>
		</table>
	</div>

	<!-- <div class="col-md-2"  style="background: gray; height:300px"></div> -->
</div>




