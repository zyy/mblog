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
 * 验证码
 * @author langhsu on 2015/8/14.
 */
@Entity
@Table(name = "mto_verify")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
public class Verify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**用户ID*/
    @Column(name = "user_id", unique = true)
    private long userId;
    /**验证码*/
    @Column(length = 60, nullable = false)
    private String code;
    /**目标：邮箱*/
    @Column(length = 96)
    private String target;
    /**验证类型：注册验证、找回密码验证*/
    @Column
    private int type;
    /**过期时间*/
    @Column(name = "expired", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expired;
    /**创建时间*/
    @Column(name = "created", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    private String token;
    /**状态：正常、关闭*/
    @Column
    private int status;

}
