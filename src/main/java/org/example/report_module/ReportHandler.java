package org.example.report_module;

abstract class ReportHandler {
    protected ReportHandler nextHandler;

    public void setNextHandler(ReportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String reportType);
}