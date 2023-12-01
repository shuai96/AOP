package com.shuai.testproject.controller;

import com.shuai.testproject.utils.PdfUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai
 */
@RestController
public class ExportPdfController {


    @GetMapping("export")
    public void registrationNoticeExport(HttpServletResponse response) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("${attachmentNameStr}", "    " + String.join("\n    ", "666"));
        //导出pdf
        PdfUtils.setResponseContentType(response, "666");
        PdfUtils.downloadPdf(dataMap,response);

    }

}
