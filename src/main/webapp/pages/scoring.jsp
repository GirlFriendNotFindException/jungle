<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="header.jsp"%>


<script>
	

	/* 初始化  显示指定页面   事件 */
	$(function() {
		show('scoring');

		$(".scoring_plus").click(function() {
			addNullRow(getTBody("scoring_tbody"), getColumn("scoring_table"));
		});

		$(".scoring_remove").click(function() {
			deleteRow(getTBody("scoring_tbody"), rowSelectedIndex);
		});

		
		tabelEvent("scoring_table");
		
		
		
		
	});
</script>


<div class="container">
	<div class="row">
		<div class="col-md-12" style="background: ; height: 50px"></div>
		<!-- 菜单栏 -->
		<div class="col-md-3 bs-docs-sidebar">
			<ul class="nav nav-list bs-docs-sidenav affix">
				<li class=""><a href="javascript:void(0);" onclick=""><i
						class="icon-chevron-right"></i> 打分</a></li>



			</ul>
		</div>




		<!-- 打分界面 -->
		<div class="col-md-9" id="scoring">
			<div class="row">
				<div class="col-md-12" style="height: 50px">
					<div class="row">
						<div class="col-md-9"
							style="height: 50px; text-align: center; line-height: 50px; font-size: 20px; font-weight: bold;">
							演讲比赛评分
						</div>
						<div class="col-md-3"
							style="background: white; height: 50px; padding-top: 22px;">
							<button type="button" class="btn btn-primary scoring_plus">
								<span class="glyphicon glyphicon-plus"></span>
							</button>

							<button type="button" class="btn btn-primary scoring_edit">
								<span class="glyphicon glyphicon-edit "></span>
							</button>

							<button type="button" class="btn btn-primary scoring_remove">
								<span class="glyphicon glyphicon-remove"></span>
							</button>

							<button type="button" class="btn btn-primary scoring_sign">
								<span class="glyphicon glyphicon-ok-sign"></span>
							</button>

						</div>
					</div>
				</div>
			</div>
			<!-- <div class="col-md-1"  style="background: gray;  height:300px"></div> -->
			
			<div class="col-md-12">
				<table class="table table-bordered table-hover scoring_table"
					tabindex="1">
					<thead>
						<tr>
							<th>#</th>
							<th>参赛者</th>
							<th>计分项1</th>
							<th>计分项2</th>
							<th>最终得分</th>
						</tr>
					</thead>
					<tbody id="scoring_tbody">
					</tbody>
				</table>
			</div>

			<!-- <div class="col-md-2"  style="background: gray; height:300px"></div> -->
		</div>
	</div>
</div>




<%@ include file="footer.jsp"%>