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
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 第三方开发授权登录
 *
 * @author langhsu on 2015/8/12.
 */
@Entity
@Table(name = "mto_users_open_oauth")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class OpenOauth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**系统中的用户ID*/
    @Column(name = "user_id")
    private long userId;

    /**认证类型：QQ、新浪*/
    @Column(name = "oauth_type")
    private int oauthType;

    /**对应第三方用户ID*/
    @Column(name = "oauth_user_id")
    private String oauthUserId;

    /**第三方返回的code*/
    @Column(name = "oauth_code")
    private String oauthCode;

    /**访问令牌*/
    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "expire_in")
    private String expireIn;

    @Column(name = "refresh_token")
    private String refreshToken;

}
