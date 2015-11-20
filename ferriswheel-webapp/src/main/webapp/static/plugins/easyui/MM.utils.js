var MM_utils = MM_utils || {
	version : '0.1',
	author : 'Michael',
	blog : 'www.micmiu.com'
}

MM_utils.baseWinAdd = function(paras) {
	MM_Ex.formWin(paras);
};

MM_utils.baseWinEdit = function(paras) {
	var _dg_id = paras.dg_id ? paras.dg_id : "#dg-list";
	var rows = $(_dg_id).datagrid('getSelections');
	if (rows == '' || rows.length > 1) {
		$.messager.alert('提示', '有且只能选中一条记录进行编辑', '提示');
		return;
	}
	var id = rows[0].id;
	paras.win_url = paras.win_url + '&id=' + id
	MM_Ex.formWin(paras);
};

MM_utils.baseGDDel = function(dg_id, del_url) {
	var rows = $(dg_id).datagrid('getSelections');
	if (rows == '' || rows.length == 0) {
		$.messager.alert('提示', '至少选中一条记录进行删除', '提示');
		return;
	}
	var ids = [];
	for ( var i = 0; i < rows.length; i++) {
		ids.push(rows[i].id);
	}
	var del_url_ids = del_url + '&ids=' + ids.join(',');

	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			$.post(del_url_ids, function(msg) {
				$.messager.alert('提示', msg, '提示');
				$(dg_id).datagrid('reload');
				$(dg_id).datagrid('clearSelections');
			});
		}
	});
};

MM_utils.baseExport = function(paras) {
	var _form_id = paras.form_id?paras.form_id:"#export-form";
	var _dg_id = paras.dg_id ? paras.dg_id : "#dg-list";
	var action_url = paras.actionURL;
	if(! action_url){
		return;
	}
	var rows = $(_dg_id).datagrid('getSelections');
	if (rows == '' || rows.length == 0) {
		 $(_form_id).attr("action",paras.actionURL+'&exportScope=all');
		 $(_form_id).submit();
	}else{
		var exportwin = $("<div></div>");
		var win_cfg={
				title:"export",
				collapsible:false,
				minimizable:false,
				maximizable:false,
				resizable:false,
				width:300,  
			    height:150,  
			    modal:true,
			    content:'<div style="MARGIN-RIGHT: auto; MARGIN-LEFT: auto;"><p><input type="radio" name="exportScope" value="select">Select <br><input type="radio" name="exportScope" value="all">ALL</p></div>'
		};
		$(exportwin).window(win_cfg);
		
		$(exportwin).find(":radio").click(function() {
			action_url+='&exportScope='+this.value;
			var ids = [];
			for ( var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}

			$(exportwin).window('close');
			$(_form_id).attr("action",action_url+ '&exportIDS=' + ids.join(','));
			$(_form_id).submit();
			$(exportwin).window('destroy');
		});
		
		$(exportwin).window('open');
			
		return false;
		
	}
};

MM_utils.formQuery = function(paras) {
	var paras = paras||{};
	var _dg_id = paras.dg_id?paras.dg_id:"#dg-list";
	var _form_id = paras.form_id?paras.form_id:"#query-form";
	var params = $(_dg_id).datagrid('options').queryParams; 
	var fields = $(_form_id).serializeArray();
	$.each(fields, function(i, field) {
		params[field.name] = field.value;
	});
	$(_dg_id).datagrid('reload'); 
};

MM_utils.formReset = function(paras) {
	var paras = paras||{};
	var _dg_id = paras.dg_id?paras.dg_id:"#dg-list";
	var _form_id = paras.form_id?paras.form_id:"#query-form";
	$(_form_id)[0].reset();
};

MM_utils.formQueryExport = function(paras) {
	var paras = paras||{};
	var _form_id = paras.form_id?paras.form_id:"#query-form";
	if(!paras.actionURL){
		return false;
	}
	 $(_form_id).attr("action",paras.actionURL);
	 $(_form_id).submit();
};

MM_utils.baseView = function(paras) {
	var _dg_id = paras.dg_id ? paras.dg_id : "#dg-list";
	var _pg_id = paras.p_id ? paras.pg_id : "#pg-view";
	var rows = $(_dg_id).datagrid('getSelections');
	if (rows == '' || rows.length > 1) {
		$.messager.alert('提示', '有且只能选中一条记录进行查看', '提示');
		return;
	}
	var id = rows[0].id;
	paras.win_url = paras.win_url + '&id=' + id;
	$(_pg_id).propertygrid({
	    url: paras.win_url,
	    showGroup: true,
	    scrollbarSize: 0
	});
	$('#main-layout').layout('expand','east');
};
