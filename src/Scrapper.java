import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javax.sound.sampled.Line;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Scrapper {
        static LocalDate localDate = LocalDate.now();
        static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        static String formattedString = localDate.format(formatter);
        static String url = "https://www.cineplex.com/Showtimes/any-movie/galaxy-cinemas-barrie?Date=";
        static String fullUrl = url+formattedString;
         TreeMap<String, String> movies ;

    public static List getMovies()throws IOException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now();
        String formattedString = localDate.format(formatter);
        String url = "https://www.cineplex.com/Showtimes/any-movie/galaxy-cinemas-barrie?Date=";
        String fullUrl = url+formattedString;
        List movies = new ArrayList();

        Document doc = Jsoup.connect(fullUrl).get();

        Elements movieTitle = doc.getElementsByClass("movie-details-link-click");
        Elements movieTime = doc.getElementsByClass("showtime  showtimeLink");
        for(int i=0; i<movieTitle.size(); i++){
            movies.add(movieTitle.get(i).text());

        }
        return movies;
    }




}
