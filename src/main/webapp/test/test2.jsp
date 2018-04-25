

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="../pages/header.jsp"%>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2" style="background: gray; height: 400px"></div>
		<div class="span10" style="background: green; height: 400px"></div>
	</div>
</div>



<ul class="nav nav-tabs ">
	<li class="active"><a href="#">首页</a></li>
	<li>
		<ul class="nav nav-tabs">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Dropdown <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a tabindex="-1" href="#">Action</a></li>
					<li><a tabindex="-1" href="#">Another action</a></li>
					<li><a tabindex="-1" href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a tabindex="-1" href="#">Separated link</a></li>
				</ul></li>
		</ul>
	</li>
	<li>
		<ul class="nav nav-tabs">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Dropdown <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a tabindex="-1" href="#">Action</a></li>
					<li><a tabindex="-1" href="#">Another action</a></li>
					<li><a tabindex="-1" href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a tabindex="-1" href="#">Separated link</a></li>
				</ul></li>
		</ul>
	</li>

</ul>


<div class="tabbable tabs-left">
	<!-- Only required for left/right tabs -->

	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab1" data-toggle="tab">Section
				1</a></li>
		<li><a href="#tab2" data-toggle="tab">Section 2</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="tab1" style="width:100px">
			<ul class="nav nav-list">
				<li class="nav-header">List header</li>
				<li class="active"><a href="#">首页</a></li>
				<li><a href="#">Library</a></li>
			</ul>
		</div>
		<div class="tab-pane" id="tab2">
			<p>Howdy, I'm in Section 2.</p>
		</div>
	</div>
</div>

<div class="navbar">
	<div class="navbar-inner">
		<div class="container">

			<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>

			<!-- Be sure to leave the brand out there if you want it shown -->
			<a class="brand" href="#">Project name</a>

			<!-- Everything you want hidden at 940px or less, place within here -->
			<div class="nav-collapse collapse">
				<!-- .nav, .navbar-search, .navbar-form, etc -->
			</div>

		</div>
	</div>
</div>


<%@ include file="../pages/footer.jsp"%>
