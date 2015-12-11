package com.micmiu.mvc.ferriswheel.examples.web1.demos.upload;

import com.micmiu.mvc.ferriswheel.examples.web1.Constant;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * 文件上传
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
@RequestMapping(value = "/demo/FileUpload.do")
public class FileUploadAction {

	private static final String PREFIX = Constant.VIEW_PREFIX + "demo" + Constant.LAYOUT_SPLIT + "upload";

	@RequestMapping(params = {"method=showForm"})
	public String showForm() {
		return PREFIX + Constant.VIEW_PAGE_SPLIT + "form";

	}

	@RequestMapping(params = {"method=upload"}, method = RequestMethod.POST)
	public String uploadFile(MultipartFile multFile,
							 RedirectAttributes redirectAttributes) throws Exception {
		if (multFile.isEmpty()) {
			System.out.println(">>>>> file is empty");
			return "404";
		} else {
			String fileName = multFile.getOriginalFilename();
			System.out.println(">>>>> file name is:" + fileName);
			FileOutputStream fileos = new FileOutputStream("test/mvcupload1/" + fileName);
			IOUtils.copy(multFile.getInputStream(), fileos);
			IOUtils.closeQuietly(fileos);
			redirectAttributes.addFlashAttribute("message", fileName + "上传成功");
		}
		return "redirect:/demo/FileUpload.do?method=showForm";

	}

	@RequestMapping(params = {"method=showUploadifyForm"})
	public String showUploadifyForm() {
		return PREFIX + Constant.VIEW_PAGE_SPLIT + "uploadify";

	}

	@RequestMapping(params = {"method=uploadify"}, method = RequestMethod.POST)
	@ResponseBody
	public String uploadify(MultipartFile multFile,
							MultipartHttpServletRequest multReq,
							RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("-----------------------------------");
		System.out.println("multFile" + multFile);
		System.out.println("multReq" + multReq);
		System.out.println(">>>>> multReq getAttributeNames");
		Enumeration<String> attrs = multReq.getAttributeNames();
		while (attrs.hasMoreElements()) {
			Object obj = attrs.nextElement();
			System.out.println(obj);
		}

		System.out.println(">>>>> multReq getFileNames");
		Iterator<String> iter = multReq.getFileNames();
		while (iter.hasNext()) {
			MultipartFile file = multReq.getFile((String) iter.next());
			System.out.println(file.getOriginalFilename());
			FileOutputStream fileos = new FileOutputStream("test/mvcupload2/" + file.getOriginalFilename());
			System.out.println(file.getInputStream());
			IOUtils.copy(file.getInputStream(), fileos);
			IOUtils.closeQuietly(fileos);
		}

		return "success";

	}
}
