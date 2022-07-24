package io.muzoo.ssc.webapp;

import org.apache.tomcat.util.descriptor.web.ErrorPage;

public class CustomErrorPage extends ErrorPage  {
    @Override
    public  String getLocation(){
        System.out.println("x");
        return super.getLocation();
    }

}
