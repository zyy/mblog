package mblog.modules.repository;

import mblog.modules.entity.PostAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by langhsu on 2017/9/27.
 */
public interface PostAttributeDao extends JpaRepository<PostAttribute, Long>, JpaSpecificationExecutor<PostAttribute> {
}
