package com.example.apoo.railwayprojectapoorva.view.trainnmnumbr;

import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;

/**
 * Created by Apoo on 6/8/2017.
 */

public interface Gettrainnameornmbrview {


    public void onSuccess(TainNameNumberResponse tainNameNumberResponse);

    public void onFailure(String error);
}
