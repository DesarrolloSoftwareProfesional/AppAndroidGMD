package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import pe.com.gmd.appeasyshopping.Clases.MyAdapter;
import pe.com.gmd.appeasyshopping.Entidades.Categoria;

public class PrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        , OnFragmentInteractionListener{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton mFloatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNavigationDrawer(toolbar);
        cargarUI();
    }

    private void cargarUI(){
        cargarRecycleView();
        cargarEventos();
    }

    private void cargarEventos(){
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.FlAcBtnNewProductos);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(v.getContext(),NewProductActivity.class);
                startActivity(inte);
            }
        });
    }

    private void setNavigationDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,   R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void cargarRecycleView(){
        mRecyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mAdapter = new MyAdapter(Arrays.asList(getResources().getStringArray(R.array.Categorias)));
        List<Categoria> listCat = new ArrayList();
        listCat.add(new Categoria("Instrumentos", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.instrumentos));
        listCat.add(new Categoria("accesorios", "28 Tipo de accesorios",
                "100 Productos", R.drawable.accesorios));
        listCat.add(new Categoria("computacion", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.computacion));
        listCat.add(new Categoria("consolas", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.consolas));
        listCat.add(new Categoria("deportes", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.deportes));
        listCat.add(new Categoria("moda", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.moda));
        listCat.add(new Categoria("hogar", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.hogar));

        mAdapter = new MyAdapter(listCat);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.principal_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(this,"Buscar Categoria",Toast.LENGTH_SHORT).show();
                break;
           /*case R.id.action_add:
                Intent inte = new Intent(this,NewProductActivity.class);
                startActivity(inte);
                break;
            case R.id.action_login:
                Intent intelog = new Intent(this,LoginActivity.class);
                startActivity(intelog);
                break;*/
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = new Intent();
        switch (id){
            case R.id.nav_publica_anuncio:
                intent.setClass(this, NewProductActivity.class);
                break;
            case R.id.nav_mi_perfil:
                intent.setClass(this, MiPerfilActivity.class);
                break;
            case R.id.nav_mis_anuncios:
                intent.setClass(this, PrincipalActivity.class);
                break;

        }

        startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
