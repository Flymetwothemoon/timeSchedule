package com.example.baselibs;

public class ServiceFactory {
    private static class Inner{
        private static ServiceFactory serviceFactory = new ServiceFactory();
    }
    public static ServiceFactory getInstance(){
        return Inner.serviceFactory;
    }
    public LogService getLogService() {
        if(logService==null){
            return new EmptyService();
        }
        else {
            return logService;
        }
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    private LogService logService;
}
