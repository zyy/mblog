package mblog.modules.authc.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限值
 * @author - langhsu on 2018/2/11
 */
@Entity
@Table(name = "shiro_permission")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -5979636077639378677L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "parent_id", updatable = false)
    private long parentId;
    
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private int weight;

    @Version
    private Integer version;
}
