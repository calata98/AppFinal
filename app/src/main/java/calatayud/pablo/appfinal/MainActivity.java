package calatayud.pablo.appfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    EditText userNameT, passT;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameT = (EditText) findViewById(R.id.usuario);
        passT = (EditText) findViewById(R.id.pass);
    }

    public void acceder(View view){
        Intent intAcceder = new Intent(this, UsuarioActivity.class);

        String textoUserName = userNameT.getText().toString();
        String textoPass = passT.getText().toString();

        startActivity(intAcceder);

            //Toast.makeText(this, "Datos introducidos incorrectos", Toast.LENGTH_LONG).show();




    }





}
