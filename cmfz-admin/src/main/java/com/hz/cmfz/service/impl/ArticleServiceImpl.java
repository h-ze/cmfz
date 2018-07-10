package com.hz.cmfz.service.impl;

import com.hz.cmfz.dao.ArticleDAO;
import com.hz.cmfz.entity.Article;
import com.hz.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2018/7/8 0008.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDAO articleDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> findAll(int totalSize, int pageIndex) {
        int i = articleDAO.countArticle();
        List<Article> articles =articleDAO.selectAll(totalSize*(pageIndex-1),totalSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",articles);
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Article find(String articleId) {
        return articleDAO.select(articleId);
    }

    @Override
    public List<String> findName() {
        List<Article> list =articleDAO.selectName();
        List<String> name1 =new ArrayList<String>();
        for (Article article:list) {
            String name =article.getArticleByName();
            if(name1.contains(name)){
                continue;
            }else {
                name1.add(name);
            }
        }
        return name1;
    }

    @Override
    public int add(Article article) {
        return articleDAO.insert(article);
    }
}
