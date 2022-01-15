package com.innova.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection extends DatabaseInformation {
    //Database connection
    private Connection connection;

    //Database connection information
    private String url=this.getUrl();
    private String userName=this.getUserName();
    private String userPassword=this.getUserPassword();

    //Singeleton Design pattern

    private  static DatabaseConnection instance;

    //bundan sonra parametresiz constructor açılır ve private yapılır

    private DatabaseConnection() {
        try {
            Class.forName(this.getForNameData());
            System.out.println("Driver Success");
            this.connection= DriverManager.getConnection(url,userName,userPassword);
            System.out.println("Connection Success");

        }catch (Exception e){
            System.out.println("Connection Failed");
            e.printStackTrace();

        }


    }

    //Eğer bağlantı varsa onu kullanacağız yoksa instance yaparız



    public static   DatabaseConnection getInstance() {

        try {
            if (instance==null)
                instance=new DatabaseConnection();
            else if(instance.connection.isClosed())
                instance=new DatabaseConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }



        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) {
      // DatabaseConnection databaseConnection=new DatabaseConnection();
    }

}
