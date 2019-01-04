/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.modules.repository;

import mblog.modules.repository.custom.FeedsDaoCustom;
import mblog.modules.entity.Feeds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author langhsu
 *
 */
public interface FeedsDao extends JpaRepository<Feeds, Long>, JpaSpecificationExecutor<Feeds>, FeedsDaoCustom {
	Page<Feeds> findAllByOwnIdOrderByIdDesc(Pageable pageable, long ownId);
	int deleteAllByOwnIdAndAuthorId(long ownId, long authorId);
	void deleteAllByPostId(long postId);
}
