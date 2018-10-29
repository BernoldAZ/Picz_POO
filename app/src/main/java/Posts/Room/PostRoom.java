package Posts.Room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.media.Image;

import java.util.Date;

import Posts.iPostable;

@Entity (tableName = "Post")
public class PostRoom implements iPostable {

    @PrimaryKey
    Date fecha; //Hay que convertirlo a un tipo de dato primitivo

    String Comment;

    //Image Photo; //Hay que convertirlo a un tipo de dato primitivo

    public void savePost() {

    }
}
