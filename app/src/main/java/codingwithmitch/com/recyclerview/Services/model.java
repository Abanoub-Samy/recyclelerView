package codingwithmitch.com.recyclerview.Services;

import com.google.gson.annotations.SerializedName;

public class model {

    @SerializedName("id")
    private int id  ;
    @SerializedName("title")
    private String title ;
    
    @SerializedName("body")
    private String body;

    public model(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
