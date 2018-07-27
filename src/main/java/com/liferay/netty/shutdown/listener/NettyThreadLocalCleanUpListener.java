package com.liferay.netty.shutdown.listener;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

import io.netty.util.concurrent.FastThreadLocal;

public class NettyThreadLocalCleanUpListener implements LifecycleListener {

	public void lifecycleEvent(LifecycleEvent event) {
        if (Lifecycle.BEFORE_STOP_EVENT.equals(event.getType())) {
        	System.err.println("another desperate try to clean up netty");
        	FastThreadLocal.destroy();
        }
        if (Lifecycle.AFTER_STOP_EVENT.equals(event.getType())) {
        	System.err.println("another desperate try to clean up netty, now after");
        	FastThreadLocal.destroy();
        }
	}

}
