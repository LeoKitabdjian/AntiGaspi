package edu.polytech.antigaspi;

import android.graphics.SweepGradient;

import java.util.ArrayList;

import edu.polytech.antigaspi.factories.SaltFactory;
import edu.polytech.antigaspi.factories.SweetFactory;

public class Tips extends ArrayList<Tip> {
    private static Tips tips;

    private Tips(){
        SaltFactory saltFactory = new SaltFactory();
        SweetFactory sweetFactory = new SweetFactory();
        add(new Tip(saltFactory.buildIngredient("Fromage"), "Pensez à bien le mettre au frais pour le conserver plus longtemps"));
        add(new Tip(saltFactory.buildIngredient("Couscous"), "Pensez à bien le conserver dans un récipient fermé et un endroit sec"));
        add(new Tip(sweetFactory.buildIngredient("Pomme"), "Si vous mettez une pomme au frigo, elle va noircir mais vous pouvez toujours la manger tant qu'elle n'est pas abimée"));
        add(new Tip(sweetFactory.buildIngredient("Banane"), "Vous pouvez manger une banane même si celle-ci a noirci"));
        add(new Tip(saltFactory.buildIngredient("Pain"), "Pour garder un bon pain frais plus longtemps, optez pour la fameuse boîte à pain ou plus simplement une boîte hermétique. Mais ce n'est pas tout, ajoutez-y une pomme coupée en deux pour éviter que le pain ne se dessèche. Ça marche aussi avec une branche de cèleri, une pomme de terre ou un morceau de sucre !"));
    }

    public static Tips getInstance() {
        if (tips == null) {
            tips = new Tips();
        }
        return tips;
    }

}

