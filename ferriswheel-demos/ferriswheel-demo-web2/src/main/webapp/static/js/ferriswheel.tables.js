var ferriswheel = ferriswheel || {}
ferriswheel.def_crud_paras = {
    "method_read_json": "read4json",
    "method_page_json": "pageQuery",
    "mehtod_form": "showForm",
    "method_create_json": "create",
    "method_update_json": "update",
    "method_delete_json": "deleteBatch",
    "formID": "#table_form",
    "formID_update": "#table_update_form",
    "formID_create": "#table_create_form",
    "tableID": "#table_list",
    "modalID_form": "#formModal",
    "modalID_update": "#updateModal",
    "modalID_create": "#createModal",
    "modalID_view": "#viewModal"
}
ferriswheel.table_oSettings = {
    "bRetrieve": true,
    "bProcessing": true,
    "bServerSide": true,
    "fnServerParams": function (aoData) {
        $("tfoot input.search_val").each(function () {
            aoData.push({"name": this.name, "value": this.value});
        });
    },
    "aoColumnDefs": [{
        "aTargets": [0],
        "bSortable": false,
        "mRender": function (data, type, full) {
            return '<input type="checkbox" name="ids" value="' + full.id + '">';
        }
    }, {
        "aTargets": [-1],
        "bSortable": false,
        "mRender": function (data, type, full) {
            var id = full.id;
            return '<a class="btn btn-default" href="javascript:ferriswheel.tableShowView(crud_paras,' + id + ')"><span class="glyphicon glyphicon-eye-open"></span></a>'
                + '<a class="btn btn-default" href="javascript:ferriswheel.tableShowUpdate(crud_paras,' + id + ')"><span class="glyphicon glyphicon-edit"></span></a>'
                + '<a class="btn btn-default" href="javascript:ferriswheel.tableDelete(crud_paras,' + id + ')"><span class="glyphicon glyphicon-remove"></span></i></a>';
        }
    }
    ],
    "sDom": "<'row-fluid'<'span12'f>r>t<'row-fluid'<'span12'li><'span12 center'p>>",
    //"sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span12'i><'span12 center'p>>",
    //"sDom": "<'row-fluid'<'span12'f>r>t<'row-fluid'<'span6'l><'span6'i><'span12 center'p>>",
    "sPaginationType": "bootstrap",
    "oLanguage": {
        "sLengthMenu": "_MENU_ records per page"
    }
}

ferriswheel.setViewPageValue = function (_url, _data) {
    $.ajax({
        type: "post",
        url: _url,
        data: _data,
        dataType: "json",
        success: function (jsondata) {
            $("#viewModal .modal-body .control-label").each(
                function () {
                    var prop = $(this).attr('for');
                    $(this).next('div').html(jsondata[prop]);
                }
            );
            $('#viewModal').modal({show: true});
        }
    });
}

ferriswheel.setFormPageValue = function (_url, _data) {
    $.ajax({
        type: "post",
        url: _url,
        data: _data,
        dataType: "json",
        success: function (jsondata) {
            if (jsondata == null) {
                return;
            }
            $("#formModal form :input").each(
                function () {
                    var val = jsondata[$(this).attr('name')];
                    var htmlType = $(this).attr("type");
                    if (htmlType == "text" || htmlType == "textarea"
                        || htmlType == "select-one"
                        || htmlType == "hidden"
                        || htmlType == "button") {
                        $(this).val(val);
                    } else if (htmlType == "radio") {
                        $(this).attr("checked", $(this).val() == val);
                    } else if (htmlType == "checkbox") {
                        var vals = val.split(",");
                        for (var i = 0; i < vals.length; i++) {
                            $(this).attr("checked",
                                $(this).val() == val);
                        }
                    }
                });
            $('#formModal').modal({
                show: true
            });
        }
    });
}

ferriswheel.tableDoDelete = function (_url, _paras) {
    $.post(_url, _paras, function (data) {
        alert(data)
    });
}
ferriswheel.setFormValue = function (_name, _val) {
    if (_val != "") {
        var htmlType = $("[name='" + _name + "']").attr("type");
        if (htmlType == "text" || htmlType == "textarea" || htmlType == "select-one" || htmlType == "hidden" || htmlType == "button") {
            $("[name='" + _name + "']").val(val);
        } else if (htmlType == "radio") {
            $("input[type=radio][name='" + _name + "'][value='" + _val + "']").attr("checked", true);
        } else if (htmlType == "checkbox") {
            var vals = _val.split(",");
            for (var i = 0; i < vals.length; i++) {
                $("input[type=checkbox][name='" + _name + "'][value='" + vals[i] + "']").attr("checked", true);
            }
        }
    }
};

