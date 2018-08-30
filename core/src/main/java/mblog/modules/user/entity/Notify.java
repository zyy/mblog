package mblog.modules.user.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.util.Date;

/**
 * 通知
 *
 * @author langhsu on 2015/8/31.
 */
@Entity
@Table(name = "mto_notify")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Notify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "own_id")
    private long ownId;

    @Column(name = "from_id")
    private long fromId;
    /**
     * 事件
     */
    private int event;
    /**
     * 关联文章ID
     */
    @Column(name = "post_id")
    private long postId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    /**
     * 阅读状态
     */
    private int status;
}
