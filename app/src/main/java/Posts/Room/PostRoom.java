package Posts.Room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Base64;

@Entity (tableName = "Post")
public class PostRoom {
    @NonNull
    @PrimaryKey
    String Photo;

    String Comment;

    Long date;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Bitmap getPhoto(){
            try {
                byte [] encodeByte=Base64.decode(this.Photo,Base64.DEFAULT);
                Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
                return bitmap;
            } catch(Exception e) {
                e.getMessage();
                return null;
            }
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }


    public PostRoom() {

    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getComment() {
        return Comment;
    }

    public void savePost(PostDataBase db, PostRoom post) {
        db.PostDAO().insert(post);
    }
}
