/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.mtons.mblog.modules.service.impl;

import com.mtons.mblog.base.lang.Consts;
import com.mtons.mblog.modules.repository.UserDao;
import com.mtons.mblog.modules.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户事件操作, 用于统计用户信息
 * @author langhsu on 2015/8/6.
 */
@Service
@Transactional
public class UserEventServiceImpl implements UserEventService {
    @Autowired
    private UserDao userDao;

    @Override
    public void identityPost(Long userId, long postId, boolean identity) {
        userDao.updatePosts(userId, (identity) ? Consts.IDENTITY_STEP : Consts.DECREASE_STEP);
    }

    @Override
    public void identityComment(Long userId, long commentId, boolean identity) {
        userDao.updateComments(userId, (identity) ? Consts.IDENTITY_STEP : Consts.DECREASE_STEP);
    }

}
