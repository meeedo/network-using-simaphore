package com.company;

import java.io.IOException;

public class Device extends Thread {

    private String devicename ;
    private String devicetype ;
    private Router router;
    private int server;

    public Device(int maxnumber, Router router)
    {
        this.router = new Router(maxnumber);
        this.router = router;
    }

    public Device(String name, String type, Router router)
    {
        devicename = name;
        devicetype = type;
        this.router = router;
    }

    @Override
    public void run()
    {
            router.connect(this);
            router.activity(this);
            router.disconnect(this);
    }


    public void setdevicename(String devicename)
    {
        this.devicename = devicename;
    }

    public String getdevicename()
    {
        return devicename;
    }


    public void setDevicetype(String devicetype)
    {
        this.devicetype = devicetype;
    }

    public String getdevicetype()
    {
        return devicetype;
    }

    public void setrouter(Router router)
    {
        this.router = router;
    }

    public Router getrouter()
    {
        return router;
    }


      public void setserver(int server)
    {
        this.server = server;
    }

    public int getserver()
    {
        return server;
    }


}
