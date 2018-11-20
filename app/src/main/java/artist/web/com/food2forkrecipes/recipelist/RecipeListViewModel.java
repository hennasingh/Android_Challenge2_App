package artist.web.com.food2forkrecipes.recipelist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import artist.web.com.food2forkrecipes.data.Recipe;
import artist.web.com.food2forkrecipes.helpers.ResultDisplay;
import artist.web.com.food2forkrecipes.network.repository.WebRepository;

public class RecipeListViewModel extends ViewModel {


    RecipeListViewModel(){
        WebRepository.getInstance().getRecipeListResult();
    }


    public LiveData<ResultDisplay<List<Recipe>>> getRecipeList(){
        return WebRepository.getInstance().getRecipeListData();
    }
}
