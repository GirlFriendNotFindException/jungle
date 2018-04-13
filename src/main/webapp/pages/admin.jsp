<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="header.jsp"%>


<script>
	

	/* 初始化  显示指定页面   事件 */
	$(function() {
		show('strategy');

		$(".plus").click(function() {
			addNullRow(getTBody("course_tbody"), 4);
		});

		$(".remove").click(function() {
			deleteRow(getTBody("course_tbody"), rowSelectedIndex);
		});
		
		$(".sign").click(function() {
			sendRequest("/jungle/admin/addCourse.action", JSON.stringify(getRows("course_table")), function(data){
				alert(data);	
			});
		});
		
		tabelEvent("course_table");
	});
</script>

<!-- admin -->
<div class="container">
	<div class="row">
		<div class="col-md-12" style="background: blue; height: 50px"></div>
		<!-- 菜单栏 -->
		<div class="col-md-3 bs-docs-sidebar">
			<ul class="nav nav-list bs-docs-sidenav affix">
				<li class=""><a href="javascript:void(0);" onclick=""><i
						class="icon-chevron-right"></i> 启动比赛</a></li>

				<li class=""><a href="javascript:void(0)"
					onclick="show('addCmpt')"><i class="icon-chevron-right"></i>
						比赛项目</a></li>

				<li class=""><a href="javascript:void(0)"
					onclick="show('strategy')"><i class="icon-chevron-right"></i>
						打分策略</a></li>

				<li class=""><a href="#gridSystem"><i
						class="icon-chevron-right"></i> 模版导出</a></li>

				<li class=""><a href="#gridSystem"><i
						class="icon-chevron-right"></i> 数据导入导出</a></li>

			</ul>
		</div>

		<!-- 功能模块    比赛项目录入-->
		<div class="col-md-9" id="addCmpt">
			<div class="row">
				<div class="col-md-9">
					<form id="cmpt_form" name="cmpt_form" method="post" class="form">
						<table width="70%" height="100px" border="0" align="center"
							cellpadding="2" cellspacing="1" class="result-tab">
							<tbody>
								<tr>
									<td width="25%" align="center" class="td_bg">名称：</td>
									<td width="%60" class="td_bg"><input type="text"
										class="form-control" placeholder="名称"></td>
								</tr>
								<tr>
									<td width="%10" align="center" class="td_bg">举办方：</td>
									<td width="%85" class="td_bg"><input type="text"
										class="form-control" placeholder="举办方"></td>
								</tr>
								<tr>
									<td width="%15" align="center" class="td_bg">举办地点：</td>
									<td width="%85" class="td_bg"><input type="text"
										class="form-control" placeholder="举办地点"></td>
								</tr>

								<tr>
									<td width="%15" align="center" class="td_bg">举办日期：</td>
									<td width="%85" class="td_bg"><input type="text"
										class="form-control" placeholder="举办日期"></td>
								</tr>

								<tr>
									<td width="%15" align="center" class="td_bg">描述：</td>
									<td width="%85" class="td_bg"><textarea
											class="form-control" rows="3"></textarea></td>
								</tr>

								<tr>
									<td align="right" class="td_bg"><input type="reset"
										name="submit2" id="button2" class="btn btn-default" value="重置"></td>
									<td class="td_bg"><input type="button" id="button"
										value="提交" class="btn btn-default"
										onclick="action_e('/jungle/addCompetition.action', 'cmpt_form' )"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>

		</div>


		<!-- 打分策略模块 -->
		<div class="col-md-9" id="strategy">
			<div class="row ">
				<div class="col-md-12" style="background: green; height: 50px">
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4" style="background: white; height: 50px; padding-top: 22px;">
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
						<div class="col-md-1" style="background: gray; height: 300px"></div>
						<div class="col-md-10">
							<table class="table table-bordered table-hover course_table"
								tabindex="1">
								<thead>
									<tr>
										<th width="10%"  id="num">#</th>
										<th width="30%"  id="name">打分项目</th>
										<th width="10%"  id="weight">权重</th>
										<th width="300%" id="description">计分规则描述</th>
									</tr>
								</thead>
								<tbody id="course_tbody">
								</tbody>
							</table>
						</div>
						<div class="col-md-1" style="background: gray; height: 300px"></div>
					</div>
				</div>
			</div>
		</div>
	
	</div>
</div>





<%@ include file="footer.jsp"%>


