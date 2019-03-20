package ulacit.holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  {

    Button aceptaBoton;
    EditText nombreTxt;
    TextView rotuloSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incializaPantalla();
    }

    public void incializaPantalla() {
        nombreTxt = (EditText) findViewById(R.id.Nombre_Text);
        rotuloSaludo = (TextView) findViewById(R.id.Saludo_Txt);
        aceptaBoton = (Button) findViewById(R.id.Acepta_Btn);
        aceptaBoton.setOnClickListener(this);
    }//incializaPantalla

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.Acepta_Btn:
                //Imprimimos en el TextView
                rotuloSaludo.setText("Bienvenido: " + nombreTxt.getText());

                //Ahora mostramos el mensaje en un Toast
                Toast.makeText(this, "Hola " + nombreTxt.getText(),
                        Toast.LENGTH_LONG).show();

                break;
        }//End switch
    }//Fin onClick

}//Fin HolaMundoCompleto
