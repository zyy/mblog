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
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户信息
 *
 * @author langhsu
 *
 */
@Entity
@Table(name = "mto_users")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**用户名*/
	@Column(name = "username", unique = true, length = 64)
	private String username;
	/**密码*/
	@Column(name = "password", length = 64)
	private String password;
	/**头像*/
	private String avatar;
	/**昵称*/
	@Column(name = "name", length = 18)
	private String name;
	/**性别*/
	private int gender;
	/**邮箱*/
	@Column(name = "email", unique = true, length = 128)
	private String email;
	/**手机号*/
	@Column(name = "mobile", length = 11)
	private String mobile;
	/**文章数*/
	private int posts;
	/**发布评论数*/
	private int comments;
	/**关注人数*/
	private int follows;
	/**粉丝数*/
	private int fans;
	/**收到的喜欢数*/
	private int favors;
	/**注册时间*/
	private Date created;
	/**注册来源：主要用于区别第三方登录*/
	private int source;

	@Column(name = "last_login")
	private Date lastLogin;
	/**个性签名*/
	private String signature;
	/**邮箱激活状态*/
	@Column(name = "active_email")
	private int activeEmail;
	/**用户状态*/
	private int status;
	public User(long id) {
		this.id = id;
	}
}
