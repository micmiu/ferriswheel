/**
 * extend easyui comp
 * Author <a href="www.micmiu.com">Michael Sun</a>
 * contact: sjsky007@gmail.com
 */

var MM_Ex= MM_Ex || {
	version : '0.1',
	author : 'Michael',
	blog : 'www.micmiu.com'
}

/**
 * paras:{
 * 		win_id:
 * 		dg_id:
 * 		form_id:
 * 		w:
 * 		h:
 * 		title:
 * 		win_url:
 * 	}
 * 
 */
MM_Ex.formWin = function(paras) {
	var _win_id = paras.win_id?paras.win_id:"#form-win";
	var _dg_id = paras.dg_id?paras.dg_id:"#dg-list";
	var _form_id = paras.form_id?paras.form_id:"#input-form";
	var _w = paras.w?paras.w:600;
	var _h = paras.h?paras.h:300;
	var _title = paras.title?paras.title:$.i18n.prop('global.text.window');
	if(!$(_dg_id) || !$(_form_id)){
		$.messager.alert($.i18n.prop("global.text.tips"), $.i18n.prop('global.msg.error.param'), 'info');
		return;
	}
	$(_win_id).dialog({
		title : _title,
		width : _w,
		height : _h,
		modal : true,
		shadow : true,
		resizable : true,
		onOpen : function() {
			$(_win_id).dialog('refresh', paras.win_url);
		},
		buttons : [ {
			text : $.i18n.prop('global.text.ok'),
			iconCls : 'icon-ok',
			handler : function() {

				if(typeof beforeFormSubmit == 'function'){
					if (!beforeFormSubmit()) {
						return;
					}
				}
				var actionUrl = $(_form_id).attr("action");
				if(!$(_form_id).valid()){
					return;
				}
				$.post(actionUrl, $(_form_id).serializeArray(), function(msg) {
					$.messager.alert($.i18n.prop("global.text.tips"), msg, 'info');
					$(_win_id).dialog('close');
					$(_dg_id).datagrid('reload');
				});
			}
		}, {
			text : $.i18n.prop('global.text.cancel'),
			iconCls : 'icon-cancel',
			handler : function() {
				$(_win_id).dialog('close');
			}
		} ]
	});
};

MM_Ex.formWinView = function(paras) {
	var _win_id = paras.win_id?paras.win_id:"#form-win";
	var _dg_id = paras.dg_id?paras.dg_id:"#dg-list";
	var _form_id = paras.form_id?paras.form_id:"#input-form";
	var _w = paras.w?paras.w:600;
	var _h = paras.h?paras.h:300;
	var _title = paras.title?paras.title:$.i18n.prop('global.text.read');
	$(_win_id).dialog({
		title : _title,
		width : _w,
		height : _h,
		modal : true,
		shadow : true,
		resizable : true,
		onOpen : function() {
			$(_win_id).dialog('refresh', paras.win_url);
		},
		buttons : [ {
			text : $.i18n.prop('global.text.close'),
			iconCls : 'icon-cancel',
			handler : function() {
				$(_win_id).dialog('close');
			}
		} ]
	});
};