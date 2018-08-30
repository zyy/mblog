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
 * 动态
 * 
 * @author langhsu
 * 
 */
@Entity
@Table(name = "mto_feeds")
@Data
public class Feeds {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "own_id")
	private long ownId; // 所属用户Id

	private int type;

	@Column(name = "post_id")
	private long postId; // 目标Id

	@Column(name = "author_id")
	private long authorId; // 作者
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
}
