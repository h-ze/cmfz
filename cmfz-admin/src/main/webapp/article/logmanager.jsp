<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#dg_log').datagrid({
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
	    url:'/cmfz-admin/Log/query.do',
	    columns:[[    
	        {field:'logId',title:'id',width:40},
	        {field:'username',title:'username',width:40},
            {field:'time',title:'time',width:50
                /*formatter : function(value){
                    var date = new Date(value);
                    var y = date.getFullYear();
                    var m = date.getMonth() + 1;
                    var d = date.getDate();
                    var h = date.getHours();
                    var m1 =date.getMinutes();
                    var s = date.getSeconds();
                    if (m <10){
                        return y + '-' +"0"+m + '-' + d;
                    }

                    return y + '-' +m + '-' + d
                        ;
                }*/
            },
            {field:'resource',title:'resource',width:60},
            {field:'action',title:'action',width:30},
            {field:'message',title:'message',width:140},
            {field:'result',title:'result',width:30},
	        {field:"operation",title:"操作",width:40,formatter:function(value,row,index){
	        	//$("#del").linkbutton({});
				return "<a name='art1' class='easyui-linkbutton' data-options=\"height:20,iconCls:'icon-ok'\" onClick='show()'>文章详情</a>   ";
			}},
	    ]],


            onLoadSuccess:function(){
	    	/* console.log(11);
	    	$(".btn").linkbutton({}); */

                $("a[name='art1']").linkbutton({});
	    },
	    pagination:true,
	    pageList : [ 5, 10, 15, 20, 25 ],
		pageSize : 5,
		toolbar : "#tb_log",
		fitColumns: true,
		singleSelect:true,
		
	});
	





	


});








</script>

<table id="dg_log"></table>
<div id="tb_log">



</div>




