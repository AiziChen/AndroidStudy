package com.sunrun.toollibrary.mvp;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
