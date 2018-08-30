package mblog.modules.authc.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户角色映射表
 *
 * @author - langhsu on 2018/2/11
 */
@Entity
@Table(name = "shiro_user_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class UserRole implements Serializable {

	private static final long serialVersionUID = -2908144287976184011L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role_id")
    private Long roleId;
}
