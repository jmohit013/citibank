/*
 * HelloMBean.java - MBean interface describing the management operations and
 * attributes for the Hello World MBean. In this case there are two operations,
 * "sayHello" and "add", and two attributes, "Name" and "CacheSize".
 */

package com.mbean.notification;

public interface HelloMBean {
    public int getCacheSize();
    public void setCacheSize(int size);
}
