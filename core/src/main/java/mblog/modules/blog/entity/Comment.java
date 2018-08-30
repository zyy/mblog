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

import javax.persistence.*;
import java.util.Date;

import lombok.Data;

/**
 * 评论
 * @author langhsu
 *
 */
@Entity
@Table(name = "mto_comments")
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * 所属内容ID
	 */
	@Column(name = "to_id")
	private long toId;

	/**
	 * 父评论ID
	 */
	private long pid;

	/**
	 * 评论内容
	 */
	@Column(name = "content")
	private String content;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "author_id")
	private long authorId;
	
	private int status;

}
