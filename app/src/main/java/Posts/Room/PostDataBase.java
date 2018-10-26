package Posts.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {PostRoom.class}, version = 1)
public abstract class PostDataBase extends RoomDatabase {

    public abstract PostDAO getPostDAO();
}
