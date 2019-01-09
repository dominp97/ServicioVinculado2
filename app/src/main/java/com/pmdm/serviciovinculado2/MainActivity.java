package com.pmdm.serviciovinculado2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ServicioVinculado servicio;
    boolean vinculado = false;

    private ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            ServicioVinculado.BinderLocal binder = (ServicioVinculado.BinderLocal) service;
            servicio = binder.getService();
            vinculado = true;
        }

        public void onServiceDisconnected(ComponentName arg0) {
            vinculado = false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, ServicioVinculado.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }


    public void obtenerDato(View view) {
        String currentTime = servicio.getCurrentTime();
        TextView myTextView = (TextView)findViewById(R.id.lblDato);
        myTextView.setText(currentTime);
    }

    public void pulsado(View v){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}



