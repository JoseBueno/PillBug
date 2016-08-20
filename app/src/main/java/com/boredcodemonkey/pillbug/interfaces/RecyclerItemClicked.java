package com.boredcodemonkey.pillbug.interfaces;

import com.boredcodemonkey.pillbug.contracts.rxcui.Data;

/**
 *
 * Created by josebueno on 8/20/16.
 */
public interface RecyclerItemClicked<T> {
    void onListItemClicked(T data);
}
