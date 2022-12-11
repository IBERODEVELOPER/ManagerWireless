package informatico.to.managerwireless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    /*creamos un objeto de la clase*/
    ImageView imagen;
    WifiManager admini_wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //llamamo a la imagen por su nombre que tiene que estar en drawable
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        /*Enlazamos el objeto de la clase imagenview con el id del xml*/
        imagen= (ImageView) findViewById(R.id.imgVwireless);
        /*Capturamos el estado del servicio*/
        admini_wifi=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        /*consultamos si el servicio esta activo entonces que me muestre segun el
         metodo setimagewifi la imagen correspondientes*/
        setimagenwifi(admini_wifi.isWifiEnabled());
        /*if (admini_wifi.isWifiEnabled()==false){
            System.out.println("Encendiendo...");
            admini_wifi.setWifiEnabled(true);
        }else{
            System.out.println("Apagando...");
            admini_wifi.setWifiEnabled(false);
        }*/
    }
    //Metodo para el onclick
    public void click_imagen(View v){
        setestadowifi();
    }
    //creamos un metodo que me devuelva un valor booleano
    public void setimagenwifi(boolean valor){
        //si el valor es verdadero entonces me mostrar la imagen wifi_on
        if (valor)imagen.setImageResource(R.drawable.wifi_on);
        //De lo contrario la imagen wifi_off
        else imagen.setImageResource(R.drawable.wifi_off);

    }
    //Metodo para saber el estado del servicio wifi
    public void setestadowifi()
    {
        //consultamos si el wifi es diferente de enable entonces me mostrara la imagen correspondiente
        setimagenwifi(!admini_wifi.isWifiEnabled());
        admini_wifi.setWifiEnabled(!admini_wifi.isWifiEnabled());
    }
}