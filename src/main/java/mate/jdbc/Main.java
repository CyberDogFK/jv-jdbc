package mate.jdbc;

import mate.jdbc.dao.Dao;
import mate.jdbc.dao.impl.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.models.Manufacturer;
import mate.jdbc.util.ConnectionToDbUtil;
import mate.jdbc.util.DbPropertiesFileReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class Main {
    private static Injector injector = Injector.getInstance("main.jdbc");

    public static void main(String[] args) {
//        Properties dbproperties = DbPropertiesFileReader
//                .getPropertiesFrom("src/main/resources/DBProperties");
//        System.out.println(dbproperties);
//        Connection connection = ConnectionToDbUtil.getConnection(dbproperties);
//
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM manufacturers");
//            resultSet.next();
//            System.out.println(resultSet.getString("name"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Dao<?> dao = (Dao<?>) injector.getInstance(Manufacturer.class);
        Injector injector = Injector.getInstance("mate.jdbc");
        System.out.println(injector.classes);
        Dao<Manufacturer> dao = (Dao<Manufacturer>) injector.getInstance(Dao.class);
//        ManufacturerDao dao = (ManufacturerDao) injector.getInstance(ManufacturerDao.class);
        List<Manufacturer> list = dao.getAll();
        System.out.println(list.get(0).getName());
//
//        System.out.println(dao.get(1L));
//        Manufacturer manufacturer = new Manufacturer();
//        manufacturer.setName("Kate");
//        manufacturer.setCountry("Mava");
//        manufacturer.setId(4L);
//        dao.update(manufacturer);
//        System.out.println(manufacturer.getId());
        System.out.println(dao.getAll());
    }
}
