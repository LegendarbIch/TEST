package valutecourse.repository;

import valutecourse.ConnectionManager;
import valutecourse.entity.Valute;

import java.sql.Connection;
import java.util.List;

public class PostgresValuteDao implements ValuteDao{

    public PostgresValuteDao(){
        Connection conn = ConnectionManager.getConnection();
    }

    @Override
    public void addValute(Valute valute) {

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
