package com.lgd.biz;

/**
 * 任务回调接口    
 * 作为方法参数    调用时具体实现   然后传入线程任务
 * @author saber
 *
 */


public interface Task {

	Object task();
	
}
