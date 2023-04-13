package valutecourse.repository;

import valutecourse.ConnectionManager;
import valutecourse.ObjectJsonConverter;
import valutecourse.entity.ValCurs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresValCursDao {

    private Connection connection;

    private final ObjectJsonConverter<ValCurs> jsonConverter = new ObjectJsonConverter<>();

    public PostgresValCursDao() {
        connection  = ConnectionManager.getConnection();
    }

    public void addValCurs(ValCurs valCurs){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO valutecurs (date, valute) VALUES (?,?::json)");
            ps.setDate(1, Date.valueOf("2023-04-13"));
            ps.setString(2, jsonConverter.convertToJson(valCurs));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
