package ejemplos.universidad.sqlitebasico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText nombreTxt;
    EditText telefonoTxt;
    EditText IDTxt;
    Button GuardaBtn;
    Button SaleBtn;
    ListView ListaClientes;

    private ControlDatos_Class ControlDatosClass = new ControlDatos_Class(this);
    private Util_TextoFechas UtileStrings = new Util_TextoFechas();
    private Util_UI UtilesUI = new Util_UI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incializaPantalla();

        ListaClientes.setAdapter(UtilesUI.CargaArrayAdapter(this, ControlDatosClass.ConsultaClientes()));
        ListViewClick();
    }//Fin onCreate  =======================

    private void ListViewClick(){
        ListaClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int laPosicion = position + 1;
                String elementoSeleccionado = (String) ListaClientes.getItemAtPosition(position);
                String[] TextoPartido = UtileStrings.CortaTextos(elementoSeleccionado, ",");
                IDTxt.setText(String.valueOf(laPosicion));
                nombreTxt.setText(TextoPartido[1]);
                telefonoTxt.setText(TextoPartido[0]);
            }
        });//End setOnItemClickListener
    }//Fin ListViewClick

    private void incializaPantalla() {
        IDTxt = (EditText) findViewById(R.id.NumClie_Txt);
        nombreTxt = (EditText) findViewById(R.id.NomClie_Txt);
        telefonoTxt = (EditText) findViewById(R.id.Tel_Txt);
        ListaClientes = (ListView) findViewById(R.id.Clientes_listView);
        SaleBtn = (Button) findViewById(R.id.Sale_Btn);
        SaleBtn.setOnClickListener(this);
        GuardaBtn = (Button) findViewById(R.id.Guarda_Btn);
        GuardaBtn.setOnClickListener(this);
    }//Fin incializaPantalla =======================

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.Sale_Btn:
                Intent elIntent = new Intent(Intent.ACTION_MAIN);
                elIntent.addCategory(Intent.CATEGORY_HOME);
                elIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(elIntent);
                break;
            case R.id.Guarda_Btn:
                ControlDatosClass.GuardaCliente(nombreTxt.getText().toString(),telefonoTxt.getText().toString());
                ListaClientes.setAdapter(UtilesUI.CargaArrayAdapter(this, ControlDatosClass.ConsultaClientes()));
                break;
        }//End switch
    }//Fin onClick =======================

}
