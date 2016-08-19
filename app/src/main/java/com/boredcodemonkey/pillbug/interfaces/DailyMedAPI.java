package com.boredcodemonkey.pillbug.interfaces;

import com.boredcodemonkey.pillbug.contracts.drugnames.DrugNameResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public interface DailyMedAPI {
    @GET("v2/drugnames.json")
    Call<DrugNameResults> searchDrugs(@Query("drug_name") String drugName);
}
