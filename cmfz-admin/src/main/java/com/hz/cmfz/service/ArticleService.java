package com.hz.cmfz.service;

import com.hz.cmfz.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2018/7/8 0008.
 */
public interface ArticleService {
    public Map<String,Object> findAll(int totalSize, int pageIndex);

    public Article find(String articleId);

    public List<String> findName();

    public int add(Article article);
}
