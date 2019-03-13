package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

public class TablaAdapter extends AbstractTableAdapter {

    public TablaAdapter(Context context) {
        super(context);
    }

    class CeldaViewHolder extends AbstractTableAdapter{

        public CeldaViewHolder(Context context) {
            super(context);

        }

        @Override
        public int getColumnHeaderItemViewType(int position) {
            return 0;
        }

        @Override
        public int getRowHeaderItemViewType(int position) {
            return 0;
        }

        @Override
        public int getCellItemViewType(int position) {
            return 0;
        }

        @Override
        public AbstractViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindCellViewHolder(AbstractViewHolder holder, Object cellItemModel, int columnPosition, int rowPosition) {

        }

        @Override
        public AbstractViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, Object columnHeaderItemModel, int columnPosition) {

        }

        @Override
        public AbstractViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindRowHeaderViewHolder(AbstractViewHolder holder, Object rowHeaderItemModel, int rowPosition) {

        }

        @Override
        public View onCreateCornerView() {
            return null;
        }
    }

    @Override
    public int getColumnHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getCellItemViewType(int position) {
        return 0;
    }

    @Override
    public AbstractViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindCellViewHolder(AbstractViewHolder holder, Object cellItemModel, int columnPosition, int rowPosition) {

    }

    @Override
    public AbstractViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, Object columnHeaderItemModel, int columnPosition) {

    }

    @Override
    public AbstractViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindRowHeaderViewHolder(AbstractViewHolder holder, Object rowHeaderItemModel, int rowPosition) {

    }

    @Override
    public View onCreateCornerView() {
        return null;
    }
}
