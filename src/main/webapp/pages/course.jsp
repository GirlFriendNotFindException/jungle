<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>



<script>
	

/* 初始化  显示指定页面   事件 */
$(function() {
	show('strategy');

	$(".plus").click(function() {
		addNullRow(getTBody("course_tbody"), getColumn("course_table"));
	});

	$(".remove").click(function() {
		deleteRow(getTBody("course_tbody"), rowSelectedIndex);
	});
	
	$(".sign").click(function() {
		$("#strategyname").show();
	});
	
	$(".courseCancle").click(function() {
		$("#strategyname").hide();
	});
	
	$(".courseCommit").click(function() {
		var tbldata=getRows("course_table");
		var formdata=getFormData("strategyform");
		$.each(tbldata, function(key, val1){
			$.each(formdata, function(key, val2){
				val1['coursename']=val2['coursename'];
				val1['fnumber']=val2['fnumber'];
				val1['courseDescription']=val2['courseDescription'];
			});
		});
		addCreatorAndCreateDate(tbldata);
		sendRequest("/jungle/admin/addCourse.action", JSON.stringify(tbldata), function(data){
			alert(data);	
		});
		$("#strategyname").hide();
		
		
		refreshCourse();
	});
	
	tabelEvent("course_table");
});
</script>





<!-- 打分策略模块 -->
<div class="col-md-9" id="strategy">
	<div class="row ">
		<div class="col-md-12" style="background:; height: 50px">
			<div class="row">
				<div class="col-md-8"
					style="height: 50px; text-align: center; line-height: 50px; font-size: 20px; font-weight: bold;">
					<div class="col-md-9">打分策略录入</div>
				</div>
				<div class="col-md-4"
					style="background: white; height: 50px; padding-top: 22px;">
					<button type="button" class="btn btn-primary plus">
						<span class="glyphicon glyphicon-plus"></span>
					</button>

					<button type="button" class="btn btn-primary">
						<span class="glyphicon glyphicon-edit"></span>
					</button>

					<button type="button" class="btn btn-primary remove">
						<span class="glyphicon glyphicon-remove"></span>
					</button>

					<button type="button" class="btn btn-primary sign">
						<span class="glyphicon glyphicon-ok-sign"></span>
					</button>

				</div>
			</div>
		</div>
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-1" style="background:; height: 300px"></div>
				<div class="col-md-10">
					<table class="table table-bordered table-hover course_table"
						tabindex="1">
						<thead>
							<tr>
								<th width="10%" id="num">#</th>
								<th width="30%" id="name">打分项目</th>
								<th width="10%" id="weight">权重</th>
								<th width="300%" id="description">计分规则描述</th>
							</tr>
						</thead>
						<tbody id="course_tbody">
						
						
						</tbody>
					</table>
				</div>
				<div class="col-md-1" style="background:; height: 300px"></div>
			</div>
		</div>
	</div>
</div>










<div class="col-md-6 " id="strategyname">
	<form id="strategyform" name="strategyform" method="post" class="form">
		<table width="30%" height="100px" border="0" align="center"
			cellpadding="2" cellspacing="1" class="result-tab">
			<tbody>
				<tr>
					<td width="25%" align="center" class="td_bg">策略名称：</td>
					<td width="%60" class="td_bg"><input type="text"
						class="form-control" name="coursename" id="coursename"
						placeholder="名称"></td>
				</tr>
				<tr>
					<td width="25%" align="center" class="td_bg">编号：</td>
					<td width="%60" class="td_bg"><input type="text"
						class="form-control" name="fnumber" placeholder="编号"></td>
				</tr>

				<tr>
					<td width="%15" align="center" class="td_bg">描述：</td>
					<td width="%85" class="td_bg"><textarea class="form-control"
							name="courseDescription" id="courseDescription" rows="3"></textarea></td>
				</tr>

				<tr>
					<td align="right" class="td_bg"><input type="reset"
						class="btn btn-default courseCancle" value="取消"></td>
					<td class="td_bg"><input type="button" value="提交"
						class="btn btn-default courseCommit"></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

