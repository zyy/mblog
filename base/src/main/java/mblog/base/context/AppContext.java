/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.base.context;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author langhsu
 * 
 */
@Component
@Data
public class AppContext {
	
	/*
	 * 文件存储-根目录
	 */
	@Value("${site.store.root:/data/mblog/}")
	String root = "/data/mblog";
	
	/*
	 * 文件存储-原文件目录
	 */
	String origDir = "/store/orig";
	
	/*
	 * 文件存储-压缩目录
	 */
	String thumbsDir = "/store/thumbs";

	/*
	 * 文件存储-头像目录
	 */
	String avaDir = "/store/ava";
	
	/*
	 * 文件存储-临时文件目录
	 */
	String tempDir = "/store/temp";

	/*
	 * 系统配置信息
	 * - 在 StartupListener 类中加载
	 */
	public Map<String, String> config;
}
