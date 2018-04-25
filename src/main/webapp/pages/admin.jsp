<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="header.jsp"%>

<script type="text/javascript">
$(function(){
	refreshComptition();

	refreshCourse();
	
	
	$(".selectCompetition").click(function(e) {
		var target=e.target;
		$("#competitiontext").html(target.textContent);
		$("#competitionFnumber").html(target.id);
	});
	
	$(".selectCourse").click(function(e) {
		var target=e.target;
		$("#coursetext").html(target.textContent);
		$("#courseFnumber").html(target.id);
	});

});
</script>


<!-- admin -->
<div class="container">
	<div class="row">
		<div class="col-md-12" style="background: ; height: 50px">
			<div class="col-md-7"></div>
			<div class="col-md-1 ">
						<button
							class="btn btn-default dropdown-toggle selectCompetitionBtn"
							type="button" id="competition" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<span id="competitiontext">请选择赛事</span> <span
								id="competitionFnumber" style="display: none"></span> <span
								class="caret"></span>
						</button>
						<ul class="dropdown-menu selectCompetition"
							aria-labelledby="dropdownMenu2">

						</ul>
					</div>
					<div class="col-md-4">
						<button class="btn btn-default dropdown-toggle selectCourseBtn"
							type="button" id="course" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<span id="coursetext">选择策略 </span> <span id="courseFnumber"
								style="display: none"></span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu selectCourse"
							aria-labelledby="dropdownMenu2">
						</ul>
					</div>
		</div>
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
						
				<li class=""><a href="javascript:void(0)"
					onclick="initJudgesPage()"><i class="icon-chevron-right"></i>
						评委录入</a></li>
						
				<li class=""><a href="javascript:void(0)"
					onclick="initCompetitorPage()"><i class="icon-chevron-right"></i>
						参赛者录入</a></li>

				<li class=""><a href="#gridSystem"><i
						class="icon-chevron-right"></i> 模版导出</a></li>

				<li class=""><a href="#gridSystem"><i
						class="icon-chevron-right"></i> 数据导入导出</a></li>

			</ul>
		</div>

		

	

<%@ include file="competition.jsp"%>

<%@ include file="course.jsp"%>

<%@ include file="judges.jsp"%>

<%@ include file="competitor.jsp"%>


	
	</div>
</div>


<%@ include file="footer.jsp"%>


