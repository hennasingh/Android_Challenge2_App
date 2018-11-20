package artist.web.com.food2forkrecipes.recipelist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import artist.web.com.food2forkrecipes.R;
import artist.web.com.food2forkrecipes.data.Recipe;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> mRecipeList;


    public RecipeAdapter(){
    }

    public void setRecipes(List<Recipe> recipes){
        mRecipeList = recipes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_item_list,viewGroup,
                false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int position) {

        Recipe recipe = mRecipeList.get(position);
        recipeViewHolder.bindTo(recipe);
    }

    @Override
    public int getItemCount() {
        return mRecipeList!=null? mRecipeList.size():0 ;
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_recipe_title)
        TextView mRecipeTitleText;

        @BindView(R.id.iv_recipe_image)
        ImageView mRecipeImage;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindTo(Recipe recipe) {
            mRecipeTitleText.setText(recipe.getTitle());
            Picasso.get()
                    .load(recipe.getImageUrl())
                    .error(R.drawable.image_not_found)
                    .placeholder(R.drawable.loading)
                    .into(mRecipeImage);
        }
    }
}
