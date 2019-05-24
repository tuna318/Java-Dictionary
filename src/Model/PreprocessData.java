package Model;

import java.io.*;



public class PreprocessData {
    public static void main(String[] args){
        String word, meaning;
        DatabaseMN databaseMN = new DatabaseMN();
        Word dictWord = new Word();
        try {
            FileReader fr = new FileReader("av.dd");
            BufferedReader br = new BufferedReader(fr);
            Reader meaning_r;
            BufferedReader meaning_bf;
            String line;

            try {
                while ((line = br.readLine()) != null){
                    if(line.contains("###")) {
                        word = line.substring(0, line.indexOf("#"));
                        meaning = line.substring(line.lastIndexOf("#") + 1);
                        meaning = meaning.replaceAll("\\|", "\n");
                        meaning = meaning.replaceAll("=", "e.g:");
                        meaning = meaning.replaceAll("\\+", "   ");
                        word = word.replaceAll("'", "''");



                        dictWord.setWord(word.trim());
                        dictWord.setMeaning(meaning);
                        if(databaseMN.searchWord(word, "EnVi").getWord() == null)
                            databaseMN.addWord(dictWord, "EnVi");
                    }
                }
            } catch (IOException e){
                System.out.println(e.fillInStackTrace());
            }

        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }


    }
}
