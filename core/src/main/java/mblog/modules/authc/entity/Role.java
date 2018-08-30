package mblog.modules.authc.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色
 * @author - langhsu on 2018/2/11
 */
@Entity
@Table(name = "shiro_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -1153854616385727165L;

    public static int STATUS_NORMAL = 0;
    public static int STATUS_CLOSED = 1;

    public static String ROLE_ADMIN = "admin";

    public static long ADMIN_ID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, updatable = false)
    private String name;

    private String description;

    private int status;

    @Transient
    private List<Permission> permissions;
}
