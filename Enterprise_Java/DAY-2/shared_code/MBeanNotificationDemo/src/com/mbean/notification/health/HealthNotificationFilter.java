package com.mbean.notification.health;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationFilter;

public class HealthNotificationFilter implements NotificationFilter {

	@Override
	public boolean isNotificationEnabled(Notification notification) {
        if (notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification acn =
                (AttributeChangeNotification) notification;
            if(Integer.parseInt(String.valueOf(acn.getNewValue())) > 200) {
            	return true;
            }
        }
		return false;
	}

}
