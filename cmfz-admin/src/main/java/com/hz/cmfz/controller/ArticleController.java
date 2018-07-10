package com.hz.cmfz.controller;

import com.hz.cmfz.entity.Article;
import com.hz.cmfz.entity.Master;
import com.hz.cmfz.service.ArticleService;
import com.hz.cmfz.service.MasterService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by 11022 on 2018/7/8 0008.
 */
@Controller
@RequestMapping("Article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MasterService masterService;

    @RequestMapping("/query")
    @ResponseBody
    public Map<String,Object> queryArticle(@RequestParam("rows") int totalSize,@RequestParam("page") int pageIndex){
        return articleService.findAll(totalSize,pageIndex);
    }

    @RequestMapping("/find")
    @ResponseBody
    public String findArticle(String articleId){
        Article article = articleService.find(articleId);
        if(article !=null){
            return "success";

        }
        return "error";
    }

    @RequestMapping("/findName")
    @ResponseBody
    public List<Master> findName(){
    return masterService.findName();
    }


    @RequestMapping("/upload")
    @ResponseBody
    public Article uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        Article result = new Article();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            System.out.println(realPath);
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";
            System.out.println(uploadPath);
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    //System.out.println(data.add("/upload/"+fileName));
                    data.add("/cmfz-admin-upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public String addArticle(Article article){
        System.out.println(article);
        if (article.getArticleStatus() == null){
            article.setArticleStatus("下架");
        }else {
            article.setArticleStatus("上架");
        }
        System.out.println(article.getArticleByName());
        Master master = masterService.find(article.getArticleByName());
        article.setArticleByName(master.getMasterName());
        String id =UUID.randomUUID().toString().replace("-","");
        article.setArticleId(id);
        article.setArticleDate(new Date());
        System.out.println(article);
        int a =articleService.add(article);
        if (a > 0){
            return "success";
        }
            return "error";
    }
}