ferriswheel.tableShowView = function (_paras, _id) {
    $.ajax({
        type: "post",
        url: _paras["baseURL"],
        data: {
            'method': _paras["method_read_json"],
            'id': _id
        },
        dataType: "json",
        success: function (jsondata) {
            if (jsondata == null) {
                return;
            }
            $(_paras['modalID_view'] + " .modal-body .control-label").each(
                function () {
                    var prop = $(this).attr('for');
                    $(this).next('div').html(jsondata[prop]);
                }
            );
            $(_paras['modalID_view']).modal({show: true});
        }
    });
}

ferriswheel.tableShowUpdate = function (_paras, _id) {
    // $("#formModal form").get(0).action = blogurl + '?method=update';
    $(_paras['formID_update']).attr("action", _paras["baseURL"] + '?method=' + _paras["method_update_json"])
    $.ajax({
        type: "post",
        url: _paras["baseURL"],
        data: {
            'method': _paras["method_read_json"],
            'id': _id
        },
        dataType: "json",
        success: function (jsondata) {
            if (jsondata == null) {
                return;
            }
            $(_paras['modalID_update'] + " :input").each(
                function () {
                    //var val = jsondata[$(this).attr('name')];
                    //fix issue:嵌套json属性取值
                    var val = eval('jsondata.' + $(this).attr('name'));
                    var htmlType = $(this).attr("type");
                    if (htmlType == "text" || htmlType == "textarea"
                        || htmlType == "select-one"
                        || htmlType == "hidden"
                        || htmlType == "button") {
                        $(this).val(val);
                        if($(this).hasClass('datepicker')){
                            $(this).datepicker('update', val);
                        }
                    } else if (htmlType == "radio") {
                        $(this).attr("checked", $(this).val() == val);
                    } else if (htmlType == "checkbox") {
                        var vals = val.split(",");
                        for (var i = 0; i < vals.length; i++) {
                            $(this).attr("checked",
                                $(this).val() == val);
                        }
                    }
                });
            $(_paras['modalID_update'] + " select").each(
                function () {
                    var val = jsondata[$(this).attr('name')];
                    $(this).val(val)
                }
            );
            $(_paras['modalID_update']).modal({
                show: true
            });
        }
    });

}

ferriswheel.tableShowCreate = function (_paras) {
    var modal_form = $(_paras['formID_create']);
    modal_form.attr("action", _paras["baseURL"] + '?method=' + _paras["method_create_json"])
    // $(_paras['formID_create']+" :input").each(function() {$(this).val('');});
    modal_form.each(function () {
        this.reset();
    });
    if (typeof _validator_create != "undefined") {
        _validator_create.resetForm();
    }
    $(_paras['modalID_create']).modal({
        show: true
    });
}

ferriswheel.tableDelete = function (_paras, _id) {
    var param = {
        "method": _paras['method_delete_json'],
        "ids": _id
    }
    $.post(_paras["baseURL"], param, function (data) {
        alert(data)
    });
    $(_paras["tableID"]).dataTable().fnReloadAjax();
}

ferriswheel.tableFormModalOK = function (_paras) {
    // var modal_form = $($("#formModal form").get(0));
    var modal_form = $(_paras['formID']);
    $.post(modal_form.attr('action'), modal_form.serializeArray(), function (data) {
        alert(data);
        $(_paras['modalID_form']).modal('hide');
        $(_paras["tableID"]).dataTable().fnReloadAjax();
    });
}

ferriswheel.tableUpdateFormModalOK = function (_paras) {
    if (typeof myselfUpdateSubmit == "function") {
        myselfUpdateSubmit();
    } else {
        var modal_form = $(_paras['formID_update']);
        if (modal_form.valid()) {
            $.post(modal_form.attr('action'), modal_form.serializeArray(), function (data) {
                alert(data);
                $(_paras['modalID_update']).modal('hide');
                $(_paras["tableID"]).dataTable().fnReloadAjax();
            });
        }
    }
}

ferriswheel.tableCreateFormModalOK = function (_paras) {
    if (typeof myselfCreateSubmit == "function") {
        myselfCreateSubmit();
    } else {
        var modal_form = $(_paras['formID_create']);
        console.info($(_paras['formID_create']));
        if (modal_form.valid()) {
            $.post(modal_form.attr('action'), modal_form.serializeArray(), function (data) {
                alert(data);
                $(_paras['modalID_create']).modal('hide');
                $(_paras["tableID"]).dataTable().fnReloadAjax();
            });
        }
    }

}

