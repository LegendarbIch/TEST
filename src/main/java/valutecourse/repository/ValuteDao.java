package valutecourse.repository;

import valutecourse.entity.Valute;

import java.util.List;

public interface ValuteDao {
    void addValute(Valute valute);
    void updateValute(Valute valute);
    void deleteValute(String id);
    void deleteValute(int id);
    Valute getValuteById(String id);

    Valute getValuteById(int id);

    List<Valute> getAllValute();
}
