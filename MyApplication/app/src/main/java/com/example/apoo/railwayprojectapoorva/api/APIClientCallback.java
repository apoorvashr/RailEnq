package com.example.apoo.railwayprojectapoorva.api;

/**
 * Created by Apoo on 5/12/2017.
 */

public interface APIClientCallback<T> {

    void onSuccess (T success);

    void onFailure (Exception e);

}
