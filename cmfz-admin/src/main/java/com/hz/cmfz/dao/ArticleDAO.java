package com.hz.cmfz.dao;

import com.hz.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 11022 on 2018/7/8 0008.
 */
public interface ArticleDAO {
    public List<Article> selectAll(@Param("begin") int begin,@Param("showSize") int showSize);

    public List<Article> selectName();

    public Article select(String articleId);

    public int countArticle();

    public int insert(Article article);
}
