package edu.sjsu.cmpe275.library.event;

import edu.sjsu.cmpe275.library.model.UserEntity;
import org.springframework.context.ApplicationEvent;

/**
 * Created by aa001 on 12/7/16.
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private final String appUrl;
    private final UserEntity user;

    public OnRegistrationCompleteEvent(
            UserEntity user, String appUrl) {
        super(user);

        this.user = user;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public UserEntity getUser() {
        return user;
    }

}
