package com.boredcodemonkey.pillbug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.boredcodemonkey.pillbug.adapters.RxCUIsResultsAdapter;
import com.boredcodemonkey.pillbug.contracts.rxcui.Data;
import com.boredcodemonkey.pillbug.contracts.rxcui.RxCUIResults;
import com.boredcodemonkey.pillbug.interfaces.DailyMedAPI;
import com.boredcodemonkey.pillbug.interfaces.RecyclerItemClicked;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxCUILookupActivity extends AppCompatActivity implements RecyclerItemClicked<Data> {


    private static final String BASE_URL = "https://dailymed.nlm.nih.gov/dailymed/services/";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private DailyMedAPI dailyMedAPIService = retrofit.create(DailyMedAPI.class);

    private RxCUIsResultsAdapter resultsAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private EditText txtDrugSearch;
    private RecyclerView lstDrugLookupResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_cuilookup);
        initializeUI();
    }

    private void initializeUI() {
        txtDrugSearch = (EditText)findViewById(R.id.txtDrugSearch);
        txtDrugSearch.addTextChangedListener(drugSearchWatcher);

        lstDrugLookupResults = (RecyclerView) findViewById(R.id.lstDrugLookupResults);

        layoutManager = new LinearLayoutManager(this);

        recyclerView = (RecyclerView) findViewById(R.id.lstDrugLookupResults);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private final TextWatcher drugSearchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() < 3) {
                lstDrugLookupResults.setVisibility(View.INVISIBLE);
            } else {
                Call<RxCUIResults> call = dailyMedAPIService.searchRxCUIs(editable.toString());
                call.enqueue(lookupCallback);
            }
        }
    };

    private final Callback<RxCUIResults> lookupCallback = new Callback<RxCUIResults>() {
        @Override
        public void onResponse(Call<RxCUIResults> call, Response<RxCUIResults> response) {
            if (response.body().getData().length > 0) {
                lstDrugLookupResults.setVisibility(View.VISIBLE);
                ArrayList<com.boredcodemonkey.pillbug.contracts.rxcui.Data> results = new ArrayList<>(Arrays.asList(response.body().getData()));
                resultsAdapter = new RxCUIsResultsAdapter(results, RxCUILookupActivity.this);
                recyclerView.setAdapter(resultsAdapter);
            }
        }

        @Override
        public void onFailure(Call<RxCUIResults> call, Throwable t) {
            int i = 0;
        }
    };

    @Override
    public void onListItemClicked(Data data) {
        Toast.makeText(this, data.getRxstring(), Toast.LENGTH_LONG).show();
    }
}
