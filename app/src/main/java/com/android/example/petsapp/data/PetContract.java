package com.android.example.petsapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Sagar on 2/9/2017.
 */
public class PetContract {

    private PetContract(){
    }

    //the main method for CONTENT_AUTHORITY
    public static final String CONTENT_AUTHORITY = "com.android.example.petsapp";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_PETS = "pets";


    public static final class PetEntry implements BaseColumns {

        //MIME type for list of pets
        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        //MIME type for a single pet
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        public final static String TABLE_NAME = "pets";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_PET_NAME = "name";

        public final static String COLUMN_PET_BREED = "breed";

        public final static String COLUMN_PET_GENDER = "gender";

        public final static String COLUMN_PET_WEIGHT = "weight";

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        public static boolean isValidGender(int gender){
            if(gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE){
                return true;
            }
            return false;
        }

    }
}
