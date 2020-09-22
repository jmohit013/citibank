package com.mbean.notification.health;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Health extends NotificationBroadcasterSupport implements HealthMBean {

	private int bloodPressure = 100;
	private long sequenceNumber = 1;
	
	@Override
	public void setBloodPressure(int bloodPressure) {
		int old_bloodPressure = this.bloodPressure;
		this.bloodPressure = bloodPressure;
		
		Notification notification = 
				new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(),
						"Blood pressure changed", "bloodPressure", "int", old_bloodPressure, this.bloodPressure);
		sendNotification(notification);
	}

	@Override
	public int getBloodPressure() {
		return this.bloodPressure;
	}
}
