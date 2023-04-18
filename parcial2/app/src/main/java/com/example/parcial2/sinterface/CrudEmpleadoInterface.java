package com.example.parcial2.sininterface;

import com.example.parcial2.model.Empleado;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface CrudEmpleadoInterface {

    @GET("/consultarAll") // consultar_todo
    Call<List<Empleado>> getAll();

    @GET("/consultar/{id}")  // consultar_por_id
    Call<Empleado> consultar_ID(@Path("id") int id);

    @POST("/guardar") // guardar_empleado
    Call<Empleado> crear_empleado(@Body Empleado dto);

    @PUT("/actualizar/{id}") // actualizar_empleado
    Call<Empleado> actualizar_empleado(@Path("id") int id, @Body Empleado dto);

    @DELETE("/user/{id}") // eliminar_empleado
    Call<Empleado> eliminar_empleado_id(@Path("id") int id);


}
