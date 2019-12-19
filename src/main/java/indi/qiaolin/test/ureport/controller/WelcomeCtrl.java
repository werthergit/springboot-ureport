package indi.qiaolin.test.ureport.controller;

import com.bstek.ureport.export.ExportManager;
import com.bstek.ureport.export.html.HtmlReport;
//import net.sf.json.JSONArray;
import com.bstek.ureport.provider.report.ReportFile;
import indi.qiaolin.test.ureport.provider.MySQLProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试报表整合
 *
 * @author liaoxiaoxia
 * @version 1.0.0
 * @date 2019/7/9 17:28
 * @since JDK 1.8
 */
@Controller
public class WelcomeCtrl {

    @Autowired
    ExportManager manager;

    @Autowired
    MySQLProvider mySQLProvider;

    /**
     * 访问报表页面
     *
     * @param request 请求信息
     * @return 页面
     */
    @RequestMapping(value = "index")
    public String index(HttpServletRequest request) throws IOException {
        Map<String, Object> parameters = new HashMap();


        HtmlReport report = manager.exportHtml("store-01.ureport.xml", request.getContextPath(), parameters);

        request.setAttribute("htmlReport", report);
        return "demo";
    }

//    @RequestMapping(value = "chart")
//    public String chart(HttpServletRequest request) {
//        Map<String, Object> parameters = new HashMap();
//        HtmlReport report = manager.exportHtml("file:bean.ureport.xml", request.getContextPath(), parameters);
//        request.setAttribute("htmlReport", report);
//
//        JSONArray array = JSONArray.fromObject(report.getChartDatas());
//        request.setAttribute("chartDatas", array.toString());
//        return "chart";
//    }


    public   String   inputStream2String   (InputStream   in)   throws IOException {
        StringBuffer   out   =   new   StringBuffer();
        byte[]   b   =   new   byte[4096];
        for   (int   n;   (n   =   in.read(b))   !=   -1;)   {
            out.append(new   String(b,   0,   n));
        }
        return   out.toString();
    }
}
