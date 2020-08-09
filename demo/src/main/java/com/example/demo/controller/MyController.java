package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


//@Api(tags = "RULE_TAG", position = 1)
@RestController
public class MyController {
    //    @ApiOperation(value = "test", notes = "CREATE_DATA_INSTANCE_NOTES")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "bookName", value = "书名", dataType = "Book")
//    })
    @GetMapping("/test")
    public String test(@RequestBody Book book) {
        return "success";
    }

    @RequestMapping("/getFileOutputStream")
    public void getFileOutputStream(HttpServletResponse response, String path) {
        response.setCharacterEncoding("UTF-8");
        OutputStream out = null;
        System.out.println(path);
        System.out.println("==========getFileOutputStream=========文件路径:" + path);
        File file = new File("test_252570435422100.json");    //1、建立连接
        BufferedInputStream is = null;
        byte[] b = new byte[4096];
        int len = 1024;
        // 清空response
        response.reset();
        response.setContentType("application/x-download");//设置response内容的类型 普通下载类型
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));//设置头部信息
            out = response.getOutputStream();
            is = new BufferedInputStream(new FileInputStream(file));
            while ((len = is.read(b)) != -1) {
                out.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
                if (is != null)
                    is.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
