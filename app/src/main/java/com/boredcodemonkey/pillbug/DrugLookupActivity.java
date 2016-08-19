package com.boredcodemonkey.pillbug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.boredcodemonkey.pillbug.adapters.DrugResultsAdapter;
import com.boredcodemonkey.pillbug.contracts.drugnames.Data;
import com.boredcodemonkey.pillbug.contracts.drugnames.DrugNameResults;
import com.boredcodemonkey.pillbug.interfaces.DailyMedAPI;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DrugLookupActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://dailymed.nlm.nih.gov/dailymed/services/";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private DailyMedAPI dailyMedAPIService = retrofit.create(DailyMedAPI.class);

    private DrugResultsAdapter drugResultsAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private EditText txtDrugSearch;
    private RecyclerView lstDrugLookupResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_lookup);

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
            if (editable.length() < 3) return;
            Call<DrugNameResults> call = dailyMedAPIService.searchDrugs(editable.toString());
            call.enqueue(lookupCallback);
        }
    };

    private final Callback<DrugNameResults> lookupCallback = new Callback<DrugNameResults>() {
        @Override
        public void onResponse(Call<DrugNameResults> call, Response<DrugNameResults> response) {
            if (response.body().getData().length == 0) {
                lstDrugLookupResults.setVisibility(View.INVISIBLE);
            } else {
                lstDrugLookupResults.setVisibility(View.VISIBLE);
                ArrayList<Data> results = new ArrayList<>(Arrays.asList(response.body().getData()));
                drugResultsAdapter = new DrugResultsAdapter(results);
                recyclerView.setAdapter(drugResultsAdapter);
            }
        }

        @Override
        public void onFailure(Call<DrugNameResults> call, Throwable t) {
            int i = 0;
        }
    };

}
