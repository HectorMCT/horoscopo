package org.hector.horoscopo.util

import org.hector.horoscopo.R
import org.hector.horoscopo.model.Horoscope

object AppContent {


    private val horoscope =  mutableSetOf(

        Horoscope(R.string.first_horoscope.toString(), arrayListOf(1926, 1938, 1950, 1962, 1974, 1986, 1998, 2010, 2022),
            R.drawable.tigre, R.drawable.tiger_year, R.string.first_msg.toString() , arrayListOf(R.string.third_horoscope.toString(), R.string.five_horoscope.toString(), R.string.ten_horoscope.toString())),

        Horoscope(R.string.second_horoscope.toString(), arrayListOf(1927, 1939, 1951, 1963, 1975, 1987, 1999, 2011, 2023),
            R.drawable.rabbit, R.drawable.rat_year, R.string.second_msg.toString() , arrayListOf(R.string.eleven_horoscope.toString(), R.string.six_horoscope.toString(), R.string.seven_horoscope.toString(), R.string.nine_horoscope.toString(), R.string.ten_horoscope.toString())),

        Horoscope(R.string.third_horoscope.toString(), arrayListOf(1928, 1940, 1952, 1964, 1976, 1988, 2000, 2012, 2024),
            R.drawable.dragon, R.drawable.dragon_year, R.string.third_msg.toString()  , arrayListOf(R.string.eleven_horoscope.toString(), R.string.first_horoscope.toString(), R.string.fourth_horoscope.toString())),

        Horoscope(R.string.fourth_horoscope.toString(), arrayListOf(1929, 1941, 1953, 1965, 1977, 1989, 2001, 2013, 2025),
            R.drawable.snake, R.drawable.snake_year, R.string.fourth_msg.toString()  , arrayListOf(R.string.third_horoscope.toString(), R.string.eight_horoscope.toString())),

        Horoscope(R.string.five_horoscope.toString(), arrayListOf(1930, 1942, 1954, 1966, 1978, 1990, 2002, 2014, 2026),
            R.drawable.horse, R.drawable.horse_year, R.string.five_msg.toString()  , arrayListOf(R.string.six_horoscope.toString(), R.string.first_horoscope.toString())),

        Horoscope(R.string.six_horoscope.toString(), arrayListOf(1931, 1943, 1955, 1967, 1979, 1991, 2003, 2015, 2027),
            R.drawable.goat, R.drawable.goat_year, R.string.six_msg.toString()  , arrayListOf(R.string.second_horoscope.toString(), R.string.first_horoscope.toString(), R.string.fourth_horoscope.toString())),

        Horoscope(R.string.seven_horoscope.toString(), arrayListOf(1932, 1944, 1956, 1968, 1980, 1992, 2004, 2016, 2028),
            R.drawable.monkey, R.drawable.monkey_year, R.string.seven_msg.toString()  , arrayListOf(R.string.twelve_horoscope.toString(), R.string.second_horoscope.toString())),

        Horoscope(R.string.eight_horoscope.toString(), arrayListOf(1921, 1933, 1945, 1957, 1969, 1981, 1993, 2005, 2017, 2029),
            R.drawable.rooster, R.drawable.rooster_year, R.string.eight_msg.toString()  , arrayListOf(R.string.twelve_horoscope.toString(), R.string.fourth_horoscope.toString())),

        Horoscope(R.string.nine_horoscope.toString(), arrayListOf(1922, 1934, 1946, 1958, 1970, 1982, 1994, 2006, 2018, 2030),
            R.drawable.dog, R.drawable.dog_year, R.string.nine_msg.toString()  , arrayListOf(R.string.second_horoscope.toString())),

        Horoscope(R.string.ten_horoscope.toString(), arrayListOf(1923, 1935, 1947, 1959, 1971, 1983, 1995, 2007, 2019, 2031),
            R.drawable.pig, R.drawable.pig_year, R.string.ten_msg.toString() , arrayListOf(R.string.five_horoscope.toString(), R.string.first_horoscope.toString(), R.string.second_horoscope.toString())),

        Horoscope(R.string.eleven_horoscope.toString(), arrayListOf(1924, 1936, 1948, 1960, 1972, 1984, 1996, 2008, 2020),
            R.drawable.rat, R.drawable.rat_year, R.string.eleven_msg.toString()  , arrayListOf(R.string.first_horoscope.toString(), R.string.third_horoscope.toString(), R.string.second_horoscope.toString())),

        Horoscope(R.string.twelve_horoscope.toString(), arrayListOf(1925, 1937, 1949, 1961, 1973, 1985, 1997, 2009, 2021),
            R.drawable.ox, R.drawable.ox_year, R.string.twelve_msg.toString()  , arrayListOf(R.string.eleven_horoscope.toString(), R.string.seven_horoscope.toString(), R.string.eight_horoscope.toString())),


    )

    val horoscopes = horoscope.toSet()


}