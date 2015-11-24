package com.micmiu.mvc.ferriswheel.support.spring.mvc.views;

import com.micmiu.mvc.ferriswheel.support.spring.mvc.ControllerConstant;
import com.micmiu.mvc.ferriswheel.utils.ReflectionUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * POI实现导出Excel
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class PoiExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
									  HSSFWorkbook workbook, HttpServletRequest request,
									  HttpServletResponse response) throws Exception {
		String fileName = FileNameUtils.formatFileName(".xls", model.get(ControllerConstant.KEY_EXPORT_FILENAME) + "",
				ControllerConstant.KEY_DEFAULT_FILENAME);
		if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		String sheetName = null == model.get(ControllerConstant.KEY_EXPORT_SHEETNAME) ? "info"
				: model.get(ControllerConstant.KEY_EXPORT_SHEETNAME) + "";
		Map<String, String> showMap = (LinkedHashMap<String, String>) model
				.get(ControllerConstant.KEY_EXPORT_COLUMN_MAP);
		// 产生Excel表头
		HSSFSheet sheet = workbook.createSheet(sheetName);
		int rowIndex = 0;
		HSSFRow header = sheet.createRow(rowIndex++); // 第0行
		// 产生标题列
		int columnIndex = 0;
		for (Map.Entry<String, String> entry : showMap.entrySet()) {
			header.createCell(columnIndex++).setCellValue(entry.getValue());
		}
		List<Object> dataList = (List<Object>) model.get(ControllerConstant.KEY_EXPORT_ROW_DATA);
		// 填充数据
		for (Object data : dataList) {
			HSSFRow row = sheet.createRow(rowIndex++);
			columnIndex = 0;
			for (Map.Entry<String, String> entry : showMap.entrySet()) {
				row.createCell(columnIndex++).setCellValue(ReflectionUtils.invokeGetter(data, entry.getKey()) + "");
			}
		}
	}

}
