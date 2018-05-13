<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="header.jsp"%>


<script>
	

	/* 初始化  显示指定页面   事件 */
	$(function() {
		

		$(".record_plus").click(function() {
			addNullRow(getTBody("record_tbody"), getColumn("record_table"));
		});

		$(".record_remove").click(function() {
			deleteRow(getTBody("record_tbody"), rowSelectedIndex);
		});
		
		$(".record_sign").click(function() {
			
		});

		
		tabelEvent("record_table");
		
		showCompetitorAndCourse();
		
	});
	
	
	
	var recordContext={};
	var strategy={};
	
	
	function showCompetitorAndCourse(){
		
		var user=localStorage.getItem('user');
		if(user==null |  user==undefined)  { alert('请先登陆'); return ;}
		var userobj=$.parseJSON(user);
		
		var username=userobj.username;
		
		var param={judges:username};
		
		sendRequest("/jungle/record/show.action", JSON.stringify(param), function(data){
			
			var index=1;
			$.each(data, function(key, val){
				addNullRow(getTBody("record_tbody"), getColumn("record_table"));
				
			});
			insertDatatoRow("record_table", data)
			
			
		});
	}
	
	function insertDatatoRow(tablecalssname, data){
		var trs=$("."+tablecalssname +" tbody tr");
		var i=0, j=1;
		$.each(data, function(key ,  val){
			for(var tmp in val ){
				if(tmp=="competitionname"){ 
					$(".competitionname").html(val[tmp]+"得分记录")
					continue;	
				}
				trs[i].children[j].textContent=val[tmp];
				j++;
			}
			i++;
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
						class="icon-chevron-right"></i> 得分记录展示分</a></li>



			</ul>
		</div>




		<!-- 打分界面 -->
		<div class="col-md-9" id="record">
			<div class="row">
				<div class="col-md-12" style="height: 50px">
					<div class="row">
						<div class="col-md-9 competitionname"
							style="height: 50px; text-align: center; line-height: 50px; font-size: 20px; font-weight: bold;">
							得分记录
						</div>
						<div class="col-md-3"
							style="background: white; height: 50px; padding-top: 22px;">
							<button type="button" class="btn btn-primary record_plus">
								<span class="glyphicon glyphicon-plus"></span>
							</button>

							<button type="button" class="btn btn-primary record_edit">
								<span class="glyphicon glyphicon-edit "></span>
							</button>

							<button type="button" class="btn btn-primary record_remove">
								<span class="glyphicon glyphicon-remove"></span>
							</button>

							<button type="button" class="btn btn-primary record_sign">
								<span class="glyphicon glyphicon-ok-sign"></span>
							</button>

						</div>
					</div>
				</div>
			</div>
			<!-- <div class="col-md-1"  style="background: gray;  height:300px"></div> -->
			
			<div class="col-md-12">
				<table class="table table-bordered table-hover record_table"
					tabindex="1">
					<thead>
						<tr>
							<th width="10%" id="num">#</th>
							<th width="18%" id="compititorname">参赛者姓名</th>
							<th width="18%" id="compititorfnumber">参赛者比编号</th>
							<th width="18%" id="endgrade">最终得分</th>
						</tr>
					</thead>
					<tbody id="record_tbody">
					</tbody>
				</table>
			</div>

			<!-- <div class="col-md-2"  style="background: gray; height:300px"></div> -->
		</div>
	</div>
</div>




<%@ include file="footer.jsp"%>