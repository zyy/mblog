/**
 *
 */
package mblog.core.template.directive;

import mblog.modules.data.PostVO;
import mblog.modules.service.PostService;
import mblog.core.template.DirectiveHandler;
import mblog.core.template.TemplateDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 推荐内容查询
 *
 * @author langhsu
 *
 */
@Component
public class BannerDirective extends TemplateDirective {
	@Autowired
    private PostService postService;

    @Override
    public String getName() {
        return "banner";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        List<PostVO> result = postService.findAllFeatured();
        handler.put(RESULTS, result).render();
    }
}
