package com.mbean.notification.health;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class HealthMBeanServer {

	public static void main(String[] args) throws Exception {
		Health healthMbean = new Health();
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName objectName = new ObjectName("com.mbean.notification.health:type=Health");

		mbs.registerMBean(healthMbean, objectName);

        System.out.println("MBean server started...");
        Thread.sleep(Long.MAX_VALUE);
	}

}
