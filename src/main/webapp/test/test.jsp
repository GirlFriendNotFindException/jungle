

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="../pages/header.jsp"%>

<script type="text/javascript">
	$('#datetimepicker').datetimepicker({
		format: "yyyy-mm-dd hh:ii",
	      autoclose: true,
	      todayBtn: true,
	      pickerPosition:"bottom-left"
	});
</script>


<body data-spy="scroll" data-target=".bs-docs-sidebar">

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container" style="width: 1170px">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="./index.html">Bootstrap</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class=""><a href="./index.html">首页</a></li>
						<li class=""><a href="./getting-started.html">评分</a></li>
						<li class="active"><a href="./scaffolding.html">评委信息</a></li>
						<li class=""><a href="./base-css.html">选手信息</a></li>
						<li class=""><a href="./components.html">得分记录</a></li>
						<li class=""><a href="./javascript.html">管理员</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<div class="container" style="width: 1170px">
		<div class="row">
			<div class="span3 bs-docs-sidebar">
				<ul class="nav nav-list bs-docs-sidenav affix">
					<li class=""><a href="#global"><i
							class="icon-chevron-right"></i> 录入</a></li>
					<li class="active"><a href="#gridSystem"><i
							class="icon-chevron-right"></i> 修改</a></li>
				</ul>
			</div>
			<div class="span9">
				<div class="bs-docs-example-table">
					<table class="table  table-bordered tab">
						<thead>
							<tr>
								<th>#</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Username</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
<div class="input-append date" id="datetimepicker" data-date="12-02-2012" >

   <input class="span2" size="16" type="text" value="12-02-2012">

   <span class="add-on"><i class="icon-th"></i></span>

</div>  


	<%@ include file="../pages/footer.jsp"%>