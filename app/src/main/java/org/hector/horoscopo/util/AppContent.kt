package org.hector.horoscopo.util

import org.hector.horoscopo.R
import org.hector.horoscopo.model.Horoscope

object AppContent {

    const val PREFS_NAME = "com.hector.horoscopo"
    var currentHoroscope: Horoscope? = null


    private val horoscope =  mutableSetOf(

        Horoscope(R.string.first_horoscope.toString(), arrayListOf(1926, 1938, 1950, 1962, 1974, 1986, 1998, 2010, 2022),R.drawable.tigre),
        Horoscope(R.string.second_horoscope.toString(), arrayListOf(1927, 1939, 1951, 1963, 1975, 1987, 1999, 2011, 2023),R.drawable.rabbit),
        Horoscope(R.string.third_horoscope.toString(), arrayListOf(1928, 1940, 1952, 1964, 1976, 1988, 2000, 2012, 2024),R.drawable.dragon),
        Horoscope(R.string.fourth_horoscope.toString(), arrayListOf(1929, 1941, 1953, 1965, 1977, 1989, 2001, 2013, 2025),R.drawable.snake),
        Horoscope(R.string.five_horoscope.toString(), arrayListOf(1930, 1942, 1954, 1966, 1978, 1990, 2002, 2014, 2026),R.drawable.horse),
        Horoscope(R.string.six_horoscope.toString(), arrayListOf(1931, 1943, 1955, 1967, 1979, 1991, 2003, 2015, 2027),R.drawable.goat),
        Horoscope(R.string.seven_horoscope.toString(), arrayListOf(1932, 1944, 1956, 1968, 1980, 1992, 2004, 2016, 2028),R.drawable.monkey),
        Horoscope(R.string.eight_horoscope.toString(), arrayListOf(1921, 1933, 1945, 1957, 1969, 1981, 1993, 2005, 2017, 2029),R.drawable.rooster),
        Horoscope(R.string.nine_horoscope.toString(), arrayListOf(1922, 1934, 1946, 1958, 1970, 1982, 1994, 2006, 2018, 2030),R.drawable.dog),
        Horoscope(R.string.ten_horoscope.toString(), arrayListOf(1923, 1935, 1947, 1959, 1971, 1983, 1995, 2007, 2019, 2031),R.drawable.pig),
        Horoscope(R.string.eleven_horoscope.toString(), arrayListOf(1924, 1936, 1948, 1960, 1972, 1984, 1996, 2008, 2020),R.drawable.rat),
        Horoscope(R.string.twelve_horoscope.toString(), arrayListOf(1925, 1937, 1949, 1961, 1973, 1985, 1997, 2009, 2021),R.drawable.ox),


    )

    val horoscopes = horoscope.toSet()


}