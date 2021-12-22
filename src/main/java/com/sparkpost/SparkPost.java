package com.sparkpost;

import com.sparkpost.exception.SparkPostException;

public class SparkPost {

    public static void main(String[] args) throws SparkPostException {
        String API_KEY = "a56910db3d6b59af5f3d726e8733f43b8ded2270";
        Client client = new Client(API_KEY);

        client.sendMessage(
                "sparkpost@sebastianbresan.com",
                "sebastianb_25@hotmail.com",
                "FC EJERCICIO 4",
                "TEST DE ENVIO DE EMAIL",
                "<b>NADA</b>");

    }
}