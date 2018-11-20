package artist.web.com.food2forkrecipes;

import android.app.Application;

import artist.web.com.food2forkrecipes.network.ApiManager;

public class RecipeApplication extends Application {

    public static ApiManager sApiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sApiManager = ApiManager.getInstance();
    }
}
