package Model;

public class Word {
    private String word;
    private String meaning;

    Word(){

    };

    Word(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }

    public void setWord(String word){
        this.word = word;
    }
    public String getWord(){
        return word;
    }
    public void setMeaning(String meaning){
        this.meaning = meaning;
    }
    public String getMeaning(){
        return meaning;
    }
}
