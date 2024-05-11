package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static void save(Producer producer) {
        String sql = "INSERT INTO producer (name) VALUES ('%s');".formatted(producer.getName());

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            log.info("Producer '{}' created successfully!", producer.getName());
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void saveTransaction(List<Producer> producers) {
        try (Connection conn = ConnectionFactory.getConnection();) {
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn, producers);
            conn.commit();
        } catch (SQLException e) {
            log.error("Error while trying to save producers", e);
        }
    }

    public static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO producer (name) VALUES (?);";

        boolean shouldRollback = false;

        for (Producer p : producers) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                log.info("Saving producer '{}'", p.getName());
                ps.setString(1, p.getName());

                if (p.getName().equals("white fox")) throw new SQLException("Can't save white fox");

                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                shouldRollback = true;
            }
        }

        if (shouldRollback) {
            log.warn("Transaction will have a rollback");
            conn.rollback();
        }
    }


    public static List<Producer> findAll() {
        String sql = "SELECT * FROM producer;";
        log.info("Finding All Producers...");

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
        return producers;
    }

    public static void showDriverMetaData() {
        log.info("Showing Driver Metadata...");

        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");

                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE");
                }
            }

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");

                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE");
                }
            }

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_FORWARD_ONLY");

                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE");
                }
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
    }

    public static void showProducerMetaData() {
        log.info("Showing Producer Metadata...");
        String sql = "SELECT * FROM producer;";

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();
            log.info("Columns count: {}", columnCount);

            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name: '{}'", metaData.getTableName(i));
                log.info("Column name: '{}'", metaData.getColumnName(i));
                log.info("Column size: '{}'", metaData.getColumnDisplaySize(i));
                log.info("Column type: '{}'", metaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
    }


    public static List<Producer> findByName(String name) {
        String sql = "SELECT * FROM producer WHERE name LIKE '%%%s%%';".formatted(name);

        log.info("Finding One Producer...");

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
        return producers;
    }

    public static List<Producer> findByNamePreparedStatement(String name) {

        log.info("Finding One Producer...");

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = createPreparedStatementFindByName(conn, name); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
        return producers;
    }

    private static PreparedStatement createPreparedStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM producer WHERE name LIKE ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + name + "%");
        return ps;
    }

    private static PreparedStatement createPreparedStatementUpdate(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM producer WHERE name LIKE ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + name + "%");
        return ps;
    }


    public static void delete(int id) {
        String sql = "DELETE FROM producer WHERE (id = %d);".formatted(id);

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            log.info("Producer ID '{}' deleted successfully!", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

    public static void update(int id, String name) {
        String sql = "UPDATE producer SET name = '%s' WHERE (id = %d);".formatted(name, id);

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            log.info("Producer ID '{}' updated successfully!", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM producer;";

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet rs = stmt.executeQuery(sql)) {
            log.info("Last row? {}", rs.last());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
    }

    public static List<Producer> findByNameAndUpdateToUppercase(String name) {
        String sql = "SELECT * FROM producer WHERE name LIKE '%%%s%%';".formatted(name);

        log.info("Finding One Producer...");

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rs.updateString("name", rs.getString("name").toUpperCase());
                rs.updateRow();

                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
        return producers;
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        String sql = "SELECT * FROM producer WHERE name LIKE '%%%s%%';".formatted(name);

        log.info("Finding One Producer...");

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return producers;

            log.info("Producer not found. Inserting new...");

            insertNewProducer(name, rs);
            Producer producer = getProducer(rs);

            producers.add(producer);

        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        String sql = "SELECT * FROM producer WHERE name LIKE '%%%s%%';".formatted(name);

        log.info("Finding One Producer...");

        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.info("Deleting '{}'", rs.getString("name"));
                rs.deleteRow();
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers ", e);
        }
    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        rs.moveToInsertRow();
        rs.updateString("name", name);
        rs.insertRow();
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        rs.next();

        return Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
    }


}
