package valutecourse;

import valutecourse.entity.ValCurs;
import valutecourse.repository.PostgresValCursDao;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException, SQLException {
        ValCursDataCollector valCursDataCollector = new ValCursDataCollector();
        PostgresValCursDao postgresValCursDao = new PostgresValCursDao();
//        for (int i = 2000; i < 2024; i++) {
//            postgresValCursDao.addValCurs(valCursDataCollector.getCourseByDate("01.01." + i));
//        }
    }
}
