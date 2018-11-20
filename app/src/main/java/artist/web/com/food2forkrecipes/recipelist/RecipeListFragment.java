package artist.web.com.food2forkrecipes.recipelist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import artist.web.com.food2forkrecipes.R;
import artist.web.com.food2forkrecipes.data.Recipe;
import artist.web.com.food2forkrecipes.helpers.ResultDisplay;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecipeListFragment extends Fragment {

    private RecipeListViewModel mRecipeListViewModel;

    @BindView(R.id.rv_recipes)
    RecyclerView mRecyclerView;

    @BindView(R.id.text_empty_list)
    TextView mTextMessage;

    @BindView(R.id.progress_indicator)
    ProgressBar mProgressBar;

    Unbinder mUnbinder;
    RecipeAdapter mRecipeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_list,container,false);
        mUnbinder = ButterKnife.bind(this,view);

        //set RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mRecipeAdapter = new RecipeAdapter();
        mRecyclerView.setAdapter(mRecipeAdapter);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecipeListViewModel.getRecipeList().observe(this, new Observer<ResultDisplay<List<Recipe>>>() {
            @Override
            public void onChanged(@Nullable ResultDisplay<List<Recipe>> listResultDisplay) {
                switch(listResultDisplay.state){
                    case ResultDisplay.STATE_LOADING:
                        mProgressBar.setVisibility(View.VISIBLE);
                        mRecyclerView.setVisibility(View.GONE);
                        break;
                    case ResultDisplay.STATE_ERROR:
                        mProgressBar.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.GONE);
                        mTextMessage.setVisibility(View.VISIBLE);
                        mTextMessage.setText(listResultDisplay.errorMessage);
                        break;
                    case ResultDisplay.STATE_SUCCESS:
                        mProgressBar.setVisibility(View.GONE);
                        mTextMessage.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mRecipeAdapter.setRecipes(listResultDisplay.data);

                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
