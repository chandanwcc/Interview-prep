package com.chandan.interview.practice.test.practice.sony;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.web.reactive.function.client.WebClient;


public class SonyCoding {

    /**
     * The Random Result Generator REST API is an open web API (it does not require authentication) which returns
     * an array of random users' metadata, including location (e.g. country name) and dob (e.g. age).
     * <p>
     * <p>
     * Example call: https://randomuser.me/api/?seed=playstation&results=20
     * <p>
     * Below we've provided the code for making the call to fetch user data and deserializing it.
     * We've also made a simple set of classes to hold the data.
     * We want you to use and/or update these classes and objects to complete a set of tasks stated in the comments below.
     */


    public static void main(String[] args) throws Exception {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://randomuser.me/api").build();

        Root users = webClient.get().uri(uriBuilder ->
                        uriBuilder.queryParam("seed", "playstation")
                                .queryParam("results", "20").build())
                .retrieve()
                .bodyToMono(Root.class)
                .block();

    /*
       Root is a List<Result>.
       Use/update it to perform the following calculations.
    */

        List<Result> resultList = users.getResultList();


        /*
         * #1 - Calculate and print out the average age of all users
         */

        int sum = 0;

        for (Result u : resultList) {
            sum += u.getDob().getAge();
        }

        int avgAge = sum / resultList.size();

        System.out.println(avgAge);

        /*
         * #2 - Calculate and print out the average age by country.
         */


        Map<String, Integer> ageCountryMap = new HashMap<>();

        List<String> countryList = resultList.stream().map(Result::getLocation).map(Location::getCountry).toList();

        for (String country : countryList) {
            List<Integer> ageList = resultList.stream().filter(x -> x.getLocation().getCountry().equals(country)).map(Result::getDob).map(Dob::getAge).toList();

            int sum1 = 0;
            for (int age : ageList) {
                sum1 += age;
            }

            int avg = sum1 / ageList.size();

            ageCountryMap.put(country, avg);
        }

        System.out.println(ageCountryMap);


        /*
         * #3 - Calculate and print out the number of users per country.
         */

        Map<String, Long> countryUserCountMap = resultList.stream().map(Result::getLocation).map(Location::getCountry).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(countryUserCountMap);
        /*
         * #4 - Add code to deserialize the  "nat" field, then Calculate
         * and print out the distinct values for "nat".
         */

        Set<String> natList = resultList.stream().map(Result::getNat).collect(Collectors.toSet());

        System.out.println(natList);

    }

}
