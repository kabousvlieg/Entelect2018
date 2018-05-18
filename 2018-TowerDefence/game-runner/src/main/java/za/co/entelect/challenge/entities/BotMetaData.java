package za.co.entelect.challenge.entities;

import com.google.gson.annotations.SerializedName;
import za.co.entelect.challenge.enums.BotLanguage;

public class BotMetaData {
    @SerializedName("author")
    private String author;
    @SerializedName("email")
    private String email;
    @SerializedName("nickName")
    private String nickName;

    @SerializedName("botLanguage")
    private BotLanguage botLanguage;
    @SerializedName("botLocation")
    private String botLocation;
    @SerializedName("botFileName")
    private String botFileName;

    public BotMetaData(BotLanguage language, String botLocation, String botFileName){
        this.botLanguage = language;
        this.botLocation = botLocation;
        this.botFileName = botFileName;
    }

    public String getAuthor() {
        return author;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    public String getBotLocation(){
        return this.botLocation;
    }

    public void setRelativeBotLocation(String relativeLocation) {
        this.botLocation = relativeLocation + this.botLocation;
    }

    public String getBotFileName() {
        return this.botFileName;
    }

    public BotLanguage getBotLanguage(){
        return this.botLanguage;
    }
}
