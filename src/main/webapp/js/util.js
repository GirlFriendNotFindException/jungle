
/**
 * 将表单序列化为josn 对象列表
 * @param element
 * @returns
 */
function formToJson(element) {
	var formdata = $("#" + element).serialize();
	var arr = formdata.split("&");
	var data = {};
	var json = [];
	for (var i = 0; i < arr.length; i++) {
		var key = arr[i].split("=")[0];
		var value = arr[i].split("=")[1];
		data[key] = value;
	}
	json.push(data);
	return JSON.stringify(json);
}


/* 使用正则表达式   除去空格 */
function myTrim(x) {
	return x.replace(/^\s+|\s+$/gm, '');
}


function sendRequest(url, jsondata, callback) {
	$.ajax({
		url : url,
		dataType : "json",
		type : "post",
		data : jsondata,
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			alert(data);
			//callback(data);
		}
	});
}


/**
 * @param url    
 * @param element  被序列化的表单的id
 */
function action_e(url, formElement) {
	var jsondata = formToJson(element);
	action_j(url, jsondata);
}


/**
 * 
 * @param url
 * @param jsondata   josn格式的数据  若后台mvc注入时的参数是list，则josn数据也应该是json对象列表:[{},  {}...]
 */
function action_j(url, jsondata) {
	sendRequest(url, jsondata);
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



/**
 * end  表格控件帮助类   ======================================================================
 */







/**
 * start  控制页面子模块显示和隐藏=================================================================
 * 
 */
function getAllSubMenu() {
	var arr = [ "addCmpt", "strategy" , "scoring"];
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
}

/**
 * end  控制页面子模块显示和隐藏=================================================================
 * 
 */
