package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepositoryRowset {
    public static List<Producer> findByNameJdbcRowset(String name) {
        String sql = "SELECT * FROM producer WHERE name LIKE ?;";
        List<Producer> producers = new ArrayList<>();

        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.setCommand(sql);
            jrs.setString(1, name);
            jrs.execute();

            while(jrs.next()) {
                Producer producer = Producer.builder().id(jrs.getInt("id")).name(jrs.getString("name")).build();

                producers.add(producer);
            }
            return producers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void updateJdbcRowset(Integer id, String name) {
//        String sql = "UPDATE producer SET name = ? WHERE id = ?;";
//
//        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
//            jrs.setCommand(sql);
//            jrs.setString(1, name);
//            jrs.setInt(2, id);
//            jrs.execute();
//
//            log.info("Producer ID {} updated successfully!", id);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void updateJdbcRowset(Integer id, String name) {
        String sql = "SELECT * FROM producer WHERE id = ?";

        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.setCommand(sql);
            jrs.setInt(1, id);
            jrs.execute();

            if (!jrs.next()) return;

            jrs.updateString("name", name);
            jrs.updateRow();

            log.info("Producer ID {} updated successfully!", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateCachedRowset(Integer id, String name) {
        String sql = "SELECT * FROM producer WHERE id = ?";

        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet()) {
            crs.setCommand(sql);
            crs.setInt(1, id);
            crs.execute();

            if (!crs.next()) return;

            crs.updateString("name", name);
            crs.updateRow();
            crs.acceptChanges();

            log.info("Producer ID {} updated successfully!", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
