package mblog.modules.blog.entity;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by langhsu on 2015/10/25.
 */
@Entity
@Table(name = "mto_posts_attribute")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
public class PostAttribute implements Serializable {
	private static final long serialVersionUID = 7829351358884064647L;

	@Id
    private long id;

    /**
     * 内容
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type="text")
    private String content; // 内容

}
