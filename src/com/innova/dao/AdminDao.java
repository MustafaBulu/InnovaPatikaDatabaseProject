package com.innova.dao;

import com.innova.dto.AdminDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class AdminDao implements IDaoConnection<AdminDto> {
    @Override
    public void create(AdminDto adminDto) {
        try(Connection connection=getInterfaceConnection()) {
            String sql="insert into blog (admin_name,admin_surname) values (?,?);";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,adminDto.getAdminName());
            preparedStatement.setString(2,adminDto.getAdminSurname());


            //birşeyler değişti mi değişmedi mi diye
            int rowEfected=preparedStatement.executeUpdate();
            if(rowEfected>0){
                System.out.println(AdminDao.class+" ekleme başarılı");
            }else {
                System.out.println(AdminDao.class+" ekleme başarısız");
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();

        }
    }

    @Override
    public void update(AdminDto adminDto) {

        try(Connection connectionUpdate=getInterfaceConnection()) {
            String sqlUpdate="update blog set admin_name=?,admin_surname=? where admin_id=? ;";
            PreparedStatement preparedStatementupdate=connectionUpdate.prepareStatement(sqlUpdate);
            preparedStatementupdate.setString(1,adminDto.getAdminName());
            preparedStatementupdate.setString(2,adminDto.getAdminSurname());
            preparedStatementupdate.setInt(3,adminDto.getAdminId());


            //birşeyler değişti mi değişmedi mi diye
            int rowEfected=preparedStatementupdate.executeUpdate();
            if(rowEfected>0){
                System.out.println(AdminDao.class+" güncelleme başarılı");
            }else {
                System.out.println(AdminDao.class+" güncelleme başarısız");
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();

        }


    }

    @Override
    public void delete(AdminDto adminDto) {

        try(Connection connectionDelete=getInterfaceConnection()) {
            String sqlDelete="delete from blog where admin_id=? ;";
            PreparedStatement preparedStatementDelete=connectionDelete.prepareStatement(sqlDelete);
            preparedStatementDelete.setInt(1,adminDto.getAdminId());


            //birşeyler değişti mi değişmedi mi diye
            int rowEfected=preparedStatementDelete.executeUpdate();
            if(rowEfected>0){
                System.out.println(AdminDao.class+" silme başarılı");
            }else {
                System.out.println(AdminDao.class+" silme başarısız");
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();

        }

    }



    @Override
    public ArrayList<AdminDto> list() {
        ArrayList<AdminDto> list2 = new ArrayList<AdminDto>();
        AdminDto adminDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "select * from blog";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                adminDto = new AdminDto();
                adminDto.setAdminId(resultSet.getInt("admin_id"));
                adminDto.setAdminName(resultSet.getString("admin_name"));
                adminDto.setAdminSurname(resultSet.getString("admin_surname"));
                list2.add(adminDto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " AdminDao Listeleme Hata meydana geldi  ");
            e.printStackTrace();
        }
        return list2;
    }
}
