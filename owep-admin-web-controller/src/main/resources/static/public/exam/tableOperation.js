/*预览试卷的方法(该方法只能在考试管理中试卷管理和考试汇总这两个页面使用
* e,value,row,index->bootstrap-table列中参数
* */
function detailedTestPaper(e,value,row,index){
    $('#modal_1 .testPaperName_1').val(row.testPaperName);
    row.state == "禁用" ? $('#modal_1 .state_1').attr("class", 'form-control state_1 text-danger') :
        $('#modal_1 .state_1').attr('class', 'form-control state_1 text-success');
    $('#modal_1 .state_1').val(row.state);
    if (row.adminPermissions == '0') {
        $('#modal_1 .adminPermissions_1').val("完全私有(只有您本人可以管理和使用该试卷)");
    } else {
        $('#modal_1 .adminPermissions_1').val("只读共享(其他管理员可以浏览和引用该试卷进行考试)");
    }
    $('#modal_1 .totalScore').val(row.totalScore + "分");
    $('#modal_1 .nameSection').text(row.nameSection);
    $('#modal_1 .questionBank').text(row.questionBank);
    $('#modal_1 .topic').text(row.topic);
    $('#modal_1 .difficulty').text(row.difficulty);
    $('#modal_1 .titleNumber').text(row.titleNumber);
    $('#modal_1 .singleTopicScore').text(row.singleTopicScore + "分");
    $('#modal_1').modal()

}
/*删除一条记录的方法(通用，使用案例在考试汇总中表删除操作)
* e,value,row,index->bootstrap-table列中参数
* url->ajax请求路径
* event->页面选择器
* */
function deleteRecord( e,value,row,index,url,event) {
    swal({
        title: '您确定要删除该信息吗？',
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "删除",
        closeOnConfirm: false
    }, function () {
        alert(row.id);
        let id = row.id;
        /* //发送ajax 删除
              $.ajax({
                  url: appName+"/book/deleteSelect.do?id="+id,
                  method: "get",
                  async: true,
                  data: delete_data,
                  dataType: "text",   //期望服务端返回的数据类型
                  contentType: "application/json",
                  success: function (data) {
                      console.log(data.toString());
                      swal("删除成功！", "您已经永久删除已选信息", "success");
                      //重新加载页面
                      window.location.reload();
                  },
                  error: function (jqXHR) {
                      swal("删除失败！", "未知错误", "error");
                  }
              });*/
        //根据Id字段删除对应的数据
        $(event).bootstrapTable('removeByUniqueId', id);

        swal("删除成功！", "您已经永久删除信息", "success");
    });
}
/*删除多条记录的方法(通用，使用案例在用户管理中表删除操作)
* url->ajax请求路径
* event->页面选择器
* */
function deleteAllRecords(url,event){
    let rows = $(event).bootstrapTable('getAllSelections');
    if (rows.length == 0){
        swal("至少选中一行！", "", "error");
        return false;
    }
    let delete_data = [];
    for (let i=0;i<rows.length;i++) {
        delete_data.push(rows[i].userName)
    }
    swal({
        title: "您确定要删除这"+delete_data.length+"条信息？",
        text: "删除后将无法恢复，请谨慎操作！",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "删除",
        closeOnConfirm: false
    }, function () {
        delete_data = JSON.stringify(rows);
        alert(delete_data);
        /* //发送ajax 删除
         $.ajax({
             url: appName+"/book/deleteSelect.do",
             method: "post",
             async: true,
             data: delete_data,
             dataType: "text",   //期望服务端返回的数据类型
             contentType: "application/json",
             success: function (data) {
                 console.log(data.toString());
                 swal("删除成功！", "您已经永久删除已选信息", "success");
                 //重新加载页面
                 window.location.reload();
             },
             error: function (jqXHR) {
                 swal("删除失败！", "未知错误", "error");
             }
         });*/
        //获取对象
        let ids = $.map(rows, function (row) {
            return row.id
        });
        //根据Id字段删除对应的数据
        $(event).bootstrapTable('remove', {field: 'id',values: ids });
        swal("删除成功！", "您已经永久删除已选信息", "success");
    });
}
/*导出记录的方法(通用，使用案例在用户管理中表记录导出操作)
* url->ajax请求路径
* title->提示信息
* format->转出文件名后缀名(可不填)
* */
function exportRecord(url,title,format) {
    format==null?format="EXCEL表格":format;
    swal({
        title: "确定要导出"+title+"吗？",
        text: "该操作将导出"+title+format+"，如果数据较多可能需要较长的时间。",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#1E90FF",
        confirmButtonText: "导出",
        closeOnConfirm: false
    }, function () {
        //ajax请求
        swal("导出成功！", "您已经永久导出信息", "success");
    });
}
/*创建最基本的bootstrap-table表格(通用，使用案例在考试汇总中表创建操作)*/
function createTable(event,url,toolbar,search,data,method) {
    $(event).bootstrapTable({
        url: url,       //请求后台的URL（*）
        method: method,                      //请求方式（*）
        toolbar: toolbar,                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: search,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端
        showSearchButton: true,
        searchAlign:"left",
        toolbarAlign: "right",
        searchFields: "customerBelongs",
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        columns: data
    });
}
/*回显表单中的数据(通用)*/