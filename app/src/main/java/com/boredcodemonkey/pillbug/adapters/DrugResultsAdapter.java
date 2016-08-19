package com.boredcodemonkey.pillbug.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boredcodemonkey.pillbug.R;
import com.boredcodemonkey.pillbug.contracts.drugnames.Data;
import com.boredcodemonkey.pillbug.enumerations.NameType;

import java.util.ArrayList;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class DrugResultsAdapter extends RecyclerView.Adapter<DrugResultsAdapter.ViewHolder> {

    private ArrayList<Data> drugNameResults;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtDrugName;
        public TextView txtGenericIndicator;

        public ViewHolder(View itemView) {
            super(itemView);
            txtDrugName = (TextView) itemView.findViewById(R.id.txtDrugName);
            txtGenericIndicator = (TextView) itemView.findViewById(R.id.txtGenericIndicator);
        }
    }

    public DrugResultsAdapter(ArrayList<Data> drugNameResults) {
        this.drugNameResults = drugNameResults;
    }

    @Override
    public DrugResultsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_drug_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Data currentRecord = drugNameResults.get(position);
        holder.txtDrugName.setText(currentRecord.getDrug_name());
        holder.txtDrugName.setText(NameType.fromShortName(currentRecord.getName_type()).toString());
    }

    @Override
    public int getItemCount() {
        return drugNameResults.size();
    }

}
