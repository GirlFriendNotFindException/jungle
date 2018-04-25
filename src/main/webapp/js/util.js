
/**
 * 将表单序列化为josn 对象列表
 * @param element
 * @returns
 */
function formToJson(elementID) {
	var arr=getFormData(elementID);
	addCreatorAndCreateDate(arr);
	return JSON.stringify(arr);
}

function getFormData(elementID){
	var formdata = $("#" + elementID).serialize();
	formdata=decodeURIComponent(formdata,true)
	var arr = formdata.split("&");
	var data = {};
	var arr1 = [];
	for (var i = 0; i < arr.length; i++) {
		var key = arr[i].split("=")[0];
		var value = arr[i].split("=")[1];
		data[key] = value;
	}
	arr1.push(data);
	return arr1;
}


/* 使用正则表达式   除去空格 */
function myTrim(x) {
	return x.replace(/^\s+|\s+$/gm, '');
}

/**
 * 发送ajax请求
 * @param url
 * @param jsondata
 * @param callback
 */
function sendRequest(url, jsondata, callback) {
	$.ajax({
		url : url,
		dataType : "json",
		type : "post",
		data : jsondata,
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			callback(data);
		}
	});
}


function getCreator(){
	var user=localStorage.getItem("user");
	var userobj=$.parseJSON( user );
	if(userobj!=null &&  userobj!=undefined){
		return userobj.username;
	}
	return "defaultuser";
}


function getCreatedate(){
	var date=new Date();
	return date;
}






/**
 * start  表格控件帮助类   ======================================================================
 */
var rowSelectedIndex=1;   /* 被选中行的索引 */
var oldrow;            	  /* 之前被选中的行对象 */
var rowCount=0;           /* 总的行数 */



/* cell 双击事件 */
function cellDoubleClick( e ){
	  var _cell=e.target;
	  var tdvalue=_cell.textContent;
	  _cell.textContent="";
	  if(_cell.firstChild==null  ||  _cell.firstChild.localName!="input"){
		  $("#"+_cell.id).append("<input id='tempinput"+ _cell.id +"' type='text' value='"+tdvalue+"' />");
		 // $("#tempinput"+_cell.id ).css({"width":"150px", "height":"28px"});
		  $("#tempinput"+_cell.id ).focus();
	  }
}

/* 行点击事件     row   之前被选择的row对象*/
function rowClick( e  ){
	if(e.target.localName=="th"){
		var _row=e.target.parentNode;
		if(oldrow!=undefined){
			oldrow.style.background="";
		}
		var id=_row.id;
		rowSelectedIndex=id.replace("tr_", "");
		oldrow=_row;
		_row.style.background="gray";
	}
	
}

/**
 * 失去焦点事件  将input.value  赋值给单元格   并删除input
 * @param _cell
 */
function outFocus( e ){
	if(e.target.loaclName="input"){
		var input=e.target;
		input.parentNode.textContent=$("#"+input.id ).val();
		$("#"+input.id ).remove();
	}
}

/* 增加空行 */
function addNullRow(table, colNum ){
	rowCount++;
	var _row=document.createElement("tr");
	_row.id="tr_"+rowCount;
	table.append(_row);
	for(var i=0; i<colNum; i++){
		var  _cell=document.createElement("th");
		_cell.id="th_"+rowCount+"_"+i;
		if(i==0) _cell.textContent=rowCount;
		//_row.append(_cell);
		$("#tr_"+rowCount).append(_cell);
	}
}



/* 新增一行并注入数据 */
function addRow(table, jsondata ){
	
}

function getRow( table,  rowIndex ){
	var arr=getRows(table );
	for(var i=0; i<arr.length; i++){
		if(rowIndex==  arr[i][0]){
			return arr[i];
		}
	}
	return null;
}

/**
 * 将指定的表格中的数据取出  包装成对象数组
 * @param tableClassName
 * @returns {Array}  对象数组
 */
function getRows(tableClassName ){
	var table=[];
	var trs=$("."+tableClassName +" tbody tr");  //数组
	if(trs==null  |  trs==undefined)  return ;
	var colID=getHead(tableClassName);
	if(colID==null  |  colID==undefined  | colID.length<=0)  return ;
	
	for(var i=0; i<trs.length; i++ ){
		var tr=trs[i];
		var row={};
		for(var j=0; j<tr.children.length; j++){
			var th=tr.children[j];
			var value=th.textContent;
			row[colID[j]]=value;
		}
		table.push(row);
	}
	return table;
}

/**
 * 
 * @param table
 * @returns {Array}
 */
