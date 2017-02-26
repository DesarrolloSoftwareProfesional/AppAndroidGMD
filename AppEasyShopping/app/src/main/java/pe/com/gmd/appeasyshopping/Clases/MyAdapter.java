package pe.com.gmd.appeasyshopping.Clases;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.com.gmd.appeasyshopping.Entidades.Categoria;
import pe.com.gmd.appeasyshopping.ProductActivity;
import pe.com.gmd.appeasyshopping.R;

/**
 * Created by ASUS on 18/02/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Categoria> listCategorias;

    public MyAdapter(List<Categoria> categorias) {
        listCategorias = categorias;
    }
    @Override
    public int getItemCount() {
        return listCategorias.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categoria, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Categoria cat;
        cat = listCategorias.get(position);
        holder.txtNomCateria.setText(cat.getNombreCat());
        holder.tvicantSubCategorias.setText(cat.getCantSubCat());
        holder.tvicantProductos.setText(cat.getCantProductos());
         holder.imgCategoria.setImageResource(cat.getDrawableImageID());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNomCateria,tvicantSubCategorias,tvicantProductos;
        public ImageView imgCategoria;
        public Button btnSeleccionarCat;
        public CardView CviCategoria;
        public ViewHolder(View v) {
            super(v);
            txtNomCateria = (TextView) v.findViewById(R.id.txtNomCateria);
            tvicantSubCategorias = (TextView) v.findViewById(R.id.tvicantSubCategorias);
            tvicantProductos = (TextView) v.findViewById(R.id.tvicantProductos);
            imgCategoria = (ImageView) v.findViewById(R.id.imgCategoria);
            //btnSeleccionarCat = (Button) v.findViewById(R.id.btnSeleccionarCat);
            CviCategoria  = (CardView) v.findViewById(R.id.CviCategoria);
            CviCategoria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombrecat;
                    nombrecat = txtNomCateria.getText().toString();
                    Toast.makeText(v.getContext(),nombrecat,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), ProductActivity.class);
                    intent.putExtra("nomCategoria",nombrecat);
                    v.getContext().startActivity(intent);
                }
            });
//            btnSeleccionarCat.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String nombrecat;
//                    nombrecat = txtNomCateria.getText().toString();
//                    Toast.makeText(v.getContext(),nombrecat,Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(v.getContext(), ProductActivity.class);
//                    intent.putExtra("nomCategoria",nombrecat);
//                    v.getContext().startActivity(intent);
//                }
//            });
        }
    }
}
