package Posts.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = {PostRoom.class}, version = 1)
@TypeConverters({DateTypeConverter.class})
public abstract class PostDataBase extends RoomDatabase {

    public abstract PostDAO getPostDAO();
}
