package mblog.core.event.handler;

import mblog.base.lang.Consts;
import mblog.core.event.NotifyEvent;
import mblog.modules.data.PostVO;
import mblog.modules.service.PostService;
import mblog.modules.data.NotifyVO;
import mblog.modules.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author langhsu on 2015/8/31.
 */
@Component
public class NotifyEventHandler implements ApplicationListener<NotifyEvent> {
    @Autowired
    private NotifyService notifyService;
    @Autowired
    private PostService postService;

    @Async
    @Override
    public void onApplicationEvent(NotifyEvent event) {
        NotifyVO nt = new NotifyVO();
        nt.setPostId(event.getPostId());
        nt.setFromId(event.getFromUserId());
        nt.setEvent(event.getEvent());

        switch (event.getEvent()) {
            case Consts.NOTIFY_EVENT_FAVOR_POST:
                PostVO p = postService.get(event.getPostId());
                nt.setOwnId(p.getAuthorId());
                break;
            case Consts.NOTIFY_EVENT_COMMENT:
            case Consts.NOTIFY_EVENT_COMMENT_REPLY:
                PostVO p2 = postService.get(event.getPostId());
                nt.setOwnId(p2.getAuthorId());

                // 自增评论数
                postService.identityComments(event.getPostId());
                break;
            default:
                nt.setOwnId(event.getToUserId());
        }

        notifyService.send(nt);
    }
}
