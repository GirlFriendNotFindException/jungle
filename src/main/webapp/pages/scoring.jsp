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
		
		$(".scoring_sign").click(function() {
			var data=getRows("scoring_table");
			var arr=[];
			
			$.each(data, function(key , val){
				val['cmpt_fid']=scoringContext.competition;
				//val['course']=val.cfid;
				val['judges']=$.parseJSON(localStorage.getItem('user')).username;
				val['compititor']=scoringContext[val.compititor];
			});
			sendRequest("/jungle/scoring/scoring.action", JSON.stringify(data), function( state ){
				if(state==null |  state==undefined) return;
				alert("提交成功!");
			});
		});

		
		$(".scoring_table").on('click', 'tr', function(e) {
			rowClick(e)
		});

		$(".scoring_table").on('dblclick', 'th', function(e) {
			cellDoubleClick(e)
		});

		$(".scoring_table").on('blur', 'input', function(e) {
			scoringoutfocus(e);
		});
		
		showCompetitorAndCourse();
		
	});
	
	
	
	var scoringContext={};
	var strategy={};
	
	
	function showCompetitorAndCourse(){
		
		var user=localStorage.getItem('user');
		if(user==null |  user==undefined)  { alert('请先登陆'); return ;}
		var userobj=$.parseJSON(user);
		
		var username=userobj.username;
		
		var param={judges:username};
		
		sendRequest("/jungle/scoring/findCompetitor.action", JSON.stringify(param), function(data){
			
			$.each(data, function(key ,  val){
				var index=0;
				if(index==0){
					$(".competitionname").html(val.competitionname+"评分");
					scoringContext['competition']=val.fnumber;
					index++;
				}
				strategy[val.cfid]=val.cweight;
				scoringContext[val.competitorname]=val.compititorfnumber;
				$(".scoring_table thead tr").append("<th width='18%' id='"+ val.cfid +"'>"+val.coursename+"</th>");
			});
			$(".scoring_table thead tr").append("<th width='18%' id='grade'> 最终得分  </th>");
			
			
			$.each(data, function(key ,  val){
				addNullRow(getTBody("scoring_tbody"), getColumn("scoring_table"));
			});
			
			var trs=$(".scoring_table tbody tr");
			var index=0;
			$.each(data, function(key ,  val){
				trs[index].children[0].textContent=index+1;
				trs[index].children[1].textContent=val.competitorname;
				index++;
			});
			
		});
	}
	
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
						<div class="col-md-9 competitionname"
							style="height: 50px; text-align: center; line-height: 50px; font-size: 20px; font-weight: bold;">
							评分页面
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
							<th width="10%" id="num">#</th>
							<th width="18%" id="compititor">参赛者</th>
							
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