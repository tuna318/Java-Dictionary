package Model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseMN {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:Dict.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public Word searchWord(String word, String table){
        String sql = String.format("SELECT * FROM %s WHERE %s.word LIKE '%%%s%%'", table.trim(), table.trim(), word.trim());
        Word item = new Word();
        try (Connection conn = this.connect();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(sql)){
             item.setWord(rs.getString("word"));
             item.setMeaning(rs.getString("meaning"));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    public void addWord(Word word, String table){
        String sql = String.format("INSERT INTO %s(word, meaning) VALUES('%s', '%s')", table, word.getWord(), word.getMeaning());

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteWord(Word word, String table){
        String sql = String.format("DELETE FROM %s WHERE word LIKE '%s'", table, word.getWord());

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateWord(Word word, String table){
        String sql = String.format("UPDATE %s SET meaning = '%s' WHERE word = '%s'", table, word.getMeaning(), word.getWord());

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args){
        Word word;
        DatabaseMN testdb = new DatabaseMN();
        word = testdb.searchWord("race way", "EnVi");
        System.out.println(word.getWord() + ": " + word.getMeaning());
        Word word2 = new Word("fan", "Người hâm mộ nhiệt thành");
        testdb.updateWord(word2, "EnVi");
    }
}

