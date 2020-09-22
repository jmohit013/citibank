/*
 * Main.java - main class for the Hello MBean and QueueSampler MXBean example.
 * Create the Hello MBean and QueueSampler MXBean, register them in the platform
 * MBean server, then wait forever (or until the program is interrupted).
 */

package com.mbean.notification;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Main {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName mbeanName = new ObjectName("com.mbean.notification:type=Hello");
		Hello mbean = new Hello();
		mbs.registerMBean(mbean, mbeanName);
        System.out.println("MBean started\nWaiting for incoming requests...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
