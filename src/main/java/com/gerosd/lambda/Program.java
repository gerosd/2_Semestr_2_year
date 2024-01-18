package com.gerosd.lambda;

public class Program {

    public static void fire(Object sender) {
        System.out.println("Fire!!!");
    }

    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        sw.addElectricity(lamp);
        sw.addElectricity(radio);

        sw.addElectricity(
            s -> System.out.println("Пожар"));

        sw.addElectricity( Program::fire );

        sw.switchOn();
    }
}
