/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.modules.user.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * 我的关注
 * 
 * @author langhsu
 * 
 */
@Entity
@Table(name = "mto_follows")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * 所属用户Id
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	/**
	 * 关注用户Id
	 */
	@ManyToOne
	@JoinColumn(name = "follow_id", nullable = false)
	private User follow;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
}
