package artist.web.com.food2forkrecipes.recipelist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import artist.web.com.food2forkrecipes.SingleFragmentActivity;

public class RecipeListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new RecipeListFragment();
    }

    public static Intent newIntent(Context context){
        return new Intent(context,RecipeListActivity.class);

    }
}
