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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 模块/内容分组
 * @author langhsu
 *
 */
@Entity
@Table(name = "mto_channels")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 唯一关键字
	 */
	@Column(name = "key_", unique = true)
	private String key;

	private int status;
}
