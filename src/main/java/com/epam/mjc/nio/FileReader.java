package com.epam.mjc.nio;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String s;
            while ((s = stream.readLine()) != null) {
                stringBuilder.append(s);
                stringBuilder.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder);

        List<String> res = Arrays.asList(stringBuilder.toString().split("\n"));

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

        String name = res.get(0).split("\\s+")[1];
        int age = Integer.parseInt(res.get(1).split("\\s+")[1]);
        String email = res.get(2).split("\\s+")[1];
        Long phone = Long.parseLong(res.get(3).split("\\s+")[1]);

        return new Profile(name, age, email, phone);
    }

}
