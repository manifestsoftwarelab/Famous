package com.example.pb221.vendaq.main;

/**
 * Created by DELL on 12/2/2017.
 */

public class BasePresenter implements WebServiceCallBackResult {
    protected IDataObserver iDataObserver;

    public BasePresenter(IDataObserver iDataObserver) {
        this.iDataObserver = iDataObserver;
    }

    public void requestData()
    {
        iDataObserver.showDelayIndicator();
    }

    @Override
    public void onExecutionSuccess() {

    }

    @Override
    public void onExecutionFailure() {

    }
}
