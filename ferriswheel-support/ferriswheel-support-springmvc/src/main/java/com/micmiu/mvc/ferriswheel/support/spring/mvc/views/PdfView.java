package com.micmiu.mvc.ferriswheel.support.spring.mvc.views;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.micmiu.mvc.ferriswheel.core.FerriswheelConstant;
import com.micmiu.mvc.ferriswheel.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * iText2 pdf 实现
 * <p/>
 * this class is deprecated user {@link PdfiText5View}
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Deprecated
public class PdfView extends AbstractPdfView {

	private static final Logger logger = LoggerFactory.getLogger(PdfView.class);

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
									Document document, PdfWriter writer, HttpServletRequest request,
									HttpServletResponse response) throws Exception {

		String fileName = FileNameUtils.formatFileName(".pdf", model.get(ViewConstant.EXPORT_KEY_FILENAME) + "", ViewConstant.DEFAULT_FILENAME);
		if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename="
				+ fileName);
		Map<String, String> showMap = (LinkedHashMap<String, String>) model
				.get(FerriswheelConstant.EXPORT_COLUMN_MAP);
		List<Object> dataList = (List<Object>) model
				.get(FerriswheelConstant.EXPORT_ROW_DATA);
		// 创建PDF表格
		PdfPTable table = new PdfPTable(showMap.size());
		// 设置pdf表格的宽度
		table.setTotalWidth(500);
		// 设置是否要固定其宽度
		table.setLockedWidth(true);
		// 表头字体
		Font thfont = getChineseFont();
		// 设置表头字体的大小
		thfont.setSize(12);
		// 设置表头字体的样式
		thfont.setStyle(Font.BOLD);
		Font tdfont = getChineseFont();
		tdfont.setSize(7);
		tdfont.setStyle(Font.NORMAL);
		// 设置水平对齐方式
		table.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		// 设置table的header
		for (Map.Entry<String, String> entry : showMap.entrySet()) {
			table.addCell(new Paragraph(entry.getValue(), thfont));
		}
		// 循环设置table的每一行
		for (Object data : dataList) {
			for (Map.Entry<String, String> entry : showMap.entrySet()) {
				table.addCell(new Paragraph(ReflectionUtils.invokeGetter(data, entry.getKey()) + "", tdfont));
			}
		}
		document.add(table);

	}

	private static final Font getChineseFont() {
		Font cnFont = null;
		try {
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			cnFont = new Font(bfChinese);
		} catch (Exception e) {
			logger.error("PDF get chinese font error", e);
			cnFont = new Font();
		}
		return cnFont;
	}
}
