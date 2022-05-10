package edu.polytech.antigaspi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import edu.polytech.antigaspi.recipes.RecipeComponents;

public class RecipeComponentAdapter extends BaseAdapter {
    private LayoutInflater inflater;

    public RecipeComponentAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return RecipeComponents.getInstance().size();
    }

    @Override
    public Object getItem(int i) {
        return RecipeComponents.getInstance().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout layout;
        layout = (LinearLayout) (view == null ? inflater.inflate(R.layout.recipecomponent_layout, viewGroup, false) : view);
        ((TextView) layout.findViewById(R.id.ingredient)).setText(RecipeComponents.getInstance().get(i).getIngredient().getNom());
        ((TextView) layout.findViewById(R.id.quantity)).setText(RecipeComponents.getInstance().get(i).getQuantite() + "");
        return layout;
    }
}
