package pe.com.gmd.appeasyshopping.Clases;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.com.gmd.appeasyshopping.Entidades.Producto;
import pe.com.gmd.appeasyshopping.R;

/**
 * Created by Cecilia on 20/02/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Producto> listaProductos;

    public ProductAdapter(List<Producto> productos) {

        listaProductos = productos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        ProductAdapter.ViewHolder vh = new ProductAdapter.ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Producto producto = listaProductos.get(position);
        holder.txtNombre.setText(producto.getNombre());
       // holder.txtPrecio.setText(producto.getPrecio());
        holder.txtCantProductos.setText(producto.getCantidad());
        holder.imgProducto.setImageResource(producto.getDrawableImageID());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNombre,txtPrecio,txtCantProductos;
        public ImageView imgProducto;

        public ViewHolder(View v) {
            super(v);
            txtNombre = (TextView) v.findViewById(R.id.txtNomProducto);
            txtPrecio = (TextView) v.findViewById(R.id.txtPrecio);
            txtCantProductos = (TextView) v.findViewById(R.id.txtCantProductos);
            imgProducto = (ImageView) v.findViewById(R.id.imgProducto);
        }
    }
}
