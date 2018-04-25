package com.lgd.biz;

import java.io.IOException;

/**
 * 请求完成时的回调接口
 * @author saber
 *
 */


public interface CallBack {

	 void callback(Object result) throws IOException;
	
}
