package mblog.modules.blog.entity;

import javax.persistence.*;
import java.util.Date;

import lombok.Data;

/**
 * 喜欢/收藏
 * @author langhsu on 2015/8/31.
 */
@Entity
@Table(name = "mto_favors")
@Data
public class Favor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 所属用户
     */
    @Column(name = "own_id")
    private long ownId;

    /**
     * 内容ID
     */
    @Column(name = "post_id")
    private long postId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
