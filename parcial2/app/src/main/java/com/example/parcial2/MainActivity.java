package com.example.parcial2;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.parcial2.model.Empleado;
import com.example.parcial2.sininterface.CrudEmpleadoInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public  Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.101.75:8081/")
            .addConverterFactory(GsonConverterFactory.create()).build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAll();

        // crear empleado para colocar desde terminal
        Empleado emp= new Empleado("1006196256",
                                "Luigi Rosero",
                                "luigi2205",
                                "luigi.rosero00@usc.edu.co");
        crear_empleado(emp);

        // actulizar empleado por id desde terminal
        int id=1006196256;
        Empleado emple = new Empleado("1006196256",
                                  "luigi rosero renteria",
                                  "luigi rosero0522",
                                  "luigi.rosero01@usc.edu.co");
        actualizar_empleado(id,emple);

        // eliminar empleado por id
        int id_borrar=1006196256;
        eliminar_empleado_id(id_borrar);

        consultar_ID(1006196256);
    }

    public void eliminar_empleado_id(int id){

        CrudEmpleadoInterface cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = cruempleado.eliminar_empleado_id(id);
        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                Toast.makeText(MainActivity.this,
                               "Empleado borrado con Exito", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                               "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void consultar_ID(int id){

        CrudEmpleadoInterface cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = cruempleado.consultar_ID(id);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                Toast.makeText(MainActivity.this,
                               "Empleado borrado con Exito", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                               "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void actualizar_empleado(int id,Empleado u){

        CrudEmpleadoInterface cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = cruempleado.actualizar_empleado(id, u);

        call.enqueue(new Callback<Empleado>() {

            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,
                                   "Empleado Actulizado con Exito", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void crear_empleado(Empleado u){

        CrudEmpleadoInterface cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = cruempleado.crear_empleado(u);

        call.enqueue(new Callback<Empleado>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if(!response.isSuccessful()){

                    Log.e("text",response.message());
                    return;
                }

                List<Empleado> listEmpleado = (List<Empleado>) response.body();

                listEmpleado.forEach(p-> Log.i("emp",p.getNombre()));

                Toast.makeText(MainActivity.this,
                               "correcto",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void getAll(){

        CrudEmpleadoInterface cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = cruempleado.getAll();

        call.enqueue(new Callback<List<Empleado>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {


                if(!response.isSuccessful()){

                    Log.e("text",response.message());
                    return;
                }

                List<Empleado> listEmpleado = response.body();

                listEmpleado.forEach(p-> Log.i("emp",p.getNombre()));

                Toast.makeText(MainActivity.this,
                               "correcto",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();


            }

        });

    }

}