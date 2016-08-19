package com.boredcodemonkey.pillbug.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boredcodemonkey.pillbug.R;
import com.boredcodemonkey.pillbug.contracts.rxcui.Data;

import java.util.ArrayList;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class RxCUIsResultsAdapter extends RecyclerView.Adapter<RxCUIsResultsAdapter.ViewHolder>{

    private ArrayList<Data> rxCUIResults;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtRxString;

        public ViewHolder(View itemView) {
            super(itemView);
            txtRxString = (TextView) itemView.findViewById(R.id.txtRxString);
        }
    }

    public RxCUIsResultsAdapter(ArrayList<Data> rxCUIResults) {
        this.rxCUIResults = rxCUIResults;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_rxcui_result, parent, false);
        return new RxCUIsResultsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Data currentRecord = rxCUIResults.get(position);
        holder.txtRxString.setText(currentRecord.getRxstring());
    }

    @Override
    public int getItemCount() {
        return rxCUIResults.size();
    }




}
