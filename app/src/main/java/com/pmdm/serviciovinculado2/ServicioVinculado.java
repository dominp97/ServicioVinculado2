package com.pmdm.serviciovinculado2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ServicioVinculado extends Service {

    private IBinder myBinder = new BinderLocal();
    private int contador;

    public class BinderLocal extends Binder {
        ServicioVinculado getService() {
            return ServicioVinculado.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        contador = 0;
        return myBinder;
    }

    public String getCurrentTime() {
        contador ++;
        return (String.valueOf(contador));
    }

}
