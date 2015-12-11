package com.micmiu.mvc.ferriswheel.support.spring.mvc;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/18/2015
 * Time: 14:25
 */
public interface ControllerConstant {

	String KEY_DEFAULT_FILENAME = "export-data";
	String KEY_EXPORT_FILENAME = "export.filename";
	String KEY_EXPORT_SHEETNAME = "export.sheetname";
	String KEY_EXPORT_TITLE = "export.title";
	String KEY_EXPORT_COLUMN_MAP = "export.columnMap";
	String KEY_EXPORT_ROW_DATA = "export.rowData";
	String KEY_EXPORT_EXCEL_TOTAL = "export.excel.total";

	String RP_PARAM_CREATE = "method=create";
	String RP_PARAM_READ = "method=read";
	String RP_PARAM_UPDATE = "method=update";
	String RP_PARAM_DELETE = "method=delete";
	String RP_PARAM_SHOWLIST = "method=showList";

	String SHOWLIST_PAGE = "list";
	String SHOWFORM_PAGE = "form";
	String READ_PAGE = "view";

}
