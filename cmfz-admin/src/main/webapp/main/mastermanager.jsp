<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#dg123').datagrid({
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
	    url:'/cmfz-admin/Master/query.do',
	    columns:[[    
	        {field:'masterId',title:'上师编号',width:80},
	        {field:'masterName',title:'上师姓名',width:80},
	        {field:'masterPhoto',title:'上师照片',width:80},
            {field:'masterSummary',title:'上师简介',width:80},

	        {field:"operation",title:"操作",width:40,formatter:function(value,row,index){
	        	//$("#del").linkbutton({});
				return "<a name='zz' class='easyui-linkbutton' data-options=\"height:20,iconCls:'icon-edit'\" onClick='updatebtn()'>修改</a> ";
			}},
	    ]],
        view:detailview,
        detailFormatter: function(rowIndex, rowData) {
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="/cmfz-admin-upload/' + rowData.masterPhoto + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '</td>' +
                '</tr></table>';
        },


            onLoadSuccess:function(){
	    	/* console.log(11);
	    	$(".btn").linkbutton({}); */
	    	//$.parser.parse();
                $("a[name='zz']").linkbutton({});

	    },
	    pagination:true,
	    pageList : [ 5, 10, 15, 20, 25 ],
		pageSize : 5,
		toolbar : "#tb1",
		fitColumns: true,
		singleSelect:true,
		
	});
	

	
	$("#addMaster").linkbutton({
		onClick:function(){
			$("#dialog_master").dialog({
				width:450,
				height:200,
				title:"新增上师",
				toolbar:[{
					iconCls:"icon-help",
					text:"help"
				}],
				href:"/cmfz-admin/main/form3.jsp",
				modal:true,
				buttons:[{
					iconCls:"icon-edit",
					text:"保存",
					handler:function(){
						//提交
						$("#ff3").form("submit",{
							url:"/cmfz-admin/Master/add.do",
							onSubmit:function(){
								return $("#ff3").form("validate");
							},
							success:function(res){
								if(res == "success"){
									$.messager.alert('提示','添加成功！');
									$("#dialog_master").dialog("close");
									$("#dg123").datagrid({
										url:"/cmfz-admin/Master/query.do",
									});
								}
							}
						}); 
					}
				},{
					iconCls:"icon-cancel",
					text:"取消",
					handler:function(){
						$.messager.show({
							title:"我的消息",
							msg:"对话框将要消失了",
							timeout:5000,
							showType:"slider",
						});
						
						$("#dialog_master").dialog("close");
					}
				}],
			});




			
		}
	});


    $("#addMaster1").linkbutton({


        onClick:function(){
            $("#dialog_master").dialog({
                width:450,
                height:200,
                title:"新增上师",
                toolbar:[{
                    iconCls:"icon-help",
                    text:"help"
                }],
                href:"/cmfz-admin/main/form5.jsp",
                modal:true,
                buttons:[{
                    iconCls:"icon-edit",
                    text:"保存",
                    handler:function(){
                        //提交
                        $("#ff_master").form("submit",{
                            url:"/cmfz-admin/Master/import.do",
                            success:function(res){
                                if(res == "success"){
                                    $.messager.alert('提示','添加成功！');
                                    $("#dialog_master").dialog("close");
                                    $("#dg123").datagrid({
                                        url:"/cmfz-admin/Master/query.do",
                                    });
                                }
                            }
                        });
                    }
                },{
                    iconCls:"icon-cancel",
                    text:"取消",
                    handler:function(){
                        $.messager.show({
                            title:"我的消息",
                            msg:"对话框将要消失了",
                            timeout:5000,
                            showType:"slider",
                        });

                        $("#dialog_master").dialog("close");
                    }
                }],
            });
        }
    });

    $("#exportMaster1").linkbutton({
        onClick:function () {
                window.location.href="/cmfz-admin/Master/download.do"
        }
    });

	


});

function updatebtn(){
        var rowData = $("#dg123").datagrid("getSelected");
            $("#dialog_master").dialog({
                width:450,
                height:200,
                title:"修改上师信息",
                toolbar:[{
                    iconCls:"icon-help",
                    text:"help"
                }],
                href:"/cmfz-admin/main/form4.jsp",
                modal:true,
                buttons:[{
                    iconCls:"icon-edit",
                    text:"保存",
                    handler:function(){
                        //提交
                        $("#ff4").form("submit",{
                            url:"/cmfz-admin/Master/update.do?masterId="+rowData.masterId,
                            onSubmit:function(){
                                return $("#ff4").form("validate");
                            },
                            success:function(res){
                                if(res == "success"){
                                    $.messager.alert('提示','修改成功！');
                                    $("#dialog_master").dialog("close");
                                    $("#dg123").datagrid({
                                        url:"/cmfz-admin/Master/query.do",
                                    });
                                }
                            }
                        });


                    }
                },{
                    iconCls:"icon-cancel",
                    text:"取消",
                    handler:function(){
                        $.messager.show({
                            title:"我的消息",
                            msg:"对话框将要消失了",
                            timeout:5000,
                            showType:"slider",
                        });

                        $("#dialog_master").dialog("close");
                    }
                }],
                onLoad:function(){
                    $("#ff4").form("load",rowData); //在加载表单时将行数据加载到表单元素中
                }
            });





}



function qq(value,name){
	if(name=="masterName"){
		$('#dg123').datagrid({
		    url:'/cmfz-admin/Master/query.do?masterName='+value,
		    
		}); 
	}
	if(name=="id"){
		$('#dg123').datagrid({
		    url:'/cmfz-admin/Master/query.do?id='+value,

		});
	}
}

</script>

<table id="dg123"></table>
<div id="tb1">
<a id="addMaster" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>
<a id="editUser" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
    <input id="ss" class="easyui-searchbox" style="width:300px"
           data-options="searcher:qq,prompt:'请输入要搜索的关键字',menu:'#mm'"></input>

    <div id="mm" style="width:120px">
        <div data-options="name:'masterName',iconCls:'icon-ok'">姓名</div>
    </div>

    <a id="addMaster1" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量插入'"></a>
    <a id="exportMaster1" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量插入'"></a>
</div>

<div id="dialog_master"></div>


