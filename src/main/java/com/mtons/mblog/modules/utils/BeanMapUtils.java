/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.mtons.mblog.modules.utils;

import com.mtons.mblog.modules.entity.User;
import com.mtons.mblog.modules.data.CommentVO;
import com.mtons.mblog.modules.data.FavorVO;
import com.mtons.mblog.modules.data.PostVO;
import com.mtons.mblog.modules.entity.Comment;
import com.mtons.mblog.modules.entity.Favor;
import com.mtons.mblog.modules.entity.Post;
import com.mtons.mblog.modules.data.AccountProfile;
import com.mtons.mblog.modules.data.NotifyVO;
import com.mtons.mblog.modules.data.UserVO;
import com.mtons.mblog.modules.entity.Notify;
import org.springframework.beans.BeanUtils;

/**
 * @author langhsu
 *
 */
public class BeanMapUtils {
	public static String[] USER_IGNORE = new String[]{"password", "extend", "roles"};

	public static String[] POST_IGNORE_LIST = new String[]{"markdown", "content"};

	public static UserVO copy(User po, int level) {
		if (po == null) {
			return null;
		}
		UserVO ret = new UserVO();
		BeanUtils.copyProperties(po, ret, USER_IGNORE);
		return ret;
	}

	public static AccountProfile copyPassport(User po) {
		AccountProfile passport = new AccountProfile(po.getId(), po.getUsername());
		passport.setName(po.getName());
		passport.setEmail(po.getEmail());
		passport.setAvatar(po.getAvatar());
		passport.setLastLogin(po.getLastLogin());
		passport.setStatus(po.getStatus());
		return passport;
	}

	public static CommentVO copy(Comment po) {
		CommentVO ret = new CommentVO();
		BeanUtils.copyProperties(po, ret);
		return ret;
	}

	public static PostVO copy(Post po, int level) {
		PostVO d = new PostVO();
		if (level > 0) {
			BeanUtils.copyProperties(po, d);
		} else {
			BeanUtils.copyProperties(po, d, POST_IGNORE_LIST);
		}
		return d;
	}

	public static NotifyVO copy(Notify po) {
		NotifyVO ret = new NotifyVO();
		BeanUtils.copyProperties(po, ret);
		return ret;
	}

	public static FavorVO copy(Favor po) {
		FavorVO ret = new FavorVO();
		BeanUtils.copyProperties(po, ret);
		return ret;
	}

}
