package com.template.helpers.models.users;

import java.util.Random;

public enum FirstName {
    AIDEN("Aiden"),
    ALEXANDER("Alexander"),
    ETHAN("Ethan"),
    JACOB("Jacob"),
    LIAM("Liam"),
    JAYDEN("Jayden"),
    MASON("Mason"),
    MICHAEL("Michael"),
    NOAH("Noah"),
    WILLIAM("William"),
    ALESSANDRO("Alessandro"),
    ANDREA("Andrea"),
    DAVID("David"),
    FRANCESCO("Francesco"),
    GABRIELE("Gabriele"),
    LEONARDO("Leonardo"),
    LORENZO("Lorenzo"),
    MATTEO("Matteo"),
    MATTIA("Mattia"),
    RICCARDO("Riccardo"),
    ALFIE("Alfie"),
    CHARLIE("Charlie"),
    JACK("Jack"),
    LEON("Leon"),
    JAMES("James"),
    HARRY("Harry"),
    OLIVER("Oliver"),
    RILEY("Riley"),
    THOMAS("Thomas"),
    COOPER("Cooper"),
    JACKSON("Jackson"),
    LUCAS("Lucas"),
    BEN("Ben"),
    FELIX("Felix"),
    FINN("Finn"),
    JONAS("Jonas"),
    LUCA("Luca"),
    LUIS("Luis"),
    MAXIMILIAN("Maximilian"),
    PAUL("Paul"),
    AGUSTIN("Agustin"),
    BENJAMIN("Benjamin"),
    CRISTOBAL("Cristobal"),
    MARTIN("Martin"),
    SEBASTIAN("Sebastian"),
    VICENTE("Vicente"),
    ADRIAN("Adrian"),
    ALEJANDRO("Alejandro"),
    ALVARO("Alvaro"),
    DANIEL("Daniel"),
    JAVIER("Javier"),
    DIEGO("Diego"),
    HUGO("Hugo"),
    VIACHESLAV("Viacheslav");

    private final String firstName;

    FirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameText() {
        return firstName;
    }

    public static FirstName getAny() {
        int rnd = new Random().nextInt(values().length);
        return values()[rnd];
    }
}
