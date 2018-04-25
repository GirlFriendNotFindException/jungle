 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="../pages/header.jsp"%>
 
  
    <head>  
        <title>Demo</title>  
        <script>  
            function getColumnDetail(column) {  
                column.style.color = "blue"; //将被点击的单元格设置为蓝色   
                alert(column.innerHTML); //弹出被点单元格里的内容   
            }  
         /*    <!--trLineNumber为动态表格行数，tdData为动态表格每行单元格的数据，数据类型为数组-->  */  
            function setTable(trLineNumber, tdData) {  
                var _table = document.getElementById("table");  
                var _row;  
                var _cell;  
                for(var i = 0; i < trLineNumber; i++) {  
                    _row = document.createElement("tr");  
                    document.getElementById("table").appendChild(_row);  
                    for(var j = 0; j < tdData.length; j++) {  
                        _cell = document.createElement("td");  
                        _cell.onclick = function() { getColumnDetail(this) }; //为每个单元格增加单击事件   
                        _cell.innerText = tdData[j];  
                        _row.appendChild(_cell);  
                    }  
  
                }  
            }         
        </script>  
    </head>  
  
    <body>  
        <label style="font-size:20px;width:600px;" onclick="setTable(1,['first','second','third']);">动态表格：</label><br/>  
        <table border="1">  
            <tbody id="table">  
        </table>  
    </body>  
  
</html> 