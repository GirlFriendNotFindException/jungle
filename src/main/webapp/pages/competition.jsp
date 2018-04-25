<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<script>
	$(function(){
		$("#competitonCommit").click(function(){
			
			var jsondata = formToJson("cmpt_form");
			
			sendRequest("/jungle/admin/addCompetition.action", jsondata, function(data){
				alert(data);
			});
			
			refreshComptition();
			
		});
	});
</script>

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
										class="form-control"  name="name"  id="name"  placeholder="名称"></td>
								</tr>
								<tr>
									<td width="25%" align="center" class="td_bg">编号：</td>
									<td width="%60" class="td_bg"><input type="text"
										class="form-control"  name="fnumber"  id="fnumber" placeholder="编号"></td>
								</tr>
								<tr>
									<td width="%10" align="center" class="td_bg">举办方：</td>
									<td width="%85" class="td_bg"><input type="text"
										class="form-control" name="organizers"  id="organizers"  placeholder="举办方"></td>
								</tr>
								<tr>
									<td width="%15" align="center" class="td_bg">举办地点：</td>
									<td width="%85" class="td_bg"><input type="text"
										class="form-control" name="venue"  id="venue"  placeholder="举办地点"></td>
								</tr>

								<tr>
									<td width="%15" align="center" class="td_bg">举办日期：</td>
									<td width="%85" class="td_bg"><input type="text"
										class="form-control" name="date"  id="date"  placeholder="举办日期"></td>
								</tr>
								
								
								<tr>
									<td width="%15" align="center" class="td_bg">比赛状态：</td>
									<td width="%85" class="td_bg"><select id="state" name="state">
										<option  value="0">未开始</option>
									</select></td>
								</tr>

								<tr>
									<td width="%15" align="center" class="td_bg">描述：</td>
									<td width="%85" class="td_bg"><textarea
											class="form-control" name="description"  id="description"   rows="3"></textarea></td>
								</tr>

								<tr>
									<td align="right" class="td_bg"><input type="reset"
										name="submit2" id="button2" class="btn btn-default" value="重置"></td>
									<td class="td_bg"><input type="button" id="competitonCommit"
										value="提交" class="btn btn-default" ></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>

		</div>




