package valutecourse.repository;

import valutecourse.ConnectionManager;
import valutecourse.entity.Valute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PostgresValuteDao implements ValuteDao{
    private Connection connection;
    private PreparedStatement ps;

    public PostgresValuteDao() {
        connection  = ConnectionManager.getConnection();
    }

    @Override
    public void addValute(Valute valute) throws SQLException {
//        ps = connection.prepareStatement("INSERT INTO valute" +
//                " (id, numcode, charcode, nominal, name, value)" +
//                " VALUES (?,?,?,?,?,?)");
//        ps.setString(1, valute.getId());
//        ps.setInt(2,valute.getNumCode());
//        ps.setString(3,valute.getCharCode());
//        ps.setInt(4,valute.getNominal());
//        ps.setString(5,valute.getName());
//        ps.setDouble(6, valute.getValue());
        ps = connection.prepareStatement("INSERT INTO valutecurs (date, valute) VALUES (?,{})")

        ps.executeUpdate();
    }

    @Override
    public void updateValute(Valute valute) {

    }

    @Override
    public void deleteValute(String id) {

    }

    @Override
    public void deleteValute(int id) {

    }

    @Override
    public Valute getValuteById(String id) {
        return null;
    }

    @Override
    public Valute getValuteById(int id) {
        return null;
    }

    @Override
    public List<Valute> getAllValute() {
        return null;
    }
}