function getHead(tableClassName){
	var arr=[];
	var ths=$("."+tableClassName +" thead tr th");
	if(ths==null  ||  ths==undefined)  return ;
	for(var i=0; i<ths.length; i++){
		arr.push(ths[i].id);
	}
	return arr;
}



function getTBody( tbodyID  ){
	return $("#"+tbodyID);
}


function getColumn(tableClassName){
	return  ths=$("."+tableClassName +" thead tr th").length;
}

/* 打分策略模块表格删除row事件 */
function  deleteRow(table, rowIndex){
	$("#tr_"+rowIndex).remove();
	//rowCount--;
}

/**
 * 给表格添加监听事件
 * @param tableClassName
 */
function tabelEvent( tableClassName ){
	/* 事件父委托模式 */
	$("."+ tableClassName).on('click', 'tr', function(e) {
		rowClick(e)
	});

	$("."+ tableClassName).on('dblclick', 'th', function(e) {
		cellDoubleClick(e)
	})

	$("."+ tableClassName).on('blur', 'input', function(e) {
		outFocus(e)
	})
}

/*  给表格信息追加创建者  和  创建时间*/
function addCreatorAndCreateDate( tbldata ){
	var creator=getCreator();
	var createdate=getCreatedate();
	$.each(tbldata, function(key, val){
		val['creator']=creator;
		val['createdate']=createdate;
	});
}

/*给fnumber字段添加前缀*/
function addFnumberPrefix(data, prefix, field){
	$.each(data, function(key , val){
		val[field]=prefix+"&"+val[field]
	});
}


/**
 * end  表格控件帮助类   ======================================================================
 */







/**
 * start  控制页面子模块显示和隐藏=================================================================
 * 
 */
function getAllSubMenu() {
	var arr = [ "addCmpt", "strategy" , "scoring", "judges" ,  "competitor", "strategyname"];
	return arr;
}

/* 隐藏除该参数模块的其他模块 */
function hidden(element) {
	var subMenu = getAllSubMenu();
	for (var i = 0; i < subMenu.length; i++) {
		if (subMenu[i] != myTrim(element)) {
			$("#" + subMenu[i]).hide();
		}
	}
}

/* 隐藏其他模块  显示指定模块 */
function show(element) {
	hidden(element);
	$("#" + element).show();
	if(element=='judges' |  element=='competitor'){
		$(".selectCompetitionBtn").show();
		$(".selectCourseBtn").show();
	}else{
		$(".selectCompetitionBtn").hide();
		$(".selectCourseBtn").hide();
	}
	
}

/**
 * end  控制页面子模块显示和隐藏=================================================================
 * 
 */




/**
 * start 评分模块
 * 
 */

/*  显示参赛者以及打分策略数据  */
function showCmptorAndCourse( data  ){
	
}

/*  从后台得到参赛者以及打分策略数据  */
function getData(){
	
}



/**
 * end 评分模块
 * 
 */


/**
 * start 添加评委
 * 
 * */





var competitorOpt={};
var courseOp={};

function initJudgesPage(){
	show('judges');
	
}

function initCompetitorPage(){
	show('competitor');
}

function refreshComptition(){
	var arr=$(".selectCompetition li").remove();
	findCompetition();
}

function refreshCourse(){
	var arr=$(".selectCourse li").remove();
	findCourse();
}

/*返回name  fid    fnumber*/
function findCompetition(){
	var param={"creator":"archer"};
	
	sendRequest("/jungle/admin/findCompetitionByCreator.action", JSON.stringify(param), function(data){
		var arr=$(".selectCompetition");
		var index=0;
		$.each(data, function(key, val){
			arr.append("<li><a id='"+ key +"'>"+ val.name +"</a></li>");
			if(index==0){
				$("#competitiontext").html(val.name);
				$("#competitionFnumber").html(key);
				competitorOpt['competitiontext']=val.name;
				competitorOpt['competitionFnumber']=key;
				index++;
			}
		});
		
	});
}

/*返回name      fnumber*/
function findCourse(){
	var param={"creator":"archer"};
	sendRequest("/jungle/admin/findCourseByCreator.action", JSON.stringify(param), function(data){
		var arr=$(".selectCourse");
		var index=0;
		$.each(data, function(key, val){
			arr.append("<li><a id='"+ key +"'>"+ val.coursename +"</a></li>");
			if(index==0){
				$("#coursetext").html(val.coursename);
				$("#courseFnumber").html(key);
				courseOp['competitiontext']=val.coursename;
				courseOp['competitionFnumber']=key;
				index++;
			}
		});	
	});
}


/**
 * end 添加评委
 * 
 */


