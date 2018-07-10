<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8" />
<script type="text/javascript">
    $(function() {

    });

    function test() {
    }
</script>
<form id="ff1" method="post" enctype="multipart/form-data">
    <div style="margin-left: 100px;margin-top: 20px">
        轮播图描述：<input class="easyui-textbox" data-options="label:'轮播图描述:'" name="description"/> <br>
        轮播图状态：<select class="easyui-combobox"  name="picStatus">
        <option>未展示</option>
        <option>展示中</option>
    </select><br>
        上传轮播图：<input class="easyui-filebox" name="myFile">

    </div>


</form>