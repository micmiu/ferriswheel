if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '페이지';
	$.fn.pagination.defaults.afterPageText = '으로 {pages}';
	$.fn.pagination.defaults.displayMsg = '표시 {from} 에 {to} 으로 {total} 상품';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '처리중인 기다려주세요。。。';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '결정';
	$.messager.defaults.cancel = '취소';
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = '입력 항목을 잃게됩니다 결정';
	$.fn.validatebox.defaults.rules.email.message = '유효한 이메일 주소를 입력 해주십시오';
	$.fn.validatebox.defaults.rules.url.message = '유효한 URL 주소를 입력 해주십시오';
	$.fn.validatebox.defaults.rules.length.message = '입력 길이는 {0} 사이 여야합니다 {1}';
	$.fn.validatebox.defaults.rules.remote.message = '필드를 수정하십시오';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '입력 항목을 잃게됩니다';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '입력 항목을 잃게됩니다';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '입력 항목을 잃게됩니다';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '입력 항목을 잃게됩니다';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'];
	$.fn.calendar.defaults.months = ['일월','이월','삼월','사월','오월','유월','칠월','팔월','구월','시월','십일월','십이월'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '오늘';
	$.fn.datebox.defaults.closeText = '가까운';
	$.fn.datebox.defaults.okText = '결정';
	$.fn.datebox.defaults.missingMessage = '입력 항목을 잃게됩니다';
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	};
	$.fn.datebox.defaults.parser = function(s){
		if (!s) return new Date();
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	};
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}
