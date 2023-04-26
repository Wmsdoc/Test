package com.etc.test.controller;


import com.etc.test.entity.WorkSummary;
import com.etc.test.service.LogSystemService;
import com.etc.test.service.WorkSummaryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
public class FileController {
    // 上传后的文件保存路径，同时也是文件下载的路径
    @Value("${file.path}")
    String filePath;

    @Autowired
    private WorkSummaryService workSummaryService;
    @Autowired
    private LogSystemService logSystemService;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam String operatorId, @RequestParam String operatorName,@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        WorkSummary workSummary = new WorkSummary();
        // 获取文件名并存入实体类
        String fileName = file.getOriginalFilename();
        workSummary.setSummaryTitle(fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 解决中文问题，liunx下中文路径，图片显示问题
        // 生成新的文件名并设置工作总结ID，文件名即为工作总结ID
        String summaryId= UUID.randomUUID().toString();
        String newFileName = summaryId + suffixName;
        workSummary.setSummaryId(summaryId);

        // 构建上传路径
        File dest = new File(filePath + newFileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            // 保存工作总结信息
            workSummaryService.insert(workSummary);
            // 保存日志信息
            logSystemService.insert(UUID.randomUUID().toString(),operatorId,operatorName,"上传关于病人编号为："+workSummary.getPatientId()+"的工作总结");
            // 保存文件
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    //文件下载
    @GetMapping("/download")
    @ResponseBody
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "ef92f3bd-9d9c-4a5b-a2ef-cce534f33968.docx";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //传入文件路径，及文件名
            File file = new File(filePath,fileName);
            if (file.exists()) {
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    response.setContentType("application/force-download");// 设置强制下载不打开
                    response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName,"utf-8"));//设置文件名
                    byte[] buffer = new byte[1024];
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("download success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
