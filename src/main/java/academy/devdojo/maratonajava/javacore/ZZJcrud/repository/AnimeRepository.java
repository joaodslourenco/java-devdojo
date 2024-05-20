package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {

    public static Optional<Anime> findById(int id) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = createPreparedStatementFindById(conn, id);
                ResultSet rs = ps.executeQuery()
        ) {
            if(!rs.next()) return Optional.empty();
            Producer producer = Producer
                    .builder()
                    .id(rs.getInt("producer_id"))
                    .name(rs.getString("producer_name"))
                    .build();

            Anime anime = Anime
                    .builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .episodes(rs.getInt("episodes"))
                    .producer(producer)
                    .build();
            return Optional.of(anime);
        } catch (SQLException e) {
            log.error("Error while trying to find all animes ", e);
        }
        return Optional.empty();
    }

    public static List<Anime> findByName(String name) {
        List<Anime> animes = new ArrayList<>();

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = createPreparedStatementFindByName(conn, name);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("producer_id"))
                        .name(rs.getString("producer_name"))
                        .build();

                Anime anime = Anime
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .episodes(rs.getInt("episodes"))
                        .producer(producer)
                        .build();

                animes.add(anime);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all animes ", e);
        }
        return animes;
    }

    public static void create(Anime anime) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementCreate(conn, anime)
        ) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while trying to insert anime '{}'", anime.getName(), e);
        }
    }

    public static void update(int id, String name, int episodes, int producerId) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = createPreparedStatementUpdate(conn, id, name, episodes, producerId)
        ) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while updating anime ID '{}'", id);
        }
    }

    public static void delete(int id) {
        try (Connection conn = academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementDelete(conn, id)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while trying to delete anime '{}'", id, e);
        }
    }

    private static PreparedStatement createPreparedStatementFindById(Connection connection, int id) throws SQLException {
        String sql = """
                SELECT A.id, A.name, A.episodes, A.producer_id, P.name AS 'producer_name'
                FROM anime A
                INNER JOIN producer P
                ON A.producer_id = P.id
                WHERE A.id = ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    private static PreparedStatement createPreparedStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = """
                SELECT A.id, A.name, A.episodes, A.producer_id, P.name AS 'producer_name'
                FROM anime AS A
                INNER JOIN producer AS P
                ON A.producer_id = P.id
                WHERE A.name LIKE ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + name + "%");
        return ps;
    }

    private static PreparedStatement createPreparedStatementCreate(Connection connection, Anime anime) throws SQLException {
        String sql = "INSERT INTO anime (name, episodes, producer_id) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getProducer().getId());

        return ps;
    }

    private static PreparedStatement createPreparedStatementUpdate(Connection connection, int id, String name, int episodes, int producerId) throws SQLException {
        String sql = "UPDATE anime SET name = ?, episodes = ?, producer_id = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, episodes);
        ps.setInt(3, producerId);
        ps.setInt(4, id);
        return ps;
    }

    private static PreparedStatement createPreparedStatementDelete(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM anime WHERE (id = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

}
