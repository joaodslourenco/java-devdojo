package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;


import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static List<Producer> findByName(String name) {
        List<Producer> producers = new ArrayList<>();

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = createPreparedStatementFindByName(conn, name);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
        return producers;
    }

    public static void create(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementCreate(conn, producer)
        ) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void update(int id, String name) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = createPreparedStatementUpdate(conn, id, name)
        ) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while updating producer ID '{}'", id);
        }
    }

    public static void delete(int id) {
        try (Connection conn = academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementDelete(conn, id)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }


    private static PreparedStatement createPreparedStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM producer WHERE name LIKE ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + name + "%");
        return ps;
    }

    private static PreparedStatement createPreparedStatementCreate(Connection connection, Producer producer) throws SQLException {
        String sql = "INSERT INTO producer (name) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        return ps;
    }

    private static PreparedStatement createPreparedStatementUpdate(Connection connection, int id, String name) throws SQLException {
        String sql = "UPDATE producer SET name = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, id);
        return ps;
    }

    private static PreparedStatement createPreparedStatementDelete(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM producer WHERE (id = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

}
