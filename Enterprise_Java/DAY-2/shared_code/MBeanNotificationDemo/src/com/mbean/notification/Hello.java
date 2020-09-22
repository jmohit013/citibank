/*
 * Hello.java - MBean implementation for the Hello MBean. This class must
 * implement all the Java methods declared in the HelloMBean interface,
 * with the appropriate behavior for each one.
 */

package com.mbean.notification;

import javax.management.*;

public class Hello
	extends NotificationBroadcasterSupport implements HelloMBean {

    public int getCacheSize() {
    	return this.cacheSize;
    }

    public synchronized void setCacheSize(int size) {
		int oldSize = this.cacheSize;
		this.cacheSize = size;
		System.out.println("Cache size now " + this.cacheSize);
		Notification n =
				new AttributeChangeNotification(this,
					    sequenceNumber++,
					    System.currentTimeMillis(),
					    "CacheSize changed",
					    "CacheSize",
					    "int",
					    oldSize,
					    this.cacheSize);
		sendNotification(n);
    }
    private int cacheSize = 200;
    private long sequenceNumber = 1;
}
