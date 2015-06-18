package com.ace.ng.session;

import com.ace.ng.event.AbstractFire;
import com.ace.ng.event.FireStore;
import com.ace.ng.event.IEvent;

/**
 * Created by Administrator on 2014/5/19.
 */
public class SessionFire extends AbstractFire<ISession> {
    public static  final String SESSION_EVENT_FIRE="SESSION_EVENT_FIRE";
    static{

        FireStore.INSTANCE.addEventFire(SESSION_EVENT_FIRE, new SessionFire());
    }
    public static SessionFire getInstance(){
        return (SessionFire)FireStore.INSTANCE.getEventFire(SESSION_EVENT_FIRE);
    }
    public  enum SessionEvent implements IEvent {
        SESSION_DISCONNECT,SESSION_CONNECT,SESSION_LOGIN;
    }
}
