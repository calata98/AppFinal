package calatayud.pablo.appfinal;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class UsuarioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Profile profileF = new Profile();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame,profileF)
                .addToBackStack(null)
                .commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            cont = 0;
        } else {
            cont++;
            if (cont >= 2){
                this.finish();
                cont = 0;
            }else{
                Toast.makeText(this, "Pulse otra vez el botón de atrás para salir", Toast.LENGTH_LONG).show();
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Profile profileF = new Profile();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,profileF)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_pedido) {
            Pedidos pedidosF = new Pedidos();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,pedidosF)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_admin) {
            Admin adminF = new Admin();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, adminF)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_tool) {
            Opciones opcionesF = new Opciones();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, opcionesF)
                    .addToBackStack(null)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
