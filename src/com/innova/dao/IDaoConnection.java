package com.innova.dao;

import com.innova.util.DatabaseConnection;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

//jenerik yapı
public interface IDaoConnection<T> {
    //CRUD
    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public ArrayList <T> list();



    //Connection

    default Connection getInterfaceConnection(){
        return DatabaseConnection.getInstance().getConnection();

    }




}
