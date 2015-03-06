/**
 * 
 */
package mblog.core.planet.impl;

import java.util.List;

import mblog.core.planet.PostPlanet;
import mblog.core.pojos.Post;
import mblog.core.service.PostService;
import mtons.modules.pojos.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author langhsu
 * 
 */
public class PostPlanetImpl implements PostPlanet {
	@Autowired
	private PostService postsService;

	@Override
	@Cacheable(value = "postsCaches", key = "'list_' + #page.getPageNo() + '_' + #page.getMaxResults()")
	public Page paging(Page page) {
		postsService.paging(page);
		return page;
	}
	
	@Override
	@Cacheable(value = "postsCaches", key = "'uhome' + #uid + '_' + #page.getPageNo()")
	public Page pagingByUserId(Page page, long uid) {
		postsService.pagingByUserId(page, uid);
		return page;
	}

	@Override
	@Cacheable(value = "postsCaches", key = "'view_' + #id")
	public Post getPost(long id) {
		return postsService.get(id);
	}

	@Override
	@CacheEvict(value = "postsCaches", allEntries = true)
	public void post(Post post) {
		postsService.post(post);
	}
	
	@Override
	@Cacheable(value = "postsCaches")
	public List<Post> findRecents(int maxResutls, long ignoreUserId) {
		return postsService.findRecents(maxResutls, ignoreUserId);
	}

	@Override
	@Cacheable(value = "postsCaches")
	public List<Post> findHots(int maxResutls, long ignoreUserId) {
		return postsService.findHots(maxResutls, ignoreUserId);
	}
	
	@Override
	@CacheEvict(value = "postsCaches", allEntries = true)
	public void delete(long id, long authorId) {
		postsService.delete(id, authorId);
	}

	@Override
	@CacheEvict(value = "postsCaches", allEntries = true)
	public void delete(long id) {
		postsService.delete(id);
	}

}
