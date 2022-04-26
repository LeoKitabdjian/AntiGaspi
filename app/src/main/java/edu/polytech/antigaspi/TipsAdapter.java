package edu.polytech.antigaspi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TipsAdapter extends BaseAdapter {
    private IListner listener;
    private Tips tips;

    //Le contexte dans lequel est présent notre adapter
    private Context context;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater inflater;


    public TipsAdapter(Context context, Tips tips) {
        this.context = context;
        this.tips = tips;
        inflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return tips.size();
    }
    public Object getItem(int position) {
        return tips.get(position);
    }
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        //(1) : Réutilisation des layouts
        layoutItem = (LinearLayout) (convertView == null ? inflater.inflate(R.layout.tip_layout, parent, false) : convertView);


        //(2) : Récupération des TextView de notre layout
        TextView tvName = layoutItem.findViewById(R.id.IngredientName);
        TextView tvName2 = layoutItem.findViewById(R.id.ContenuTip);

        //(3) : Renseignement des valeurs
        tvName.setText(tips.get(position).getIngredientName());
        tvName2.setText(tips.get(position).getContenuTip());

        //(4) Changement de la couleur du fond de notre item
        //tvPrice.setTextColor( tips.get(position).getPrice() >= 5 ? Color.RED : Color.BLACK);

        layoutItem.setOnClickListener( click -> {
                listener.onClickTip(tips.get(position));
        });
        //On retourne l'item créé.
        return layoutItem;
    }

    //abonnement pour click sur le nom...
    public void addListener(IListner listener) {
        this.listener = listener;
    }

}




