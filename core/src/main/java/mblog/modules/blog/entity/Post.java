/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.modules.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.SortableField;

/**
 * 内容表
 *
 * @author langhsu
 */
@Entity
@Table(name = "mto_posts")
@Indexed(index = "posts")
@Analyzer(impl = SmartChineseAnalyzer.class)
@Data
public class Post implements Serializable {
    private static final long serialVersionUID = 7144425803920583495L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SortableField
    @NumericField
    private long id;

    /**
     * 分组/模块ID
     */
    @Field
    @NumericField
    @Column(name = "channel_id", length = 5)
    private int channelId;

    /**
     * 标题
     */
    @Field
    @Column(name = "title", length = 64)
    private String title;

    /**
     * 摘要
     */
    @Field
    private String summary;

    /**
     * 预览图
     */
    private String thumbnail;

    /**
     * 标签, 多个逗号隔开
     */
    @Field
    private String tags;

    @Field
    @NumericField
    @Column(name = "author_id")
    private long authorId; // 作者

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    /**
     * 喜欢数
     */
    private int favors;

    /**
     * 评论数
     */
    private int comments;

    /**
     * 阅读数
     */
    private int views;

    /**
     * 文章状态
     */
    private int status;

    /**
     * 推荐状态
     */
    private int featured;

    /**
     * 置顶状态
     */
    private int weight;
}