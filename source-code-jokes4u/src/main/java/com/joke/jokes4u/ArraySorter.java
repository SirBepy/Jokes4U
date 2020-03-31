package com.joke.jokes4u;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class ArraySorter {

    /**
     * Adding more properties to the joke for easier access.
     * @param joke
     * @param categoryName
     * @param index
     * @return JokeVisualised with the id, category id, content, likes and dislikes.
     */
    public JokeVisualised changeToVisualizedJoke(Joke joke, String categoryName, int index) {
        JokeVisualised tempJoke = new JokeVisualised(joke.getId(), joke.getCategoryid(), joke.getContent(), index++);
        tempJoke.setCategoryName(categoryName);
        tempJoke.setLikes(joke.getLikes());
        tempJoke.setDislikes(joke.getDislikes());
        return tempJoke;
    }

    /**
     * Getting an array of jokes based on the category (retrieved from the database).
     * @param jokes
     * @param dbController
     * @return ArrayList with jokes based on the category.
     */
    public List<JokeVisualised> getArrOfVisualizedJokes(List<Joke> jokes, DBController dbController) {
        List<JokeVisualised> toReturn = new ArrayList<JokeVisualised>();
        for (int x = 0; x < jokes.size();) {
            JokeVisualised tempJoke = changeToVisualizedJoke(jokes.get(x),
                    dbController.findCategory(jokes.get(x).getCategoryid()).getName(), ++x);
            toReturn.add(tempJoke);
        }
        return toReturn;
    }

    /**
     * Method to sort jokes based on the oldest to newest.
     * @param jokes
     * @param dbController
     * @param page
     * @return ArrayList of JokeVisualised based on oldest to newest.
     */
    public List<JokeVisualised> sortOldest(List<Joke> jokes, DBController dbController, int page) {
        List<JokeVisualised> toReturn = new ArrayList<JokeVisualised>();
        for (int x = page * 10; x < (page + 1) * 10 && x < jokes.size();)
            toReturn.add(changeToVisualizedJoke(jokes.get(x),
                    dbController.findCategory(jokes.get(x).getCategoryid()).getName(), ++x));

        return toReturn;
    }

    /**
     * Method to sort jokes based on the newest to oldest.
     * @param jokes
     * @param dbController
     * @param page
     * @return ArrayList of JokeVisualised based on newest to oldest.
     */
    public List<JokeVisualised> sortYoungest(List<Joke> jokes, DBController dbController, int page) {
        List<JokeVisualised> toReturn = new ArrayList<JokeVisualised>();
        int index = 1;
        for (int x = jokes.size() - 1 - page * 10; x > jokes.size() - (page + 1) * 10 - 1 && x > 0; x--)
            toReturn.add(changeToVisualizedJoke(jokes.get(x),
                    dbController.findCategory(jokes.get(x).getCategoryid()).getName(), index++));

        return toReturn;
    }

    /**
     * Sorting jokes from the biggest difference to the smallest.
     * @param jokes
     * @param dbController
     * @param page
     * @return Array of JokeVisualised from the biggest difference to the smallest difference.
     */
    public List<JokeVisualised> sortDescendingDifference(List<Joke> jokes, DBController dbController, int page) {
        List<JokeVisualised> visJokes = getArrOfVisualizedJokes(jokes, dbController);
        visJokes = visJokes.stream().sorted(Comparator.comparing(JokeVisualised::getDifference))
                .collect(Collectors.toList());
        List<JokeVisualised> toReturn = new ArrayList<>();

        int index = 1;
        for (int x = jokes.size() - 1 - page * 10; x > jokes.size() - (page + 1) * 10 - 1 && x > 0; x--)
            toReturn.add(changeToVisualizedJoke(visJokes.get(x), visJokes.get(x).getCategoryName(), index++));

        return toReturn;
    }

    /**
     * Sorting jokes from the smallest difference to the biggest.
     * @param jokes
     * @param dbController
     * @param page
     * @return Array of JokeVisualised from the smallest difference to the biggest difference.
     */
    public List<JokeVisualised> sortAscendingDifference(List<Joke> jokes, DBController dbController, int page) {
        List<JokeVisualised> visJokes = getArrOfVisualizedJokes(jokes, dbController);
        visJokes = visJokes.stream().sorted(Comparator.comparing(JokeVisualised::getDifference))
                .collect(Collectors.toList());
        List<JokeVisualised> toReturn = new ArrayList<>();

        int index = 1;
        for (int x = page * 10; x < (page + 1) * 10 && x < jokes.size();)
            toReturn.add(changeToVisualizedJoke(visJokes.get(x), visJokes.get(x++).getCategoryName(), index++));

        return toReturn;
    }

}