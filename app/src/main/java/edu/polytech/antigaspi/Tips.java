package edu.polytech.antigaspi;

import java.util.ArrayList;

public class Tips extends ArrayList<Tip> {
    public Tips(){
        add(new Tip("Fromage", "Mettre au Frais"));
        add(new Tip("Couscous", "Mettre au chaud"));
        add(new Tip("Pomme", "Mettre dedans"));
        add(new Tip("Fraise", "Mettre dehors"));

    }

}

