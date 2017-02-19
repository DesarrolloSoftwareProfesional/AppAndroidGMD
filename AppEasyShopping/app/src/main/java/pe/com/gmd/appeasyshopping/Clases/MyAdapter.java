package pe.com.gmd.appeasyshopping.Clases;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.com.gmd.appeasyshopping.R;

/**
 * Created by ASUS on 18/02/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<String> mDataset;

    public MyAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categoria, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvinomCategoria.setText(mDataset.get(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvinomCategoria;
        public ViewHolder(View v) {
            super(v);
            tvinomCategoria = (TextView) v.findViewById(R.id.txtNomCateria);
        }
    }
}
