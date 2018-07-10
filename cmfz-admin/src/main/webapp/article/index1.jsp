<%@page pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor demo</title>

</head>
<body style="background-color: #b52b27;">


<form id="ffArticle" method="post" enctype="multipart/form-data">
    <br>
    <div style="margin-top: 35px;margin-left: 75px">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文章标题：<input class="easyui-textbox" data-options="label:'文章标题:'" name="articleName"/> <br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文章作者：<input id="cc" name="articleByName" value="aa"><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文章状态：<input name="articleStatus" class="easyui-switchbutton" data-options="onText:'上架',offText:'下架'"><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文章内容：<br><br>
        <input id="editValue" name="introduction" type="text" hidden="hidden">
        <div id="editor" style="width: 1000px;margin-left: 20px">
        </div>


        <br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a id="btn" onclick="addArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">创建文章</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a id="btnClear" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">重置</a>

    </div>
</form>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/Article/upload.do';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称

    editor.create();


    function addArticle() {
        var text=editor.txt.html();
        document.getElementById("editValue").value=text;
        $("#ffArticle").form("submit",{
            url:"${pageContext.request.contextPath}/Article/addArticle.do",
            success:function(res){
                if(res == "success"){
                    $.messager.show({
                        title:"提示",
                        msg:"上传成功！",
                        timeout:3000,
                        showType:"slider",
                    });
                    $("#ffArticle").form('reset');
                    editor.txt.html('<p><br></p>');
                }else{
                    $.messager.show({
                        title:"提示",
                        msg:"上传失败！",
                        timeout:3000,
                        showType:"slider",
                    });
                }
            }
        });
    }


    $(function () {
        $('#cc').combobox({
            url:'${pageContext.request.contextPath}/Article/findName.do',
            valueField:'masterId',
            textField:'masterName'
        });


    });

    function clearArticle(){
        $("#ffArticle").form('clear');
        editor.txt.html('<p><br></p>');
    }
</script>
</body>
</html>
